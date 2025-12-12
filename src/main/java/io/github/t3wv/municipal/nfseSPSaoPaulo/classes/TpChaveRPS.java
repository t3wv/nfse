package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpChaveRPS {

    @Element(name = "InscricaoPrestador")
    protected String inscricaoPrestador;
    @Element(name = "SerieRPS", required = false)
    protected String serieRPS;
    @Element(name = "NumeroRPS")
    protected String numeroRPS;

    public String getInscricaoPrestador() {
        return inscricaoPrestador;
    }

    public TpChaveRPS setInscricaoPrestador(String value) {
        this.inscricaoPrestador = value;
        return this;
    }

    public String getSerieRPS() {
        return serieRPS;
    }

    public TpChaveRPS setSerieRPS(String value) {
        this.serieRPS = value;
        return this;
    }

    public String getNumeroRPS() {
        return numeroRPS;
    }

    public TpChaveRPS setNumeroRPS(String value) {
        this.numeroRPS = value;
        return this;
    }

}
