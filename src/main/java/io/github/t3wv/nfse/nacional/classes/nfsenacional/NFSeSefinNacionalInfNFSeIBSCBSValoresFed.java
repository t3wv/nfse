package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSValoresFed {
    @Element(name="pCBS", required = false)
    private BigDecimal pCBS;
    @Element(name="pRedAliqCBS", required = false)
    private BigDecimal pRedAliqCBS;
    @Element(name="pAliqEfetCBS", required = false)
    private BigDecimal pAliqEfetCBS;

    public BigDecimal getpCBS() {
        return pCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresFed setpCBS(BigDecimal pCBS) {
        this.pCBS = pCBS;
        return this;
    }

    public BigDecimal getpRedAliqCBS() {
        return pRedAliqCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresFed setpRedAliqCBS(BigDecimal pRedAliqCBS) {
        this.pRedAliqCBS = pRedAliqCBS;
        return this;
    }

    public BigDecimal getpAliqEfetCBS() {
        return pAliqEfetCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresFed setpAliqEfetCBS(BigDecimal pAliqEfetCBS) {
        this.pAliqEfetCBS = pAliqEfetCBS;
        return this;
    }
}
