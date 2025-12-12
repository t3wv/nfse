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

@Root(name = "PedidoCancelamentoNFe")
@Namespace(reference = "http://www.prefeitura.sp.gov.br/nfe")
public class NFSeSPSaoPauloRequestCancelamentoNFe {

    @Element(name = "Cabecalho")
    protected NFSeSPSaoPauloRequestCancelamentoNFeCabecalho cabecalho;

    @ElementList(name = "Detalhe", inline = true)
    protected List<NFSeSPSaoPauloRequestCancelamentoNFeDetalhe> detalhe;

    @Element(name = "Signature", required = false)
    protected SignatureType signature;

    public NFSeSPSaoPauloRequestCancelamentoNFeCabecalho getCabecalho() {
        return cabecalho;
    }

    public NFSeSPSaoPauloRequestCancelamentoNFe setCabecalho(NFSeSPSaoPauloRequestCancelamentoNFeCabecalho cabecalho) {
        this.cabecalho = cabecalho;
        return this;
    }

    public List<NFSeSPSaoPauloRequestCancelamentoNFeDetalhe> getDetalhe() {
        return detalhe;
    }

    public NFSeSPSaoPauloRequestCancelamentoNFe setDetalhe(List<NFSeSPSaoPauloRequestCancelamentoNFeDetalhe> detalhe) {
        this.detalhe = detalhe;
        return this;
    }

    public NFSeSPSaoPauloRequestCancelamentoNFe addDetalhe(NFSeSPSaoPauloRequestCancelamentoNFeDetalhe detalheItem) {
        if (this.detalhe == null) {
            this.detalhe = new ArrayList<>();
        }
        this.detalhe.add(detalheItem);
        return this;
    }

    public SignatureType getSignature() {
        return signature;
    }

    public NFSeSPSaoPauloRequestCancelamentoNFe setSignature(SignatureType signature) {
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
