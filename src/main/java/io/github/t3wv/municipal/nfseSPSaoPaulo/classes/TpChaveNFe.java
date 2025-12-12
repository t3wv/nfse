package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpChaveNFe {

    @Element(name = "InscricaoPrestador")
    protected String inscricaoPrestador;
    @Element(name = "NumeroNFe")
    protected String numeroNFe;
    @Element(name = "CodigoVerificacao", required = false)
    protected String codigoVerificacao;
    @Element(name = "ChaveNotaNacional", required = false)
    protected String chaveNotaNacional;

    public String getInscricaoPrestador() {
        return inscricaoPrestador;
    }

    public TpChaveNFe setInscricaoPrestador(String value) {
        this.inscricaoPrestador = value;
        return this;
    }

    public String getNumeroNFe() {
        return numeroNFe;
    }

    public TpChaveNFe setNumeroNFe(String value) {
        this.numeroNFe = value;
        return this;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public TpChaveNFe setCodigoVerificacao(String value) {
        this.codigoVerificacao = value;
        return this;
    }

    public String getChaveNotaNacional() {
        return chaveNotaNacional;
    }

    public TpChaveNFe setChaveNotaNacional(String value) {
        this.chaveNotaNacional = value;
        return this;
    }

}
