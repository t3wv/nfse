package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

public class TpEnderecoNacional {

    @Element(name = "cMun")
    protected int cMun;
    @Element(name = "CEP")
    protected int cep;

    public int getCMun() {
        return cMun;
    }

    public TpEnderecoNacional setCMun(int value) {
        this.cMun = value;
        return this;
    }

    public int getCEP() {
        return cep;
    }

    public TpEnderecoNacional setCEP(int value) {
        this.cep = value;
        return this;
    }

}
