package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif {
    @Element(name = "pDifUF", required = false)
    private String pDifUF;

    @Element(name = "pDifMun", required = false)
    private String pDifMun;

    @Element(name = "pDifCBS", required = false)
    private String pDifCBS;

    public String getpDifUF() {
        return pDifUF;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif setpDifUF(String pDifUF) {
        this.pDifUF = pDifUF;
        return this;
    }

    public String getpDifMun() {
        return pDifMun;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif setpDifMun(String pDifMun) {
        this.pDifMun = pDifMun;
        return this;
    }

    public String getpDifCBS() {
        return pDifCBS;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif setpDifCBS(String pDifCBS) {
        this.pDifCBS = pDifCBS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
