package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Informações de locação, cessão onerosa ou arrendamento de imóvel (TCRTCLocacaoImovel, NT SE/CGNFS-e 009)
 */
@Root(name = "gLocacao")
public class NFSeSefinNacionalInfoIBSCBSImovelLocacao {
    @Element(name = "pCopropriedade")
    protected BigDecimal pCopropriedade;
    @Element(name = "vTotOper")
    protected BigDecimal vTotOper;
    @Element(name = "vDescIncondTot", required = false)
    protected BigDecimal vDescIncondTot;
    @Element(name = "vDescCondTot", required = false)
    protected BigDecimal vDescCondTot;
    @Element(name = "dVencOrig", required = false)
    protected LocalDate dVencOrig;

    /**
     * Percentual de copropriedade
     * @return pCopropriedade
     */
    public BigDecimal getpCopropriedade() {
        return pCopropriedade;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelLocacao setpCopropriedade(BigDecimal pCopropriedade) {
        this.pCopropriedade = pCopropriedade;
        return this;
    }

    /**
     * Valor total da operação
     * @return vTotOper
     */
    public BigDecimal getvTotOper() {
        return vTotOper;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelLocacao setvTotOper(BigDecimal vTotOper) {
        this.vTotOper = vTotOper;
        return this;
    }

    /**
     * Valor total do desconto incondicionado
     * @return vDescIncondTot
     */
    public BigDecimal getvDescIncondTot() {
        return vDescIncondTot;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelLocacao setvDescIncondTot(BigDecimal vDescIncondTot) {
        this.vDescIncondTot = vDescIncondTot;
        return this;
    }

    /**
     * Valor total do desconto condicionado
     * @return vDescCondTot
     */
    public BigDecimal getvDescCondTot() {
        return vDescCondTot;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelLocacao setvDescCondTot(BigDecimal vDescCondTot) {
        this.vDescCondTot = vDescCondTot;
        return this;
    }

    /**
     * Data de vencimento original
     * @return dVencOrig
     */
    public LocalDate getdVencOrig() {
        return dVencOrig;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelLocacao setdVencOrig(LocalDate dVencOrig) {
        this.dVencOrig = dVencOrig;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSImovelLocacao{" +
                "pCopropriedade=" + pCopropriedade +
                ", vTotOper=" + vTotOper +
                ", vDescIncondTot=" + vDescIncondTot +
                ", vDescCondTot=" + vDescCondTot +
                ", dVencOrig=" + dVencOrig +
                '}';
    }
}
