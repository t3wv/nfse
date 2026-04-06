
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "InfoEventoRejeicao")
public class NFSeSefinNacionalInfoEventoRejeicao {

    @Element(required = true)
    protected String cMotivo;
    protected String xMotivo;

    public String getCMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfoEventoRejeicao setCMotivo(String value) {
        this.cMotivo = value;
        return this;
    }

    public String getXMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfoEventoRejeicao setXMotivo(String value) {
        this.xMotivo = value;
        return this;
    }

}
