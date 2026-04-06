
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "TribTotalPercent")
public class NFSeSefinNacionalTribTotalPercent {

    @Element(name = "pTotTribFed")
    protected String percentualTributosFederais;
    @Element(name = "pTotTribEst")
    protected String percentualTributosEstaduais;
    @Element(name = "pTotTribMun")
    protected String percentualTributosMunicipais;

    public String getPercentualTributosFederais() {
        return percentualTributosFederais;
    }

    public NFSeSefinNacionalTribTotalPercent setPercentualTributosFederais(String value) {
        this.percentualTributosFederais = value;
        return this;
    }

    public String getPercentualTributosEstaduais() {
        return percentualTributosEstaduais;
    }

    public NFSeSefinNacionalTribTotalPercent setPercentualTributosEstaduais(String value) {
        this.percentualTributosEstaduais = value;
        return this;
    }

    public String getPercentualTributosMunicipais() {
        return percentualTributosMunicipais;
    }

    public NFSeSefinNacionalTribTotalPercent setPercentualTributosMunicipais(String value) {
        this.percentualTributosMunicipais = value;
        return this;
    }

}
