package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE205208 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "CPFAgTrib")
    protected String cPFAgTrib;
    @Element(name = "idEvManifRej")
    protected String idEvManifRej;
    @Element(name = "xMotivo")
    protected String xMotivo;

    public NFSeSefinNacionalInfPedRegTE205208() {
        super("Anulação da Rejeição", "205208");
    }

    public String getcPFAgTrib() {
        return cPFAgTrib;
    }

    public NFSeSefinNacionalInfPedRegTE205208 setcPFAgTrib(String cPFAgTrib) {
        this.cPFAgTrib = cPFAgTrib;
        return this;
    }

    public String getIdEvManifRej() {
        return idEvManifRej;
    }

    public NFSeSefinNacionalInfPedRegTE205208 setIdEvManifRej(String idEvManifRej) {
        this.idEvManifRej = idEvManifRej;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE205208 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
