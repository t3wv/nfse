package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS {
    @Element(name = "vIBSTot", required = false)
    private BigDecimal vIBSTot;
    @Element(name = "gIBSCredPres", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSCredPres gIBSCredPres;
    @Element(name = "gIBSUFTot", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSUFTot gIBSUFTot;
    @Element(name = "gIBSMunTot", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSMunTot gIBSMunTot;

    public BigDecimal getvIBSTot() {
        return vIBSTot;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS setvIBSTot(BigDecimal vIBSTot) {
        this.vIBSTot = vIBSTot;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSCredPres getgIBSCredPres() {
        return gIBSCredPres;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS setgIBSCredPres(NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSCredPres gIBSCredPres) {
        this.gIBSCredPres = gIBSCredPres;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSUFTot getgIBSUFTot() {
        return gIBSUFTot;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS setgIBSUFTot(NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSUFTot gIBSUFTot) {
        this.gIBSUFTot = gIBSUFTot;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSMunTot getgIBSMunTot() {
        return gIBSMunTot;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS setgIBSMunTot(NFSeSefinNacionalInfNFSeIBSCBSTotaisIBSMunTot gIBSMunTot) {
        this.gIBSMunTot = gIBSMunTot;
        return this;
    }
}
