package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;

public class NFSeSefinNacionalInfNFSeIBSCBSTotais {
    @Element( name="vTotNF", required = false)
    private BigDecimal vTotNF;
    @Element( name="gIBS", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS gIBS;
    @Element( name="gCBS", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS gCBS;
    @Element( name="gTribRegular", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular gTribRegular;
    @Element( name="gTribCompraGov", required = false)
    private NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov gTribCompraGov;

    public BigDecimal getvTotNF() {
        return vTotNF;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setvTotNF(BigDecimal vTotNF) {
        this.vTotNF = vTotNF;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS getgIBS() {
        return gIBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgIBS(NFSeSefinNacionalInfNFSeIBSCBSTotaisIBS gIBS) {
        this.gIBS = gIBS;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS getgCBS() {
        return gCBS;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgCBS(NFSeSefinNacionalInfNFSeIBSCBSTotaisCBS gCBS) {
        this.gCBS = gCBS;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular getgTribRegular() {
        return gTribRegular;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgTribRegular(NFSeSefinNacionalInfNFSeIBSCBSTotaisTribRegular gTribRegular) {
        this.gTribRegular = gTribRegular;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov getgTribCompraGov() {
        return gTribCompraGov;
    }

    public NFSeSefinNacionalInfNFSeIBSCBSTotais setgTribCompraGov(NFSeSefinNacionalInfNFSeIBSCBSTotaisTribCompraGov gTribCompraGov) {
        this.gTribCompraGov = gTribCompraGov;
        return this;
    }
}
