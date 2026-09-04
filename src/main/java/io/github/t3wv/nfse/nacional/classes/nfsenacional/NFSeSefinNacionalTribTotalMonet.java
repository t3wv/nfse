
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.math.BigDecimal;

@Root(name = "TribTotalMonet")
public class NFSeSefinNacionalTribTotalMonet {

    @Element(name = "vTotTribFed")
    protected BigDecimal valorTributosFederais;
    @Element(name = "vTotTribEst")
    protected BigDecimal valorTributosEstaduais;
    @Element(name = "vTotTribMun")
    protected BigDecimal valorTributosMunicipais;

    public BigDecimal getValorTributosFederais() {
        return valorTributosFederais;
    }

    public NFSeSefinNacionalTribTotalMonet setValorTributosFederais(BigDecimal valorTributosFederais) {
        this.valorTributosFederais = valorTributosFederais;
        return this;
    }

    public BigDecimal getValorTributosEstaduais() {
        return valorTributosEstaduais;
    }

    public NFSeSefinNacionalTribTotalMonet setValorTributosEstaduais(BigDecimal valorTributosEstaduais) {
        this.valorTributosEstaduais = valorTributosEstaduais;
        return this;
    }

    public BigDecimal getValorTributosMunicipais() {
        return valorTributosMunicipais;
    }

    public NFSeSefinNacionalTribTotalMonet setValorTributosMunicipais(BigDecimal valorTributosMunicipais) {
        this.valorTributosMunicipais = valorTributosMunicipais;
        return this;
    }

}
