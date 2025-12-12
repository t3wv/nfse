package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeNfIBSCBSValoresFed {
    @Element(name = "pCBS")
    private Double percentualCBS;

    @Element(name = "pRedAliqCBS", required = false)
    private Double percentualReducaoAliquotaCBS;

    @Element(name = "pAliqEfetCBS")
    private Double percentualAliquotaEfetivaCBS;

    public Double getPercentualCBS() {
        return percentualCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresFed setPercentualIBSCBS(Double percentualIBSCBS) {
        this.percentualCBS = percentualIBSCBS;
        return this;
    }

    public Double getPercentualReducaoAliquotaCBS() {
        return percentualReducaoAliquotaCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresFed setPercentualReducaoAliquotaCBS(Double percentualReducaoAliquotaCBS) {
        this.percentualReducaoAliquotaCBS = percentualReducaoAliquotaCBS;
        return this;
    }

    public Double getPercentualAliquotaEfetivaCBS() {
        return percentualAliquotaEfetivaCBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresFed setPercentualAliquotaEfetivaCBS(Double percentualAliquotaEfetivaCBS) {
        this.percentualAliquotaEfetivaCBS = percentualAliquotaEfetivaCBS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
