package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres {

    @Element(name = "pCredPresCBS")
    private double pCredPresCBS;
    @Element(name = "vCredPresCBS")
    private BigDecimal vCredPresCBS;

    public double getpCredPresCBS() {
        return pCredPresCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres setpCredPresCBS(double pCredPresCBS) {
        this.pCredPresCBS = pCredPresCBS;
        return this;
    }

    public BigDecimal getvCredPresCBS() {
        return vCredPresCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres setvCredPresCBS(BigDecimal vCredPresCBS) {
        this.vCredPresCBS = vCredPresCBS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
