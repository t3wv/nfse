package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSValoresUF {
    @Element(name = "pIBSUF")
    private Double percentualIBSUF;

    @Element(name = "pRedAliqUF", required = false)
    private Double percentualReducaoAliquotaUF;

    @Element(name = "pAliqEfetUF")
    private Double percentualAliquotaEfetivaUF;

    public Double getPercentualIBSUF() {
        return percentualIBSUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresUF setPercentualIBSUF(Double percentualIBSUF) {
        this.percentualIBSUF = percentualIBSUF;
        return this;
    }

    public Double getPercentualReducaoAliquotaUF() {
        return percentualReducaoAliquotaUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresUF setPercentualReducaoAliquotaUF(Double percentualReducaoAliquotaUF) {
        this.percentualReducaoAliquotaUF = percentualReducaoAliquotaUF;
        return this;
    }

    public Double getPercentualAliquotaEfetivaUF() {
        return percentualAliquotaEfetivaUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresUF setPercentualAliquotaEfetivaUF(Double percentualAliquotaEfetivaUF) {
        this.percentualAliquotaEfetivaUF = percentualAliquotaEfetivaUF;
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
