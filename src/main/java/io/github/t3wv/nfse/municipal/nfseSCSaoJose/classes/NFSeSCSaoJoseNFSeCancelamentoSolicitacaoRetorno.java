package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.util.List;

@Root(name = "nfse")
public class NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetorno {

    @Element(name = "dados")
    private NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetornoDados dados;

    @Path(value="mensagem")
    @ElementList(inline = true, entry = "codigo", required = false)
    private List<String> mensagem;

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetornoDados getDados() {
        return dados;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetorno setDados(NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetornoDados dados) {
        this.dados = dados;
        return this;
    }

    public List<String> getMensagem() {
        return mensagem;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetorno setMensagem(List<String> mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public String toXml() throws Exception {
        StringWriter writer = new StringWriter();
        new NFSePersister(true, new NFSeRegistryMatcher()).write(this, writer);
        return writer.toString();
    }
}
