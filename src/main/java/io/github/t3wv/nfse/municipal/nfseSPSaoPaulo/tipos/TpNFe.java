package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Root(name = "NFe")
public class TpNFe {

    @Element(name = "Assinatura", required = false)
    protected String assinatura;
    @Element(name = "ChaveNFe")
    protected TpChaveNFe chaveNFe;
    @Element(name = "DataEmissaoNFe")
    protected LocalDateTime dataEmissaoNFe;
    @Element(name = "NumeroLote", required = false)
    protected Long numeroLote;
    @Element(name = "ChaveRPS", required = false)
    protected TpChaveRPS chaveRPS;
    @Element(name = "TipoRPS", required = false)
    protected TpTipoRPS tipoRPS;
    @Element(name = "DataEmissaoRPS", required = false)
    protected LocalDate dataEmissaoRPS;
    @Element(name = "DataFatoGeradorNFe")
    protected LocalDateTime dataFatoGeradorNFe;
    @Element(name = "CPFCNPJPrestador")
    protected TpCPFCNPJ cPFCNPJPrestador;
    @Element(name = "RazaoSocialPrestador")
    protected String razaoSocialPrestador;
    @Element(name = "EnderecoPrestador")
    protected TpEndereco enderecoPrestador;
    @Element(name = "EmailPrestador", required = false)
    protected String emailPrestador;
    @Element(name = "StatusNFe")
    protected TpStatusNFe statusNFe;
    @Element(name = "DataCancelamento", required = false)
    protected LocalDateTime dataCancelamento;
    @Element(name = "TributacaoNFe")
    protected String TributacaoNFe;
    @Element(name = "OpcaoSimples")
    protected TpOpcaoSimplesNFe opcaoSimplesNFe;
    @Element(name = "NumeroGuia", required = false)
    protected Long numeroGuia;
    @Element(name = "DataQuitacaoGuia", required = false)
    protected LocalDate dataQuitacaoGuia;
    @Element(name="ValorServicos")
    protected BigDecimal valorServicos;
    @Element(name="ValorDeducoes", required = false)
    protected BigDecimal valorDeducoes;
    @Element(name="ValorPIS", required = false)
    protected BigDecimal valorPIS;
    @Element(name="ValorCOFINS", required = false)
    protected BigDecimal valorCOFINS;
    @Element(name="ValorINSS", required = false)
    protected BigDecimal valorINSS;
    @Element(name="ValorIR", required = false)
    protected BigDecimal valorIR;
    @Element(name="ValorCSLL", required = false)
    protected BigDecimal valorCSLL;
    @Element(name = "CodigoServico")
    protected String codigoServico;
    @Element(name = "AliquotaServicos")
    protected BigDecimal aliquotaServicos;
    @Element(name="ValorISS")
    protected BigDecimal valorISS;
    @Element(name="ValorCredito")
    protected BigDecimal valorCredito;
    @Element(name = "ISSRetido")
    protected boolean issRetido;
    @Element(name = "CPFCNPJTomador", required = false)
    protected TpCPFCNPJNIF cpfcnpjTomador;
    @Element(name = "InscricaoMunicipalTomador", required = false)
    protected Long inscricaoMunicipalTomador;
    @Element(name = "InscricaoEstadualTomador", required = false)
    protected Long inscricaoEstadualTomador;
    @Element(name = "RazaoSocialTomador", required = false)
    protected String razaoSocialTomador;
    @Element(name = "EnderecoTomador", required = false)
    protected TpEndereco enderecoTomador;
    @Element(name = "EmailTomador", required = false)
    protected String emailTomador;
    @Element(name = "CPFCNPJIntermediario", required = false)
    protected TpCPFCNPJ cpfcnpjIntermediario;
    @Element(name = "InscricaoMunicipalIntermediario", required = false)
    protected Long inscricaoMunicipalIntermediario;
    @Element(name = "ISSRetidoIntermediario", required = false)
    protected String issRetidoIntermediario;
    @Element(name = "EmailIntermediario", required = false)
    protected String emailIntermediario;
    @Element(name = "Discriminacao")
    protected String discriminacao;
    @Element(name = "ValorCargaTributaria", required = false)
    protected BigDecimal valorCargaTributaria;
    @Element(name = "PercentualCargaTributaria", required = false)
    protected BigDecimal percentualCargaTributaria;
    @Element(name = "FonteCargaTributaria", required = false)
    protected String fonteCargaTributaria;
    @Element(name = "CodigoCEI", required = false)
    protected Long codigoCEI;
    @Element(name = "MatriculaObra", required = false)
    protected Long matriculaObra;
    @Element(name = "MunicipioPrestacao", required = false)
    protected Integer municipioPrestacao;
    @Element(name = "NumeroEncapsulamento", required = false)
    protected Long numeroEncapsulamento;
    @Element(name = "ValorTotalRecebido", required = false)
    protected BigDecimal valorTotalRecebido;
    @Element(name = "ValorInicialCobrado", required = false)
    protected BigDecimal valorInicialCobrado;
    @Element(name = "ValorFinalCobrado", required = false)
    protected BigDecimal valorFinalCobrado;
    @Element(name = "ValorMulta", required = false)
    protected BigDecimal valorMulta;
    @Element(name = "ValorJuros", required = false)
    protected BigDecimal valorJuros;
    @Element(name = "ValorIPI", required = false)
    protected BigDecimal valorIPI;
    @Element(name = "ExigibilidadeSuspensa", required = false)
    protected Integer exigibilidadeSuspensa;
    @Element(name = "PagamentoParceladoAntecipado", required = false)
    protected Integer pagamentoParceladoAntecipado;
    @Element(name = "NCM", required = false)
    protected String ncm;
    @Element(name = "NBS", required = false)
    protected String nbs;
    @Element(name = "atvEvento", required = false)
    protected TpAtividadeEvento atvEvento;
    @Element(name = "cLocPrestacao", required = false)
    protected String cLocPrestacao;
    @Element(name = "cPaisPrestacao", required = false)
    protected String cPaisPrestacao;
    @Element(name = "IBSCBS", required = false)
    protected TpIBSCBS ibscbs;
    @Element(name = "RetornoComplementarIBSCBS", required = false)
    protected TpRetornoComplementarIBSCBS retornoComplementarIBSCBS;

