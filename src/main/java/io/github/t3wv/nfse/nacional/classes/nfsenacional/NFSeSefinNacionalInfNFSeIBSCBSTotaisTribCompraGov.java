package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov {
    @Element(name = "pIBSUF", required = false)
    private BigDecimal pIBSUF;
    @Element(name = "vIBSUF", required = false)
    private BigDecimal vIBSUF;
    @Element(name = "pIBSMun", required = false)
    private BigDecimal pIBSMun;
    @Element(name = "vIBSMun", required = false)
    private BigDecimal vIBSMun;
    @Element(name = "pCBS", required = false)
    private BigDecimal pCBS;
    @Element(name = "vCBS", required = false)
    private BigDecimal vCBS;

    public BigDecimal getpIBSUF() {
        return pIBSUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov setpIBSUF(BigDecimal pIBSUF) {
        this.pIBSUF = pIBSUF;
        return this;
    }

    public BigDecimal getvIBSUF() {
        return vIBSUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov setvIBSUF(BigDecimal vIBSUF) {
        this.vIBSUF = vIBSUF;
        return this;
    }

    public BigDecimal getpIBSMun() {
        return pIBSMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov setpIBSMun(BigDecimal pIBSMun) {
        this.pIBSMun = pIBSMun;
        return this;
    }

    public BigDecimal getvIBSMun() {
        return vIBSMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov setvIBSMun(BigDecimal vIBSMun) {
        this.vIBSMun = vIBSMun;
        return this;
    }

    public BigDecimal getpCBS() {
        return pCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov setpCBS(BigDecimal pCBS) {
        this.pCBS = pCBS;
        return this;
    }

    public BigDecimal getvCBS() {
        return vCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov setvCBS(BigDecimal vCBS) {
        this.vCBS = vCBS;
        return this;
    }
}
