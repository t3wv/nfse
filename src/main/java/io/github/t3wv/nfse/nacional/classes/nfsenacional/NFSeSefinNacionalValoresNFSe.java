
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.math.BigDecimal;

@Root(name = "ValoresNFSe")
public class NFSeSefinNacionalValoresNFSe {
    @Element(name = "vCalcDR", required = false)
    protected BigDecimal vCalcDR;
    @Element(name = "tpBM", required = false)
    protected String tpBM;
    @Element(name = "vCalcBM", required = false)
    protected BigDecimal vCalcBM;
    @Element(name = "vBC", required = false)
    protected BigDecimal vbc;
    @Element(name = "pAliqAplic", required = false)
    protected BigDecimal pAliqAplic;
    @Element(name = "vISSQN", required = false)
    protected BigDecimal vissqn;
    @Element(name = "vTotalRet", required = false)
    protected BigDecimal vTotalRet;
    @Element(name = "vLiq", required = false)
    protected BigDecimal vLiq;
    @Element(name = "xOutInf", required = false)
    protected String xOutInf;


    public BigDecimal getVCalcDR() {
        return vCalcDR;
    }

    public NFSeSefinNacionalValoresNFSe setVCalcDR(BigDecimal value) {
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

    public BigDecimal getVCalcBM() {
        return vCalcBM;
    }

    public NFSeSefinNacionalValoresNFSe setVCalcBM(BigDecimal value) {
        this.vCalcBM = value;
        return this;
    }

    public BigDecimal getVBC() {
        return vbc;
    }

    public NFSeSefinNacionalValoresNFSe setVBC(BigDecimal value) {
        this.vbc = value;
        return this;
    }

    public BigDecimal getPAliqAplic() {
        return pAliqAplic;
    }

    public NFSeSefinNacionalValoresNFSe setPAliqAplic(BigDecimal value) {
        this.pAliqAplic = value;
        return this;
    }

    public BigDecimal getVISSQN() {
        return vissqn;
    }

    public NFSeSefinNacionalValoresNFSe setVISSQN(BigDecimal value) {
        this.vissqn = value;
        return this;
    }

    public BigDecimal getVTotalRet() {
        return vTotalRet;
    }

    public NFSeSefinNacionalValoresNFSe setVTotalRet(BigDecimal value) {
        this.vTotalRet = value;
        return this;
    }

    public BigDecimal getVLiq() {
        return vLiq;
    }

    public NFSeSefinNacionalValoresNFSe setVLiq(BigDecimal value) {
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
