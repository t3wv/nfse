package io.github.t3wv.nfse.nacional;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.*;
import io.github.t3wv.nfse.utils.*;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.StringUtils;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Objects;

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
     * Consulta NFSe pela chave de acesso
     *
     * @param chaveAcesso chave de acesso da nfse
     * @return objeto de resposta da consulta
     * @throws Exception
     */
    public NFSeSefinNacionalGetResponse buscarNFSeByChaveAcesso(final String chaveAcesso) throws Exception {
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
        if (response.statusCode() != 200) {
            throw new Exception("Consulta de XML do NFSe '%s' retornou erro '%d'!".formatted(chaveAcessoNormalizada, response.statusCode()));
        } else {
            return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalGetResponse.class);
        }
    }

    /**
     * Consulta NFSe XML pela chave de acesso
     *
     * @param nfseChaveAcesso chave de acesso da nfse
     * @return XML da NFSe
     * @throws Exception Caso erro.
     */
    public String buscarNFSeXmlByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var nfse = this.buscarNFSeByChaveAcesso(nfseChaveAcesso);
        return NFSeUtils.decodeXmlGZipB64(nfse.getNfseXmlGZipB64());
    }

    /**
     * Emite uma NFSe a partir de um DPS
     *
     * @param dps Objeto DPS.
     * @return Objeto de resposta da emissão.
     * @throws Exception Caso erro.
     */
    public NFSeSefinNacionalPostResponseSucesso emitirNFSeByDPS(final NFSeSefinNacionalDPS dps) throws Exception {
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
        final var xmlValidator = new NFSeXmlValidator(new StreamSource(new File(Objects.requireNonNull(WSSefinNFSe.class.getResource("/NFSeNacional_nfse-esquemas_xsd-rtc-v1-00-20251210/DPS_v1.01.xsd")).getFile())));

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
        this.getLogger().info("Response {}: {}", response.statusCode(), response.body());
        if (response.statusCode() != 201) {
            final var responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException("Erro ao enviar DPS: %s".formatted(responseError.getErros()));
        }
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }

    /**
     * Emite um evento de cancelamento para uma NFSe
     */
    public NFSeSefinNacionalPostResponseSucesso enviarPedidoRegistroEvento(final NFSeSefinNacionalPedRegEvt pedidoRegistroEvento) throws Exception {
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
            pedidoRegistroEvento.getInfPedReg().setNPedRegEvento("1");
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
        if (response.statusCode() != 201) {
            final var responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            throw new IllegalStateException(String.format("Erro ao registrar evento: %s", responseError.getErros()));
        }
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }

    /**
     * Solicita os eventos de uma NFSe pela chave de acesso.
     *
     * @param chave Chave de acesso da nfse.
     * @return Eventos da NFSe.
     * @throws Exception Caso erro.
     */
    public NFSeSefinNacionalPostResponseSucesso solicitarEventos(final String chave, final String codigoEvento, final int seq) throws Exception {
        final var uri = new URI(String.format("%s/%s/eventos/%s/%s", config.isTeste() ? URL_HOMOLOGACAO_NFSE : URL_PRODUCAO_NFSE, chave, codigoEvento, seq));
        final var response = new NFSeHttpClient(config).sendGetRequest(uri);
        if (!Range.of(200, 299).contains(response.statusCode())) {
            final var responseError = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseErro.class);
            final var erroMensagem = responseError.getErros() != null && !responseError.getErros().isEmpty() ? responseError.getErros() : "Erro não informado";
            switch (response.statusCode()) {
                case 404:
                    this.getLogger().debug("Nenhum evento encontrado para a NFS-e.");
                    return null;
                case 401:
                    throw new IllegalAccessException(String.format("Usuário do certificado informado não tem permissão para acessar os eventos '%s' da NFS-e de chave '%s'.", codigoEvento, chave));
                case 422:
                    throw new IllegalStateException(String.format("A requisição violou alguma regra de negócio: %s", erroMensagem));
                default:
                    throw new IllegalStateException(String.format("Erro ao buscar evento: %s", erroMensagem));
            }
        }

        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeSefinNacionalPostResponseSucesso.class);
    }
}
