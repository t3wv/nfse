package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE101103 extends NFSeSefinNacionalInfPedRegEventoTE{

    @Element(name = "cMotivo")
    protected NFSeSefinNacionalTSCodJustAnaliseFiscalCanc cMotivo;
    @Element(name = "xMotivo")
    protected String xMotivo;

    public NFSeSefinNacionalInfPedRegTE101103() {
        super("Solicitação de Análise Fiscal para Cancelamento de NFS-e", "101103");
    }

    public NFSeSefinNacionalTSCodJustAnaliseFiscalCanc getcMotivo() {
        return cMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE101103 setcMotivo(NFSeSefinNacionalTSCodJustAnaliseFiscalCanc cMotivo) {
        this.cMotivo = cMotivo;
        return this;
    }

    public String getxMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfPedRegTE101103 setxMotivo(String xMotivo) {
        this.xMotivo = xMotivo;
        return this;
    }
}
