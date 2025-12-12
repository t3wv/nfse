package io.github.t3wv.nacional.classes.nfsenacional;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

@Namespace(reference = "http://www.sped.fazenda.gov.br/nfse")
@Root(name = "pedRegEvento")
public class NFSeSefinNacionalPedRegEvt {

    @Element(name = "infPedReg")
    protected NFSeSefinNacionalInfPedReg infPedReg;
    @Element(name = "Signature", required = false)
    protected SignatureType signature;
    @Attribute(name = "versao", empty = "1.00")
    protected String versao;


    public NFSeSefinNacionalInfPedReg getInfPedReg() {
        return infPedReg;
    }

    public NFSeSefinNacionalPedRegEvt setInfPedReg(NFSeSefinNacionalInfPedReg value) {
        this.infPedReg = value;
        return this;
    }

    public SignatureType getSignature() {
        return signature;
    }

    public NFSeSefinNacionalPedRegEvt setSignature(SignatureType signature) {
        this.signature = signature;
        return this;
    }

    public String toXml() throws Exception {
        Persister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

}
