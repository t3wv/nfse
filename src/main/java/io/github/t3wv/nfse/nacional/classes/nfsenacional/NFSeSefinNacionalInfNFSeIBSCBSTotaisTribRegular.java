package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular {
    @Element(name = "pAliqEfeRegIBSUF")
    private BigDecimal pAliqEfeRegIBSUF;
    @Element(name = "vTribRegIBSUF")
    private BigDecimal vTribRegIBSUF;
    @Element(name = "pAliqEfeRegIBSMun")
    private BigDecimal pAliqEfeRegIBSMun;
    @Element(name = "vTribRegIBSMun")
    private BigDecimal vTribRegIBSMun;
    @Element(name = "pAliqEfeRegCBS")
    private BigDecimal pAliqEfeRegCBS;
    @Element(name = "vTribRegCBS")
    private BigDecimal vTribRegCBS;

    public BigDecimal getpAliqEfeRegIBSUF() {
        return pAliqEfeRegIBSUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular setpAliqEfeRegIBSUF(BigDecimal pAliqEfeRegIBSUF) {
        this.pAliqEfeRegIBSUF = pAliqEfeRegIBSUF;
        return this;
    }

    public BigDecimal getvTribRegIBSUF() {
        return vTribRegIBSUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular setvTribRegIBSUF(BigDecimal vTribRegIBSUF) {
        this.vTribRegIBSUF = vTribRegIBSUF;
        return this;
    }

    public BigDecimal getpAliqEfeRegIBSMun() {
        return pAliqEfeRegIBSMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular setpAliqEfeRegIBSMun(BigDecimal pAliqEfeRegIBSMun) {
        this.pAliqEfeRegIBSMun = pAliqEfeRegIBSMun;
        return this;
    }

    public BigDecimal getvTribRegIBSMun() {
        return vTribRegIBSMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular setvTribRegIBSMun(BigDecimal vTribRegIBSMun) {
        this.vTribRegIBSMun = vTribRegIBSMun;
        return this;
    }

    public BigDecimal getpAliqEfeRegCBS() {
        return pAliqEfeRegCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular setpAliqEfeRegCBS(BigDecimal pAliqEfeRegCBS) {
        this.pAliqEfeRegCBS = pAliqEfeRegCBS;
        return this;
    }

    public BigDecimal getvTribRegCBS() {
        return vTribRegCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular setvTribRegCBS(BigDecimal vTribRegCBS) {
        this.vTribRegCBS = vTribRegCBS;
        return this;
    }
}
