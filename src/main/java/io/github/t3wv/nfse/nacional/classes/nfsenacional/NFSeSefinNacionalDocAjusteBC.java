package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Documento utilizado para ajuste dos valores de base de cálculo do ISSQN e/ou do IBS/CBS
 * (TCDocAjusteBC, NT SE/CGNFS-e 009). Substitui o docDedRed (vDedRed) e o documentos do gReeRepRes.
 */
@Root(name = "docAjusteBC")
public class NFSeSefinNacionalDocAjusteBC {
    @Element(name = "tpAjusteBC")
    protected NFSeSefinNacionalDocAjusteBCTipoAjuste tpAjusteBC;
    @Element(name = "xTpAjusteBC", required = false)
    protected String xTpAjusteBC;
    @Element(name = "vTotDoc")
    protected BigDecimal vTotDoc;
    @Element(name = "vAjusteAplic")
    protected BigDecimal vAjusteAplic;
    @Element(name = "dtEmiDoc", required = false)
    protected LocalDate dtEmiDoc;
    @Element(name = "dtCompDoc", required = false)
    protected LocalDate dtCompDoc;
    @ElementUnion({
            @Element(name = "dFeNacional", type = NFSeSefinNacionalInfoIBSCBSDocumentoDFe.class),
            @Element(name = "docFiscalOutro", type = NFSeSefinNacionalInfoIBSCBSDocumentoFiscalOutro.class),
            @Element(name = "docOutro", type = NFSeSefinNacionalInfoIBSCBSDocumentoOutro.class)
    })
    protected NFSeSefinNacionalInfoIBSCBSDocumento documento;
    @Element(name = "fornec", required = false)
    protected NFSeSefinNacionalInfoPessoa fornec;

    /**
     * Tipo de ajuste
     * @return tpAjusteBC
     */
    public NFSeSefinNacionalDocAjusteBCTipoAjuste getTpAjusteBC() {
        return tpAjusteBC;
    }

    public NFSeSefinNacionalDocAjusteBC setTpAjusteBC(NFSeSefinNacionalDocAjusteBCTipoAjuste tpAjusteBC) {
        this.tpAjusteBC = tpAjusteBC;
        return this;
    }

    /**
     * Descrição do ajuste, quando o tipo é 99 ou 199
     * @return xTpAjusteBC
     */
    public String getxTpAjusteBC() {
        return xTpAjusteBC;
    }

    public NFSeSefinNacionalDocAjusteBC setxTpAjusteBC(String xTpAjusteBC) {
        this.xTpAjusteBC = xTpAjusteBC;
        return this;
    }

    /**
     * Valor total do documento passível de ajuste de base de cálculo (R$)
     * @return vTotDoc
     */
    public BigDecimal getvTotDoc() {
        return vTotDoc;
    }

    public NFSeSefinNacionalDocAjusteBC setvTotDoc(BigDecimal vTotDoc) {
        this.vTotDoc = vTotDoc;
        return this;
    }

    /**
     * Valor efetivamente utilizado para ajuste de base(s) de cálculo (R$)
     * @return vAjusteAplic
     */
    public BigDecimal getvAjusteAplic() {
        return vAjusteAplic;
    }

    public NFSeSefinNacionalDocAjusteBC setvAjusteAplic(BigDecimal vAjusteAplic) {
        this.vAjusteAplic = vAjusteAplic;
        return this;
    }

    public LocalDate getDtEmiDoc() {
        return dtEmiDoc;
    }

    public NFSeSefinNacionalDocAjusteBC setDtEmiDoc(LocalDate dtEmiDoc) {
        this.dtEmiDoc = dtEmiDoc;
        return this;
    }

    public LocalDate getDtCompDoc() {
        return dtCompDoc;
    }

    public NFSeSefinNacionalDocAjusteBC setDtCompDoc(LocalDate dtCompDoc) {
        this.dtCompDoc = dtCompDoc;
        return this;
    }

    /**
     * Documento: dFeNacional, docFiscalOutro ou docOutro
     * @return documento
     */
    public NFSeSefinNacionalInfoIBSCBSDocumento getDocumento() {
        return documento;
    }

    public NFSeSefinNacionalDocAjusteBC setDocumento(NFSeSefinNacionalInfoIBSCBSDocumento documento) {
        this.documento = documento;
        return this;
    }

    public NFSeSefinNacionalInfoPessoa getFornec() {
        return fornec;
    }

    public NFSeSefinNacionalDocAjusteBC setFornec(NFSeSefinNacionalInfoPessoa fornec) {
        this.fornec = fornec;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalDocAjusteBC{" +
                "tpAjusteBC=" + tpAjusteBC +
                ", xTpAjusteBC='" + xTpAjusteBC + '\'' +
                ", vTotDoc=" + vTotDoc +
                ", vAjusteAplic=" + vAjusteAplic +
                ", dtEmiDoc=" + dtEmiDoc +
                ", dtCompDoc=" + dtCompDoc +
                ", documento=" + documento +
                ", fornec=" + fornec +
                '}';
    }
}
