
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfNFSe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfNFSe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="xLocEmi" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150"/&gt;
 *         &lt;element name="xLocPrestacao" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150"/&gt;
 *         &lt;element name="nNFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSNNFSe"/&gt;
 *         &lt;element name="cLocIncid" type="{http://www.sped.fazenda.gov.br/nfse}TSCodMunIBGE" minOccurs="0"/&gt;
 *         &lt;element name="xLocIncid" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc150" minOccurs="0"/&gt;
 *         &lt;element name="xTribNac" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600"/&gt;
 *         &lt;element name="xTribMun" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600" minOccurs="0"/&gt;
 *         &lt;element name="xNBS" type="{http://www.sped.fazenda.gov.br/nfse}TSDesc600" minOccurs="0"/&gt;
 *         &lt;element name="verAplic" type="{http://www.sped.fazenda.gov.br/nfse}TSVerAplic"/&gt;
 *         &lt;element name="ambGer" type="{http://www.sped.fazenda.gov.br/nfse}TSAmbGeradorNFSe"/&gt;
 *         &lt;element name="tpEmis" type="{http://www.sped.fazenda.gov.br/nfse}TSTipoEmissao"/&gt;
 *         &lt;element name="procEmi" type="{http://www.sped.fazenda.gov.br/nfse}TSProcEmissao"/&gt;
 *         &lt;element name="cStat" type="{http://www.sped.fazenda.gov.br/nfse}TStat"/&gt;
 *         &lt;element name="dhProc" type="{http://www.sped.fazenda.gov.br/nfse}TSDateTimeUTC"/&gt;
 *         &lt;element name="nDFSe" type="{http://www.sped.fazenda.gov.br/nfse}TSNDFSe"/&gt;
 *         &lt;element name="emit" type="{http://www.sped.fazenda.gov.br/nfse}TCEmitente"/&gt;
 *         &lt;element name="valores" type="{http://www.sped.fazenda.gov.br/nfse}TCValoresNFSe"/&gt;
 *         &lt;element name="DPS" type="{http://www.sped.fazenda.gov.br/nfse}TCDPS"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" use="required" type="{http://www.sped.fazenda.gov.br/nfse}TSIdNFSe" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfNFSe")
public class NFSeSefinNacionalInfNFSe {

    @Element(name = "xLocEmi", required = true)
    protected String xLocEmi;
    @Element(name = "xLocPrestacao", required = true)
    protected String xLocPrestacao;
    @Element(name = "nNFSe", required = false)
    protected String nnfSe;
    @Element(name = "cLocIncid", required = false)
    protected String cLocIncid;
    @Element(name = "xLocIncid", required = false)
    protected String xLocIncid;
    @Element(name = "xTribNac", required = true)
    protected String xTribNac;
    @Element(name = "xTribMun", required = false)
    protected String xTribMun;
    @Element(name = "xNBS", required = false)
    protected String xnbs;
    @Element(name = "verAplic", required = true)
    protected String verAplic;
    @Element(name = "ambGer", required = true)
    protected String ambGer;
    @Element(name = "tpEmis", required = true)
    protected String tpEmis;
    @Element(name = "procEmi", required = true)
    protected String procEmi;
    @Element(name = "cStat", required = true)
    protected String cStat;
    @Element(name = "dhProc", required = true)
    protected String dhProc;
    @Element(name = "nDFSe", required = false)
    protected String ndfSe;
    @Element(name = "emit", required = true)
    protected NFSeSefinNacionalEmitente emit;
    @Element(name = "valores", required = true)
    protected NFSeSefinNacionalValoresNFSe valores;
    @Element(name = "DPS", required = false)
    protected NFSeSefinNacionalDPS dps;
    @Attribute(name = "Id", required = false)
    protected String id;

    public String getXLocEmi() {
        return xLocEmi;
    }

    public NFSeSefinNacionalInfNFSe setXLocEmi(String value) {
        this.xLocEmi = value;
        return this;
    }

    public String getXLocPrestacao() {
        return xLocPrestacao;
    }

    public NFSeSefinNacionalInfNFSe setXLocPrestacao(String value) {
        this.xLocPrestacao = value;
        return this;
    }

    public String getNNFSe() {
        return nnfSe;
    }

    public NFSeSefinNacionalInfNFSe setNNFSe(String value) {
        this.nnfSe = value;
        return this;
    }

    public String getCLocIncid() {
        return cLocIncid;
    }

    public NFSeSefinNacionalInfNFSe setCLocIncid(String value) {
        this.cLocIncid = value;
        return this;
    }

    public String getXLocIncid() {
        return xLocIncid;
    }

    public NFSeSefinNacionalInfNFSe setXLocIncid(String value) {
        this.xLocIncid = value;
        return this;
    }

    public String getXTribNac() {
        return xTribNac;
    }

    public NFSeSefinNacionalInfNFSe setXTribNac(String value) {
        this.xTribNac = value;
        return this;
    }

    public String getXTribMun() {
        return xTribMun;
    }

    public NFSeSefinNacionalInfNFSe setXTribMun(String value) {
        this.xTribMun = value;
        return this;
    }

    public String getXNBS() {
        return xnbs;
    }

    public NFSeSefinNacionalInfNFSe setXNBS(String value) {
        this.xnbs = value;
        return this;
    }

    public String getVerAplic() {
        return verAplic;
    }

    public NFSeSefinNacionalInfNFSe setVerAplic(String value) {
        this.verAplic = value;
        return this;
    }

    public String getAmbGer() {
        return ambGer;
    }

    public NFSeSefinNacionalInfNFSe setAmbGer(String value) {
        this.ambGer = value;
        return this;
    }

    public String getTpEmis() {
        return tpEmis;
    }

    public NFSeSefinNacionalInfNFSe setTpEmis(String value) {
        this.tpEmis = value;
        return this;
    }

    public String getProcEmi() {
        return procEmi;
    }

    public NFSeSefinNacionalInfNFSe setProcEmi(String value) {
        this.procEmi = value;
        return this;
    }

    public String getCStat() {
        return cStat;
    }

    public NFSeSefinNacionalInfNFSe setCStat(String value) {
        this.cStat = value;
        return this;
    }

    public String getDhProc() {
        return dhProc;
    }

    public NFSeSefinNacionalInfNFSe setDhProc(String value) {
        this.dhProc = value;
        return this;
    }

    public String getNDFSe() {
        return ndfSe;
    }

    public NFSeSefinNacionalInfNFSe setNDFSe(String value) {
        this.ndfSe = value;
        return this;
    }

    public NFSeSefinNacionalEmitente getEmit() {
        return emit;
    }

    public NFSeSefinNacionalInfNFSe setEmit(NFSeSefinNacionalEmitente value) {
        this.emit = value;
        return this;
    }

    public NFSeSefinNacionalValoresNFSe getValores() {
        return valores;
    }

    public NFSeSefinNacionalInfNFSe setValores(NFSeSefinNacionalValoresNFSe value) {
        this.valores = value;
        return this;
    }

    public NFSeSefinNacionalDPS getDPS() {
        return dps;
    }

    public NFSeSefinNacionalInfNFSe setDPS(NFSeSefinNacionalDPS value) {
        this.dps = value;
        return this;
    }

    public String getId() {
        return id;
    }

    public NFSeSefinNacionalInfNFSe setId(String value) {
        this.id = value;
        return this;
    }

}
