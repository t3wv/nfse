package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS {

    @Element(name = "gCBSCredPres")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres gCBSCredPres;

    @Element(name = "vDifCBS")
    private BigDecimal vDifCBS;
    @Element(name = "vCBS")
    private BigDecimal vCBS;

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres getgCBSCredPres() {
        return gCBSCredPres;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS setgCBSCredPres(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBSgCBSCredPres gCBSCredPres) {
        this.gCBSCredPres = gCBSCredPres;
        return this;
    }

    public BigDecimal getvDifCBS() {
        return vDifCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS setvDifCBS(BigDecimal vDifCBS) {
        this.vDifCBS = vDifCBS;
        return this;
    }

    public BigDecimal getvCBS() {
        return vCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS setvCBS(BigDecimal vCBS) {
        this.vCBS = vCBS;
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
