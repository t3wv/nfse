package io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.*;
import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.math.BigDecimal;

@Root(name = "nfse")
public class NFSeSCSaoJoseCancelamentoEnvio {

    @Element(name = "nf", required = false)
    private NFSeSCSaoJoseNFSeCancelamento nf;

    @Element(name = "prestador")
    private NFSeSCSaoJoseNFSePrestador prestador;

    public NFSeSCSaoJoseNFSeCancelamento getNf() {
        return nf;
    }

    public NFSeSCSaoJoseCancelamentoEnvio setNf(NFSeSCSaoJoseNFSeCancelamento nf) {
        this.nf = nf;
        return this;
    }

    public NFSeSCSaoJoseNFSePrestador getPrestador() {
        return prestador;
    }

    public NFSeSCSaoJoseCancelamentoEnvio setPrestador(NFSeSCSaoJoseNFSePrestador prestador) {
        this.prestador = prestador;
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
