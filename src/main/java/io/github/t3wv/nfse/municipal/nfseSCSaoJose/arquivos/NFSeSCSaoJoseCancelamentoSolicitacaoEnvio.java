package io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.NFSeSCSaoJoseNFSeCancelamentoSolicitacao;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.NFSeSCSaoJoseNFSePrestador;
import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Root(name = "solicitacao_cancelamento")
public class NFSeSCSaoJoseCancelamentoSolicitacaoEnvio {

    @Element(name = "prestador")
    private NFSeSCSaoJoseNFSePrestador prestador;

    @Path(value="documentos")
    @ElementList(inline = true, entry = "nfse")
    private List<NFSeSCSaoJoseNFSeCancelamentoSolicitacao> documentos;

    public NFSeSCSaoJoseNFSePrestador getPrestador() {
        return prestador;
    }

    public NFSeSCSaoJoseCancelamentoSolicitacaoEnvio setPrestador(NFSeSCSaoJoseNFSePrestador prestador) {
        this.prestador = prestador;
        return this;
    }

    public List<NFSeSCSaoJoseNFSeCancelamentoSolicitacao> getDocumentos() {
        return documentos;
    }

    public NFSeSCSaoJoseCancelamentoSolicitacaoEnvio setDocumentos(List<NFSeSCSaoJoseNFSeCancelamentoSolicitacao> documentos) {
        this.documentos = documentos;
        return this;
    }

    public NFSeSCSaoJoseCancelamentoSolicitacaoEnvio addDocumento(NFSeSCSaoJoseNFSeCancelamentoSolicitacao documento) {
        if(this.documentos == null){
            this.documentos = new ArrayList<io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.NFSeSCSaoJoseNFSeCancelamentoSolicitacao>();
        }
        this.documentos.add(documento);
        return this;
    }

    public String toXml() throws Exception {
        final var registryMatcher = new NFSeRegistryMatcher();
        registryMatcher.bind(boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(Boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());

        NFSePersister serializer = new NFSePersister(true, registryMatcher);
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

}
