package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSValoresUF {
    @Element(name = "pIBSUF", required = false)
    private BigDecimal pIBSUF;
    @Element(name = "pRedAliqUF", required = false)
    private BigDecimal pRedAliqUF;
    @Element(name = "pAliqEfetUF", required = false)
    private BigDecimal pAliqEfetUF;

    public BigDecimal getpIBSUF() {
        return pIBSUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresUF setpIBSUF(BigDecimal pIBSUF) {
        this.pIBSUF = pIBSUF;
        return this;
    }

    public BigDecimal getpRedAliqUF() {
        return pRedAliqUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresUF setpRedAliqUF(BigDecimal pRedAliqUF) {
        this.pRedAliqUF = pRedAliqUF;
        return this;
    }

    public BigDecimal getpAliqEfetUF() {
        return pAliqEfetUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresUF setpAliqEfetUF(BigDecimal pAliqEfetUF) {
        this.pAliqEfetUF = pAliqEfetUF;
        return this;
    }
}
