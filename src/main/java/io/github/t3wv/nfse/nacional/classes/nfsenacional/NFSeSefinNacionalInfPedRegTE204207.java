package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE204207 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "cMotivo")
    protected NFSeSefinNacionalTSCodMotivoRejeicao cMotivo;
    @Element(name = "xMotivo", required = false)
    protected String xMotivo;

    public NFSeSefinNacionalInfPedRegTE204207() {
        super("Rejeição do Intermediário", "204207");
    }

    public NFSeSefinNacionalTSCodMotivoRejeicao getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE204207 setcMotivo(NFSeSefinNacionalTSCodMotivoRejeicao cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE204207 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
