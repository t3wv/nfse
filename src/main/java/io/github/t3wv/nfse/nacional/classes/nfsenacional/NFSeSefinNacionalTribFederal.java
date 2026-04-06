
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TribNacional")
public class NFSeSefinNacionalTribFederal {

    @Element(name = "piscofins", required = false)
    protected NFSeSefinNacionalTribOutrosPisCofins piscofins;
    @Element(name = "vRetCP", required = false)
    protected String valorCP;
    @Element(name = "vRetIRRF", required = false)
    protected String valorIRRF;
    @Element(name = "vRetCSLL", required = false)
    protected String valorCSLL;

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
    public String getValorCP() {
        return valorCP;
    }

    /**
     * @param value Valor retido do tributo CP
     */
    public NFSeSefinNacionalTribFederal setValorCP(String value) {
        this.valorCP = value;
        return this;
    }

    /**
     * @return Valor retido do tributo IRRF
     */
    public String getValorIRRF() {
        return valorIRRF;
    }

    /**
     * @param value Valor retido do tributo IRRF
     */
    public NFSeSefinNacionalTribFederal setValorIRRF(String value) {
        this.valorIRRF = value;
        return this;
    }

    /**
     * @return Valor retido do tributo CSLL
     */
    public String getValorCSLL() {
        return valorCSLL;
    }

    /**
     * @param value Valor retido do tributo CSLL
     */
    public NFSeSefinNacionalTribFederal setValorCSLL(String value) {
        this.valorCSLL = value;
        return this;
    }

}
