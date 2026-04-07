
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

@Root(name = "TribNacional")
public class NFSeSefinNacionalTribFederal {

    @Element(name = "piscofins", required = false)
    protected NFSeSefinNacionalTribOutrosPisCofins piscofins;
    @Element(name = "vRetCP", required = false)
    protected BigDecimal valorCP;
    @Element(name = "vRetIRRF", required = false)
    protected BigDecimal valorIRRF;
    @Element(name = "vRetCSLL", required = false)
    protected BigDecimal valorCSLL;

    /**
     * @return Informações dos tributos PIS/COFINS
     */
    public NFSeSefinNacionalTribOutrosPisCofins getPiscofins() {
        return piscofins;
    }

    /**
     * @param value Informações dos tributos PIS/COFINS
     */
    public NFSeSefinNacionalTribFederal setPiscofins(NFSeSefinNacionalTribOutrosPisCofins value) {
        this.piscofins = value;
        return this;
    }

    /**
     * @return Valor retido do tributo CP
     */
    public BigDecimal getValorCP() {
        return valorCP;
    }

    /**
     * @param value Valor retido do tributo CP
     */
    public NFSeSefinNacionalTribFederal setValorCP(BigDecimal value) {
        this.valorCP = value;
        return this;
    }

    /**
     * @return Valor retido do tributo IRRF
     */
    public BigDecimal getValorIRRF() {
        return valorIRRF;
    }

    /**
     * @param value Valor retido do tributo IRRF
     */
    public NFSeSefinNacionalTribFederal setValorIRRF(BigDecimal value) {
        this.valorIRRF = value;
        return this;
    }

    /**
     * @return Valor retido do tributo CSLL
     */
    public BigDecimal getValorCSLL() {
        return valorCSLL;
    }

    /**
     * @param value Valor retido do tributo CSLL
     */
    public NFSeSefinNacionalTribFederal setValorCSLL(BigDecimal value) {
        this.valorCSLL = value;
        return this;
    }

}
