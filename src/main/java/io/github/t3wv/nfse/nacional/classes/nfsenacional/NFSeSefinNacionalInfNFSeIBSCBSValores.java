package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSValores {
    @Element(name = "vBC", required = false)
    private BigDecimal vBC;

    @Element(name = "vCalcReeRepRes", required = false)
    private BigDecimal vCalcReeRepRes;

    @Element(name = "uf", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSValoresUF uf;

    @Element(name = "mun", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSValoresMun mun;

    @Element(name = "fed", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSValoresFed fed;

    public BigDecimal getvBC() {
        return vBC;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores setvBC(BigDecimal vBC) {
        this.vBC = vBC;
        return this;
    }

    public BigDecimal getvCalcReeRepRes() {
        return vCalcReeRepRes;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores setvCalcReeRepRes(BigDecimal vCalcReeRepRes) {
        this.vCalcReeRepRes = vCalcReeRepRes;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresUF getUf() {
        return uf;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores setUf(NFSeSefinNacionalInfNFSeIBSCBSValoresUF uf) {
        this.uf = uf;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresMun getMun() {
        return mun;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores setMun(NFSeSefinNacionalInfNFSeIBSCBSValoresMun mun) {
        this.mun = mun;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValoresFed getFed() {
        return fed;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores setFed(NFSeSefinNacionalInfNFSeIBSCBSValoresFed fed) {
        this.fed = fed;
        return this;
    }
}
