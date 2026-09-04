
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.ZonedDateTime;

@Root(name = "InfNFSe")
public class NFSeSefinNacionalInfNFSe {

    @Element(name = "xLocEmi", required = true)
    protected String localEmissao;
    @Element(name = "xLocPrestacao", required = true)
    protected String localPrestacao;
    @Element(name = "nNFSe")
    protected String numeroNFSe;
    @Element(name = "cLocIncid", required = false)
    protected String codigoLocalIncidenciaISSQN;
    @Element(name = "xLocIncid", required = false)
    protected String localIncidenciaISSQN;
    @Element(name = "xTribNac", required = true)
    protected String descricaoNacionalISSQN;
    @Element(name = "xTribMun", required = false)
    protected String descricaoMunicipalISSQN;
    @Element(name = "xNBS", required = false)
    protected String descricaoNBS;
    @Element(name = "verAplic", required = true)
    protected String versaoAplicacao;
    @Element(name = "ambGer", required = true)
    protected String ambienteGeracao;
    @Element(name = "tpEmis", required = true)
    protected NFSeSefinNacionalInfNFSeTipoEmissao tipoEmissao;
    @Element(name = "procEmi", required = false)
    protected NFSeSefinNacionalInfNFSeProcessoEmissao processoEmissao;
    @Element(name = "cStat", required = true)
    protected String codigoStatus;
    @Element(name = "dhProc", required = true)
    protected ZonedDateTime dataHoraProcessamento;
    @Element(name = "nDFSe", required = false)
    protected String numeroDFSe;
    @Element(name = "emit", required = true)
    protected NFSeSefinNacionalEmitente emitente;
    @Element(name = "valores", required = true)
    protected NFSeSefinNacionalValoresNFSe valores;
    @Element(name = "xOutInf", required = false)
    protected String informacoesUsoAdministracaoTributaria;
    @Element(name = "IBSCBS", required = false)
    protected NFSeSefinNacionalInfNFSeIBSCBS ibsCbs;
    @Element(name = "DPS", required = false)
    protected NFSeSefinNacionalDPS dps;
    @Attribute(name = "Id", required = false)
    protected String id;

    public String getLocalEmissao() {
        return localEmissao;
    }

    public NFSeSefinNacionalInfNFSe setLocalEmissao(String localEmissao) {
        this.localEmissao = localEmissao;
        return this;
    }

    public String getLocalPrestacao() {
        return localPrestacao;
    }

    public NFSeSefinNacionalInfNFSe setLocalPrestacao(String localPrestacao) {
        this.localPrestacao = localPrestacao;
        return this;
    }

    public String getNumeroNFSe() {
        return numeroNFSe;
    }

    public NFSeSefinNacionalInfNFSe setNumeroNFSe(String numeroNFSe) {
        this.numeroNFSe = numeroNFSe;
        return this;
    }

    public String getCodigoLocalIncidenciaISSQN() {
        return codigoLocalIncidenciaISSQN;
    }

    public NFSeSefinNacionalInfNFSe setCodigoLocalIncidenciaISSQN(String codigoLocalIncidenciaISSQN) {
        this.codigoLocalIncidenciaISSQN = codigoLocalIncidenciaISSQN;
        return this;
    }

    public String getLocalIncidenciaISSQN() {
        return localIncidenciaISSQN;
    }

    public NFSeSefinNacionalInfNFSe setLocalIncidenciaISSQN(String localIncidenciaISSQN) {
        this.localIncidenciaISSQN = localIncidenciaISSQN;
        return this;
    }

    public String getDescricaoNacionalISSQN() {
        return descricaoNacionalISSQN;
    }

    public NFSeSefinNacionalInfNFSe setDescricaoNacionalISSQN(String descricaoNacionalISSQN) {
        this.descricaoNacionalISSQN = descricaoNacionalISSQN;
        return this;
    }

    public String getDescricaoMunicipalISSQN() {
        return descricaoMunicipalISSQN;
    }

    public NFSeSefinNacionalInfNFSe setDescricaoMunicipalISSQN(String descricaoMunicipalISSQN) {
        this.descricaoMunicipalISSQN = descricaoMunicipalISSQN;
        return this;
    }

    public String getDescricaoNBS() {
        return descricaoNBS;
    }

    public NFSeSefinNacionalInfNFSe setDescricaoNBS(String descricaoNBS) {
        this.descricaoNBS = descricaoNBS;
        return this;
    }

    public String getVersaoAplicacao() {
        return versaoAplicacao;
    }

    public NFSeSefinNacionalInfNFSe setVersaoAplicacao(String versaoAplicacao) {
        this.versaoAplicacao = versaoAplicacao;
        return this;
    }

    public String getAmbienteGeracao() {
        return ambienteGeracao;
    }

    public NFSeSefinNacionalInfNFSe setAmbienteGeracao(String ambienteGeracao) {
        this.ambienteGeracao = ambienteGeracao;
        return this;
    }

    public NFSeSefinNacionalInfNFSeTipoEmissao getTipoEmissao() {
        return tipoEmissao;
    }

    public NFSeSefinNacionalInfNFSe setTipoEmissao(NFSeSefinNacionalInfNFSeTipoEmissao tipoEmissao) {
        this.tipoEmissao = tipoEmissao;
        return this;
    }

    public NFSeSefinNacionalInfNFSeProcessoEmissao getProcessoEmissao() {
        return processoEmissao;
    }

    public NFSeSefinNacionalInfNFSe setProcessoEmissao(NFSeSefinNacionalInfNFSeProcessoEmissao processoEmissao) {
        this.processoEmissao = processoEmissao;
        return this;
    }

    public String getCodigoStatus() {
        return codigoStatus;
    }

    public NFSeSefinNacionalInfNFSe setCodigoStatus(String codigoStatus) {
        this.codigoStatus = codigoStatus;
        return this;
    }

    public ZonedDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public NFSeSefinNacionalInfNFSe setDataHoraProcessamento(ZonedDateTime value) {
        this.dataHoraProcessamento = value;
        return this;
    }

    public String getNumeroDFSe() {
        return numeroDFSe;
    }

    public NFSeSefinNacionalInfNFSe setNumeroDFSe(String numeroDFSe) {
        this.numeroDFSe = numeroDFSe;
        return this;
    }

    /**
     * @return Informações de uso da Administração Tributária Municipal
     */
    public String getInformacoesUsoAdministracaoTributaria() {
        return informacoesUsoAdministracaoTributaria;
    }

    /**
     * @param value Informações de uso da Administração Tributária Municipal
     */
    public NFSeSefinNacionalInfNFSe setInformacoesUsoAdministracaoTributaria(String value) {
        this.informacoesUsoAdministracaoTributaria = value;
        return this;
    }

    public NFSeSefinNacionalEmitente getEmitente() {
        return emitente;
    }

    public NFSeSefinNacionalInfNFSe setEmitente(NFSeSefinNacionalEmitente emitente) {
        this.emitente = emitente;
        return this;
    }

    public NFSeSefinNacionalValoresNFSe getValores() {
        return valores;
    }

    public NFSeSefinNacionalInfNFSe setValores(NFSeSefinNacionalValoresNFSe value) {
        this.valores = value;
        return this;
    }

    public NFSeSefinNacionalInfNFSeIBSCBS getIbsCbs() {
        return ibsCbs;
    }

    public NFSeSefinNacionalInfNFSe setIbsCbs(NFSeSefinNacionalInfNFSeIBSCBS ibsCbs) {
        this.ibsCbs = ibsCbs;
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
