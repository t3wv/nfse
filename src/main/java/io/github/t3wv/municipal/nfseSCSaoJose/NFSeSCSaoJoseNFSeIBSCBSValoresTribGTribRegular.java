package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular {
    @Element(name = "CSTReg")
    private String CSTReg;
    @Element(name = "cClassTribReg")
    private String cClassTribReg;

    public String getCSTReg() {
        return CSTReg;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular setCSTReg(String CSTReg) {
        this.CSTReg = CSTReg;
        return this;
    }

    public String getcClassTribReg() {
        return cClassTribReg;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular setcClassTribReg(String cClassTribReg) {
        this.cClassTribReg = cClassTribReg;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
