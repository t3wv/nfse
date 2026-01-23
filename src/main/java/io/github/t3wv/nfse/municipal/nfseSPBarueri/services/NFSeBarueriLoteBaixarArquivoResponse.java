package io.github.t3wv.nfse.municipal.nfseSPBarueri.services;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.io.StringWriter;

@Root(name = "NFeLoteBaixarArquivoResponse")
@Namespace(reference = "http://www.barueri.sp.gov.br/nfe")
public class NFSeBarueriLoteBaixarArquivoResponse {

    @Element(name = "NFeLoteBaixarArquivoResult")
    private NFSeBarueriLoteBaixarArquivoResult resultado;

    public NFSeBarueriLoteBaixarArquivoResult getResultado() {
        return resultado;
    }

    public void setResultado(NFSeBarueriLoteBaixarArquivoResult resultado) {
        this.resultado = resultado;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
