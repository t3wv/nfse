package io.github.t3wv.municipal.nfseSPBarueri.webservices;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.NFSeHttpClient;
import io.github.t3wv.NFSeObjectMapper;
import io.github.t3wv.municipal.nfseSPBarueri.classes.*;
import org.simpleframework.xml.core.Persister;

import java.net.URI;
import java.util.Map;

public class WSRPS {

    public static final String URL_BASE_PRODUCAO = "https://www.barueri.sp.gov.br/nfeservice/wsrps.asmx";
    public static final String URL_BASE_HOMOLOGACAO = "https://testeeiss.barueri.sp.gov.br/nfeservice/wsrps.asmx";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeConfig config;

    public WSRPS(NFSeConfig config) {
        this.config = config;
    }

    public NFSeBarueriLoteEnviarArquivoResponse NFeLoteEnviarArquivo(NFSeBarueriLoteEnviarArquivoRequest request) throws Exception {
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

        final var response = new NFSeHttpClient(config).sendPostRequest( new URI(config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), soapEnvelope);
        Persister serializer = new Persister();
        return (NFSeBarueriLoteEnviarArquivoResponse) serializer.read(NFSeBarueriSoapEnvelope.class, response.body()).getResponse();
    }

    public NFSeBarueriLoteStatusArquivoResponse NFeLoteStatusArquivo(final NFSeBarueriLoteStatusArquivoRequest request) throws Exception {
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

        Persister serializer = new Persister();
        return (NFSeBarueriLoteStatusArquivoResponse) serializer.read(NFSeBarueriSoapEnvelope.class, response.body()).getResponse();
    }

    public NFSeBarueriLoteBaixarArquivoResponse NFeLoteBaixarArquivo(NFSeBarueriLoteBaixarArquivoRequest request) throws Exception {
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
        Persister serializer = new Persister();
        return (NFSeBarueriLoteBaixarArquivoResponse) serializer.read(NFSeBarueriSoapEnvelope.class, response.body()).getResponse();
    }
}
