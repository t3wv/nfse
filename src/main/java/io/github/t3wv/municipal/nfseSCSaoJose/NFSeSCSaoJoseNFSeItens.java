package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeItens {
    @Element(name = "lista")
    private NFSeSCSaoJoseNFSeItensLista lista;

    public NFSeSCSaoJoseNFSeItensLista getLista() {
        return lista;
    }

    public NFSeSCSaoJoseNFSeItens setLista(NFSeSCSaoJoseNFSeItensLista lista) {
        this.lista = lista;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}