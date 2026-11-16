package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;

/**
 * Parcela não integrante da base de cálculo do IBS/CBS na locação de imóvel (TCRTCValoresBCImoveis, NT SE/CGNFS-e 009)
 */
@Root(name = "gAjusteBCLocImoveis")
public class NFSeSefinNacionalInfoIBSCBSImovelAjusteBC {
    @Element(name = "tpAjusteBCLocImoveis")
    protected NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC tpAjusteBCLocImoveis;
    @Element(name = "xTpAjusteBCLocImoveis", required = false)
    protected String xTpAjusteBCLocImoveis;
    @Element(name = "vAjusteBCLocImoveis")
    protected BigDecimal vAjusteBCLocImoveis;

    /**
     * Tipo de parcela não integrante da base de cálculo
     * @return tpAjusteBCLocImoveis
     */
    public NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC getTpAjusteBCLocImoveis() {
        return tpAjusteBCLocImoveis;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelAjusteBC setTpAjusteBCLocImoveis(NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC tpAjusteBCLocImoveis) {
        this.tpAjusteBCLocImoveis = tpAjusteBCLocImoveis;
        return this;
    }

    /**
     * Descrição, quando o tipo é 99
     * @return xTpAjusteBCLocImoveis
     */
    public String getxTpAjusteBCLocImoveis() {
        return xTpAjusteBCLocImoveis;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelAjusteBC setxTpAjusteBCLocImoveis(String xTpAjusteBCLocImoveis) {
        this.xTpAjusteBCLocImoveis = xTpAjusteBCLocImoveis;
        return this;
    }

    /**
     * Valor da parcela não integrante da base de cálculo (R$)
     * @return vAjusteBCLocImoveis
     */
    public BigDecimal getvAjusteBCLocImoveis() {
        return vAjusteBCLocImoveis;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelAjusteBC setvAjusteBCLocImoveis(BigDecimal vAjusteBCLocImoveis) {
        this.vAjusteBCLocImoveis = vAjusteBCLocImoveis;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSImovelAjusteBC{" +
                "tpAjusteBCLocImoveis=" + tpAjusteBCLocImoveis +
                ", xTpAjusteBCLocImoveis=" + xTpAjusteBCLocImoveis +
                ", vAjusteBCLocImoveis=" + vAjusteBCLocImoveis +
                '}';
    }
}
