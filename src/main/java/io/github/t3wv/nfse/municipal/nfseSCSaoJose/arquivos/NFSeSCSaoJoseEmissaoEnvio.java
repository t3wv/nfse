package io.github.t3wv.nfse.municipal.nfseSCSaoJose.arquivos;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes.*;
import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Root(name = "nfse")
public class NFSeSCSaoJoseEmissaoEnvio {

    @Element(name = "nfse_teste", required = false)
    private Boolean teste;

    @Element(name = "identificador", required = false)
    private String identificador;

    @Element(name = "rps", required = false)
    private NFSeSCSaoJoseNFSeRPS rps;

    @Element(name = "pedagio", required = false)
    private NFSeSCSaoJoseNFSePedagio pedagio;

    @Element(name = "nf")
    private NFSeSCSaoJoseNFSeEmissao nf;

    @Element(name = "prestador")
    private NFSeSCSaoJoseNFSePrestador prestador;

    @Element(name = "tomador")
    private NFSeSCSaoJoseNFSeTomador tomador;

    @Path(value="itens")
    @ElementList(inline = true, entry = "lista", required = false)
    private List<NFSeSCSaoJoseNFSeListaItem> itens;

    @Element(name = "IBSCBS", required = false)
    private NFSeSCSaoJoseNFSeIBSCBS IBSCBS;

    @ElementList(name = "genericos", inline = true, entry = "linha", required = false)
    private List<NFSeSCSaoJoseNFSeGenericosLinha> genericos;

    @Element(name = "produtos", required = false)
    private NFSeSCSaoJoseNFSeProdutos produtos;

    @Element(name = "forma_pagamento", required = false)
    private NFSeSCSaoJoseNFSeFormaPagamento formaPagamento;

    public boolean isTeste() {
        return teste;
    }

    public NFSeSCSaoJoseEmissaoEnvio setTeste(boolean teste) {
        this.teste = teste;
        return this;
    }

    public String getIdentificador() {
        return identificador;
    }

    public NFSeSCSaoJoseEmissaoEnvio setIdentificador(String identificador) {
        this.identificador = identificador;
        return this;
    }

    public NFSeSCSaoJoseNFSeRPS getRps() {
        return rps;
    }

    public NFSeSCSaoJoseEmissaoEnvio setRps(NFSeSCSaoJoseNFSeRPS rps) {
        this.rps = rps;
        return this;
    }

    public NFSeSCSaoJoseNFSePedagio getPedagio() {
        return pedagio;
    }

    public NFSeSCSaoJoseEmissaoEnvio setPedagio(NFSeSCSaoJoseNFSePedagio pedagio) {
        this.pedagio = pedagio;
        return this;
    }

    public NFSeSCSaoJoseNFSeEmissao getNf() {
        return nf;
    }

    public NFSeSCSaoJoseEmissaoEnvio setNf(NFSeSCSaoJoseNFSeEmissao nf) {
        this.nf = nf;
        return this;
    }

    public NFSeSCSaoJoseNFSePrestador getPrestador() {
        return prestador;
    }

    public NFSeSCSaoJoseEmissaoEnvio setPrestador(NFSeSCSaoJoseNFSePrestador prestador) {
        this.prestador = prestador;
        return this;
    }

    public NFSeSCSaoJoseNFSeTomador getTomador() {
        return tomador;
    }

    public NFSeSCSaoJoseEmissaoEnvio setTomador(NFSeSCSaoJoseNFSeTomador tomador) {
        this.tomador = tomador;
        return this;
    }

    public List<NFSeSCSaoJoseNFSeListaItem> getItens() {
        return itens;
    }

    public NFSeSCSaoJoseEmissaoEnvio setItens(List<NFSeSCSaoJoseNFSeListaItem> itens) {
        this.itens = itens;
        return this;
    }

    public NFSeSCSaoJoseEmissaoEnvio addItem(NFSeSCSaoJoseNFSeListaItem item) {
        if (this.itens == null){
            this.itens = new ArrayList<>();
        }
        this.itens.add(item);
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBS getIBSCBS() {
        return IBSCBS;
    }

    public NFSeSCSaoJoseEmissaoEnvio setIBSCBS(NFSeSCSaoJoseNFSeIBSCBS IBSCBS) {
        this.IBSCBS = IBSCBS;
        return this;
    }

    public List<NFSeSCSaoJoseNFSeGenericosLinha> getGenericos() {
        return genericos;
    }

    public NFSeSCSaoJoseEmissaoEnvio setGenericos(List<NFSeSCSaoJoseNFSeGenericosLinha> genericos) {
        this.genericos = genericos;
        return this;
    }

    public NFSeSCSaoJoseNFSeProdutos getProdutos() {
        return produtos;
    }

    public NFSeSCSaoJoseEmissaoEnvio setProdutos(NFSeSCSaoJoseNFSeProdutos produtos) {
        this.produtos = produtos;
        return this;
    }

    public NFSeSCSaoJoseNFSeFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public NFSeSCSaoJoseEmissaoEnvio setFormaPagamento(NFSeSCSaoJoseNFSeFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
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