    public String getAssinatura() {
        return assinatura;
    }

    public TpNFe setAssinatura(String assinatura) {
        this.assinatura = assinatura;
        return this;
    }

    public TpChaveNFe getChaveNFe() {
        return chaveNFe;
    }

    public TpNFe setChaveNFe(TpChaveNFe chaveNFe) {
        this.chaveNFe = chaveNFe;
        return this;
    }

    public LocalDateTime getDataEmissaoNFe() {
        return dataEmissaoNFe;
    }

    public TpNFe setDataEmissaoNFe(LocalDateTime dataEmissaoNFe) {
        this.dataEmissaoNFe = dataEmissaoNFe;
        return this;
    }

    public Long getNumeroLote() {
        return numeroLote;
    }

    public TpNFe setNumeroLote(Long numeroLote) {
        this.numeroLote = numeroLote;
        return this;
    }

    public TpChaveRPS getChaveRPS() {
        return chaveRPS;
    }

    public TpNFe setChaveRPS(TpChaveRPS chaveRPS) {
        this.chaveRPS = chaveRPS;
        return this;
    }

    public TpTipoRPS getTipoRPS() {
        return tipoRPS;
    }

    public TpNFe setTipoRPS(TpTipoRPS tipoRPS) {
        this.tipoRPS = tipoRPS;
        return this;
    }

    public LocalDate getDataEmissaoRPS() {
        return dataEmissaoRPS;
    }

    public TpNFe setDataEmissaoRPS(LocalDate dataEmissaoRPS) {
        this.dataEmissaoRPS = dataEmissaoRPS;
        return this;
    }

    public LocalDateTime getDataFatoGeradorNFe() {
        return dataFatoGeradorNFe;
    }

    public TpNFe setDataFatoGeradorNFe(LocalDateTime dataFatoGeradorNFe) {
        this.dataFatoGeradorNFe = dataFatoGeradorNFe;
        return this;
    }

