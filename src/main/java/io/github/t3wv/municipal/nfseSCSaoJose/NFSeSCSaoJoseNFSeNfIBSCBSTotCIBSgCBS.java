package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS {

    @Element(name = "gCBSCredPres")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres gCBSCredPres;

    @Element(name = "vDifCBS")
    private BigDecimal vDifCBS;
    @Element(name = "vCBS")
    private BigDecimal vCBS;

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres getgCBSCredPres() {
        return gCBSCredPres;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS setgCBSCredPres(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres gCBSCredPres) {
        this.gCBSCredPres = gCBSCredPres;
        return this;
    }

    public BigDecimal getvDifCBS() {
        return vDifCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS setvDifCBS(BigDecimal vDifCBS) {
        this.vDifCBS = vDifCBS;
        return this;
    }

    public BigDecimal getvCBS() {
        return vCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS setvCBS(BigDecimal vCBS) {
        this.vCBS = vCBS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
