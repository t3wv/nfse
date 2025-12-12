package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeNfIBSCBSValoresMun {
    @Element(name = "pIBSMun")
    private Double percentualIBSMun;

    @Element(name = "pRedAliqMun", required = false)
    private Double percentualReducaoAliquotaMun;

    @Element(name = "pAliqEfetMun")
    private Double percentualAliquotaEfetivaMun;

    public Double getPercentualIBSMun() {
        return percentualIBSMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresMun setPercentualIBSMun(Double percentualIBSMun) {
        this.percentualIBSMun = percentualIBSMun;
        return this;
    }

    public Double getPercentualReducaoAliquotaMun() {
        return percentualReducaoAliquotaMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresMun setPercentualReducaoAliquotaMun(Double percentualReducaoAliquotaMun) {
        this.percentualReducaoAliquotaMun = percentualReducaoAliquotaMun;
        return this;
    }

    public Double getPercentualAliquotaEfetivaMun() {
        return percentualAliquotaEfetivaMun;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresMun setPercentualAliquotaEfetivaMun(Double percentualAliquotaEfetivaMun) {
        this.percentualAliquotaEfetivaMun = percentualAliquotaEfetivaMun;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
