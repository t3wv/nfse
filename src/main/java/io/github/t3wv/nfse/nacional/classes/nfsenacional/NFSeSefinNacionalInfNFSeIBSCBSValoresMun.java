package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSValoresMun {
    @Element(name="pIBSMun")
    private BigDecimal pIBSMun;
    @Element(name="pRedAliqMun", required = false)
    private BigDecimal pRedAliqMun;
    @Element(name="pAliqEfetMun")
    private BigDecimal pAliqEfetMun;

    public BigDecimal getpIBSMun() {
        return pIBSMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresMun setpIBSMun(BigDecimal pIBSMun) {
        this.pIBSMun = pIBSMun;
        return this;
    }

    public BigDecimal getpRedAliqMun() {
        return pRedAliqMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresMun setpRedAliqMun(BigDecimal pRedAliqMun) {
        this.pRedAliqMun = pRedAliqMun;
        return this;
    }

    public BigDecimal getpAliqEfetMun() {
        return pAliqEfetMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresMun setpAliqEfetMun(BigDecimal pAliqEfetMun) {
        this.pAliqEfetMun = pAliqEfetMun;
        return this;
    }
}
