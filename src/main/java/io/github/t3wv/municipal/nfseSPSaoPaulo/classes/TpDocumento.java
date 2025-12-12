package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

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

    public void setDFeNacional(TpDFeNacional value) {
        this.dFeNacional = value;
    }

    public TpDocFiscalOutro getDocFiscalOutro() {
        return docFiscalOutro;
    }

    public void setDocFiscalOutro(TpDocFiscalOutro value) {
        this.docFiscalOutro = value;
    }

    public TpDocOutro getDocOutro() {
        return docOutro;
    }

    public void setDocOutro(TpDocOutro value) {
        this.docOutro = value;
    }

    public TpFornecedor getFornec() {
        return fornec;
    }

    public void setFornec(TpFornecedor value) {
        this.fornec = value;
    }

    public LocalDate getDtEmiDoc() {
        return dtEmiDoc;
    }

    public void setDtEmiDoc(LocalDate value) {
        this.dtEmiDoc = value;
    }

    public LocalDate getDtCompDoc() {
        return dtCompDoc;
    }

    public void setDtCompDoc(LocalDate value) {
        this.dtCompDoc = value;
    }

    public int getTpReeRepRes() {
        return tpReeRepRes;
    }

    public void setTpReeRepRes(int value) {
        this.tpReeRepRes = value;
    }

    public String getXTpReeRepRes() {
        return xTpReeRepRes;
    }

    public void setXTpReeRepRes(String value) {
        this.xTpReeRepRes = value;
    }

    public BigDecimal getVlrReeRepRes() {
        return vlrReeRepRes;
    }

    public void setVlrReeRepRes(BigDecimal value) {
        this.vlrReeRepRes = value;
    }

}
