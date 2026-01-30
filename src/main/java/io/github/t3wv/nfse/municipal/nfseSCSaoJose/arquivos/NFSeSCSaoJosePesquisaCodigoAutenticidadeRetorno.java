package io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.NFSeSCSaoJoseNFSeEmissao;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.NFSeSCSaoJoseNFSeListaItem;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.NFSeSCSaoJoseNFSePrestador;
import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.NFSeSCSaoJoseNFSeTomador;
import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Root(name = "nfse")
public class NFSeSCSaoJosePesquisaCodigoAutenticidadeRetorno {

    @ElementList(name = "mensagem", entry = "codigo", required = false)
    private List<String> mensagem;

    @Element(name = "nf", required = false)
    private NFSeSCSaoJoseNFSeEmissao nf;

    @Element(name = "prestador", required = false)
    private NFSeSCSaoJoseNFSePrestador prestador;

    @Element(name = "tomador", required = false)
    private NFSeSCSaoJoseNFSeTomador tomador;

    @Path(value="itens")
    @ElementList(inline = true, entry = "lista", required = false)
    private List<NFSeSCSaoJoseNFSeListaItem> itens;

    public NFSeSCSaoJoseNFSeEmissao getNf() {
        return nf;
    }

    public NFSeSCSaoJosePesquisaCodigoAutenticidadeRetorno setNf(NFSeSCSaoJoseNFSeEmissao nf) {
        this.nf = nf;
        return this;
    }

    public NFSeSCSaoJoseNFSePrestador getPrestador() {
        return prestador;
    }

    public NFSeSCSaoJosePesquisaCodigoAutenticidadeRetorno setPrestador(NFSeSCSaoJoseNFSePrestador prestador) {
        this.prestador = prestador;
        return this;
    }

    public NFSeSCSaoJoseNFSeTomador getTomador() {
        return tomador;
    }

    public NFSeSCSaoJosePesquisaCodigoAutenticidadeRetorno setTomador(NFSeSCSaoJoseNFSeTomador tomador) {
        this.tomador = tomador;
        return this;
    }

    public List<NFSeSCSaoJoseNFSeListaItem> getItens() {
        return itens;
    }

    public NFSeSCSaoJosePesquisaCodigoAutenticidadeRetorno setItens(List<NFSeSCSaoJoseNFSeListaItem> itens) {
        this.itens = itens;
        return this;
    }

    public NFSeSCSaoJosePesquisaCodigoAutenticidadeRetorno addItem(NFSeSCSaoJoseNFSeListaItem item) {
        if (this.itens == null){
            this.itens = new ArrayList<>();
        }
        this.itens.add(item);
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
