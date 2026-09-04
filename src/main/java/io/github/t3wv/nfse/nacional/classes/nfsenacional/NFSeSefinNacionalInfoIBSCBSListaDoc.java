package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NFSeSefinNacionalInfoIBSCBSListaDoc {
    @ElementUnion({
            @Element(name = "dFeNacional", type = NFSeSefinNacionalInfoIBSCBSDocumentoDFe.class),
            @Element(name = "docFiscalOutro", type = NFSeSefinNacionalInfoIBSCBSDocumentoFiscalOutro.class),
            @Element(name = "docOutro", type = NFSeSefinNacionalInfoIBSCBSDocumentoOutro.class)
    })
    protected NFSeSefinNacionalInfoIBSCBSDocumento documento;
    @Element(name = "fornec", required = false)
    protected NFSeSefinNacionalInfoIBSCBSListaDocFornec fornec;
    @Element(name = "dtEmiDoc")
    protected LocalDate dtEmiDoc;
    @Element(name = "dtCompDoc")
    protected LocalDate dtCompDoc;
    @Element(name = "tpReeRepRes")
    protected NFSeSefinNacionalInfoIBSCBSTpReeRepRes tpReeRepRes;
    @Element(name = "xTpReeRepRes", required = false)
    protected String xTpReeRepRes;
    @Element(name = "vlrReeRepRes")
    protected BigDecimal vlrReeRepRes;

    public NFSeSefinNacionalInfoIBSCBSDocumento getDocumento() {
        return documento;
    }

    public NFSeSefinNacionalInfoIBSCBSListaDoc setDocumento(NFSeSefinNacionalInfoIBSCBSDocumento documento) {
        this.documento = documento;
        return this;
    }

    public NFSeSefinNacionalInfoIBSCBSListaDocFornec getFornec() {
        return fornec;
    }

    public NFSeSefinNacionalInfoIBSCBSListaDoc setFornec(NFSeSefinNacionalInfoIBSCBSListaDocFornec fornec) {
        this.fornec = fornec;
        return this;
    }

    public LocalDate getDtEmiDoc() {
        return dtEmiDoc;
    }

    public NFSeSefinNacionalInfoIBSCBSListaDoc setDtEmiDoc(LocalDate dtEmiDoc) {
        this.dtEmiDoc = dtEmiDoc;
        return this;
    }

    public LocalDate getDtCompDoc() {
        return dtCompDoc;
    }

    public NFSeSefinNacionalInfoIBSCBSListaDoc setDtCompDoc(LocalDate dtCompDoc) {
        this.dtCompDoc = dtCompDoc;
        return this;
    }

    public NFSeSefinNacionalInfoIBSCBSTpReeRepRes getTpReeRepRes() {
        return tpReeRepRes;
    }

    public NFSeSefinNacionalInfoIBSCBSListaDoc setTpReeRepRes(NFSeSefinNacionalInfoIBSCBSTpReeRepRes tpReeRepRes) {
        this.tpReeRepRes = tpReeRepRes;
        return this;
    }

    public String getxTpReeRepRes() {
        return xTpReeRepRes;
    }

    public NFSeSefinNacionalInfoIBSCBSListaDoc setxTpReeRepRes(String xTpReeRepRes) {
        this.xTpReeRepRes = xTpReeRepRes;
        return this;
    }

    public BigDecimal getVlrReeRepRes() {
        return vlrReeRepRes;
    }

    public NFSeSefinNacionalInfoIBSCBSListaDoc setVlrReeRepRes(BigDecimal vlrReeRepRes) {
        this.vlrReeRepRes = vlrReeRepRes;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSListaDoc{" +
                "documento=" + documento +
                ", fornec=" + fornec +
                ", dtEmiDoc=" + dtEmiDoc +
                ", dtCompDoc=" + dtCompDoc +
                ", tpReeRepRes=" + tpReeRepRes +
                ", xTpReeRepRes='" + xTpReeRepRes + '\'' +
                ", vlrReeRepRes=" + vlrReeRepRes +
                '}';
    }
}
