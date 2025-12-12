package io.github.t3wv.municipal.nfseSPSaoPaulo.webservices;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.NFSeHttpClient;
import io.github.t3wv.municipal.nfseSPSaoPaulo.requests.NFSeSPSaoPauloRequestCancelamentoNFe;
import io.github.t3wv.municipal.nfseSPSaoPaulo.requests.NFSeSPSaoPauloRequestConsultaNFe;
import io.github.t3wv.municipal.nfseSPSaoPaulo.requests.NFSeSPSaoPauloRequestEnvioRPS;
import io.github.t3wv.utils.NFSeAssinaturaDigital;

import java.net.URI;
import java.util.Map;

public class WSRPS {

    public static final String URL_BASE = "https://nfews.prefeitura.sp.gov.br/lotenfe.asmx";

    private final NFSeConfig config;

    public WSRPS(NFSeConfig config) {
        this.config = config;
    }

    public String enviarTesteLoteRPS(NFSeSPSaoPauloRequestEnvioRPS pedidoEnvioRPS) throws Exception {
        final var body = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><TesteEnvioLoteRPSRequest xmlns=\"http://www.prefeitura.sp.gov.br/nfe\"><VersaoSchema>%s</VersaoSchema><MensagemXML><![CDATA[%s]]></MensagemXML></TesteEnvioLoteRPSRequest></soap12:Body></soap12:Envelope>", pedidoEnvioRPS.getCabecalho().getVersao(), new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(true).setUsarIdComoReferencia(false).assinarDocumento(pedidoEnvioRPS.toXml()));
        final var response = new NFSeHttpClient(this.config).sendPostRequest(new URI(URL_BASE), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), body);
        return response.body();
    }

    public String enviarRPS(NFSeSPSaoPauloRequestEnvioRPS pedidoEnvioRPS) throws Exception {
        final var body = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><EnvioRPSRequest xmlns=\"http://www.prefeitura.sp.gov.br/nfe\"><VersaoSchema>%s</VersaoSchema><MensagemXML><![CDATA[%s]]></MensagemXML></EnvioRPSRequest></soap12:Body></soap12:Envelope>", pedidoEnvioRPS.getCabecalho().getVersao(), new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(true).setUsarIdComoReferencia(false).assinarDocumento(pedidoEnvioRPS.toXml()));
        final var response = new NFSeHttpClient(this.config).sendPostRequest(new URI(URL_BASE), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), body);
        return response.body();
    }

    public String enviarPedidoConsultaNFe(NFSeSPSaoPauloRequestConsultaNFe pedidoConsultaNFe) throws Exception {
        final var body = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><ConsultaNFeRequest xmlns=\"http://www.prefeitura.sp.gov.br/nfe\"><VersaoSchema>1</VersaoSchema><MensagemXML><![CDATA[%s]]></MensagemXML></ConsultaNFeRequest></soap12:Body></soap12:Envelope>", new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(true).setUsarIdComoReferencia(false).assinarDocumento(pedidoConsultaNFe.toXml()));
        final var response = new NFSeHttpClient(this.config).sendPostRequest(new URI(URL_BASE), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), body);
        return response.body();
    }

    public String enviarPedidoCancelamentoNFe(NFSeSPSaoPauloRequestCancelamentoNFe pedidoCancelamentoNFe) throws Exception {
        final var body = String.format("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\"><soap12:Body><CancelamentoNFeRequest xmlns=\"http://www.prefeitura.sp.gov.br/nfe\"><VersaoSchema>%s</VersaoSchema><MensagemXML><![CDATA[%s]]></MensagemXML></CancelamentoNFeRequest></soap12:Body></soap12:Envelope>", pedidoCancelamentoNFe.getCabecalho().getVersao(), new NFSeAssinaturaDigital(this.config).setOmitirDeclaracaoXML(true).setUsarIdComoReferencia(false).assinarDocumento(pedidoCancelamentoNFe.toXml()));
        final var response = new NFSeHttpClient(this.config).sendPostRequest(new URI(URL_BASE), Map.of("Content-Type", "application/soap+xml; charset=utf-8"), body);
        return response.body();
    }
}
