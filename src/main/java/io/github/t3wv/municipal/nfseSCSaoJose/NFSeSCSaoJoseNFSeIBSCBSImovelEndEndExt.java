package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt {
    @Element(name = "cEndPost", required = false)
    private String cEndPost;

    @Element(name = "xCidade", required = false)
    private String xCidade;

    @Element(name = "xEstProvReg", required = false)
    private String xEstProvReg;

    public String getcEndPost() {
        return cEndPost;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt setcEndPost(String cEndPost) {
        this.cEndPost = cEndPost;
        return this;
    }

    public String getxCidade() {
        return xCidade;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt setxCidade(String xCidade) {
        this.xCidade = xCidade;
        return this;
    }

    public String getxEstProvReg() {
        return xEstProvReg;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovelEndEndExt setxEstProvReg(String xEstProvReg) {
        this.xEstProvReg = xEstProvReg;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
