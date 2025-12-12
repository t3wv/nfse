package io.github.t3wv.municipal.nfseSCSaoJose;

import io.github.t3wv.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.transformers.NFSeBooleanTransformer;
import io.github.t3wv.transformers.NFSeRegistryMatcher;
import io.github.t3wv.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.StringWriter;
import java.math.BigDecimal;

@Root(name = "nfse")
public class NFSeSCSaoJoseNFSe {

    @Element(name = "nfse_teste")
    private boolean teste;

    @Element(name = "identificador", required = false)
    private String identificador;

    @Element(name = "rps", required = false)
    private NFSeSCSaoJoseNFSeRPS rps;

    @Element(name = "pedagio", required = false)
    private NFSeSCSaoJoseNFSePedagio pedagio;

    @Element(name = "nf", required = false)
    private NFSeSCSaoJoseNFSeNF nf;

    @Element(name = "prestador")
    private NFSeSCSaoJoseNFSePrestador prestador;

    @Element(name = "tomador")
    private NFSeSCSaoJoseNFSeTomador tomador;

    @Element(name = "itens")
    private NFSeSCSaoJoseNFSeItens itens;

    @Element(name = "IBSCBS", required = false)
    private NFSeSCSaoJoseNFSeIBSCBS IBSCBS;

    @Element(name = "genericos", required = false)
    private NFSeSCSaoJoseNFSeGenericos genericos;

    @Element(name = "produtos", required = false)
    private NFSeSCSaoJoseNFSeProdutos produtos;

    @Element(name = "forma_pagamento", required = false)
    private NFSeSCSaoJoseNFSeFormaPagamento formaPagamento;

    public boolean isTeste() {
        return teste;
    }

    public NFSeSCSaoJoseNFSe setTeste(boolean teste) {
        this.teste = teste;
        return this;
    }

    public String getIdentificador() {
        return identificador;
    }

    public NFSeSCSaoJoseNFSe setIdentificador(String identificador) {
        this.identificador = identificador;
        return this;
    }

    public NFSeSCSaoJoseNFSeRPS getRps() {
        return rps;
    }

    public NFSeSCSaoJoseNFSe setRps(NFSeSCSaoJoseNFSeRPS rps) {
        this.rps = rps;
        return this;
    }

    public NFSeSCSaoJoseNFSePedagio getPedagio() {
        return pedagio;
    }

    public NFSeSCSaoJoseNFSe setPedagio(NFSeSCSaoJoseNFSePedagio pedagio) {
        this.pedagio = pedagio;
        return this;
    }

    public NFSeSCSaoJoseNFSeNF getNf() {
        return nf;
    }

    public NFSeSCSaoJoseNFSe setNf(NFSeSCSaoJoseNFSeNF nf) {
        this.nf = nf;
        return this;
    }

    public NFSeSCSaoJoseNFSePrestador getPrestador() {
        return prestador;
    }

    public NFSeSCSaoJoseNFSe setPrestador(NFSeSCSaoJoseNFSePrestador prestador) {
        this.prestador = prestador;
        return this;
    }

    public NFSeSCSaoJoseNFSeTomador getTomador() {
        return tomador;
    }

    public NFSeSCSaoJoseNFSe setTomador(NFSeSCSaoJoseNFSeTomador tomador) {
        this.tomador = tomador;
        return this;
    }

    public NFSeSCSaoJoseNFSeItens getItens() {
        return itens;
    }

    public NFSeSCSaoJoseNFSe setItens(NFSeSCSaoJoseNFSeItens itens) {
        this.itens = itens;
        return this;
    }

    public NFSeSCSaoJoseNFSeIBSCBS getIBSCBS() {
        return IBSCBS;
    }

    public NFSeSCSaoJoseNFSe setIBSCBS(NFSeSCSaoJoseNFSeIBSCBS IBSCBS) {
        this.IBSCBS = IBSCBS;
        return this;
    }

    public NFSeSCSaoJoseNFSeGenericos getGenericos() {
        return genericos;
    }

    public NFSeSCSaoJoseNFSe setGenericos(NFSeSCSaoJoseNFSeGenericos genericos) {
        this.genericos = genericos;
        return this;
    }

    public NFSeSCSaoJoseNFSeProdutos getProdutos() {
        return produtos;
    }

    public NFSeSCSaoJoseNFSe setProdutos(NFSeSCSaoJoseNFSeProdutos produtos) {
        this.produtos = produtos;
        return this;
    }

    public NFSeSCSaoJoseNFSeFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public NFSeSCSaoJoseNFSe setFormaPagamento(NFSeSCSaoJoseNFSeFormaPagamento formaPagamento) {
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
