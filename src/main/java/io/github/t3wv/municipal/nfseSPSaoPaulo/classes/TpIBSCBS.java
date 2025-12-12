package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

import org.simpleframework.xml.Element;

public class TpIBSCBS {

    @Element(name = "finNFSe")
    protected int finNFSe;
    @Element(name = "indFinal")
    protected int indFinal;
    @Element(name = "cIndOp")
    protected String cIndOp;
    @Element(name = "tpOper", required = false)
    protected Integer tpOper;
    @Element(name = "gRefNFSe", required = false)
    protected TpGRefNFSe gRefNFSe;
    @Element(name = "tpEnteGov", required = false)
    protected Integer tpEnteGov;
    @Element(name = "indDest")
    protected int indDest;
    @Element(name = "dest", required = false)
    protected TpInformacoesPessoa dest;
    @Element(name = "valores")
    protected TpValores valores;
    @Element(name = "imovelobra", required = false)
    protected TpImovelObra imovelobra;

    public int getFinNFSe() {
        return finNFSe;
    }

    public TpIBSCBS setFinNFSe(int value) {
        this.finNFSe = value;
        return this;
    }

    public int getIndFinal() {
        return indFinal;
    }

    public TpIBSCBS setIndFinal(int value) {
        this.indFinal = value;
        return this;
    }

    public String getCIndOp() {
        return cIndOp;
    }

    public TpIBSCBS setCIndOp(String value) {
        this.cIndOp = value;
        return this;
    }

    public Integer getTpOper() {
        return tpOper;
    }

    public TpIBSCBS setTpOper(Integer value) {
        this.tpOper = value;
        return this;
    }

    public TpGRefNFSe getGRefNFSe() {
        return gRefNFSe;
    }

    public TpIBSCBS setGRefNFSe(TpGRefNFSe value) {
        this.gRefNFSe = value;
        return this;
    }

    public Integer getTpEnteGov() {
        return tpEnteGov;
    }

    public TpIBSCBS setTpEnteGov(Integer value) {
        this.tpEnteGov = value;
        return this;
    }

    public int getIndDest() {
        return indDest;
    }

    public TpIBSCBS setIndDest(int value) {
        this.indDest = value;
        return this;
    }

    public TpInformacoesPessoa getDest() {
        return dest;
    }

    public TpIBSCBS setDest(TpInformacoesPessoa value) {
        this.dest = value;
        return this;
    }

    public TpValores getValores() {
        return valores;
    }

    public TpIBSCBS setValores(TpValores value) {
        this.valores = value;
        return this;
    }

    public TpImovelObra getImovelobra() {
        return imovelobra;
    }

    public TpIBSCBS setImovelobra(TpImovelObra value) {
        this.imovelobra = value;
        return this;
    }

}
