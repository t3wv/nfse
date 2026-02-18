package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.requests;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class NFSeSPSaoPauloRetornoCabecalho {

    @Element(name = "Sucesso")
    private Boolean sucesso;

    @Element(name = "InformacoesLote", required = false)
    private NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote informacoesLote;

    @Attribute(name = "Versao")
    private String Versao;

    public Boolean getSucesso() {
        return sucesso;
    }

    public NFSeSPSaoPauloRetornoCabecalho setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
        return this;
    }

    public NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote getInformacoesLote() {
        return informacoesLote;
    }

    public NFSeSPSaoPauloRetornoCabecalho setInformacoesLote(NFSeSPSaoPauloRetornoEnvioRPSInformacoesLote informacoesLote) {
        this.informacoesLote = informacoesLote;
        return this;
    }

    public String getVersao() {
        return Versao;
    }

    public NFSeSPSaoPauloRetornoCabecalho setVersao(String versao) {
        Versao = versao;
        return this;
    }
}
