package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt {
    @Element(name = "cEndPost", required = false)
    private String cEndPost;

    @Element(name = "xCidade", required = false)
    private String xCidade;

    @Element(name = "xEstProvReg", required = false)
    private String xEstProvReg;

    public String getcEndPost() {
        return cEndPost;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt setcEndPost(String cEndPost) {
        this.cEndPost = cEndPost;
        return this;
    }

    public String getxCidade() {
        return xCidade;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt setxCidade(String xCidade) {
        this.xCidade = xCidade;
        return this;
    }

    public String getxEstProvReg() {
        return xEstProvReg;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt setxEstProvReg(String xEstProvReg) {
        this.xEstProvReg = xEstProvReg;
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
