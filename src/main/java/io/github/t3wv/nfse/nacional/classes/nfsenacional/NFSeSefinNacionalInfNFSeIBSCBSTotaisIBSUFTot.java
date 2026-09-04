package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSUFTot {
    @Element(name = "vDifUF", required = false)
    private BigDecimal vDifUF;
    @Element(name = "vIBSUF")
    private BigDecimal vIBSUF;

    public BigDecimal getvDifUF() {
        return vDifUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSUFTot setvDifUF(BigDecimal vDifUF) {
        this.vDifUF = vDifUF;
        return this;
    }

    public BigDecimal getvIBSUF() {
        return vIBSUF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSUFTot setvIBSUF(BigDecimal vIBSUF) {
        this.vIBSUF = vIBSUF;
        return this;
    }
}
