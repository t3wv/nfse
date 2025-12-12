package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot {
    @Element(name = "vDifMun")
    private BigDecimal vDifMun;
    @Element(name = "vIBSMun")
    private BigDecimal vIBSMun;

    public BigDecimal getvDifMun() {
        return vDifMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot setvDifMun(BigDecimal vDifMun) {
        this.vDifMun = vDifMun;
        return this;
    }

    public BigDecimal getvIBSMun() {
        return vIBSMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot setvIBSMun(BigDecimal vIBSMun) {
        this.vIBSMun = vIBSMun;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
