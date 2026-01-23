package io.github.t3wv.nfse.municipal.nfseSPBarueri.services;

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
public class NFSeBarueriSoapEnvelope <T> {

    @Element(name = "Body")
    private SoapBody<T> body;

    public SoapBody<T> getBody() {
        return body;
    }

    public T getResponse() {
        return body != null ? body.getContent() : null;
    }

    @Root(name = "Body", strict = false)
    public static class SoapBody<T> {

        @Element(name = "NFeLoteEnviarArquivoResponse", required = false)
        private NFSeBarueriLoteEnviarArquivoResponse enviarResponse;

        @Element(name = "NFeLoteStatusArquivoResponse", required = false)
        private NFSeBarueriLoteStatusArquivoResponse statusResponse; // Substitua por sua classe específica

        @Element(name = "NFeLoteBaixarArquivoResponse", required = false)
        private NFSeBarueriLoteBaixarArquivoResponse baixarResponse; // Substitua por sua classe específica

        @SuppressWarnings("unchecked")
        public T getContent() {
            if (enviarResponse != null) return (T) enviarResponse;
            if (statusResponse != null) return (T) statusResponse;
            if (baixarResponse != null) return (T) baixarResponse;
            return null;
        }
    }
}