    public TpCPFCNPJ getcPFCNPJPrestador() {
        return cPFCNPJPrestador;
    }

    public TpNFe setcPFCNPJPrestador(TpCPFCNPJ cPFCNPJPrestador) {
        this.cPFCNPJPrestador = cPFCNPJPrestador;
        return this;
    }

    public String getRazaoSocialPrestador() {
        return razaoSocialPrestador;
    }

    public TpNFe setRazaoSocialPrestador(String razaoSocialPrestador) {
        this.razaoSocialPrestador = razaoSocialPrestador;
        return this;
    }

    public TpEndereco getEnderecoPrestador() {
        return enderecoPrestador;
    }

    public TpNFe setEnderecoPrestador(TpEndereco enderecoPrestador) {
        this.enderecoPrestador = enderecoPrestador;
        return this;
    }

    public String getEmailPrestador() {
        return emailPrestador;
    }

    public TpNFe setEmailPrestador(String emailPrestador) {
        this.emailPrestador = emailPrestador;
        return this;
    }

    public TpStatusNFe getStatusNFe() {
        return statusNFe;
    }

    public TpNFe setStatusNFe(TpStatusNFe statusNFe) {
        this.statusNFe = statusNFe;
        return this;
    }

    public LocalDateTime getDataCancelamento() {
        return dataCancelamento;
    }

    public TpNFe setDataCancelamento(LocalDateTime dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
        return this;
    }

    public String getTributacaoNFe() {
        return TributacaoNFe;
    }

    public TpNFe setTributacaoNFe(String tributacaoNFe) {
        TributacaoNFe = tributacaoNFe;
        return this;
    }

    public TpOpcaoSimplesNFe getOpcaoSimplesNFe() {
        return opcaoSimplesNFe;
    }

    public Long getNumeroGuia() {
        return numeroGuia;
    }

    public TpNFe setNumeroGuia(Long numeroGuia) {
        this.numeroGuia = numeroGuia;
        return this;
    }

    public LocalDate getDataQuitacaoGuia() {
        return dataQuitacaoGuia;
    }

    public TpNFe setDataQuitacaoGuia(LocalDate dataQuitacaoGuia) {
        this.dataQuitacaoGuia = dataQuitacaoGuia;
        return this;
    }

    public BigDecimal getValorServicos() {
        return valorServicos;
    }

    public TpNFe setValorServicos(BigDecimal valorServicos) {
        this.valorServicos = valorServicos;
        return this;
    }

    public BigDecimal getValorDeducoes() {
        return valorDeducoes;
    }

    public TpNFe setValorDeducoes(BigDecimal valorDeducoes) {
        this.valorDeducoes = valorDeducoes;
        return this;
    }

    public BigDecimal getValorPIS() {
        return valorPIS;
    }

    public TpNFe setValorPIS(BigDecimal valorPIS) {
        this.valorPIS = valorPIS;
        return this;
    }

    public BigDecimal getValorCOFINS() {
        return valorCOFINS;
    }

    public TpNFe setValorCOFINS(BigDecimal valorCOFINS) {
        this.valorCOFINS = valorCOFINS;
        return this;
    }

    public BigDecimal getValorINSS() {
        return valorINSS;
    }

    public TpNFe setValorINSS(BigDecimal valorINSS) {
        this.valorINSS = valorINSS;
        return this;
    }

    public BigDecimal getValorIR() {
        return valorIR;
    }

    public TpNFe setValorIR(BigDecimal valorIR) {
        this.valorIR = valorIR;
        return this;
    }

    public BigDecimal getValorCSLL() {
        return valorCSLL;
    }

    public TpNFe setValorCSLL(BigDecimal valorCSLL) {
        this.valorCSLL = valorCSLL;
        return this;
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public TpNFe setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico;
        return this;
    }

    public BigDecimal getAliquotaServicos() {
        return aliquotaServicos;
    }

    public TpNFe setAliquotaServicos(BigDecimal aliquotaServicos) {
        this.aliquotaServicos = aliquotaServicos;
        return this;
    }

    public BigDecimal getValorISS() {
        return valorISS;
    }

    public TpNFe setValorISS(BigDecimal valorISS) {
        this.valorISS = valorISS;
        return this;
    }

