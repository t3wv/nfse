package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSePrestador {
    @Element(name = "cpfcnpj")
    private String cpfCnpj;

    @Element(name = "cidade")
    private String cidade;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public NFSeSCSaoJoseNFSePrestador setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public NFSeSCSaoJoseNFSePrestador setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
