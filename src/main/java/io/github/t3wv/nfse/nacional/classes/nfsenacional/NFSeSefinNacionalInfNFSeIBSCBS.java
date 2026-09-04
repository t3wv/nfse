package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBS {
    @Element(name = "cLocalidadeIncid")
    private String cLocalidadeIncid;
    @Element(name = "xLocalidadeIncid")
    private String xLocalidadeIncid;
    @Element(name = "pRedutor", required = false)
    private BigDecimal pRedutor;
    @Element(name = "valores")
    private NFSeSefinNacionalInfNFSeIBSCBSValores valores;
    @Element(name = "totCIBS")
    private NFSeSefinNacionalInfNFSeIBSCBSTotais totCIBS;

    public String getcLocalidadeIncid() {
        return cLocalidadeIncid;
    }

    public NFSeSefinNacionalInfNFSeIBSCBS setcLocalidadeIncid(String cLocalidadeIncid) {
        this.cLocalidadeIncid = cLocalidadeIncid;
        return this;
    }

    public String getxLocalidadeIncid() {
        return xLocalidadeIncid;
    }

    public NFSeSefinNacionalInfNFSeIBSCBS setxLocalidadeIncid(String xLocalidadeIncid) {
        this.xLocalidadeIncid = xLocalidadeIncid;
        return this;
    }

    public BigDecimal getpRedutor() {
        return pRedutor;
    }

    public NFSeSefinNacionalInfNFSeIBSCBS setpRedutor(BigDecimal pRedutor) {
        this.pRedutor = pRedutor;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSValores getValores() {
        return valores;
    }

    public NFSeSefinNacionalInfNFSeIBSCBS setValores(NFSeSefinNacionalInfNFSeIBSCBSValores valores) {
        this.valores = valores;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais getTotCIBS() {
        return totCIBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBS setTotCIBS(NFSeSefinNacionalInfNFSeIBSCBSTotais totCIBS) {
        this.totCIBS = totCIBS;
        return this;
    }
}
