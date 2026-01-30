package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeCancelamento {

    @Element(name = "numero")
    private String numero;

    @Element(name = "serie_nfse", required = false)
    private String serieNFSe;

    @Element(name = "situacao", required = false)
    private String situacao;

    @Element(name = "observacao")
    private String observacao;

    public String getNumero() {
        return numero;
    }

    public NFSeSCSaoJoseNFSeCancelamento setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getSerieNFSe() {
        return serieNFSe;
    }

    public NFSeSCSaoJoseNFSeCancelamento setSerieNFSe(String serieNFSe) {
        this.serieNFSe = serieNFSe;
        return this;
    }

    public String getSituacao() {
        return situacao;
    }

    public NFSeSCSaoJoseNFSeCancelamento setSituacao(String situacao) {
        this.situacao = situacao;
        return this;
    }

    public String getObservacao() {
        return observacao;
    }

    public NFSeSCSaoJoseNFSeCancelamento setObservacao(String observacao) {
        this.observacao = observacao;
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
