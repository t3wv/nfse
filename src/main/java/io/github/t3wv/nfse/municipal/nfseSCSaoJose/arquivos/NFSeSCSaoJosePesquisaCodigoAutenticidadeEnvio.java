package io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos;

import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.StringWriter;

@Root(name = "nfse")
public class NFSeSCSaoJosePesquisaCodigoAutenticidadeEnvio {

    @Path(value = "pesquisa")
    @Element(name = "codigo_autenticidade")
    private String codigoAutenticidade;

    public String getCodigoAutenticidade() {
        return codigoAutenticidade;
    }

    public NFSeSCSaoJosePesquisaCodigoAutenticidadeEnvio setCodigoAutenticidade(String codigoAutenticidade) {
        this.codigoAutenticidade = codigoAutenticidade;
        return this;
    }

    public String toXml() throws Exception {
        final var registryMatcher = new NFSeRegistryMatcher();
        NFSePersister serializer = new NFSePersister(true, registryMatcher);
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

}
