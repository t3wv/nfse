package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSMunTot {
    @Element(name = "vDifMun", required = false)
    private BigDecimal vDifMun;
    @Element(name = "vIBSMun", required = false)
    private BigDecimal vIBSMun;

    public BigDecimal getvDifMun() {
        return vDifMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSMunTot setvDifMun(BigDecimal vDifMun) {
        this.vDifMun = vDifMun;
        return this;
    }

    public BigDecimal getvIBSMun() {
        return vIBSMun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSMunTot setvIBSMun(BigDecimal vIBSMun) {
        this.vIBSMun = vIBSMun;
        return this;
    }
}
