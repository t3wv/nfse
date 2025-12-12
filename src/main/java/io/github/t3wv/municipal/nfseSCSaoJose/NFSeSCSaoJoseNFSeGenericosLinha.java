package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

class NFSeSCSaoJoseNFSeGenericosLinha {
    @Element(name = "titulo")
    private String titulo;
    @Element(name = "descricao")
    private String descricao;

    public String getTitulo() {
        return titulo;
    }

    public NFSeSCSaoJoseNFSeGenericosLinha setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public NFSeSCSaoJoseNFSeGenericosLinha setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
