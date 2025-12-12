package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeNfIBSCBSValoresUF {
    @Element(name = "pIBSUF")
    private Double percentualIBSUF;

    @Element(name = "pRedAliqUF", required = false)
    private Double percentualReducaoAliquotaUF;

    @Element(name = "pAliqEfetUF")
    private Double percentualAliquotaEfetivaUF;

    public Double getPercentualIBSUF() {
        return percentualIBSUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresUF setPercentualIBSUF(Double percentualIBSUF) {
        this.percentualIBSUF = percentualIBSUF;
        return this;
    }

    public Double getPercentualReducaoAliquotaUF() {
        return percentualReducaoAliquotaUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresUF setPercentualReducaoAliquotaUF(Double percentualReducaoAliquotaUF) {
        this.percentualReducaoAliquotaUF = percentualReducaoAliquotaUF;
        return this;
    }

    public Double getPercentualAliquotaEfetivaUF() {
        return percentualAliquotaEfetivaUF;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValoresUF setPercentualAliquotaEfetivaUF(Double percentualAliquotaEfetivaUF) {
        this.percentualAliquotaEfetivaUF = percentualAliquotaEfetivaUF;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
