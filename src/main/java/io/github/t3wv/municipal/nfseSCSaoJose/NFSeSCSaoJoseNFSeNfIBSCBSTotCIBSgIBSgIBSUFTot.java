package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSUFTot {

    @Element(name = "vDifUF")
    private BigDecimal vDifUF;
    @Element(name = "vIBSUF")
    private BigDecimal vIBSUF;

    public BigDecimal getvDifUF() {
        return vDifUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSUFTot setvDifUF(BigDecimal vDifUF) {
        this.vDifUF = vDifUF;
        return this;
    }

    public BigDecimal getvIBSUF() {
        return vIBSUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSUFTot setvIBSUF(BigDecimal vIBSUF) {
        this.vIBSUF = vIBSUF;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
