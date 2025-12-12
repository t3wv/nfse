package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpEnderecoNacional {

    @Element(name = "cMun")
    protected int cMun;
    @Element(name = "CEP")
    protected int cep;

    public int getCMun() {
        return cMun;
    }

    public void setCMun(int value) {
        this.cMun = value;
    }

    public int getCEP() {
        return cep;
    }

    public void setCEP(int value) {
        this.cep = value;
    }

}
