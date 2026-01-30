package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

class NFSeSCSaoJoseNFSeItensListaProfissional {
    @Element(name = "cnpj", required = false)
    private String cnpj;
    @Element(name = "razao_social", required = false)
    private String razaoSocial;
    @Element(name = "valor_servico", required = false)
    private BigDecimal valorServico;

    public String getCnpj() {
        return cnpj;
    }

    public NFSeSCSaoJoseNFSeItensListaProfissional setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public NFSeSCSaoJoseNFSeItensListaProfissional setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public NFSeSCSaoJoseNFSeItensListaProfissional setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
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
