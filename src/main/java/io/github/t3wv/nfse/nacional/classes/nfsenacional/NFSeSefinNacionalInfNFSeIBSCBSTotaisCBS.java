package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS {
    @Element(name = "gCBSCredPres", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisCBSCredPres gCBSCredPres;
    @Element(name = "vDifCBS", required = false)
    private BigDecimal vDifCBS;
    @Element(name = "vCBS")
    private BigDecimal vCBS;

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisCBSCredPres getgCBSCredPres() {
        return gCBSCredPres;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS setgCBSCredPres(NFSeSefinNacionalInfNFSeIBSCBSTotaisCBSCredPres gCBSCredPres) {
        this.gCBSCredPres = gCBSCredPres;
        return this;
    }

    public BigDecimal getvDifCBS() {
        return vDifCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS setvDifCBS(BigDecimal vDifCBS) {
        this.vDifCBS = vDifCBS;
        return this;
    }

    public BigDecimal getvCBS() {
        return vCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS setvCBS(BigDecimal vCBS) {
        this.vCBS = vCBS;
        return this;
    }
}
