package io.github.t3wv.municipal.nfseSPSaoPaulo.requests;

import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.TpChaveNFe;
import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Detalhe")
@Namespace(reference = "")
public class NFSeSPSaoPauloRequestCancelamentoNFeDetalhe {

    @Element(name = "ChaveNFe")
    protected TpChaveNFe chaveNFe;

    @Element(name = "AssinaturaCancelamento")
    protected String assinaturaCancelamento;

    public TpChaveNFe getChaveNFe() {
        return chaveNFe;
    }

    public NFSeSPSaoPauloRequestCancelamentoNFeDetalhe setChaveNFe(TpChaveNFe chaveNFe) {
        this.chaveNFe = chaveNFe;
        return this;
    }

    public String getAssinaturaCancelamento() {
        return assinaturaCancelamento;
    }

    public NFSeSPSaoPauloRequestCancelamentoNFeDetalhe setAssinaturaCancelamento(String assinaturaCancelamento) {
        this.assinaturaCancelamento = assinaturaCancelamento;
        return this;
    }

    public String getAssinaturaString() {
        return StringUtils.leftPad(this.chaveNFe.getInscricaoPrestador(), 8, '0') + StringUtils.leftPad(this.chaveNFe.getNumeroNFe(), 12, '0');
    }
}
