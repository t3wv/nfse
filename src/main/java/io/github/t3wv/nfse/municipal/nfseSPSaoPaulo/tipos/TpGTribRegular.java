package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpGTribRegular {

    @Element(name = "cClassTribReg")
    protected String cClassTribReg;

    public String getCClassTribReg() {
        return cClassTribReg;
    }

    public void setCClassTribReg(String value) {
        this.cClassTribReg = value;
    }

}
