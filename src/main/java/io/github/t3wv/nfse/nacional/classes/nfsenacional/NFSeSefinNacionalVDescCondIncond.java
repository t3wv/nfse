
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Grupo de informações relativas aos descontos condicionados e incondicionados
 */

@Root(name = "vDescCondIncond")
public class NFSeSefinNacionalVDescCondIncond {

    @Element(name = "vDescIncond")
    protected BigDecimal valorDescontoIncondicionado;
    @Element(name = "vDescCond")
    protected BigDecimal valorDescontoCondicionado;

    /**
     * @return Valor monetário do desconto incondicionado (R$)
     */
    public BigDecimal getValorDescontoIncondicionado() {
        return valorDescontoIncondicionado;
    }

    /**
     * @param valorDescontoIncondicionado Valor monetário do desconto incondicionado (R$)
     */
    public NFSeSefinNacionalVDescCondIncond setValorDescontoIncondicionado(BigDecimal valorDescontoIncondicionado) {
        this.valorDescontoIncondicionado = valorDescontoIncondicionado;
        return this;
    }

    /**
     * @return Valor monetário do desconto condicionado (R$)
     */
    public BigDecimal getValorDescontoCondicionado() {
        return valorDescontoCondicionado;
    }

    /**
     * @param valorDescontoCondicionado Valor monetário do desconto condicionado (R$)
     */
    public NFSeSefinNacionalVDescCondIncond setValorDescontoCondicionado(BigDecimal valorDescontoCondicionado) {
        this.valorDescontoCondicionado = valorDescontoCondicionado;
        return this;
    }

}
