package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE203206 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "cMotivo")
    protected NFSeSefinNacionalTSCodMotivoRejeicao cMotivo;
    @Element(name = "xMotivo", required = false)
    protected String xMotivo;

    public NFSeSefinNacionalInfPedRegTE203206() {
        super("Rejeição do Tomador", "203206");
    }

    public NFSeSefinNacionalTSCodMotivoRejeicao getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE203206 setcMotivo(NFSeSefinNacionalTSCodMotivoRejeicao cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE203206 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
