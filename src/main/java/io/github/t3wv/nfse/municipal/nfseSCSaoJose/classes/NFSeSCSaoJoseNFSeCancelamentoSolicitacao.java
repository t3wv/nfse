package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.StringWriter;

@Root(name = "nfse")
public class NFSeSCSaoJoseNFSeCancelamentoSolicitacao {

    @Element(name = "numero")
    private long numero;

    @Element(name = "serie", required = false)
    private Integer serie;

    @Element(name = "observacao")
    private String observacao;

    @Element(name = "substituta", required = false)
    private NFSeSCSaoJoseNFSeCancelamentoSolicitacaoSubstituta substituta;

    public long getNumero() {
        return numero;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacao setNumero(long numero) {
        this.numero = numero;
        return this;
    }

    public Integer getSerie() {
        return serie;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacao setSerie(Integer serie) {
        this.serie = serie;
        return this;
    }

    public String getObservacao() {
        return observacao;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacao setObservacao(String observacao) {
        this.observacao = observacao;
        return this;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacaoSubstituta getSubstituta() {
        return substituta;
    }

    public NFSeSCSaoJoseNFSeCancelamentoSolicitacao setSubstituta(NFSeSCSaoJoseNFSeCancelamentoSolicitacaoSubstituta substituta) {
        this.substituta = substituta;
        return this;
    }

    public String toXml() throws Exception {
        StringWriter writer = new StringWriter();
        new NFSePersister(true, new NFSeRegistryMatcher()).write(this, writer);
        return writer.toString();
    }
}
