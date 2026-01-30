package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeCancelamentoSolicitacaoSubstituta {
    @Element(name = "numero")
    private long numero;

    @Element(name = "serie", required = false)
    private Integer serie;

    public long getNumero() {
        return numero;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacaoSubstituta setNumero(long numero) {
        this.numero = numero;
        return this;
    }

    public Integer getSerie() {
        return serie;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacaoSubstituta setSerie(Integer serie) {
        this.serie = serie;
        return this;
    }

    public String toXml() throws Exception {
        StringWriter writer = new StringWriter();
        new NFSePersister(true, new NFSeRegistryMatcher()).write(this, writer);
        return writer.toString();
    }
}
