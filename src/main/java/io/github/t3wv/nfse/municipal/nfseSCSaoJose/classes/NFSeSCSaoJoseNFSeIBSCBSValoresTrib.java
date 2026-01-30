package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeIBSCBSValoresTrib {
    @Element(name = "CST")
    private String cst;

    @Element(name = "cClassTrib")
    private String cClassTrib;

    @Element(name = "cCredPres")
    private String cCredPres;

    @Element(name = "gTribRegular")
    private NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular gTribRegular;

    @Element(name = "gDif")
    private NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif gDif;

    public String getCst() {
        return cst;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setCst(String cst) {
        this.cst = cst;
        return this;
    }

    public String getcClassTrib() {
        return cClassTrib;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setcClassTrib(String cClassTrib) {
        this.cClassTrib = cClassTrib;
        return this;
    }

    public String getcCredPres() {
        return cCredPres;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setcCredPres(String cCredPres) {
        this.cCredPres = cCredPres;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular getgTribRegular() {
        return gTribRegular;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setgTribRegular(NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular gTribRegular) {
        this.gTribRegular = gTribRegular;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif getgDif() {
        return gDif;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setgDif(NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif gDif) {
        this.gDif = gDif;
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
