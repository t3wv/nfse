
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "ValoresNFSe")
public class NFSeSefinNacionalValoresNFSe {
    @Element(name = "vCalcDR", required = false)
    protected String vCalcDR;
    @Element(name = "tpBM", required = false)
    protected String tpBM;
    @Element(name = "vCalcBM", required = false)
    protected String vCalcBM;
    @Element(name = "vBC", required = false)
    protected String vbc;
    @Element(name = "pAliqAplic", required = false)
    protected String pAliqAplic;
    @Element(name = "vISSQN", required = false)
    protected String vissqn;
    @Element(name = "vTotalRet", required = false)
    protected String vTotalRet;
    @Element(name = "vLiq", required = false)
    protected String vLiq;
    @Element(name = "xOutInf", required = false)
    protected String xOutInf;


    public String getVCalcDR() {
        return vCalcDR;
    }

    public NFSeSefinNacionalValoresNFSe setVCalcDR(String value) {
        this.vCalcDR = value;
        return this;
    }

    public String getTpBM() {
        return tpBM;
    }

    public NFSeSefinNacionalValoresNFSe setTpBM(String value) {
        this.tpBM = value;
        return this;
    }

    public String getVCalcBM() {
        return vCalcBM;
    }

    public NFSeSefinNacionalValoresNFSe setVCalcBM(String value) {
        this.vCalcBM = value;
        return this;
    }

    public String getVBC() {
        return vbc;
    }

    public NFSeSefinNacionalValoresNFSe setVBC(String value) {
        this.vbc = value;
        return this;
    }

    public String getPAliqAplic() {
        return pAliqAplic;
    }

    public NFSeSefinNacionalValoresNFSe setPAliqAplic(String value) {
        this.pAliqAplic = value;
        return this;
    }

    public String getVISSQN() {
        return vissqn;
    }

    public NFSeSefinNacionalValoresNFSe setVISSQN(String value) {
        this.vissqn = value;
        return this;
    }

    public String getVTotalRet() {
        return vTotalRet;
    }

    public NFSeSefinNacionalValoresNFSe setVTotalRet(String value) {
        this.vTotalRet = value;
        return this;
    }

    public String getVLiq() {
        return vLiq;
    }

    public NFSeSefinNacionalValoresNFSe setVLiq(String value) {
        this.vLiq = value;
        return this;
    }

    public String getXOutInf() {
        return xOutInf;
    }

    public NFSeSefinNacionalValoresNFSe setXOutInf(String value) {
        this.xOutInf = value;
        return this;
    }

}
