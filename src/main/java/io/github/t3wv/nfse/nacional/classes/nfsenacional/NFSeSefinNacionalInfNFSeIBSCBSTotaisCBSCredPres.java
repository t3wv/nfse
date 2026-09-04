package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotaisCBSCredPres {
    @Element(name = "pCredPresCBS")
    private BigDecimal pCredPresCBS;
    @Element(name = "vCredPresCBS")
    private BigDecimal vCredPresCBS;

    public BigDecimal getpCredPresCBS() {
        return pCredPresCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisCBSCredPres setpCredPresCBS(BigDecimal pCredPresCBS) {
        this.pCredPresCBS = pCredPresCBS;
        return this;
    }

    public BigDecimal getvCredPresCBS() {
        return vCredPresCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisCBSCredPres setvCredPresCBS(BigDecimal vCredPresCBS) {
        this.vCredPresCBS = vCredPresCBS;
        return this;
    }
}
