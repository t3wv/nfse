
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.math.BigDecimal;

@Root(name = "TribTotalPercent")
public class NFSeSefinNacionalTribTotalPercent {

    @Element(name = "pTotTribFed")
    protected BigDecimal percentualTributosFederais;
    @Element(name = "pTotTribEst")
    protected BigDecimal percentualTributosEstaduais;
    @Element(name = "pTotTribMun")
    protected BigDecimal percentualTributosMunicipais;

    public BigDecimal getPercentualTributosFederais() {
        return percentualTributosFederais;
    }

    public NFSeSefinNacionalTribTotalPercent setPercentualTributosFederais(BigDecimal value) {
        this.percentualTributosFederais = value;
        return this;
    }

    public BigDecimal getPercentualTributosEstaduais() {
        return percentualTributosEstaduais;
    }

    public NFSeSefinNacionalTribTotalPercent setPercentualTributosEstaduais(BigDecimal value) {
        this.percentualTributosEstaduais = value;
        return this;
    }

    public BigDecimal getPercentualTributosMunicipais() {
        return percentualTributosMunicipais;
    }

    public NFSeSefinNacionalTribTotalPercent setPercentualTributosMunicipais(BigDecimal value) {
        this.percentualTributosMunicipais = value;
        return this;
    }

}