    public BigDecimal getValorCredito() {
        return valorCredito;
    }

    public TpNFe setValorCredito(BigDecimal valorCredito) {
        this.valorCredito = valorCredito;
        return this;
    }

    public boolean isIssRetido() {
        return issRetido;
    }

    public TpNFe setIssRetido(boolean issRetido) {
        this.issRetido = issRetido;
        return this;
    }

    public TpCPFCNPJNIF getCpfcnpjTomador() {
        return cpfcnpjTomador;
    }

    public TpNFe setCpfcnpjTomador(TpCPFCNPJNIF cpfcnpjTomador) {
        this.cpfcnpjTomador = cpfcnpjTomador;
        return this;
    }

    public Long getInscricaoMunicipalTomador() {
        return inscricaoMunicipalTomador;
    }

    public TpNFe setInscricaoMunicipalTomador(Long inscricaoMunicipalTomador) {
        this.inscricaoMunicipalTomador = inscricaoMunicipalTomador;
        return this;
    }

    public Long getInscricaoEstadualTomador() {
        return inscricaoEstadualTomador;
    }

    public TpNFe setInscricaoEstadualTomador(Long inscricaoEstadualTomador) {
        this.inscricaoEstadualTomador = inscricaoEstadualTomador;
        return this;
    }

    public String getRazaoSocialTomador() {
        return razaoSocialTomador;
    }

    public TpNFe setRazaoSocialTomador(String razaoSocialTomador) {
        this.razaoSocialTomador = razaoSocialTomador;
        return this;
    }

    public TpEndereco getEnderecoTomador() {
        return enderecoTomador;
    }

    public TpNFe setEnderecoTomador(TpEndereco enderecoTomador) {
        this.enderecoTomador = enderecoTomador;
        return this;
    }

    public String getEmailTomador() {
        return emailTomador;
    }

    public TpNFe setEmailTomador(String emailTomador) {
        this.emailTomador = emailTomador;
        return this;
    }

    public TpCPFCNPJ getCpfcnpjIntermediario() {
        return cpfcnpjIntermediario;
    }

    public TpNFe setCpfcnpjIntermediario(TpCPFCNPJ cpfcnpjIntermediario) {
        this.cpfcnpjIntermediario = cpfcnpjIntermediario;
        return this;
    }

    public Long getInscricaoMunicipalIntermediario() {
        return inscricaoMunicipalIntermediario;
    }

    public TpNFe setInscricaoMunicipalIntermediario(Long inscricaoMunicipalIntermediario) {
        this.inscricaoMunicipalIntermediario = inscricaoMunicipalIntermediario;
        return this;
    }

    public String getIssRetidoIntermediario() {
        return issRetidoIntermediario;
    }

    public TpNFe setIssRetidoIntermediario(String issRetidoIntermediario) {
        this.issRetidoIntermediario = issRetidoIntermediario;
        return this;
    }

    public String getEmailIntermediario() {
        return emailIntermediario;
    }

    public TpNFe setEmailIntermediario(String emailIntermediario) {
        this.emailIntermediario = emailIntermediario;
        return this;
    }

    public String getDiscriminacao() {
        return discriminacao;
    }

    public TpNFe setDiscriminacao(String discriminacao) {
        this.discriminacao = discriminacao;
        return this;
    }

    public BigDecimal getValorCargaTributaria() {
        return valorCargaTributaria;
    }

    public TpNFe setValorCargaTributaria(BigDecimal valorCargaTributaria) {
        this.valorCargaTributaria = valorCargaTributaria;
        return this;
    }

    public BigDecimal getPercentualCargaTributaria() {
        return percentualCargaTributaria;
    }

    public TpNFe setPercentualCargaTributaria(BigDecimal percentualCargaTributaria) {
        this.percentualCargaTributaria = percentualCargaTributaria;
        return this;
    }

    public String getFonteCargaTributaria() {
        return fonteCargaTributaria;
    }

    public TpNFe setFonteCargaTributaria(String fonteCargaTributaria) {
        this.fonteCargaTributaria = fonteCargaTributaria;
        return this;
    }

    public Long getCodigoCEI() {
        return codigoCEI;
    }

