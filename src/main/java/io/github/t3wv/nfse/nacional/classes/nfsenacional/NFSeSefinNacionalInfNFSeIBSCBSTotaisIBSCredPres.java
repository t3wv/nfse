package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSCredPres {
    @Element(name = "pCredPresIBS")
    private BigDecimal pCredPresIBS;
    @Element(name = "vCredPresIBS")
    private BigDecimal vCredPresIBS;

    public BigDecimal getpCredPresIBS() {
        return pCredPresIBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSCredPres setpCredPresIBS(BigDecimal pCredPresIBS) {
        this.pCredPresIBS = pCredPresIBS;
        return this;
    }

    public BigDecimal getvCredPresIBS() {
        return vCredPresIBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSCredPres setvCredPresIBS(BigDecimal vCredPresIBS) {
        this.vCredPresIBS = vCredPresIBS;
        return this;
    }
}
