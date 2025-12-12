package io.github.t3wv.nacional.classes.nfsenacional;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

@Namespace(reference = "http://www.sped.fazenda.gov.br/nfse")
@Root(name = "DPS")
public class NFSeSefinNacionalDPS {

    @Element(name = "infDPS")
    protected NFSeSefinNacionalInfDPS infDPS;
    @Attribute(name = "versao", empty = "1.00")
    protected String versao;
    @Element(name = "Signature", required = false)
    protected SignatureType signature;

    public NFSeSefinNacionalInfDPS getInfDPS() {
        return infDPS;
    }

    public NFSeSefinNacionalDPS setInfDPS(NFSeSefinNacionalInfDPS value) {
        this.infDPS = value;
        return this;
    }

    public String getVersao() {
        return versao;
    }

    public NFSeSefinNacionalDPS setVersao(String value) {
        this.versao = value;
        return this;
    }

    public SignatureType getSignature() {
        return signature;
    }

    public NFSeSefinNacionalDPS setSignature(SignatureType signature) {
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
