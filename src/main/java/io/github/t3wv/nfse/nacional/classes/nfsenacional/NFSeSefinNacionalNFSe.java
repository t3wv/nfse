package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

@Namespace(reference = "http://www.sped.fazenda.gov.br/nfse")
@Root(name = "NFSe")
public class NFSeSefinNacionalNFSe {

    @Element(name = "infNFSe")
    protected NFSeSefinNacionalInfNFSe infNFSe;
    @Attribute(name = "versao", empty = "1.00")
    protected String versao;
    @Element(name = "Signature")
    protected SignatureType signature;

    public NFSeSefinNacionalInfNFSe getInfNFSe() {
        return infNFSe;
    }

    public NFSeSefinNacionalNFSe setInfNFSe(NFSeSefinNacionalInfNFSe value) {
        this.infNFSe = value;
        return this;
    }

    public String getVersao() {
        return versao;
    }

    public NFSeSefinNacionalNFSe setVersao(String versao) {
        this.versao = versao;
        return this;
    }

    public String toXml() throws Exception {
        Persister serializer = new Persister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

}