    public TpNFe setCodigoCEI(Long codigoCEI) {
        this.codigoCEI = codigoCEI;
        return this;
    }

    public Long getMatriculaObra() {
        return matriculaObra;
    }

    public TpNFe setMatriculaObra(Long matriculaObra) {
        this.matriculaObra = matriculaObra;
        return this;
    }

    public Integer getMunicipioPrestacao() {
        return municipioPrestacao;
    }

    public TpNFe setMunicipioPrestacao(Integer municipioPrestacao) {
        this.municipioPrestacao = municipioPrestacao;
        return this;
    }

    public Long getNumeroEncapsulamento() {
        return numeroEncapsulamento;
    }

    public TpNFe setNumeroEncapsulamento(Long numeroEncapsulamento) {
        this.numeroEncapsulamento = numeroEncapsulamento;
        return this;
    }

    public BigDecimal getValorTotalRecebido() {
        return valorTotalRecebido;
    }

    public TpNFe setValorTotalRecebido(BigDecimal valorTotalRecebido) {
        this.valorTotalRecebido = valorTotalRecebido;
        return this;
    }

    public BigDecimal getValorInicialCobrado() {
        return valorInicialCobrado;
    }

    public TpNFe setValorInicialCobrado(BigDecimal valorInicialCobrado) {
        this.valorInicialCobrado = valorInicialCobrado;
        return this;
    }

    public BigDecimal getValorFinalCobrado() {
        return valorFinalCobrado;
    }

    public TpNFe setValorFinalCobrado(BigDecimal valorFinalCobrado) {
        this.valorFinalCobrado = valorFinalCobrado;
        return this;
    }

    public BigDecimal getValorMulta() {
        return valorMulta;
    }

    public TpNFe setValorMulta(BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
        return this;
    }

    public BigDecimal getValorJuros() {
        return valorJuros;
    }

    public TpNFe setValorJuros(BigDecimal valorJuros) {
        this.valorJuros = valorJuros;
        return this;
    }

    public BigDecimal getValorIPI() {
        return valorIPI;
    }

    public TpNFe setValorIPI(BigDecimal valorIPI) {
        this.valorIPI = valorIPI;
        return this;
    }

    public Integer getExigibilidadeSuspensa() {
        return exigibilidadeSuspensa;
    }

    public TpNFe setExigibilidadeSuspensa(Integer exigibilidadeSuspensa) {
        this.exigibilidadeSuspensa = exigibilidadeSuspensa;
        return this;
    }

    public Integer getPagamentoParceladoAntecipado() {
        return pagamentoParceladoAntecipado;
    }

    public TpNFe setPagamentoParceladoAntecipado(Integer pagamentoParceladoAntecipado) {
        this.pagamentoParceladoAntecipado = pagamentoParceladoAntecipado;
        return this;
    }

    public String getNcm() {
        return ncm;
    }

    public TpNFe setNcm(String ncm) {
        this.ncm = ncm;
        return this;
    }

    public String getNbs() {
        return nbs;
    }

    public TpNFe setNbs(String nbs) {
        this.nbs = nbs;
        return this;
    }

    public TpAtividadeEvento getAtvEvento() {
        return atvEvento;
    }

    public TpNFe setAtvEvento(TpAtividadeEvento atvEvento) {
        this.atvEvento = atvEvento;
        return this;
    }

    public String getcLocPrestacao() {
        return cLocPrestacao;
    }

    public TpNFe setcLocPrestacao(String cLocPrestacao) {
        this.cLocPrestacao = cLocPrestacao;
        return this;
    }

    public String getcPaisPrestacao() {
        return cPaisPrestacao;
    }

    public TpNFe setcPaisPrestacao(String cPaisPrestacao) {
        this.cPaisPrestacao = cPaisPrestacao;
        return this;
    }

    public TpIBSCBS getIbscbs() {
        return ibscbs;
    }

    public TpNFe setIbscbs(TpIBSCBS ibscbs) {
        this.ibscbs = ibscbs;
        return this;
    }

    public TpRetornoComplementarIBSCBS getRetornoComplementarIBSCBS() {
        return retornoComplementarIBSCBS;
    }

