package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

public class NFSeSCSaoJoseNFSeListaItem {
    @Element(name = "tributa_municipio_prestador")
    private Boolean tributaMunicipioPrestador;

    @Element(name = "tributa_municipio_tomador", required = false)
    private Boolean tributaMunicipioTomador;

    @Element(name = "codigo_local_prestacao_servico")
    private String codigoLocalPrestacaoServico;

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

    @Element(name = "valor_desconto_incondicional", required = false)
    private BigDecimal valorDescontoIncondicional;

    @Element(name = "valor_issrf", required = false)
    private BigDecimal valorISSRF;

    @Element(name = "cno", required = false)
    private String cno;

    @Path(value="profissionais")
    @ElementList(inline = true, entry = "profissional", required = false)
    private List<NFSeSCSaoJoseNFSeItensListaProfissional> profissionais;

    public Boolean isTributaMunicipioPrestador() {
        return tributaMunicipioPrestador;
    }

    public NFSeSCSaoJoseNFSeListaItem setTributaMunicipioPrestador(Boolean tributaMunicipioPrestador) {
        this.tributaMunicipioPrestador = tributaMunicipioPrestador;
        return this;
    }

    public String getCodigoLocalPrestacaoServico() {
        return codigoLocalPrestacaoServico;
    }

    public NFSeSCSaoJoseNFSeListaItem setCodigoLocalPrestacaoServico(String codigoLocalPrestacaoServico) {
        this.codigoLocalPrestacaoServico = codigoLocalPrestacaoServico;
        return this;
    }

    public String getUnidadeCodigo() {
        return unidadeCodigo;
    }

    public NFSeSCSaoJoseNFSeListaItem setUnidadeCodigo(String unidadeCodigo) {
        this.unidadeCodigo = unidadeCodigo;
        return this;
    }

    public BigDecimal getUnidadeQuantidade() {
        return unidadeQuantidade;
    }

    public NFSeSCSaoJoseNFSeListaItem setUnidadeQuantidade(BigDecimal unidadeQuantidade) {
        this.unidadeQuantidade = unidadeQuantidade;
        return this;
    }

    public BigDecimal getUnidadeValorUnitario() {
        return unidadeValorUnitario;
    }

    public NFSeSCSaoJoseNFSeListaItem setUnidadeValorUnitario(BigDecimal unidadeValorUnitario) {
        this.unidadeValorUnitario = unidadeValorUnitario;
        return this;
    }

    public String getCodigoItemListaServico() {
        return codigoItemListaServico;
    }

    public NFSeSCSaoJoseNFSeListaItem setCodigoItemListaServico(String codigoItemListaServico) {
        this.codigoItemListaServico = codigoItemListaServico;
        return this;
    }

    public String getCodigoAtividade() {
        return codigoAtividade;
    }

    public NFSeSCSaoJoseNFSeListaItem setCodigoAtividade(String codigoAtividade) {
        this.codigoAtividade = codigoAtividade;
        return this;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public NFSeSCSaoJoseNFSeListaItem setDescritivo(String descritivo) {
        this.descritivo = descritivo;
        return this;
    }

    public BigDecimal getAliquotaItemListaServico() {
        return aliquotaItemListaServico;
    }

    public NFSeSCSaoJoseNFSeListaItem setAliquotaItemListaServico(BigDecimal aliquotaItemListaServico) {
        this.aliquotaItemListaServico = aliquotaItemListaServico;
        return this;
    }

    public String getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public NFSeSCSaoJoseNFSeListaItem setSituacaoTributaria(String situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
        return this;
    }

    public BigDecimal getValorTributavel() {
        return valorTributavel;
    }

    public NFSeSCSaoJoseNFSeListaItem setValorTributavel(BigDecimal valorTributavel) {
        this.valorTributavel = valorTributavel;
        return this;
    }

    public BigDecimal getValorDeducao() {
        return valorDeducao;
    }

    public NFSeSCSaoJoseNFSeListaItem setValorDeducao(BigDecimal valorDeducao) {
        this.valorDeducao = valorDeducao;
        return this;
    }

    public BigDecimal getValorISSRF() {
        return valorISSRF;
    }

    public NFSeSCSaoJoseNFSeListaItem setValorISSRF(BigDecimal valorISSRF) {
        this.valorISSRF = valorISSRF;
        return this;
    }

    public String getCno() {
        return cno;
    }

    public NFSeSCSaoJoseNFSeListaItem setCno(String cno) {
        this.cno = cno;
        return this;
    }

    public List<NFSeSCSaoJoseNFSeItensListaProfissional> getProfissionais() {
        return profissionais;
    }

    public NFSeSCSaoJoseNFSeListaItem setProfissionais(List<NFSeSCSaoJoseNFSeItensListaProfissional> profissionais) {
        this.profissionais = profissionais;
        return this;
    }

    public Boolean getTributaMunicipioPrestador() {
        return tributaMunicipioPrestador;
    }

    public Boolean getTributaMunicipioTomador() {
        return tributaMunicipioTomador;
    }

    public NFSeSCSaoJoseNFSeListaItem setTributaMunicipioTomador(Boolean tributaMunicipioTomador) {
        this.tributaMunicipioTomador = tributaMunicipioTomador;
        return this;
    }

    public BigDecimal getValorDescontoIncondicional() {
        return valorDescontoIncondicional;
    }

    public NFSeSCSaoJoseNFSeListaItem setValorDescontoIncondicional(BigDecimal valorDescontoIincondicional) {
        this.valorDescontoIncondicional = valorDescontoIincondicional;
        return this;
    }

    public String toXml() throws Exception {
        final var registryMatcher = new NFSeRegistryMatcher();
        registryMatcher.bind(boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(Boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());

        NFSePersister serializer = new NFSePersister(true, registryMatcher);
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
