
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.math.BigDecimal;

/**
 * Grupo de informações dos tributos PIS/COFINS
 */

@Root(name = "TribOutrosPisCofins")
public class NFSeSefinNacionalTribOutrosPisCofins {

    @Element(name="CST")
    protected NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria situacaoTributaria;
    @Element(name="vBCPisCofins", required=false)
    protected BigDecimal valorBaseCalculoPisCofins;
    @Element(name="pAliqPis", required=false)
    protected BigDecimal aliquotaPIS;
    @Element(name="pAliqCofins", required=false)
    protected BigDecimal aliquotaCOFINS;
    @Element(name="vPis", required=false)
    protected BigDecimal valorPIS;
    @Element(name="vCofins", required=false)
    protected BigDecimal valorCOFINS;
    @Element(name="tpRetPisCofins", required=false)
    protected NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao tipoRetencao;

    /**
     * @return Situação Tributária do PIS/COFINS
     */
    public NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria getSituacaoTributaria() {
        return situacaoTributaria;
    }

    /**
     * @param value Situação Tributária do PIS/COFINS
     */
    public NFSeSefinNacionalTribOutrosPisCofins setCST(NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria value) {
        this.situacaoTributaria = value;
        return this;
    }

    public BigDecimal getValorBaseCalculoPisCofins() {
        return valorBaseCalculoPisCofins;
    }

    public NFSeSefinNacionalTribOutrosPisCofins setValorBaseCalculoPisCofins(BigDecimal value) {
        this.valorBaseCalculoPisCofins = value;
        return this;
    }

    public BigDecimal getAliquotaPIS() {
        return aliquotaPIS;
    }

    public NFSeSefinNacionalTribOutrosPisCofins setAliquotaPIS(BigDecimal value) {
        this.aliquotaPIS = value;
        return this;
    }

    public BigDecimal getAliquotaCOFINS() {
        return aliquotaCOFINS;
    }

    public NFSeSefinNacionalTribOutrosPisCofins setAliquotaCOFINS(BigDecimal value) {
        this.aliquotaCOFINS = value;
        return this;
    }

    public BigDecimal getValorPIS() {
        return valorPIS;
    }

    public NFSeSefinNacionalTribOutrosPisCofins setValorPIS(BigDecimal value) {
        this.valorPIS = value;
        return this;
    }

    public BigDecimal getValorCofins() {
        return valorCOFINS;
    }

    public NFSeSefinNacionalTribOutrosPisCofins setValorCofins(BigDecimal value) {
        this.valorCOFINS = value;
        return this;
    }

    public NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao getTipoRetencao() {
        return tipoRetencao;
    }

    public NFSeSefinNacionalTribOutrosPisCofins setTipoRetencao(NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao value) {
        this.tipoRetencao = value;
        return this;
    }

}
