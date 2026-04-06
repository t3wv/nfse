
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relativas ao valores para dedução/redução do valor da base de cálculo (valor do serviço)
 */

@Root(name = "vDedRed")
public class NFSeSefinNacionalInfoDedRed {

    @Element(name = "pDR")
    protected String percentualPadrao;
    @Element(name = "vDR")
    protected String valorMonetarioPadrao;
    @Element(name = "documentos")
    protected NFSeSefinNacionalListaDocDedRed documentos;

    public String getPercentualPadrao() {
        return percentualPadrao;
    }

    public NFSeSefinNacionalInfoDedRed setPercentualPadrao(String percentualPadrao) {
        this.percentualPadrao = percentualPadrao;
        return this;
    }

    public String getValorMonetarioPadrao() {
        return valorMonetarioPadrao;
    }

    public NFSeSefinNacionalInfoDedRed setValorMonetarioPadrao(String valorMonetarioPadrao) {
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
