package io.github.t3wv.nacional.webservices;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.NFSeHttpClient;
import io.github.t3wv.NFSeLogger;

import java.net.URI;
import java.net.http.HttpResponse;

public class WSDANFSe implements NFSeLogger {

    public static final String URL_BASE_PRODUCAO = "https://adn.nfse.gov.br/";
    public static final String URL_BASE_HOMOLOGACAO = "https://adn.producaorestrita.nfse.gov.br/";
    private final NFSeConfig config;

    public WSDANFSe(final NFSeConfig config) {
        this.config = config;
    }

    /**
     * Faz o download do DANFSe em PDF utilizando a chave de acesso da NFSe.
     *
     * @param nfseChaveAcesso Chave de acesso da NFSe com 50 dígitos.
     * @return Array de bytes representando o arquivo PDF do DANFSe.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public byte[] downloadDANFSePdfByChaveAcesso(final String nfseChaveAcesso) throws Exception {
        final var url = new URI(String.format("%s/danfse/%s", this.config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO, nfseChaveAcesso));
        final var response = new NFSeHttpClient(this.config).sendGetRequest(url, HttpResponse.BodyHandlers.ofByteArray());
        return response.body();
    }
}
