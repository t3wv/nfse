package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeIBSCBSValores {

    @Element(name = "trib")
    private NFSeSCSaoJoseNFSeIBSCBSValoresTrib trib;

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib getTrib() {
        return trib;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValores setTrib(NFSeSCSaoJoseNFSeIBSCBSValoresTrib trib) {
        this.trib = trib;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
