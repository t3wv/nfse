package io.github.t3wv.municipal.nfseSPSaoPaulo.requests;

import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.TpChaveNFe;
import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.TpChaveRPS;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Detalhe")
@Namespace(reference = "")
public class NFSeSPSaoPauloRequestConsultaNFeDetalhe {

    @Element(name = "ChaveRPS", required = false)
    protected TpChaveRPS chaveRPS;

    @Element(name = "ChaveNFe", required = false)
    protected TpChaveNFe chaveNFe;

    public TpChaveRPS getChaveRPS() {
        return chaveRPS;
    }

    public NFSeSPSaoPauloRequestConsultaNFeDetalhe setChaveRPS(TpChaveRPS chaveRPS) {
        this.chaveRPS = chaveRPS;
        return this;
    }

    public TpChaveNFe getChaveNFe() {
        return chaveNFe;
    }

    public NFSeSPSaoPauloRequestConsultaNFeDetalhe setChaveNFe(TpChaveNFe chaveNFe) {
        this.chaveNFe = chaveNFe;
        return this;
    }
}
