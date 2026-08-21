package io.github.t3wv.nfse.nacional;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.nacional.classes.adn.NFSeAdnLoteDistribuicaoResponse;
import io.github.t3wv.nfse.utils.NFSeHttpClient;
import io.github.t3wv.nfse.utils.NFSeObjectMapper;
import io.github.t3wv.nfse.utils.NFSeUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Distribuição de DF-e do ADN (Ambiente de Dados Nacional) — o serviço que entrega ao contribuinte
 * os documentos fiscais de serviço em que ele figura como <b>emitente, tomador ou intermediário</b>.
 *
 * <p>É a via para descobrir as NFS-e emitidas <i>contra</i> um CNPJ, papel que na NF-e cabe ao
 * {@code NFeDistribuicaoDFe}. Não confundir com a API Sefin Nacional ({@link WSSefinNFSe}), que
 * emite documentos e consulta uma nota específica quando a chave de acesso já é conhecida.
 *
 * <p>O modelo é sequencial por <b>NSU</b> (Número Sequencial Único): guarda-se o último NSU
 * processado e pedem-se os seguintes. Diferente da NF-e, o ADN <b>não devolve um teto de NSU</b> —
 * a drenagem termina quando a resposta vem com
 * {@link io.github.t3wv.nfse.nacional.classes.adn.NFSeAdnStatusProcessamento#NENHUM_DOCUMENTO_LOCALIZADO}.
 * Quem itera deve manter uma trava de iterações, sob pena de laço infinito caso o ADN repita NSU.
 *
 * <p>A autenticação é o próprio certificado (mTLS); não há token nem chave de API. Requisições sem
 * certificado recebem {@code 496 SSL Certificate Required}.
 */
public class WSDistribuicaoDFe implements NFSeLogger {

    public static final String URL_BASE_PRODUCAO = "https://adn.nfse.gov.br/contribuintes";
    public static final String URL_BASE_HOMOLOGACAO = "https://adn.producaorestrita.nfse.gov.br/contribuintes";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeConfig config;

    public WSDistribuicaoDFe(final NFSeConfig config) {
        this.config = config;
    }

    /**
     * Distribuição em lote: devolve o bloco de documentos a partir do NSU informado.
     *
     * @param nsu NSU de partida; {@code 0} começa do início.
     * @return Objeto {@link NFSeAdnLoteDistribuicaoResponse} com os documentos do bloco.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeAdnLoteDistribuicaoResponse distribuirDFe(final long nsu) throws Exception {
        return this.distribuirDFe(nsu, null);
    }

    /**
     * Distribuição em lote a partir do NSU informado, para um CNPJ de mesma raiz que a do
     * certificado.
     *
     * @param nsu          NSU de partida; {@code 0} começa do início.
     * @param cnpjConsulta CNPJ a consultar, que deve ser de mesma raiz que a do certificado, ou
     *                     {@code null} para usar o CNPJ do próprio certificado.
     * @return Objeto {@link NFSeAdnLoteDistribuicaoResponse} com os documentos do bloco.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeAdnLoteDistribuicaoResponse distribuirDFe(final long nsu, final String cnpjConsulta) throws Exception {
        return this.consultarDFe(nsu, cnpjConsulta, true);
    }

    /**
     * Consulta pontual: devolve apenas o documento do NSU informado, sem avançar em lote.
     *
     * @param nsu NSU do documento.
     * @return Objeto {@link NFSeAdnLoteDistribuicaoResponse} com, no máximo, um documento.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeAdnLoteDistribuicaoResponse consultarDFePorNsu(final long nsu) throws Exception {
        return this.consultarDFe(nsu, null, false);
    }

    /**
     * Consulta pontual do documento de um NSU, para um CNPJ de mesma raiz que a do certificado.
     *
     * @param nsu          NSU do documento.
     * @param cnpjConsulta CNPJ a consultar, que deve ser de mesma raiz que a do certificado, ou
     *                     {@code null} para usar o CNPJ do próprio certificado.
     * @return Objeto {@link NFSeAdnLoteDistribuicaoResponse} com, no máximo, um documento.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeAdnLoteDistribuicaoResponse consultarDFePorNsu(final long nsu, final String cnpjConsulta) throws Exception {
        return this.consultarDFe(nsu, cnpjConsulta, false);
    }

    /**
     * Consulta os DF-e do tipo Evento vinculados a uma chave de acesso.
     *
     * @param chaveAcesso Chave de acesso da NFS-e, podendo conter caracteres não numéricos que
     *                    serão removidos automaticamente; após normalização, deve conter
     *                    exatamente 50 dígitos.
     * @return Objeto {@link NFSeAdnLoteDistribuicaoResponse} com os eventos da chave.
     * @throws IllegalArgumentException Se a chave de acesso normalizada não tiver 50 dígitos.
     * @throws Exception                Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeAdnLoteDistribuicaoResponse consultarEventosPorChaveAcesso(final String chaveAcesso) throws Exception {
        //normaliza a chave de acesso removendo quaisquer caracteres não numéricos
        final var chaveAcessoNormalizada = StringUtils.defaultString(chaveAcesso).replaceAll("\\D", "");

        //valida o tamanho da chave de acesso, pois precisa ser exatamente 50 caracteres numericos
        if (!chaveAcessoNormalizada.matches("\\d{50}")) {
            throw new IllegalArgumentException("Chave de acesso da NFSe deve conter exatamente 50 dígitos numéricos!");
        }

        final var url = new URI("%s/NFSe/%s/Eventos".formatted(this.getUrlBase(), chaveAcessoNormalizada));
        return this.executarConsulta(url);
    }

    /**
     * Monta e executa {@code GET /DFe/{nsu}}, com ou sem o parâmetro {@code lote}, que é o que
     * separa a distribuição em lote da consulta de um NSU específico.
     */
    private NFSeAdnLoteDistribuicaoResponse consultarDFe(final long nsu, final String cnpjConsulta, final boolean lote) throws Exception {
        if (nsu < 0) {
            throw new IllegalArgumentException("O NSU não pode ser negativo!");
        }

        final var url = new StringBuilder("%s/DFe/%d".formatted(this.getUrlBase(), nsu));
        if (lote) {
            url.append("?lote=true");
        }
        if (StringUtils.isNotBlank(cnpjConsulta)) {
            final var cnpjNormalizado = cnpjConsulta.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
            if (!NFSeUtils.isCnpjValido(cnpjNormalizado)) {
                throw new IllegalArgumentException("O CNPJ de consulta '%s' é inválido!".formatted(cnpjConsulta));
            }
            url.append(lote ? '&' : '?')
                .append("cnpjConsulta=")
                .append(URLEncoder.encode(cnpjNormalizado, StandardCharsets.UTF_8));
        }

        return this.executarConsulta(new URI(url.toString()));
    }

    /**
     * Executa a consulta e desserializa a resposta.
     *
     * <p>{@code 400} e {@code 404} são respostas de negócio do ADN — trazem o mesmo corpo das
     * respostas de sucesso, com o detalhamento em {@code Erros} (por exemplo {@code E2215}, quando
     * não existem documentos a partir do NSU, e {@code E2230}, quando não existe documento para o
     * NSU consultado). Só os demais códigos viram exceção.
     */
    private NFSeAdnLoteDistribuicaoResponse executarConsulta(final URI url) throws Exception {
        final var response = new NFSeHttpClient(this.config).sendGetRequest(url);
        //só metadados no log: o corpo traz o XML fiscal de todos os documentos do lote
        this.getLogger().debug("Response {}: {} bytes", response.statusCode(), StringUtils.length(response.body()));

        switch (response.statusCode()) {
            case HttpURLConnection.HTTP_OK, HttpURLConnection.HTTP_BAD_REQUEST, HttpURLConnection.HTTP_NOT_FOUND -> {
                if (StringUtils.isBlank(response.body())) {
                    throw new IllegalStateException("Consulta de distribuição de DFe em '%s' retornou código '%d' com corpo vazio!".formatted(url, response.statusCode()));
                }
                return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeAdnLoteDistribuicaoResponse.class);
            }
            default -> throw new IllegalStateException("Consulta de distribuição de DFe em '%s' retornou erro '%d': %s".formatted(url, response.statusCode(), StringUtils.abbreviate(response.body(), 300)));
        }
    }

    private String getUrlBase() {
        return this.config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO;
    }
}
