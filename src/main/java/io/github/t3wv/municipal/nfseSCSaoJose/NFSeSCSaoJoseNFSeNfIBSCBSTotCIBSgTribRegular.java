package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular {

    @Element(name = "pAliqEfeRegIBSUF")
    private double pAliqEfeRegIBSUF;
    @Element(name = "vTribRegIBSUF")
    private double vTribRegIBSUF;
    @Element(name = "pAliqEfeRegIBSMun")
    private double pAliqEfeRegIBSMun;
    @Element(name = "vTribRegIBSMun")
    private double vTribRegIBSMun;
    @Element(name = "pAliqEfeRegCBS")
    private double pAliqEfeRegCBS;
    @Element(name = "vTribRegCBS")
    private double vTribRegCBS;

    public double getpAliqEfeRegIBSUF() {
        return pAliqEfeRegIBSUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular setpAliqEfeRegIBSUF(double pAliqEfeRegIBSUF) {
        this.pAliqEfeRegIBSUF = pAliqEfeRegIBSUF;
        return this;
    }

    public double getvTribRegIBSUF() {
        return vTribRegIBSUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular setvTribRegIBSUF(double vTribRegIBSUF) {
        this.vTribRegIBSUF = vTribRegIBSUF;
        return this;
    }

    public double getpAliqEfeRegIBSMun() {
        return pAliqEfeRegIBSMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular setpAliqEfeRegIBSMun(double pAliqEfeRegIBSMun) {
        this.pAliqEfeRegIBSMun = pAliqEfeRegIBSMun;
        return this;
    }

    public double getvTribRegIBSMun() {
        return vTribRegIBSMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular setvTribRegIBSMun(double vTribRegIBSMun) {
        this.vTribRegIBSMun = vTribRegIBSMun;
        return this;
    }

    public double getpAliqEfeRegCBS() {
        return pAliqEfeRegCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular setpAliqEfeRegCBS(double pAliqEfeRegCBS) {
        this.pAliqEfeRegCBS = pAliqEfeRegCBS;
        return this;
    }

    public double getvTribRegCBS() {
        return vTribRegCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBSgTribRegular setvTribRegCBS(double vTribRegCBS) {
        this.vTribRegCBS = vTribRegCBS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
