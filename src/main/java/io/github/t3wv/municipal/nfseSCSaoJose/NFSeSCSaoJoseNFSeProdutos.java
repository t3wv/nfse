package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeProdutos {
    @Element(name = "descricao")
    private String descricao;
    @Element(name = "valor")
    private BigDecimal valor;

    public String getDescricao() {
        return descricao;
    }

    public NFSeSCSaoJoseNFSeProdutos setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public NFSeSCSaoJoseNFSeProdutos setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
