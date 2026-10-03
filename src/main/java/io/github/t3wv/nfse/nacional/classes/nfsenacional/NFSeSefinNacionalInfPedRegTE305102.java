package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE305102 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "CPFAgTrib")
    protected String cPFAgTrib;
    @Element(name = "xMotivo")
    protected String xMotivo;
    @Element(name = "codEvento")
    protected NFSeSefinNacionalTSCodigoEventoNFSe codEvento;

    public NFSeSefinNacionalInfPedRegTE305102() {
        super("Bloqueio de NFS-e por Ofício", "305102");
    }

    public String getcPFAgTrib() {
        return cPFAgTrib;
    }

    public NFSeSefinNacionalInfPedRegTE305102 setcPFAgTrib(String cPFAgTrib) {
        this.cPFAgTrib = cPFAgTrib;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE305102 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }

    public NFSeSefinNacionalTSCodigoEventoNFSe getCodEvento() {
        return codEvento;
    }

    public NFSeSefinNacionalInfPedRegTE305102 setCodEvento(NFSeSefinNacionalTSCodigoEventoNFSe codEvento) {
        this.codEvento = codEvento;
        return this;
    }
}
