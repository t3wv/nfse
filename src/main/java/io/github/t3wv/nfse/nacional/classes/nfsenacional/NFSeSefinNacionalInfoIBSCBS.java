package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "IBSCBS")
public class NFSeSefinNacionalInfoIBSCBS {
    @Element(name="finNFSe")
    protected NFSeSefinNacionalInfoIBSCBSFinNFSe finNFSe;
    @Element(name="indFinal", required = false)
    protected Boolean indFinal;
    @Element(name="cIndOp")
    protected String cIndOp;
    @Element(name="tpOper", required = false)
    protected NFSeSefinNacionalInfoIBSCBSTpOper tpOper;
    @ElementList(name="gRefNFSe", entry = "refNFSe", required = false)
    protected List<String> gRefNFSe;
    @Element(name="tpEnteGov", required = false)
    protected NFSeSefinNacionalInfoIBSCBSTpEnteGov tpEnteGov;
    @Element(name="indDest")
    protected NFSeSefinNacionalInfoIBSCBSIndDest indDest;
    @Element(name="dest", required = false)
    protected NFSeSefinNacionalInfoIBSCBSInfoDest dest;
    @Element(name="imovel", required = false)
    protected NFSeSefinNacionalInfoIBSCBSInfoImovel imovel;
    @Element(name="valores")
    protected NFSeSefinNacionalInfoIBSCBSInfoValoresIBSCBS valores;

    public NFSeSefinNacionalInfoIBSCBS() {
        this.finNFSe = NFSeSefinNacionalInfoIBSCBSFinNFSe.REGULAR;
    }

    /**
     * Indicador da finalidade da emissão de NFS-e
     * @return finNFSe
     */
    public NFSeSefinNacionalInfoIBSCBSFinNFSe getFinNFSe() {
        return finNFSe;
    }

    /**
     * Indicador da finalidade da emissão de NFS-e
     * @param finNFSe the finNFSe to set
     * @return NFSeSefinNacionalInfoIBSCBS
     */
    public NFSeSefinNacionalInfoIBSCBS setFinNFSe(NFSeSefinNacionalInfoIBSCBSFinNFSe finNFSe) {
        this.finNFSe = finNFSe;
        return this;
    }

    /**
     * Indica operação de uso ou consumo pessoal (art. 57)
     * @return indFinal
     */
    public Boolean getIndFinal() {
        return indFinal;
    }

    /**
     * Indica operação de uso ou consumo pessoal (art. 57)
     * @param indFinal
     * @return NFSeSefinNacionalInfoIBSCBS
     */
    public NFSeSefinNacionalInfoIBSCBS setIndFinal(Boolean indFinal) {
        this.indFinal = indFinal;
        return this;
    }

    /**
     * Código indicador da operação de fornecimento, conforme tabela <a href="https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica/rtc-producao-restrita-piloto">"código indicador de operação - AnexoVII-IndOp_IBSCBS_V1.00.00 "</a>
     * @return cIndOp
     */
    public String getcIndOp() {
        return cIndOp;
    }

    /**
     * Código indicador da operação de fornecimento, conforme tabela <a href="https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica/rtc-producao-restrita-piloto">"código indicador de operação - AnexoVII-IndOp_IBSCBS_V1.00.00 "</a>
     * @param cIndOp
     * @return NFSeSefinNacionalInfoIBSCBS
     */
    public NFSeSefinNacionalInfoIBSCBS setcIndOp(String cIndOp) {
        this.cIndOp = cIndOp;
        return this;
    }

    /**
     * Tipo de Operação com Entes Governamentais ou outros serviços sobre bens imóveis
     * @return tpOper
     */
    public NFSeSefinNacionalInfoIBSCBSTpOper getTpOper() {
        return tpOper;
    }

    /**
     * Tipo de Operação com Entes Governamentais ou outros serviços sobre bens imóveis
     * @param tpOper
     * @return NFSeSefinNacionalInfoIBSCBS
     */
    public NFSeSefinNacionalInfoIBSCBS setTpOper(NFSeSefinNacionalInfoIBSCBSTpOper tpOper) {
        this.tpOper = tpOper;
        return this;
    }

