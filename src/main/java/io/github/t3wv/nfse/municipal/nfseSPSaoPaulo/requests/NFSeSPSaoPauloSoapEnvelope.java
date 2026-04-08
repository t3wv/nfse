package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.requests;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

@Root(name = "Envelope", strict = false)
@NamespaceList({
        @Namespace(prefix = "soap", reference = "http://schemas.xmlsoap.org/soap/envelope/"),
        @Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace(prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema")
})
public class NFSeSPSaoPauloSoapEnvelope <T> {
    @Element(name = "Body")
    private NFSeSPSaoPauloSoapEnvelope.SoapBody<T> body;

    public NFSeSPSaoPauloSoapEnvelope.SoapBody<T> getBody() {
        return body;
    }

    public T getResponse() throws Exception {
        return body != null ? body.getContent() : null;
    }

    @Root(name = "Body", strict = false)
    public static class SoapBody<T> {

        @Element(name = "EnvioRPSResponse", required = false)
        private EnvioLoteRPSResponse enviarResponse;

        @Element(name = "EnvioLoteRPSResponse", required = false)
        private EnvioLoteRPSResponse enviarLoteResponse;

        @Element(name = "TesteEnvioLoteRPSResponse", required = false)
        private EnvioLoteRPSResponse testeEnviarResponse;

        @Element(name = "ConsultaNFeResponse", required = false)
        private ConsultaNFeResponse consultaNFeResponse;

        @Element(name = "CancelamentoNFeResponse", required = false)
        private CancelamentoNFeResponse cancelamentoNFeResponse;

        public T getContent() throws Exception {
            if (enviarResponse != null) return (T) enviarResponse.getRetornoXML();
            if (enviarLoteResponse != null) return (T) enviarLoteResponse.getRetornoXML();
            if (testeEnviarResponse != null) return (T) testeEnviarResponse.getRetornoXML();
            if (consultaNFeResponse != null) return (T) consultaNFeResponse.getRetornoXML();
            if (cancelamentoNFeResponse != null) return (T) cancelamentoNFeResponse.getRetornoXML();
            return null;
        }
    }

    private static class EnvioLoteRPSResponse {
        @Element(name = "RetornoXML", required = false)
        private String retornoXml;

        public NFSeSPSaoPauloRetornoEnvioLoteRPS getRetornoXML() throws Exception {
            return new NFSePersister().read(NFSeSPSaoPauloRetornoEnvioLoteRPS.class, retornoXml);
        }
    }

    private static class ConsultaNFeResponse {
        @Element(name = "RetornoXML", required = false)
        private String retornoXml;

        public NFSeSPSaoPauloRetornoConsultaNFe getRetornoXML() throws Exception {
            return new NFSePersister().read(NFSeSPSaoPauloRetornoConsultaNFe.class, retornoXml);
        }
    }

    private static class CancelamentoNFeResponse {
        @Element(name = "RetornoXML", required = false)
        private String retornoXml;

        public NFSeSPSaoPauloRetornoCancelamentoNFe getRetornoXML() throws Exception {
            return new NFSePersister().read(NFSeSPSaoPauloRetornoCancelamentoNFe.class, retornoXml);
        }
    }

}
