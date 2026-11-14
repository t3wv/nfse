package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações de bens móveis (NCM) no fornecimento (TCRTCInfoBensMoveis, NT SE/CGNFS-e 009)
 */
@Root(name = "bensMoveis")
public class NFSeSefinNacionalInfoIBSCBSBensMoveis {
    @Element(name = "cNCMBemMovel")
    protected String cNCMBemMovel;
    @Element(name = "xNCMBemMovel")
    protected String xNCMBemMovel;
    @Element(name = "qtdNCMBemMovel")
    protected Integer qtdNCMBemMovel;

    /**
     * Código NCM do bem móvel (8 dígitos)
     * @return cNCMBemMovel
     */
    public String getcNCMBemMovel() {
        return cNCMBemMovel;
    }

    public NFSeSefinNacionalInfoIBSCBSBensMoveis setcNCMBemMovel(String cNCMBemMovel) {
        this.cNCMBemMovel = cNCMBemMovel;
        return this;
    }

    /**
     * Descrição do NCM do bem móvel
     * @return xNCMBemMovel
     */
    public String getxNCMBemMovel() {
        return xNCMBemMovel;
    }

    public NFSeSefinNacionalInfoIBSCBSBensMoveis setxNCMBemMovel(String xNCMBemMovel) {
        this.xNCMBemMovel = xNCMBemMovel;
        return this;
    }

    /**
     * Quantidade do bem móvel (até 3 dígitos)
     * @return qtdNCMBemMovel
     */
    public Integer getQtdNCMBemMovel() {
        return qtdNCMBemMovel;
    }

    public NFSeSefinNacionalInfoIBSCBSBensMoveis setQtdNCMBemMovel(Integer qtdNCMBemMovel) {
        this.qtdNCMBemMovel = qtdNCMBemMovel;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSBensMoveis{" +
                "cNCMBemMovel='" + cNCMBemMovel + '\'' +
                ", xNCMBemMovel='" + xNCMBemMovel + '\'' +
                ", qtdNCMBemMovel=" + qtdNCMBemMovel +
                '}';
    }
}
