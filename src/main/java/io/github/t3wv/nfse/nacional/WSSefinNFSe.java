package io.github.t3wv.nfse.nacional;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.*;
import io.github.t3wv.nfse.utils.*;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.AbstractMap;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class WSSefinNFSe implements NFSeLogger {

    public static final String URL_BASE_PRODUCAO = "https://sefin.nfse.gov.br/sefinnacional";
    public static final String URL_BASE_HOMOLOGACAO = "https://sefin.producaorestrita.nfse.gov.br/sefinnacional";
    private static final String URL_PRODUCAO_NFSE = URL_BASE_PRODUCAO + "/nfse";
    private static final String URL_HOMOLOGACAO_NFSE = URL_BASE_HOMOLOGACAO + "/nfse";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeConfig config;

    public WSSefinNFSe(final NFSeConfig config) {
        this.config = config;
    }

    /**
     * Busca uma NFS-e (Nota Fiscal de Serviços Eletrônica) pelo número de chave de acesso.
     *
     * <p>A chave de acesso é normalizada antes da consulta, removendo quaisquer caracteres
     * não numéricos. Após a normalização, é validado se a chave possui exatamente 50 dígitos.
     * A requisição é direcionada ao ambiente de homologação ou produção conforme a configuração
     * definida em {@code config.isTeste()}.
     *
     * <p>Os possíveis retornos são:
     * <ul>
     *   <li>{@code 200 OK} – Consulta realizada com sucesso. O valor do par será uma instância
     *       de {@link NFSeSefinNacionalGetResponse} contendo os dados da NFS-e.</li>
     *   <li>{@code 400 Bad Request} – Requisição inválida.</li>
     *   <li>{@code 401 Unauthorized} – Não autorizado.</li>
     *   <li>{@code 403 Forbidden} – Acesso proibido.</li>
     *   <li>{@code 404 Not Found} – NFS-e não encontrada.</li>
     *       Para os casos 400, 401, 403 e 404, o valor do par será uma instância de
     *       {@link NFSeSefinNacionalResponseErro} contendo os detalhes do erro retornado pela API.
     * </ul>
     *
     * @param chaveAcesso chave de acesso da NFS-e, podendo conter caracteres não numéricos
     *                    que serão removidos automaticamente antes da validação e consulta;
     *                    após normalização, deve conter exatamente 50 dígitos numéricos
     * @return um {@link Map.Entry} onde a chave é o código de status HTTP da resposta
     *         ({@link java.net.HttpURLConnection#HTTP_OK} para sucesso, ou o código de erro
     *         correspondente) e o valor é o objeto deserializado da resposta
     *         ({@link NFSeSefinNacionalGetResponse} ou {@link NFSeSefinNacionalResponseErro})
     * @throws IllegalArgumentException se a chave de acesso normalizada não contiver
     *                                  exatamente 50 dígitos numéricos
     * @throws IllegalStateException    se a API retornar um código de status HTTP não tratado
     * @throws Exception                se ocorrer qualquer erro de I/O, URI inválida ou falha
     *                                  na desserialização da resposta
     */
    public Map.Entry<Integer, Object> buscarNFSeByChaveAcesso(final String chaveAcesso) throws Exception {
        //normaliza a chave de acesso removendo quaisquer caracteres não numéricos
        final var chaveAcessoNormalizada = chaveAcesso.replaceAll("\\D", "");

        //valida o tamanho da chave de acesso, pois precisa ser exatamente 50 caracteres numericos
        if (!chaveAcessoNormalizada.matches("\\d{50}")) {
            throw new IllegalArgumentException("Chave de acesso da NFSe deve conter exatamente 50 dígitos numéricos!");
        }

        //busca os dados
        final var url = new URI(String.format("%s/%s", config.isTeste() ? URL_HOMOLOGACAO_NFSE : URL_PRODUCAO_NFSE, chaveAcesso));
        final var response = new NFSeHttpClient(config).sendGetRequest(url);
        this.getLogger().info("Response {}: {}", response.statusCode(), response.body());
        return switch (response.statusCode()) {
            case HttpURLConnection.HTTP_OK -> new AbstractMap.SimpleEntry<>(HttpURLConnection.HTTP_OK, this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class));
            case HttpURLConnection.HTTP_BAD_REQUEST, HttpURLConnection.HTTP_UNAUTHORIZED, HttpURLConnection.HTTP_FORBIDDEN, HttpURLConnection.HTTP_NOT_FOUND -> new AbstractMap.SimpleEntry<>(response.statusCode(), this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalResponseErro.class));
            default -> throw new IllegalStateException("Consulta de NFSe '%s' retornou erro '%d'!".formatted(chaveAcessoNormalizada, response.statusCode()));
        };
    }

    /**
     * Consulta NFSe XML pela chave de acesso
     *
     * @param nfseChaveAcesso chave de acesso da nfse
     * @return XML da NFSe
     * @throws Exception Caso erro.
     */
    public String buscarNFSeXmlByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var response = this.buscarNFSeByChaveAcesso(nfseChaveAcesso);
        if (response.getKey().equals(HttpURLConnection.HTTP_OK)) {
            final var nfse = (NFSeSefinNacionalGetResponse) response.getValue();
            return NFSeUtils.decodeXmlGZipB64(nfse.getNfseXmlGZipB64());
        } else {
            final var erro = (NFSeSefinNacionalResponseErro) response.getValue();
            throw new Exception("Não foi possível obter o xml da nota fiscal via chave de acesso '%s': [HTTP response code %s] - %s".formatted(nfseChaveAcesso, response.getKey(), erro.getErro().stream().map(e -> "%s - %s;".formatted(e.getCodigo(), e.getDescricao())).collect(Collectors.joining())));
        }
    }

    /**
     * Emite uma NFSe a partir de um DPS
     *
     * @param dps Objeto DPS.
     * @return Objeto de resposta da emissão.
     * @throws Exception Caso erro.
     */
    public Map.Entry<Integer, Object> emitirNFSeByDPS(final NFSeSefinNacionalDPS dps) throws Exception {
        //gera os defaults
        if (dps.getInfDPS().getTipoAmbiente() == null) {
            dps.getInfDPS().setTipoAmbiente(this.config.isTeste() ? NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO : NFSeSefinNacionalTipoAmbiente.PRODUCAO);
        }
        if (dps.getInfDPS().getDataHoraEmissao() == null) {
            dps.getInfDPS().setDataHoraEmissao(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("-03:00")));
        }
        if (dps.getInfDPS().getTipoEmitente() == null) {
            dps.getInfDPS().setTipoEmitente(NFSeSefinNacionalInfDPSTipoEmitente.PRESTADOR);
        }
        if (StringUtils.isBlank(dps.getInfDPS().getVersaoApp())) {
            dps.getInfDPS().setVersaoApp("T3W %s".formatted(dps.getInfDPS().getTipoAmbiente().getDescricao()));
        }
        if (dps.getInfDPS().getDataInicioPrestacaoServico() == null) {
            dps.getInfDPS().setDataInicioPrestacaoServico(LocalDate.now());
        }

        //valida o ambiente
        final var dpsHomologacao = NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO.equals(dps.getInfDPS().getTipoAmbiente());
        final var sistemaHomologacao = this.config.isTeste();
        if (dpsHomologacao != sistemaHomologacao) {
            throw new IllegalStateException("O ambiente do DPS (%s) não corresponde ao ambiente do sistema (%s)!".formatted(dpsHomologacao ? "HOMOLOGAÇÃO" : "PRODUÇÃO", sistemaHomologacao ? "HOMOLOGAÇÃO" : "PRODUÇÃO"));
        }

        // Gera o id e seta no objeto para preenchimento no xml
        dps.getInfDPS().setId(NFSeUtils.gerarDPSId(dps));


        //cria os validatores
        final var xmlValidator = new NFSeXmlValidator(new StreamSource(new File(Objects.requireNonNull(WSSefinNFSe.class.getResource("/NFSeNacional_nfse-esquemas_xsd-v1-01-20260209/Schemas/1.01/DPS_v1.01.xsd")).getFile())));

        //gera o xml e valida
        final var xmlNaoAssinado = dps.toXml();
        getLogger().debug(xmlNaoAssinado);
        final var xmlNaoAssinadoErros = xmlValidator.validateAndGetErrors(xmlNaoAssinado).getLeft();
        assert xmlNaoAssinadoErros.isEmpty() : "XML não assinado do DPS não é válido: %s".formatted(String.join("; ", xmlNaoAssinadoErros));

        //assina o xml e revalida
        final var xmlAssinado = new NFSeAssinaturaDigital(this.config)
            .setOmitirDeclaracaoXML(false)
            .setUsarIdComoReferencia(false)
            .assinarDocumento(xmlNaoAssinado);
        getLogger().debug(xmlAssinado);
        final var xmlAssinadoErros = xmlValidator.validateAndGetErrors(xmlNaoAssinado).getLeft();
        assert xmlAssinadoErros.isEmpty() : "XML assinado do DPS não é válido: %s".formatted(String.join("; ", xmlAssinadoErros));

        byte[] gzipped;
        try (var baos = new ByteArrayOutputStream(); var gos = new java.util.zip.GZIPOutputStream(baos)) {
            gos.write(xmlAssinado.getBytes(StandardCharsets.UTF_8));
            gos.finish();
            gzipped = baos.toByteArray();
        }

        final var uri = new URI(String.format("%s", config.isTeste() ? URL_HOMOLOGACAO_NFSE : URL_PRODUCAO_NFSE));
        final var body = String.format("{dpsXmlGZipB64:\"%s\"}", Base64.getEncoder().encodeToString(gzipped));
        final var response = new NFSeHttpClient(config).sendPostRequest(uri, body);
        this.getLogger().info("Response emissão by DPS {}: {}", response.statusCode(), response.body());
        return switch (response.statusCode()) {
            case HttpURLConnection.HTTP_CREATED -> new AbstractMap.SimpleEntry<>(HttpURLConnection.HTTP_CREATED, this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalNFSePostResponseSucesso.class));
            case HttpURLConnection.HTTP_BAD_REQUEST -> new AbstractMap.SimpleEntry<>(HttpURLConnection.HTTP_BAD_REQUEST, this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalNFSePostResponseErro.class));
            default -> throw new IllegalStateException("Erro ao enviar DPS: %s".formatted(this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalNFSePostResponseErro.class).getErros()));
        };
    }

    /**
     * Emite um evento de cancelamento para uma NFSe
     */
    public Map.Entry<Integer, Object> enviarPedidoRegistroEvento(final NFSeSefinNacionalPedRegEvt pedidoRegistroEvento) throws Exception {
        //gera os defaults
        if (pedidoRegistroEvento.getInfPedReg().getTpAmb() == null) {
            pedidoRegistroEvento.getInfPedReg().setTpAmb(this.config.isTeste() ? NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO : NFSeSefinNacionalTipoAmbiente.PRODUCAO);
        }
        if (pedidoRegistroEvento.getInfPedReg().getDhEvento() == null) {
            pedidoRegistroEvento.getInfPedReg().setDhEvento(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("-03:00")));
        }
        if (StringUtils.isBlank(pedidoRegistroEvento.getInfPedReg().getVerAplic())) {
            pedidoRegistroEvento.getInfPedReg().setVerAplic("T3W %s".formatted(pedidoRegistroEvento.getInfPedReg().getTpAmb().getDescricao()));
        }
        if (StringUtils.isBlank(pedidoRegistroEvento.getInfPedReg().getNPedRegEvento())) {
//            pedidoRegistroEvento.getInfPedReg().setNPedRegEvento("1");
        }
        if (pedidoRegistroEvento.getInfPedReg().getEvento() == null) {
            pedidoRegistroEvento.getInfPedReg().setEvento(new NFSeSefinNacionalInfPedRegTE101101()
                .setcMotivo(NFSeSefinNacionalTSCodJustCanc.OUTROS)
                .setxMotivo("Motivo não especificado"));
        }

        //valida o ambiente
        final var solicitacaoHomologacao = NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO.equals(pedidoRegistroEvento.getInfPedReg().getTpAmb());
        final var sistemaHomologacao = this.config.isTeste();
        if (solicitacaoHomologacao != sistemaHomologacao) {
            throw new IllegalStateException("O ambiente do evento (%s) não corresponde ao ambiente do sistema (%s)!".formatted(solicitacaoHomologacao ? "HOMOLOGAÇÃO" : "PRODUÇÃO", sistemaHomologacao ? "HOMOLOGAÇÃO" : "PRODUÇÃO"));
        }

        // Gera o id e seta no objeto para preenchimento no xml
        pedidoRegistroEvento.getInfPedReg().setId(NFSeUtils.gerarEventoId(pedidoRegistroEvento));

        final String body;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); java.util.zip.GZIPOutputStream gos = new java.util.zip.GZIPOutputStream(baos)) {
            gos.write(new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(false).setUsarIdComoReferencia(false).assinarDocumento(pedidoRegistroEvento.toXml(), "infPedReg").getBytes(StandardCharsets.UTF_8));
            gos.finish();
            body = String.format("{pedidoRegistroEventoXmlGZipB64:\"%s\"}", Base64.getEncoder().encodeToString(baos.toByteArray()));
        }

        final var uri = new URI(String.format("%s/%s/eventos", config.isTeste() ? URL_HOMOLOGACAO_NFSE : URL_PRODUCAO_NFSE, pedidoRegistroEvento.getInfPedReg().getChaveAcessoNFSE()));
        final var response = new NFSeHttpClient(config).sendPostRequest(uri, body);
        return switch (response.statusCode()) {
            case HttpURLConnection.HTTP_CREATED -> new AbstractMap.SimpleEntry<>(HttpURLConnection.HTTP_CREATED, this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalEventosPostResponseSucesso.class));
            case HttpURLConnection.HTTP_BAD_REQUEST -> new AbstractMap.SimpleEntry<>(HttpURLConnection.HTTP_BAD_REQUEST, this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalResponseErro.class));
            default -> throw new IllegalStateException("Erro ao enviar DPS: %s".formatted(this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalResponseErro.class).getErro()));
        };
    }

    /**
     * Solicita os eventos de uma NFSe pela chave de acesso.
     *
     * @param chave Chave de acesso da nfse.
     * @param codigoEvento Codigo do evento
     * @param seq Sequencial do evento
     * @return Eventos da NFSe.
     * @throws Exception Caso erro.
     */
    public Map.Entry<Integer, Object> solicitarEventos(final String chave, final String codigoEvento, final Integer seq) throws Exception {
        final var uri = new URI(String.format("%s/%s/eventos/%s/%s", config.isTeste() ? URL_HOMOLOGACAO_NFSE : URL_PRODUCAO_NFSE, chave, ObjectUtils.firstNonNull(codigoEvento, "="), ObjectUtils.firstNonNull(seq, "=")));
        final var response = new NFSeHttpClient(config).sendGetRequest(uri);
        return switch (response.statusCode()) {
            case HttpURLConnection.HTTP_OK -> new AbstractMap.SimpleEntry<>(HttpURLConnection.HTTP_OK, this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalEventosPostResponseSucesso.class));
            case HttpURLConnection.HTTP_BAD_REQUEST -> new AbstractMap.SimpleEntry<>(HttpURLConnection.HTTP_BAD_REQUEST, this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalResponseErro.class));
            default -> throw new IllegalStateException("Erro ao enviar DPS: %s".formatted(this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalResponseErro.class).getErro()));
        };
    }
}
