package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSePrestador {
    @Element(name = "cpfcnpj")
    private String cpfCnpj;

    @Element(name = "cidade")
    private String cidade;

    @Element(name = "inscricao_municipal", required = false)
    private String inscricaoMunicipal;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public NFSeSCSaoJoseNFSePrestador setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public NFSeSCSaoJoseNFSePrestador setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public NFSeSCSaoJoseNFSePrestador setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
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
