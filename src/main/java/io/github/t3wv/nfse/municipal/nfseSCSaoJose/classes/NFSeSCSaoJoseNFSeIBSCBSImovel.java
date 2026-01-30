package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeIBSCBSImovel {
    @Element(name = "inscImobFisc", required = false)
    private String inscImobFisc;

    @Element(name = "cCIB", required = false)
    private String cCIB;

    @Element(name = "end", required = false)
    private NFSeSCSaoJoseNFSeIBSCBSImovelEnd end;

    public String getInscImobFisc() {
        return inscImobFisc;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovel setInscImobFisc(String inscImobFisc) {
        this.inscImobFisc = inscImobFisc;
        return this;
    }

    public String getcCIB() {
        return cCIB;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovel setcCIB(String cCIB) {
        this.cCIB = cCIB;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEnd getEnd() {
        return end;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovel setEnd(NFSeSCSaoJoseNFSeIBSCBSImovelEnd end) {
        this.end = end;
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
