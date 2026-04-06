
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "endExt")
public class NFSeSefinNacionalEnderExtSimples {

    @Element(name="cEndPost")
    protected String codigoPostal;
    @Element(name="xCidade")
    protected String cidade;
    @Element(name="xEstProvReg")
    protected String estadoProvinciaRegiao;

    /**
     * @return Código alfanumérico do Endereçamento Postal no exterior do prestador do serviço.
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Define o Código alfanumérico do Endereçamento Postal no exterior do prestador do serviço.
     * @param value Código alfanumérico do Endereçamento Postal no exterior do prestador do serviço.
     */
    public NFSeSefinNacionalEnderExtSimples setCodigoPostal(String value) {
        this.codigoPostal = value;
        return this;
    }

    /**
     * Retorna a cidade
     * @return Cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define a cidade
     * @param value Cidade
     */
    public NFSeSefinNacionalEnderExtSimples setCidade(String value) {
        this.cidade = value;
        return this;
    }

    /**
     * Retorna o estado, província ou região
     * @return Estado, província ou região
     */
    public String getEstadoProvinciaRegiao() {
        return estadoProvinciaRegiao;
    }

    /**
     * Define o estado, província ou região
     * @param value Estado, província ou região
     */
    public NFSeSefinNacionalEnderExtSimples setEstadoProvinciaRegiao(String value) {
        this.estadoProvinciaRegiao = value;
        return this;
    }

}
