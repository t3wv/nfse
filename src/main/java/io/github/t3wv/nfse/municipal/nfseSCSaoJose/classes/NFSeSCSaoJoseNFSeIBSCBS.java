package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

public class NFSeSCSaoJoseNFSeIBSCBS {
    @Element(name = "finNFSe")
    private String finNFSe;

    @Element(name = "indFinal")
    private boolean indFinal;

    @Element(name = "cIndOp")
    private String cIndOp;

    @Element(name = "tpOper", required = false)
    private String tpOper;

    @ElementList(name = "gRefNFSe", entry = "refNFSe")
    private List<String> gRefNFSe;

    @Element(name = "tpEnteGov", required = false)
    private String tpEnteGov;

    @Element(name = "imovel", required = false)
    private NFSeSCSaoJoseNFSeIBSCBSImovel imovel;

    @Element(name = "valores")
    private NFSeSCSaoJoseNFSeIBSCBSValores valores;

    public String getFinNFSe() {
        return finNFSe;
    }

    public NFSeSCSaoJoseNFSeIBSCBS setFinNFSe(String finNFSe) {
        this.finNFSe = finNFSe;
        return this;
    }

    public boolean isIndFinal() {
        return indFinal;
    }

    public NFSeSCSaoJoseNFSeIBSCBS setIndFinal(boolean indFinal) {
        this.indFinal = indFinal;
        return this;
    }

    public String getcIndOp() {
        return cIndOp;
    }

    public NFSeSCSaoJoseNFSeIBSCBS setcIndOp(String cIndOp) {
        this.cIndOp = cIndOp;
        return this;
    }

    public String getTpOper() {
        return tpOper;
    }

    public NFSeSCSaoJoseNFSeIBSCBS setTpOper(String tpOper) {
        this.tpOper = tpOper;
        return this;
    }

    public List<String> getgRefNFSe() {
        return gRefNFSe;
    }

    public NFSeSCSaoJoseNFSeIBSCBS setgRefNFSe(List<String> gRefNFSe) {
        this.gRefNFSe = gRefNFSe;
        return this;
    }

    public String getTpEnteGov() {
        return tpEnteGov;
    }

    public NFSeSCSaoJoseNFSeIBSCBS setTpEnteGov(String tpEnteGov) {
        this.tpEnteGov = tpEnteGov;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSImovel getImovel() {
        return imovel;
    }

    public NFSeSCSaoJoseNFSeIBSCBS setImovel(NFSeSCSaoJoseNFSeIBSCBSImovel imovel) {
        this.imovel = imovel;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBSValores getValores() {
        return valores;
    }

    public NFSeSCSaoJoseNFSeIBSCBS setValores(NFSeSCSaoJoseNFSeIBSCBSValores valores) {
        this.valores = valores;
        return this;
    }

    public String toXml() throws Exception {
        final var registryMatcher = new NFSeRegistryMatcher();
        registryMatcher.bind(boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(Boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());

        NFSePersister serializer = new NFSePersister(true, registryMatcher);
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
