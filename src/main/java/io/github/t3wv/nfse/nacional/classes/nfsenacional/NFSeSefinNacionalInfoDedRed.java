
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.math.BigDecimal;

/**
 * Grupo de informações relativas ao valores para dedução/redução do valor da base de cálculo (valor do serviço)
 */

@Root(name = "vDedRed")
public class NFSeSefinNacionalInfoDedRed {

    @Element(name = "pDR", required = false)
    protected BigDecimal percentualPadrao;
    @Element(name = "vDR", required = false)
    protected BigDecimal valorMonetarioPadrao;
    @Element(name = "documentos", required = false)
    protected NFSeSefinNacionalListaDocDedRed documentos;

    public BigDecimal getPercentualPadrao() {
        return percentualPadrao;
    }

    public NFSeSefinNacionalInfoDedRed setPercentualPadrao(BigDecimal percentualPadrao) {
        this.percentualPadrao = percentualPadrao;
        return this;
    }

    public BigDecimal getValorMonetarioPadrao() {
        return valorMonetarioPadrao;
    }

    public NFSeSefinNacionalInfoDedRed setValorMonetarioPadrao(BigDecimal valorMonetarioPadrao) {
        this.valorMonetarioPadrao = valorMonetarioPadrao;
        return this;
    }

    public NFSeSefinNacionalListaDocDedRed getDocumentos() {
        return documentos;
    }

    public NFSeSefinNacionalInfoDedRed setDocumentos(NFSeSefinNacionalListaDocDedRed documentos) {
        this.documentos = documentos;
        return this;
    }

}
