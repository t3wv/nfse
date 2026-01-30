package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif {
    @Element(name = "pDifUF", required = false)
    private String pDifUF;

    @Element(name = "pDifMun", required = false)
    private String pDifMun;

    @Element(name = "pDifCBS", required = false)
    private String pDifCBS;

    public String getpDifUF() {
        return pDifUF;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif setpDifUF(String pDifUF) {
        this.pDifUF = pDifUF;
        return this;
    }

    public String getpDifMun() {
        return pDifMun;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif setpDifMun(String pDifMun) {
        this.pDifMun = pDifMun;
        return this;
    }

    public String getpDifCBS() {
        return pDifCBS;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif setpDifCBS(String pDifCBS) {
        this.pDifCBS = pDifCBS;
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
