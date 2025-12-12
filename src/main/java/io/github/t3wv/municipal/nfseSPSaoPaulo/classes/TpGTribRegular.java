package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

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