    public TpNFe setRetornoComplementarIBSCBS(TpRetornoComplementarIBSCBS retornoComplementarIBSCBS) {
        this.retornoComplementarIBSCBS = retornoComplementarIBSCBS;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }

    @Override
    public String toString() {
        return "TpNFe{" +
                "assinatura='" + assinatura + '\'' +
                ", chaveNFe=" + chaveNFe +
                ", dataEmissaoNFe=" + dataEmissaoNFe +
                ", numeroLote=" + numeroLote +
                ", chaveRPS=" + chaveRPS +
                ", tipoRPS=" + tipoRPS +
                ", dataEmissaoRPS=" + dataEmissaoRPS +
                ", dataFatoGeradorNFe=" + dataFatoGeradorNFe +
                ", cPFCNPJPrestador=" + cPFCNPJPrestador +
                ", razaoSocialPrestador='" + razaoSocialPrestador + '\'' +
                ", enderecoPrestador=" + enderecoPrestador +
                ", emailPrestador='" + emailPrestador + '\'' +
                ", statusNFe=" + statusNFe +
                ", dataCancelamento=" + dataCancelamento +
                ", TributacaoNFe='" + TributacaoNFe + '\'' +
                ", numeroGuia=" + numeroGuia +
                ", dataQuitacaoGuia=" + dataQuitacaoGuia +
                ", valorServicos=" + valorServicos +
                ", valorDeducoes=" + valorDeducoes +
                ", valorPIS=" + valorPIS +
                ", valorCOFINS=" + valorCOFINS +
                ", valorINSS=" + valorINSS +
                ", valorIR=" + valorIR +
                ", valorCSLL=" + valorCSLL +
                ", codigoServico='" + codigoServico + '\'' +
                ", aliquotaServicos=" + aliquotaServicos +
                ", valorISS=" + valorISS +
                ", valorCredito=" + valorCredito +
                ", issRetido=" + issRetido +
                ", cpfcnpjTomador=" + cpfcnpjTomador +
                ", inscricaoMunicipalTomador=" + inscricaoMunicipalTomador +
                ", inscricaoEstadualTomador=" + inscricaoEstadualTomador +
                ", razaoSocialTomador='" + razaoSocialTomador + '\'' +
                ", enderecoTomador=" + enderecoTomador +
                ", emailTomador='" + emailTomador + '\'' +
                ", cpfcnpjIntermediario=" + cpfcnpjIntermediario +
                ", inscricaoMunicipalIntermediario=" + inscricaoMunicipalIntermediario +
                ", issRetidoIntermediario='" + issRetidoIntermediario + '\'' +
                ", emailIntermediario='" + emailIntermediario + '\'' +
                ", discriminacao='" + discriminacao + '\'' +
                ", valorCargaTributaria=" + valorCargaTributaria +
                ", percentualCargaTributaria=" + percentualCargaTributaria +
                ", fonteCargaTributaria='" + fonteCargaTributaria + '\'' +
                ", codigoCEI=" + codigoCEI +
                ", matriculaObra=" + matriculaObra +
                ", municipioPrestacao=" + municipioPrestacao +
                ", numeroEncapsulamento=" + numeroEncapsulamento +
                ", valorTotalRecebido=" + valorTotalRecebido +
                ", valorInicialCobrado=" + valorInicialCobrado +
                ", valorFinalCobrado=" + valorFinalCobrado +
                ", valorMulta=" + valorMulta +
                ", valorJuros=" + valorJuros +
                ", valorIPI=" + valorIPI +
                ", exigibilidadeSuspensa=" + exigibilidadeSuspensa +
                ", pagamentoParceladoAntecipado=" + pagamentoParceladoAntecipado +
                ", ncm='" + ncm + '\'' +
                ", nbs='" + nbs + '\'' +
                ", atvEvento=" + atvEvento +
                ", cLocPrestacao='" + cLocPrestacao + '\'' +
                ", cPaisPrestacao='" + cPaisPrestacao + '\'' +
                ", ibscbs=" + ibscbs +
                ", retornoComplementarIBSCBS=" + retornoComplementarIBSCBS +
                '}';
    }
}
