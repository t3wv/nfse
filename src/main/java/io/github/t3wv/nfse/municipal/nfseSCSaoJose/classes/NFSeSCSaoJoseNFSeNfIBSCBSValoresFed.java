package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSValoresFed {
    @Element(name = "pCBS")
    private Double percentualCBS;

    @Element(name = "pRedAliqCBS", required = false)
    private Double percentualReducaoAliquotaCBS;

    @Element(name = "pAliqEfetCBS")
    private Double percentualAliquotaEfetivaCBS;

    public Double getPercentualCBS() {
        return percentualCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresFed setPercentualIBSCBS(Double percentualIBSCBS) {
        this.percentualCBS = percentualIBSCBS;
        return this;
    }

    public Double getPercentualReducaoAliquotaCBS() {
        return percentualReducaoAliquotaCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresFed setPercentualReducaoAliquotaCBS(Double percentualReducaoAliquotaCBS) {
        this.percentualReducaoAliquotaCBS = percentualReducaoAliquotaCBS;
        return this;
    }

    public Double getPercentualAliquotaEfetivaCBS() {
        return percentualAliquotaEfetivaCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresFed setPercentualAliquotaEfetivaCBS(Double percentualAliquotaEfetivaCBS) {
        this.percentualAliquotaEfetivaCBS = percentualAliquotaEfetivaCBS;
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
