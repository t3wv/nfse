package io.github.t3wv.municipal.nfseSPSaoPaulo.requests;

import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.SignatureType;
import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Root(name = "PedidoConsultaNFe")
@Namespace(reference = "http://www.prefeitura.sp.gov.br/nfe")
public class NFSeSPSaoPauloRequestConsultaNFe {

    @Element(name = "Cabecalho")
    protected NFSeSPSaoPauloRequestConsultaNFeCabecalho cabecalho;

    @ElementList(name = "Detalhe", inline = true)
    protected List<NFSeSPSaoPauloRequestConsultaNFeDetalhe> detalhe;

    @Element(name = "Signature", required = false)
    protected SignatureType signature;

    public NFSeSPSaoPauloRequestConsultaNFeCabecalho getCabecalho() {
        return cabecalho;
    }

    public NFSeSPSaoPauloRequestConsultaNFe setCabecalho(NFSeSPSaoPauloRequestConsultaNFeCabecalho cabecalho) {
        this.cabecalho = cabecalho;
        return this;
    }

    public List<NFSeSPSaoPauloRequestConsultaNFeDetalhe> getDetalhe() {
        return detalhe;
    }

    public NFSeSPSaoPauloRequestConsultaNFe setDetalhe(List<NFSeSPSaoPauloRequestConsultaNFeDetalhe> detalhe) {
        this.detalhe = detalhe;
        return this;
    }

    public NFSeSPSaoPauloRequestConsultaNFe addDetalhe(NFSeSPSaoPauloRequestConsultaNFeDetalhe detalheItem) {
        if (this.detalhe == null) {
            this.detalhe = new ArrayList<>();
        }
        this.detalhe.add(detalheItem);
        return this;
    }

    public SignatureType getSignature() {
        return signature;
    }

    public NFSeSPSaoPauloRequestConsultaNFe setSignature(SignatureType signature) {
        this.signature = signature;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
