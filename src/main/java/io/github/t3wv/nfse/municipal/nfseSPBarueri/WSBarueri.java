package io.github.t3wv.nfse.municipal.nfseSPBarueri;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeLogger;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.services.*;
import io.github.t3wv.nfse.utils.NFSeHttpClient;
import io.github.t3wv.nfse.utils.NFSePersister;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class WSBarueri implements NFSeLogger {

    public static final String URL_BASE_PRODUCAO = "https://www.barueri.sp.gov.br/nfeservice/wsrps.asmx";
    public static final String URL_BASE_HOMOLOGACAO = "https://testeeiss.barueri.sp.gov.br/nfeservice/wsrps.asmx";
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HHmmss");
    public static final char CHR13 = (char) 13;
    public static final char CHR10 = (char) 10;

    private final NFSeConfig config;

    public WSBarueri(NFSeConfig config) {
        this.config = config;
    }

    public NFSeBarueriLoteEnviarArquivoResponse loteEnviarArquivo(NFSeBarueriLoteEnviarArquivoRequest request) throws Exception {
        String soapEnvelope = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                              "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
                              "    <soap12:Body>\n" +
                              "        <NFeLoteEnviarArquivo xmlns=\"http://www.barueri.sp.gov.br/nfe\">\n" +
                              "            <VersaoSchema>1</VersaoSchema>\n" +
                              "            <MensagemXML><![CDATA[\n" +
                              request.toXml() +
                              "            ]]>\n" +
                              "            </MensagemXML>\n" +
                              "        </NFeLoteEnviarArquivo>\n" +
                              "    </soap12:Body>\n" +
                              "</soap12:Envelope>";

        final var response = new NFSeHttpClient(config).sendPostRequest(new URI(config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), soapEnvelope);
        final var body = response.body();
        this.getLogger().debug(body);
        return (NFSeBarueriLoteEnviarArquivoResponse) new NFSePersister().read(NFSeBarueriSoapEnvelope.class, body).getResponse();
    }

    public NFSeBarueriLoteStatusArquivoResponse loteStatusArquivo(final NFSeBarueriLoteStatusArquivoRequest request) throws Exception {
        String soapEnvelope = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                              "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
                              "    <soap12:Body>\n" +
                              "        <NFeLoteStatusArquivo xmlns=\"http://www.barueri.sp.gov.br/nfe\">\n" +
                              "            <VersaoSchema>1</VersaoSchema>\n" +
                              "            <MensagemXML><![CDATA[\n" +
                              request.toXml() +
                              "            ]]>\n" +
                              "            </MensagemXML>\n" +
                              "        </NFeLoteStatusArquivo>\n" +
                              "    </soap12:Body>\n" +
                              "</soap12:Envelope>";

        final var response = new NFSeHttpClient(config).sendPostRequest(new URI(config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), soapEnvelope);
        final var body = response.body();
        this.getLogger().debug(body);
        return (NFSeBarueriLoteStatusArquivoResponse) new NFSePersister().read(NFSeBarueriSoapEnvelope.class, body).getResponse();
    }

    public NFSeBarueriLoteBaixarArquivoResponse loteBaixarArquivo(NFSeBarueriLoteBaixarArquivoRequest request) throws Exception {
        String soapEnvelope = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                              "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
                              "    <soap12:Body>\n" +
                              "        <NFeLoteBaixarArquivo xmlns=\"http://www.barueri.sp.gov.br/nfe\">\n" +
                              "            <VersaoSchema>1</VersaoSchema>\n" +
                              "            <MensagemXML><![CDATA[\n" +
                              request.toXml() +
                              "            ]]>\n" +
                              "            </MensagemXML>\n" +
                              "        </NFeLoteBaixarArquivo>\n" +
                              "    </soap12:Body>\n" +
                              "</soap12:Envelope>";

        final var response = new NFSeHttpClient(config).sendPostRequest(new URI(config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), soapEnvelope);
        final var body = response.body();
        this.getLogger().debug(body);
        return (NFSeBarueriLoteBaixarArquivoResponse) new NFSePersister().read(NFSeBarueriSoapEnvelope.class, body).getResponse();
    }
}
