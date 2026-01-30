package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSValores {
    @Element(name = "vBC")
    private BigDecimal valorBaseCalculo;

    @Element(name = "uf")
    private NFSeSCSaoJoseNFSeNfIBSCBSValoresUF uf;

    @Element(name = "mun")
    private NFSeSCSaoJoseNFSeNfIBSCBSValoresMun mun;

    @Element(name = "fed")
    private NFSeSCSaoJoseNFSeNfIBSCBSValoresFed fed;

    public BigDecimal getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValores setValorBaseCalculo(BigDecimal valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresUF getUf() {
        return uf;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValores setUf(NFSeSCSaoJoseNFSeNfIBSCBSValoresUF uf) {
        this.uf = uf;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresMun getMun() {
        return mun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValores setMun(NFSeSCSaoJoseNFSeNfIBSCBSValoresMun mun) {
        this.mun = mun;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresFed getFed() {
        return fed;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValores setFed(NFSeSCSaoJoseNFSeNfIBSCBSValoresFed fed) {
        this.fed = fed;
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
