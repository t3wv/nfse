package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import org.simpleframework.xml.Element;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TpDocumento {

    @Element(name = "dFeNacional")
    protected TpDFeNacional dFeNacional;
    @Element(name = "docFiscalOutro")
    protected TpDocFiscalOutro docFiscalOutro;
    @Element(name = "docOutro")
    protected TpDocOutro docOutro;
    @Element(name = "fornec")
    protected TpFornecedor fornec;
    @Element(name = "dtEmiDoc")
    protected LocalDate dtEmiDoc;
    @Element(name = "dtCompDoc")
    protected LocalDate dtCompDoc;
    @Element(name = "tpReeRepRes")
    protected int tpReeRepRes;
    @Element(name = "xTpReeRepRes")
    protected String xTpReeRepRes;
    @Element(name = "vlrReeRepRes")
    protected BigDecimal vlrReeRepRes;

    public TpDFeNacional getDFeNacional() {
        return dFeNacional;
    }

    public TpDocumento setDFeNacional(TpDFeNacional value) {
        this.dFeNacional = value;
        return this;
    }

    public TpDocFiscalOutro getDocFiscalOutro() {
        return docFiscalOutro;
    }

    public TpDocumento setDocFiscalOutro(TpDocFiscalOutro value) {
        this.docFiscalOutro = value;
        return this;
    }

    public TpDocOutro getDocOutro() {
        return docOutro;
    }

    public TpDocumento setDocOutro(TpDocOutro value) {
        this.docOutro = value;
        return this;
    }

    public TpFornecedor getFornec() {
        return fornec;
    }

    public TpDocumento setFornec(TpFornecedor value) {
        this.fornec = value;
        return this;
    }

    public LocalDate getDtEmiDoc() {
        return dtEmiDoc;
    }

    public TpDocumento setDtEmiDoc(LocalDate value) {
        this.dtEmiDoc = value;
        return this;
    }

    public LocalDate getDtCompDoc() {
        return dtCompDoc;
    }

    public TpDocumento setDtCompDoc(LocalDate value) {
        this.dtCompDoc = value;
        return this;
    }

    public int getTpReeRepRes() {
        return tpReeRepRes;
    }

    public TpDocumento setTpReeRepRes(int value) {
        this.tpReeRepRes = value;
        return this;
    }

    public String getXTpReeRepRes() {
        return xTpReeRepRes;
    }

    public TpDocumento setXTpReeRepRes(String value) {
        this.xTpReeRepRes = value;
        return this;
    }

    public BigDecimal getVlrReeRepRes() {
        return vlrReeRepRes;
    }

    public TpDocumento setVlrReeRepRes(BigDecimal value) {
        this.vlrReeRepRes = value;
        return this;
    }

}
