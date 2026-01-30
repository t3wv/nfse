package io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

@Root(name = "retorno")
public class NFSeSCSaoJoseCancelamentoRetorno {
    @ElementList(name = "mensagem", entry = "codigo", required = false)
    private List<String> mensagem;

    @Element(name = "nfse", required = false)
    private NFSeSCSaoJoseEmissaoEnvio nfse;

    public List<String> getMensagem() {
        return mensagem;
    }

    public NFSeSCSaoJoseCancelamentoRetorno setMensagem(List<String> mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public NFSeSCSaoJoseEmissaoEnvio getNfse() {
        return nfse;
    }

    public NFSeSCSaoJoseCancelamentoRetorno setNfse(NFSeSCSaoJoseEmissaoEnvio nfse) {
        this.nfse = nfse;
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
