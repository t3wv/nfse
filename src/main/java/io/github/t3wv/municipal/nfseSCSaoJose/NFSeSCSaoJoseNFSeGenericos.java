package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.ElementList;

import java.io.StringWriter;
import java.util.List;

public class NFSeSCSaoJoseNFSeGenericos {

    @ElementList(name = "linha", inline = true, required = false)
    private List<NFSeSCSaoJoseNFSeGenericosLinha> linhas;


    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

}
