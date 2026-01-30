package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBS {

    @Element(name = "vIBSTot")
    private BigDecimal vIBSTot;

    @Element(name = "gIBSCredPres")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSCredPres gIBSCredPres;

    @Element(name = "gIBSUFTot")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSUFTot gIBSUFTot;

    @Element(name = "gIBSMunTot")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot gIBSMunTot;

    public BigDecimal getvIBSTot() {
        return vIBSTot;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBS setvIBSTot(BigDecimal vIBSTot) {
        this.vIBSTot = vIBSTot;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSCredPres getgIBSCredPres() {
        return gIBSCredPres;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBS setgIBSCredPres(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSCredPres gIBSCredPres) {
        this.gIBSCredPres = gIBSCredPres;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSUFTot getgIBSUFTot() {
        return gIBSUFTot;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBS setgIBSUFTot(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSUFTot gIBSUFTot) {
        this.gIBSUFTot = gIBSUFTot;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot getgIBSMunTot() {
        return gIBSMunTot;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBS setgIBSMunTot(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgIBSgIBSMunTot gIBSMunTot) {
        this.gIBSMunTot = gIBSMunTot;
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
