
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "ExigSuspensa")
public class NFSeSefinNacionalExigSuspensa {

    @Element(name = "tpSusp")
    protected NFSeSefinNacionalExigSuspensaTipoSuspensao tipoSuspensao;
    @Element(name = "nProcesso")
    protected String numeroProcesso;

    /**
     * @return Tipo de Suspensão da Exigibilidade do Crédito Tributário
     */
    public NFSeSefinNacionalExigSuspensaTipoSuspensao getTipoSuspensao() {
        return tipoSuspensao;
    }

    /**
     * @param tipoSuspensao Tipo de Suspensão da Exigibilidade do Crédito Tributário
     */
    public NFSeSefinNacionalExigSuspensa setTipoSuspensao(NFSeSefinNacionalExigSuspensaTipoSuspensao tipoSuspensao) {
        this.tipoSuspensao = tipoSuspensao;
        return this;
    }

    /**
     * @return Número do Processo Administrativo ou Judicial
     */
    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    /**
     * @param numeroProcesso Número do Processo Administrativo ou Judicial
     */
    public NFSeSefinNacionalExigSuspensa setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
        return this;
    }

}
