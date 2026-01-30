package io.github.t3wv.nfse.municipal.nfseSCSaoJose;

import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos.*;
import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;

public class WSSaoJose  implements NFSeLogger {

    private static final String URL_PRODUCAO = "https://saojose.atende.net/atende.php?pg=rest&service=WNERestServiceNFSe&cidade=padrao";
    private final String credentials;

    public WSSaoJose(String login, String senha) {
        this.credentials = Base64.getEncoder().encodeToString("%s:%s".formatted(login, senha).getBytes());
    }

    public NFSeSCSaoJoseEmissaoRetorno enviarEmissaoNFSe(final NFSeSCSaoJoseEmissaoEnvio arquivoEmissao, final String filename) throws Exception {
        try (HttpClient client = HttpClient.newHttpClient()) {
            this.getLogger().debug("Request emissão NFSe com xml: {}", arquivoEmissao.toXml());
            final var response = client.send(this.buildRequest(arquivoEmissao.toXml(), filename), HttpResponse.BodyHandlers.ofString());
            final var responseBody = StringUtils.trimToEmpty(response.body());
            final var responseCode = response.statusCode();
            if (responseCode != 200) {
                throw new Exception("Emissão de NFSe retornou erro '%d'!".formatted(responseCode));
            } else {
                final var registryMatcher = new NFSeRegistryMatcher();
                registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());
                this.getLogger().debug("NFSe emitida: {}", responseBody);
                return new NFSePersister(true, registryMatcher).read(NFSeSCSaoJoseEmissaoRetorno.class, responseBody);
            }
        }
    }

    public NFSeSCSaoJoseCancelamentoRetorno enviarCancelamentoNFSe(final NFSeSCSaoJoseCancelamentoEnvio arquivoCancelamento, final String filename) throws Exception {
        try (HttpClient client = HttpClient.newHttpClient()) {
            this.getLogger().debug("Request cancelamento NFSe com xml: {}", arquivoCancelamento.toXml());
            final var response = client.send(this.buildRequest(arquivoCancelamento.toXml(), filename), HttpResponse.BodyHandlers.ofString());
            final var responseBody = StringUtils.trimToEmpty(response.body()); // Trim no body porque o webservice retorna espaços em branco antes do XML
            final var responseCode = response.statusCode();
            if (responseCode != 200) {
                throw new Exception("Cancelamento de NFSe retornou erro '%d'!".formatted(responseCode));
            } else {
                final var registryMatcher = new NFSeRegistryMatcher();
                registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());
                this.getLogger().debug("NFSe cancelada: {}", responseBody);
                return new NFSePersister(true, registryMatcher).read(NFSeSCSaoJoseCancelamentoRetorno.class, responseBody);
            }
        }
    }

    public NFSeSCSaoJoseCancelamentoRetorno enviarSolicitacaoCancelamentoNFSe(final NFSeSCSaoJoseCancelamentoSolicitacaoEnvio arquivoCancelamento, final String filename) throws Exception {
        try (HttpClient client = HttpClient.newHttpClient()) {
            this.getLogger().debug("Request de solicitação de cancelamento NFSe com xml: {}", arquivoCancelamento.toXml());
            final var response = client.send(this.buildRequest(arquivoCancelamento.toXml(), filename), HttpResponse.BodyHandlers.ofString());
            final var responseBody = StringUtils.trimToEmpty(response.body());
            final var responseCode = response.statusCode();
            if (responseCode != 200) {
                throw new Exception("Solicitação de cancelamento de NFSe retornou erro '%d'!".formatted(responseCode));
            } else {
                final var registryMatcher = new NFSeRegistryMatcher();
                registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());
                this.getLogger().debug("Solicitacao de cancelamento de NFSe registrada: {}", responseBody);
                return new NFSePersister(true, registryMatcher).read(NFSeSCSaoJoseCancelamentoRetorno.class, responseBody);
            }
        }
    }

    public NFSeSCSaoJosePesquisaCodigoAutenticidadeRetorno consultaNFSeCodigoAutenticidade(final NFSeSCSaoJosePesquisaCodigoAutenticidadeEnvio arquivoPesquisa, final String filename) throws Exception {
        try (HttpClient client = HttpClient.newHttpClient()) {
            this.getLogger().debug("Request de consulta de NFSe com xml: {}", arquivoPesquisa.toXml());
            final var response = client.send(this.buildRequest(arquivoPesquisa.toXml(), filename), HttpResponse.BodyHandlers.ofString());
            final var responseBody = StringUtils.trimToEmpty(response.body());
            final var responseCode = response.statusCode();
            if (responseCode != 200) {
                throw new Exception("Consulta de NFSe por codigo de autenticidade retornou erro '%d'!".formatted(responseCode));
            } else {
                final var registryMatcher = new NFSeRegistryMatcher();
                registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());
                this.getLogger().debug("NFSe localizada: {}", responseBody);
                return new NFSePersister(true, registryMatcher).read(NFSeSCSaoJosePesquisaCodigoAutenticidadeRetorno.class, responseBody);
            }
        }
    }

    private HttpRequest buildRequest(final String xml, final String filename) throws Exception {
        final var boundary = "----Boundary%d".formatted(System.currentTimeMillis());
        final var CRLF = "\r\n";

        // Monta o corpo multipart
        try (final var baos = new ByteArrayOutputStream()) {
            baos.write("--%s%sContent-Disposition: form-data; name=\"file\"; filename=\"%s\"%sContent-Type: text/xml; charset=UTF-8%s%s".formatted(boundary, CRLF, filename, CRLF, CRLF, CRLF).getBytes(StandardCharsets.UTF_8));
            baos.write(xml.getBytes(StandardCharsets.UTF_8));
            baos.write("%s--%s--%s".formatted(CRLF, boundary, CRLF).getBytes(StandardCharsets.UTF_8));

            return HttpRequest.newBuilder()
                .uri(URI.create(URL_PRODUCAO))
                .header("Content-Type", "multipart/form-data; boundary=" + boundary)
                .header("Authorization", "Basic %s".formatted(this.credentials))
                .POST(HttpRequest.BodyPublishers.ofByteArray(baos.toByteArray()))
                .timeout(Duration.ofSeconds(10))
                .build();
        }
    }
}
