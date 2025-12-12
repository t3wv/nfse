package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

public class NFSeSCSaoJoseNFSeItensLista {
    @Element(name = "tributa_municipio_prestador")
    private boolean tributaMunicipioPrestador;

    @Element(name = "codigo_local_prestacao_servico")
    private String codigoLocalPrestacaoServico;

    @Element(name = "codigo_nbs", required = false)
    private String codigoNBS;

    @Element(name = "unidade_codigo", required = false)
    private String unidadeCodigo;

    @Element(name = "unidade_quantidade", required = false)
    private BigDecimal unidadeQuantidade;

    @Element(name = "unidade_valor_unitario", required = false)
    private BigDecimal unidadeValorUnitario;

    @Element(name = "codigo_item_lista_servico")
    private String codigoItemListaServico;

    @Element(name = "codigo_atividade", required = false)
    private String codigoAtividade;

    @Element(name = "descritivo")
    private String descritivo;

    @Element(name = "aliquota_item_lista_servico")
    private BigDecimal aliquotaItemListaServico;

    @Element(name = "situacao_tributaria")
    private String situacaoTributaria;

    @Element(name = "valor_tributavel")
    private BigDecimal valorTributavel;

    @Element(name = "valor_deducao", required = false)
    private BigDecimal valorDeducao;

    @Element(name = "valor_issrf", required = false)
    private BigDecimal valorISSRF;

    @Element(name = "cno", required = false)
    private String cno;

    @ElementList(name = "profissionais", inline = true, required = false)
    private List<NFSeSCSaoJoseNFSeItensListaProfissional> profissionais;

    public boolean isTributaMunicipioPrestador() {
        return tributaMunicipioPrestador;
    }

    public NFSeSCSaoJoseNFSeItensLista setTributaMunicipioPrestador(boolean tributaMunicipioPrestador) {
        this.tributaMunicipioPrestador = tributaMunicipioPrestador;
        return this;
    }

    public String getCodigoLocalPrestacaoServico() {
        return codigoLocalPrestacaoServico;
    }

    public NFSeSCSaoJoseNFSeItensLista setCodigoLocalPrestacaoServico(String codigoLocalPrestacaoServico) {
        this.codigoLocalPrestacaoServico = codigoLocalPrestacaoServico;
        return this;
    }

    public String getCodigoNBS() {
        return codigoNBS;
    }

    public NFSeSCSaoJoseNFSeItensLista setCodigoNBS(String codigoNBS) {
        this.codigoNBS = codigoNBS;
        return this;
    }

    public String getUnidadeCodigo() {
        return unidadeCodigo;
    }

    public NFSeSCSaoJoseNFSeItensLista setUnidadeCodigo(String unidadeCodigo) {
        this.unidadeCodigo = unidadeCodigo;
        return this;
    }

    public BigDecimal getUnidadeQuantidade() {
        return unidadeQuantidade;
    }

    public NFSeSCSaoJoseNFSeItensLista setUnidadeQuantidade(BigDecimal unidadeQuantidade) {
        this.unidadeQuantidade = unidadeQuantidade;
        return this;
    }

    public BigDecimal getUnidadeValorUnitario() {
        return unidadeValorUnitario;
    }

    public NFSeSCSaoJoseNFSeItensLista setUnidadeValorUnitario(BigDecimal unidadeValorUnitario) {
        this.unidadeValorUnitario = unidadeValorUnitario;
        return this;
    }

    public String getCodigoItemListaServico() {
        return codigoItemListaServico;
    }

    public NFSeSCSaoJoseNFSeItensLista setCodigoItemListaServico(String codigoItemListaServico) {
        this.codigoItemListaServico = codigoItemListaServico;
        return this;
    }

    public String getCodigoAtividade() {
        return codigoAtividade;
    }

    public NFSeSCSaoJoseNFSeItensLista setCodigoAtividade(String codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
        return this;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public NFSeSCSaoJoseNFSeItensLista setDescritivo(String descritivo) {
        this.descritivo = descritivo;
        return this;
    }

    public BigDecimal getAliquotaItemListaServico() {
        return aliquotaItemListaServico;
    }

    public NFSeSCSaoJoseNFSeItensLista setAliquotaItemListaServico(BigDecimal aliquotaItemListaServico) {
        this.aliquotaItemListaServico = aliquotaItemListaServico;
        return this;
    }

    public String getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public NFSeSCSaoJoseNFSeItensLista setSituacaoTributaria(String situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
        return this;
    }

    public BigDecimal getValorTributavel() {
        return valorTributavel;
    }

    public NFSeSCSaoJoseNFSeItensLista setValorTributavel(BigDecimal valorTributavel) {
        this.valorTributavel = valorTributavel;
        return this;
    }

    public BigDecimal getValorDeducao() {
        return valorDeducao;
    }

    public NFSeSCSaoJoseNFSeItensLista setValorDeducao(BigDecimal valorDeducao) {
        this.valorDeducao = valorDeducao;
        return this;
    }

    public BigDecimal getValorISSRF() {
        return valorISSRF;
    }

    public NFSeSCSaoJoseNFSeItensLista setValorISSRF(BigDecimal valorISSRF) {
        this.valorISSRF = valorISSRF;
        return this;
    }

    public String getCno() {
        return cno;
    }

    public NFSeSCSaoJoseNFSeItensLista setCno(String cno) {
        this.cno = cno;
        return this;
    }

    public List<NFSeSCSaoJoseNFSeItensListaProfissional> getProfissionais() {
        return profissionais;
    }

    public NFSeSCSaoJoseNFSeItensLista setProfissionais(List<NFSeSCSaoJoseNFSeItensListaProfissional> profissionais) {
        this.profissionais = profissionais;
        return this;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
