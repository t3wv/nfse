
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações relativas aos descontos condicionados e incondicionados
 */

@Root(name = "vDescCondIncond")
public class NFSeSefinNacionalVDescCondIncond {

    @Element(name = "vDescIncond")
    protected String valorDescontoIncondicionado;
    @Element(name = "vDescCond")
    protected String valorDescontoCondicionado;

    /**
     * @return Valor monetário do desconto incondicionado (R$)
     */
    public String getValorDescontoIncondicionado() {
        return valorDescontoIncondicionado;
    }

    /**
     * @param valorDescontoIncondicionado Valor monetário do desconto incondicionado (R$)
     */
    public NFSeSefinNacionalVDescCondIncond setValorDescontoIncondicionado(String valorDescontoIncondicionado) {
        this.valorDescontoIncondicionado = valorDescontoIncondicionado;
        return this;
    }

    /**
     * @return Valor monetário do desconto condicionado (R$)
     */
    public String getValorDescontoCondicionado() {
        return valorDescontoCondicionado;
    }

    /**
     * @param valorDescontoCondicionado Valor monetário do desconto condicionado (R$)
     */
    public NFSeSefinNacionalVDescCondIncond setValorDescontoCondicionado(String valorDescontoCondicionado) {
        this.valorDescontoCondicionado = valorDescontoCondicionado;
        return this;
    }

}
