package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBS {
    @Element(name = "pRedutor")
    private Double percentualRedutor;

    @Element(name = "valores")
    private NFSeSCSaoJoseNFSeNfIBSCBSValores valores;

    @Element(name = "totCIBS")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS totCIBS;

    public Double getPercentualRedutor() {
        return percentualRedutor;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBS setPercentualRedutor(Double percentualRedutor) {
        this.percentualRedutor = percentualRedutor;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValores getValores() {
        return valores;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBS setValores(NFSeSCSaoJoseNFSeNfIBSCBSValores valores) {
        this.valores = valores;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS getTotCIBS() {
        return totCIBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBS setTotCIBS(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS totCIBS) {
        this.totCIBS = totCIBS;
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
