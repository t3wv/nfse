
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "EnderecoSimples")
public class NFSeSefinNacionalEnderecoSimples {

    @Element(name="CEP")
    protected String cep;
    @Element(name="endExt")
    protected NFSeSefinNacionalEnderExtSimples enderecoExterior;
    @Element(name="xLgr")
    protected String logradouro;
    @Element(name="nro")
    protected String numero;
    @Element(name="xCpl", required = false)
    protected String complemento;
    @Element(name="xBairro")
    protected String bairro;

    /**
     * CEP do endereço
     * @return CEP do endereço
     */
    public String getCEP() {
        return cep;
    }

    /**
     * Define o CEP do endereço
     * @param value CEP do endereço
     */
    public NFSeSefinNacionalEnderecoSimples setCEP(String value) {
        this.cep = value;
        return this;
    }

    /**
     * Endereço no exterior
     * @return Endereço no exterior
     */
    public NFSeSefinNacionalEnderExtSimples getEnderecoExterior() {
        return enderecoExterior;
    }

    /**
     * Define o endereço no exterior
     * @param value Endereço no exterior
     */
    public NFSeSefinNacionalEnderecoSimples setEnderecoExterior(NFSeSefinNacionalEnderExtSimples value) {
        this.enderecoExterior = value;
        return this;
    }

    /**
     * Logradouro
     * @return Logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Define o logradouro
     * @param logradouro Logradouro
     */
    public NFSeSefinNacionalEnderecoSimples setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    /**
     * Número
     * @return Número
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o número
     * @param numero Número
     */
    public NFSeSefinNacionalEnderecoSimples setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    /**
     * Complemento
     * @return Complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o complemento
     * @param complemento Complemento
     */
    public NFSeSefinNacionalEnderecoSimples setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    /**
     * Bairro
     * @return Bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o bairro
     * @param bairro Bairro
     */
    public NFSeSefinNacionalEnderecoSimples setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }
}
