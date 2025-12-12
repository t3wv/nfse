package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeIBSCBSValoresTrib {
    @Element(name = "CST")
    private String cst;

    @Element(name = "cClassTrib")
    private String cClassTrib;

    @Element(name = "cCredPres")
    private String cCredPres;

    @Element(name = "gTribRegular")
    private NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular gTribRegular;

    @Element(name = "gDif")
    private NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif gDif;

    public String getCst() {
        return cst;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setCst(String cst) {
        this.cst = cst;
        return this;
    }

    public String getcClassTrib() {
        return cClassTrib;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setcClassTrib(String cClassTrib) {
        this.cClassTrib = cClassTrib;
        return this;
    }

    public String getcCredPres() {
        return cCredPres;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setcCredPres(String cCredPres) {
        this.cCredPres = cCredPres;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular getgTribRegular() {
        return gTribRegular;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setgTribRegular(NFSeSCSaoJoseNFSeIBSCBSValoresTribGTribRegular gTribRegular) {
        this.gTribRegular = gTribRegular;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif getgDif() {
        return gDif;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValoresTrib setgDif(NFSeSCSaoJoseNFSeIBSCBSValoresTribGDif gDif) {
        this.gDif = gDif;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
