package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeIBSCBSImovelEnd {

    @Element(name = "CEP", required = false)
    private String cep;

    @Element(name = "endExt", required = false)
    private NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt endExt;

    @Element(name = "xLgr", required = false)
    private String logradouro;

    @Element(name = "nro", required = false)
    private String numero;

    @Element(name = "xCpl", required = false)
    private String complemento;

    @Element(name = "xBairro", required = false)
    private String bairro;

    public String getCep() {
        return cep;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEnd setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt getEndExt() {
        return endExt;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEnd setEndExt(NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt endExt) {
        this.endExt = endExt;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEnd setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEnd setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEnd setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEnd setBairro(String bairro) {
        this.bairro = bairro;
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
