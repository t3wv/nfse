package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular {
    @Element(name = "CSTReg")
    private String CSTReg;
    @Element(name = "cClassTribReg")
    private String cClassTribReg;

    public String getCSTReg() {
        return CSTReg;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular setCSTReg(String CSTReg) {
        this.CSTReg = CSTReg;
        return this;
    }

    public String getcClassTribReg() {
        return cClassTribReg;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular setcClassTribReg(String cClassTribReg) {
        this.cClassTribReg = cClassTribReg;
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
