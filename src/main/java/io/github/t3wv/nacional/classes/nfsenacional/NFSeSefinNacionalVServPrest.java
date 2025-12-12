
package io.github.t3wv.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.math.BigDecimal;

/**
 * Grupo de informações relativas aos valores do serviço prestado
 */

@Root(name = "vServPrest")
public class NFSeSefinNacionalVServPrest {

    @Element(name = "vReceb", required = false)
    protected BigDecimal valorRecebidoIntermediario;
    @Element(name = "vServ")
    protected BigDecimal valorServicos;

    /**
     * @return Valor monetário recebido pelo intermediário do serviço (R$)
     */
    public BigDecimal getValorRecebidoIntermediario() {
        return valorRecebidoIntermediario;
    }

    /**
     * @param valorRecebidoIntermediario Valor monetário recebido pelo intermediário do serviço (R$)
     */
    public void setValorRecebidoIntermediario(BigDecimal valorRecebidoIntermediario) {
        this.valorRecebidoIntermediario = valorRecebidoIntermediario;
    }

    /**
     * @return Valor dos serviços em R$
     */
    public BigDecimal getValorServicos() {
        return valorServicos;
    }

    /**
     * @param valorServicos Valor dos serviços em R$
     */
    public NFSeSefinNacionalVServPrest setValorServicos(BigDecimal valorServicos) {
        this.valorServicos = valorServicos;
        return this;
    }

}
