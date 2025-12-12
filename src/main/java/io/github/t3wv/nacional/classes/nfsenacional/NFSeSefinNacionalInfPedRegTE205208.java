package io.github.t3wv.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;

public class NFSeSefinNacionalInfPedRegTE205208 extends NFSeSefinNacionalInfPedRegEventoTE{
    @Element(name = "infAnRej")
    protected NFSeSefinNacionalTCInfoEventoAnulacaoRejeicao infAnRej;

    public NFSeSefinNacionalInfPedRegTE205208() {
        super("Anulação da Rejeição", "205208");
    }

    public NFSeSefinNacionalTCInfoEventoAnulacaoRejeicao getInfAnRej() {
        return infAnRej;
    }

    public NFSeSefinNacionalInfPedRegTE205208 setInfAnRej(NFSeSefinNacionalTCInfoEventoAnulacaoRejeicao infAnRej) {
        this.infAnRej = infAnRej;
        return this;
    }
}
