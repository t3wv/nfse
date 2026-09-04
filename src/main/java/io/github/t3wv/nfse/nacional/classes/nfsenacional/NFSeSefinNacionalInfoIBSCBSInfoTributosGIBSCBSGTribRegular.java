package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular {
    @Element(name="CSTReg")
    protected String cstReg;
    @Element(name="cClassTribReg")
    protected String cClassTribReg;

    public String getCstReg() {
        return cstReg;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular setCstReg(String cstReg) {
        this.cstReg = cstReg;
        return this;
    }

    public String getcClassTribReg() {
        return cClassTribReg;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoTributosGIBSCBSGTribRegular setcClassTribReg(String cClassTribReg) {
        this.cClassTribReg = cClassTribReg;
        return this;
    }


}
