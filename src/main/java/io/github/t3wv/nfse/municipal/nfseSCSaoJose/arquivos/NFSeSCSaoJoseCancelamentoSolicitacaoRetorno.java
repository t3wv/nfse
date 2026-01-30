package io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetorno;
import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

@Root(name = "retorno")
public class NFSeSCSaoJoseCancelamentoSolicitacaoRetorno {

    @ElementList(name = "mensagem", entry = "codigo", required = false)
    private List<String> mensagem;

    @Path(value = "documentos")
    @ElementList(inline = true, entry = "nfse", required = false)
    private List<NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetorno> documentos;

    public List<NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetorno> getDocumentos() {
        return documentos;
    }

    public NFSeSCSaoJoseCancelamentoSolicitacaoRetorno setDocumentos(List<NFSeSCSaoJoseNFSeCancelamentoSolicitacaoRetorno> documentos) {
        this.documentos = documentos;
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
