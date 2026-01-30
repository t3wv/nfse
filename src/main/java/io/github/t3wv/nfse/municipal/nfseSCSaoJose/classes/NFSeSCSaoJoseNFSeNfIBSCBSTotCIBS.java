package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS {

    @Element(name = "vTotNF")
    private BigDecimal valorTotalNF;

    @Element(name = "gTribRegular", required = false)
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular gTribRegular;

    @Element(name = "gTribCompraGov", required = false)
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov gTribCompraGov;

    @Element(name = "gIBS")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBS gIBS;

    @Element(name = "gCBS")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS gCBS;

    public BigDecimal getValorTotalNF() {
        return valorTotalNF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS setValorTotalNF(BigDecimal valorTotalNF) {
        this.valorTotalNF = valorTotalNF;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular getgTribRegular() {
        return gTribRegular;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS setgTribRegular(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular gTribRegular) {
        this.gTribRegular = gTribRegular;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov getgTribCompraGov() {
        return gTribCompraGov;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS setgTribCompraGov(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribCompraGov gTribCompraGov) {
        this.gTribCompraGov = gTribCompraGov;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBS getgIBS() {
        return gIBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS setgIBS(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBS gIBS) {
        this.gIBS = gIBS;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS getgCBS() {
        return gCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS setgCBS(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgCBS gCBS) {
        this.gCBS = gCBS;
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
