package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS {
    @Element(name = "cCredPres", required = false)
    protected String cCredPres;
    @Element(name = "gTribRegular", required = false)
    protected NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular gTribRegular;
    @Element(name = "gDif", required = false)
    protected NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGDif gDif;

    public String getcCredPres() {
        return cCredPres;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS setcCredPres(String cCredPres) {
        this.cCredPres = cCredPres;
        return this;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular getgTribRegular() {
        return gTribRegular;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS setgTribRegular(NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular gTribRegular) {
        this.gTribRegular = gTribRegular;
        return this;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGDif getgDif() {
        return gDif;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS setgDif(NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGDif gDif) {
        this.gDif = gDif;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBS{" +
                "cCredPres='" + cCredPres + '\'' +
                ", gTribRegular=" + gTribRegular +
                ", gDif=" + gDif +
                '}';
    }
}
