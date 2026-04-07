
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.math.BigDecimal;

/**
 * 
 */

@Root(name = "TribMunicipal")
public class NFSeSefinNacionalTribMunicipal {

    @Element(name = "tribISSQN")
    protected NFSeSefinNacionalTribMunicipalTributacaoISSQN tributacaoISSQN;
    @Element(name = "cPaisResult", required = false)
    protected String codigoPais;
    @Element(name = "BM", required = false)
    protected NFSeSefinNacionalBeneficioMunicipal beneficioMunicipal;
    @Element(name = "exigSusp", required = false)
    protected NFSeSefinNacionalExigSuspensa exigibilidadeSuspensa;
    @Element(name = "tpImunidade", required = false)
    protected NFSeSefinNacionalTribMunicipalTipoImunidade tipoImunidade;
    @Element(name = "pAliq", required = false)
    protected BigDecimal percentualAliquota;
    @Element(name = "tpRetISSQN")
    protected NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN tipoRetencaoISSQN;

    /**
     * @return tributação do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipalTributacaoISSQN getTributacaoISSQN() {
        return tributacaoISSQN;
    }

    /**
     * @param tributacaoISSQN tributação do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipal setTributacaoISSQN(NFSeSefinNacionalTribMunicipalTributacaoISSQN tributacaoISSQN) {
        this.tributacaoISSQN = tributacaoISSQN;
        return this;
    }

    /**
     * @return Código do país onde se verficou o resultado da prestação do serviço para o caso de Exportação de Serviço.(Tabela de Países ISO)
     */
    public String getCodigoPais() {
        return codigoPais;
    }

    /**
     * @param codigoPais Código do país onde se verficou o resultado da prestação do serviço para o caso de Exportação de Serviço.(Tabela de Países ISO)
     */
    public NFSeSefinNacionalTribMunicipal setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
        return this;
    }

    /**
     * @return Benefício Municipal concedido ao prestador do serviço
     */
    public NFSeSefinNacionalBeneficioMunicipal getBeneficioMunicipal() {
        return beneficioMunicipal;
    }

    /**
     * @param beneficioMunicipal Benefício Municipal concedido ao prestador do serviço
     */
    public NFSeSefinNacionalTribMunicipal setBeneficioMunicipal(NFSeSefinNacionalBeneficioMunicipal beneficioMunicipal) {
        this.beneficioMunicipal = beneficioMunicipal;
        return this;
    }

    /**
     * @return Exigibilidade Suspensa do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalExigSuspensa getExigibilidadeSuspensa() {
        return exigibilidadeSuspensa;
    }

    /**
     * @param exigibilidadeSuspensa Exigibilidade Suspensa do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipal setExigibilidadeSuspensa(NFSeSefinNacionalExigSuspensa exigibilidadeSuspensa) {
        this.exigibilidadeSuspensa = exigibilidadeSuspensa;
        return this;
    }

    /**
     * @return Tipo de imunidade do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipalTipoImunidade getTipoImunidade() {
        return tipoImunidade;
    }

    /**
     * @param tipoImunidade Tipo de imunidade do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipal setTipoImunidade(NFSeSefinNacionalTribMunicipalTipoImunidade tipoImunidade) {
        this.tipoImunidade = tipoImunidade;
        return this;
    }

    /**
     * @return Percentual da alíquota do ISSQN sobre o serviço prestado
     */
    public BigDecimal getPercentualAliquota() {
        return percentualAliquota;
    }

    /**
     * @param percentualAliquota Percentual da alíquota do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipal setPercentualAliquota(BigDecimal percentualAliquota) {
        this.percentualAliquota = percentualAliquota;
        return this;
    }

    /**
     * @return Tipo de retenção do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN getTipoRetencaoISSQN() {
        return tipoRetencaoISSQN;
    }

    /**
     * @param tipoRetencaoISSQN Tipo de retenção do ISSQN sobre o serviço prestado
     */
    public NFSeSefinNacionalTribMunicipal setTipoRetencaoISSQN(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN tipoRetencaoISSQN) {
        this.tipoRetencaoISSQN = tipoRetencaoISSQN;
        return this;
    }

}
