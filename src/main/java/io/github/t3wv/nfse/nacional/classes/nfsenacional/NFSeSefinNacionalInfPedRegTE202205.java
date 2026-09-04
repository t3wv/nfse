package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE202205 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "cMotivo")
    protected NFSeSefinNacionalTSCodMotivoRejeicao cMotivo;
    @Element(name = "xMotivo", required = false)
    protected String xMotivo;

    public NFSeSefinNacionalInfPedRegTE202205() {
        super("Rejeição do Prestador", "202205");
    }

    public NFSeSefinNacionalTSCodMotivoRejeicao getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE202205 setcMotivo(NFSeSefinNacionalTSCodMotivoRejeicao cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE202205 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
