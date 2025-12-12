package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;

public class NFSeSCSaoJoseNFSeNfIBSCBS {
    @Element(name = "pRedutor")
    private Double percentualRedutor;

    @Element(name = "valores")
    private NFSeSCSaoJoseNFSeNfIBSCBSValores valores;

    @Element(name = "totCIBS")
    private NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS totCIBS;

    public Double getPercentualRedutor() {
        return percentualRedutor;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBS setPercentualRedutor(Double percentualRedutor) {
        this.percentualRedutor = percentualRedutor;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSValores getValores() {
        return valores;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBS setValores(NFSeSCSaoJoseNFSeNfIBSCBSValores valores) {
        this.valores = valores;
        return this;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS getTotCIBS() {
        return totCIBS;
    }

    public NFSeSCSaoJoseNFSeNfIBSCBS setTotCIBS(NFSeSCSaoJoseNFSeNfIBSCBSTotCIBS totCIBS) {
        this.totCIBS = totCIBS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
