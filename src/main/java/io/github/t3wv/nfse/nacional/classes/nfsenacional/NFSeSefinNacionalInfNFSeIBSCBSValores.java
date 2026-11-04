package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSValores {
    @Element(name = "vBC", required = false)
    private BigDecimal vBC;

    @Element(name = "vCalcAjusteBCLocImoveis", required = false)
    private BigDecimal vCalcAjusteBCLocImoveis;

    @Element(name = "vCalcAjusteBCIBSCBS", required = false)
    private BigDecimal vCalcAjusteBCIBSCBS;

    @Element(name = "uf")
    private NFSeSefinNacionalInfNFSeIBSCBSValoresUF uf;

    @Element(name = "mun")
    private NFSeSefinNacionalInfNFSeIBSCBSValoresMun mun;

    @Element(name = "fed")
    private NFSeSefinNacionalInfNFSeIBSCBSValoresFed fed;

    public BigDecimal getvBC() {
        return vBC;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores setvBC(BigDecimal vBC) {
        this.vBC = vBC;
        return this;
    }

    /**
     * Valor calculado do ajuste da base de cálculo do IBS/CBS na locação de imóveis (NT SE/CGNFS-e 009)
     */
    public BigDecimal getvCalcAjusteBCLocImoveis() {
        return vCalcAjusteBCLocImoveis;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores setvCalcAjusteBCLocImoveis(BigDecimal vCalcAjusteBCLocImoveis) {
        this.vCalcAjusteBCLocImoveis = vCalcAjusteBCLocImoveis;
        return this;
    }

    /**
     * Valor calculado do ajuste da base de cálculo do IBS/CBS por documentos (NT SE/CGNFS-e 009; substitui o vCalcReeRepRes)
     */
    public BigDecimal getvCalcAjusteBCIBSCBS() {
        return vCalcAjusteBCIBSCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores setvCalcAjusteBCIBSCBS(BigDecimal vCalcAjusteBCIBSCBS) {
        this.vCalcAjusteBCIBSCBS = vCalcAjusteBCIBSCBS;
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
