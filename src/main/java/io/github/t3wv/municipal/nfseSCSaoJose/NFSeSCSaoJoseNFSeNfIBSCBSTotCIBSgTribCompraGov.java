package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov {
    @Element(name = "pIBSUF")
    private double pIBSUF;
    @Element(name = "vIBSUF")
    private BigDecimal vIBSUF;
    @Element(name = "pIBSMun")
    private double pIBSMun;
    @Element(name = "vIBSMun")
    private BigDecimal vIBSMun;
    @Element(name = "pCBS")
    private double pCBS;
    @Element(name = "vCBS")
    private BigDecimal vCBS;

    public double getpIBSUF() {
        return pIBSUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov setpIBSUF(double pIBSUF) {
        this.pIBSUF = pIBSUF;
        return this;
    }

    public BigDecimal getvIBSUF() {
        return vIBSUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov setvIBSUF(BigDecimal vIBSUF) {
        this.vIBSUF = vIBSUF;
        return this;
    }

    public double getpIBSMun() {
        return pIBSMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov setpIBSMun(double pIBSMun) {
        this.pIBSMun = pIBSMun;
        return this;
    }

    public BigDecimal getvIBSMun() {
        return vIBSMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov setvIBSMun(BigDecimal vIBSMun) {
        this.vIBSMun = vIBSMun;
        return this;
    }

    public double getpCBS() {
        return pCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov setpCBS(double pCBS) {
        this.pCBS = pCBS;
        return this;
    }

    public BigDecimal getvCBS() {
        return vCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov setvCBS(BigDecimal vCBS) {
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
