package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;

import java.io.StringWriter;

@Namespace(reference = "http://www.prefeitura.sp.gov.br/nfe")
public class TpChaveNFeRPS {

    @Element(name = "ChaveNFe", required = false)
    private TpChaveNFe chaveNFe;

    @Element(name = "ChaveRPS", required = false)
    private TpChaveRPS chaveRPS;

    public TpChaveNFe getChaveNFe() {
        return chaveNFe;
    }

    public TpChaveNFeRPS setChaveNFe(TpChaveNFe chaveNFe) {
        this.chaveNFe = chaveNFe;
        return this;
    }

    public TpChaveRPS getChaveRPS() {
        return chaveRPS;
    }

    public TpChaveNFeRPS setChaveRPS(TpChaveRPS chaveRPS) {
        this.chaveRPS = chaveRPS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
