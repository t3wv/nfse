package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSCredPres {

    @Element(name = "pCredPresIBS")
    private double pCredPresIBS;
    @Element(name = "vCredPresIBS")
    private BigDecimal vCredPresIBS;

    public double getpCredPresIBS() {
        return pCredPresIBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSCredPres setpCredPresIBS(double pCredPresIBS) {
        this.pCredPresIBS = pCredPresIBS;
        return this;
    }

    public BigDecimal getvCredPresIBS() {
        return vCredPresIBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSCredPres setvCredPresIBS(BigDecimal vCredPresIBS) {
        this.vCredPresIBS = vCredPresIBS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
