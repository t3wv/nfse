package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot {
    @Element(name = "vDifMun")
    private BigDecimal vDifMun;
    @Element(name = "vIBSMun")
    private BigDecimal vIBSMun;

    public BigDecimal getvDifMun() {
        return vDifMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot setvDifMun(BigDecimal vDifMun) {
        this.vDifMun = vDifMun;
        return this;
    }

    public BigDecimal getvIBSMun() {
        return vIBSMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot setvIBSMun(BigDecimal vIBSMun) {
        this.vIBSMun = vIBSMun;
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