    /**
     * Grupo de NFS-e referenciadas
     * @return gRefNFSe
     */
    public List<String> getgRefNFSe() {
        return gRefNFSe;
    }

    /**
     * Grupo de NFS-e referenciadas
     * @param gRefNFSe Lista de chaves de nfs-e referenciadas
     * @return NFSeSefinNacionalInfoIBSCBS
     */
    public NFSeSefinNacionalInfoIBSCBS setgRefNFSe(List<String> gRefNFSe) {
        this.gRefNFSe = gRefNFSe;
        return this;
    }

    /**
     * Tipo de ente governamental
     * @return tpEnteGov
     */
    public NFSeSefinNacionalInfoIBSCBSTpEnteGov getTpEnteGov() {
        return tpEnteGov;
    }

    /**
     * Tipo de ente governamental
     * @see NFSeSefinNacionalInfoIBSCBSTpEnteGov
     * @param tpEnteGov tipo ente governamental
     * @return NFSeSefinNacionalInfoIBSCBS
     */
    public NFSeSefinNacionalInfoIBSCBS setTpEnteGov(NFSeSefinNacionalInfoIBSCBSTpEnteGov tpEnteGov) {
        this.tpEnteGov = tpEnteGov;
        return this;
    }

    /**
     * A respeito do Destinatário dos serviços
     * @return indDest
     */
    public NFSeSefinNacionalInfoIBSCBSIndDest getIndDest() {
        return indDest;
    }

    /**
     * A respeito do Destinatário dos serviços
     * @see NFSeSefinNacionalInfoIBSCBSIndDest
     * @param indDest
     * @return NFSeSefinNacionalInfoIBSCBS
     */
    public NFSeSefinNacionalInfoIBSCBS setIndDest(NFSeSefinNacionalInfoIBSCBSIndDest indDest) {
        this.indDest = indDest;
        return this;
    }

    /**
     * Dados do destinatário dos serviços
     * @return dest
     */
    public NFSeSefinNacionalInfoIBSCBSInfoDest getDest() {
        return dest;
    }

    /**
     * Dados do destinatário dos serviços
     * @param dest
     * @return NFSeSefinNacionalInfoIBSCBS
     */
    public NFSeSefinNacionalInfoIBSCBS setDest(NFSeSefinNacionalInfoIBSCBSInfoDest dest) {
        this.dest = dest;
        return this;
    }

    /**
     * Grupo de informações de operações relacionadas a bens imóveis, exceto obras
     * @return
     */
    public NFSeSefinNacionalInfoIBSCBSInfoImovel getImovel() {
        return imovel;
    }

    /**
     * Grupo de informações de operações relacionadas a bens imóveis, exceto obras
     * @param imovel
     * @return
     */
    public NFSeSefinNacionalInfoIBSCBS setImovel(NFSeSefinNacionalInfoIBSCBSInfoImovel imovel) {
        this.imovel = imovel;
        return this;
    }

    /**
     * Grupo de informações relativas aos valores do serviço prestado para IBS e CBS
     * @return
     */
    public NFSeSefinNacionalInfoIBSCBSInfoValoresIBSCBS getValores() {
        return valores;
    }

    /**
     * Grupo de informações relativas aos valores do serviço prestado para IBS e CBS
     * @param valores
     * @return
     */
    public NFSeSefinNacionalInfoIBSCBS setValores(NFSeSefinNacionalInfoIBSCBSInfoValoresIBSCBS valores) {
        this.valores = valores;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBS{" +
                "finNFSe=" + finNFSe +
                ", indFinal=" + indFinal +
                ", cIndOp='" + cIndOp + '\'' +
                ", tpOper=" + tpOper +
                ", gRefNFSe='" + gRefNFSe + '\'' +
                ", tpEnteGov=" + tpEnteGov +
                ", indDest=" + indDest +
                ", dest=" + dest +
                ", imovel=" + imovel +
                ", valores=" + valores +
                '}';
    }
}
