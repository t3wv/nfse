package io.github.t3wv.municipal.nfseSPSaoPaulo.requests;

import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.SignatureType;
import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.TpRPS;
import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Namespace(reference = "http://www.prefeitura.sp.gov.br/nfe")
public abstract class NFSeSPSaoPauloRequestEnvioRPS {
    @Element(name = "Cabecalho")
    protected NFSeSPSaoPauloRequestEnvioRPSCabecalho cabecalho;

    @ElementList(name = "RPS", inline = true)
    protected List<TpRPS> rps;

    @Element(name = "Signature", required = false)
    protected SignatureType signature;

    public NFSeSPSaoPauloRequestEnvioRPSCabecalho getCabecalho() {
        return cabecalho;
    }

    public NFSeSPSaoPauloRequestEnvioRPS setCabecalho(NFSeSPSaoPauloRequestEnvioRPSCabecalho cabecalho) {
        this.cabecalho = cabecalho;
        return this;
    }

    public List<TpRPS> getRps() {
        return rps;
    }

    public NFSeSPSaoPauloRequestEnvioRPS setRps(List<TpRPS> rps) {
        this.rps = rps;
        return this;
    }

    public NFSeSPSaoPauloRequestEnvioRPS addRps(TpRPS rpsItem) {
        if (this.rps == null) {
            this.rps = new ArrayList<>();
        }
        this.rps.add(rpsItem);
        return this;
    }

    public SignatureType getSignature() {
        return signature;
    }

    public NFSeSPSaoPauloRequestEnvioRPS setSignature(SignatureType signature) {
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
