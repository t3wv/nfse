package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeIBSCBSImovel {
    @Element(name = "inscImobFisc", required = false)
    private String inscImobFisc;

    @Element(name = "cCIB", required = false)
    private String cCIB;

    @Element(name = "end", required = false)
    private NFSeSCSaoJoseNFSeIBSCBSImovelEnd end;

    public String getInscImobFisc() {
        return inscImobFisc;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovel setInscImobFisc(String inscImobFisc) {
        this.inscImobFisc = inscImobFisc;
        return this;
    }

    public String getcCIB() {
        return cCIB;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovel setcCIB(String cCIB) {
        this.cCIB = cCIB;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEnd getEnd() {
        return end;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovel setEnd(NFSeSCSaoJoseNFSeIBSCBSImovelEnd end) {
        this.end = end;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
