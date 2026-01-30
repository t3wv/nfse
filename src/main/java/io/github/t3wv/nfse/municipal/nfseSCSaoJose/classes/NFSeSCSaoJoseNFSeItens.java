package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.ElementList;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

public class NFSeSCSaoJoseNFSeItens {

    @ElementList(name = "lista", entry = "lista", inline = true, required = false)
    private List<NFSeSCSaoJoseNFSeListaItem> lista;

    public List<NFSeSCSaoJoseNFSeListaItem> getLista() {
        return lista;
    }

    public NFSeSCSaoJoseNFSeItens setItens(List<NFSeSCSaoJoseNFSeListaItem> lista) {
        this.lista = lista;
        return this;
    }

    public NFSeSCSaoJoseNFSeItens addItem(NFSeSCSaoJoseNFSeListaItem nfSeSCSaoJoseNFSeListaItem) {
        if(this.lista == null){
            this.lista = new java.util.ArrayList<>();
        }
        this.lista.add(nfSeSCSaoJoseNFSeListaItem);
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