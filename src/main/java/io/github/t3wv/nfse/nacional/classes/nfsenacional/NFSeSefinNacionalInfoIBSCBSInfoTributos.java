package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

/**
 * Grupo de informações relacionadas ao IBS e à CBS (TCRTCInfoTribIBSCBS). Pela NT SE/CGNFS-e 009,
 * CST e cClassTrib saíram do gIBSCBS e passaram a ficar aqui, e o gIBSCBS ficou opcional.
 */
public class NFSeSefinNacionalInfoIBSCBSInfoTributos {
    // Obrigatórios no XSD da NT 009, mas required = false para ainda ler NFS-e anteriores, em que
    // ficavam no gIBSCBS. Numa DPS nova sem eles, quem recusa é a SEFIN (a validação local contra o
    // XSD em WSSefinNFSe é feita com assert e só roda com -ea).
    @Element(name = "CST", required = false)
    protected String CST;
    @Element(name = "cClassTrib", required = false)
    protected String cClassTrib;
    @Element(name = "gIBSCBS", required = false)
    protected NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS gIBSCBS;

    /**
     * Código de Situação Tributária do IBS e da CBS
     * @return
     */
    public String getCST() {
        return CST;
    }

    /**
     * Código de Situação Tributária do IBS e da CBS
     * @param CST
     * @return NFSeSefinNacionalInfoIBSCBSInfoTributos
     */
    public NFSeSefinNacionalInfoIBSCBSInfoTributos setCST(String CST) {
        this.CST = CST;
        return this;
    }

    /**
     * Código de Classificação Tributária do IBS e da CBS
     * @return
     */
    public String getcClassTrib() {
        return cClassTrib;
    }

    /**
     * Código de Classificação Tributária do IBS e da CBS
     * @param cClassTrib
     * @return NFSeSefinNacionalInfoIBSCBSInfoTributos
     */
    public NFSeSefinNacionalInfoIBSCBSInfoTributos setcClassTrib(String cClassTrib) {
        this.cClassTrib = cClassTrib;
        return this;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS getgIBSCBS() {
        return gIBSCBS;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributos setgIBSCBS(NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS gIBSCBS) {
        this.gIBSCBS = gIBSCBS;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSInfoTributos{" +
                "CST='" + CST + '\'' +
                ", cClassTrib='" + cClassTrib + '\'' +
                ", gIBSCBS=" + gIBSCBS +
                '}';
    }
}
