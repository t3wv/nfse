
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.LocalDate;

/**
 * Grupo de informações do DPS relativas à Atividade do Evento
 */

@Root(name = "atvEvento")
public class NFSeSefinNacionalAtvEvento {

    @Element(name = "desc")
    protected String descricao;
    @Element(name = "dtIni")
    protected LocalDate dataInicio;
    @Element(name = "dtFim")
    protected LocalDate dataFim;
    @Element(name = "id")
    protected String id;
    @Element(name = "end")
    protected NFSeSefinNacionalEnderecoSimples endereco;

    /**
     * @return Descrição do evento Artístico, Cultural, Esportivo, etc
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Descrição do evento Artístico, Cultural, Esportivo, etc
     *
     * @param descricao Descrição do evento Artístico, Cultural, Esportivo, etc
     */
    public NFSeSefinNacionalAtvEvento setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    /**
     * @return Data de Início do Evento
     */
    public LocalDate getDataInicio() {
        return dataInicio;
    }

    /**
     * Data de Início do Evento
     *
     * @param dataInicio Data de Início do Evento
     */
    public NFSeSefinNacionalAtvEvento setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    /**
     * @return Data de Término do Evento
     */
    public LocalDate getDataFim() {
        return dataFim;
    }

    /**
     * Data de Término do Evento
     *
     * @param dataFim Data de Término do Evento
     */
    public NFSeSefinNacionalAtvEvento setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    /**
     * @return Id do Evento
     */
    public String getId() {
        return id;
    }

    /**
     * Id do Evento
     *
     * @param id Id do Evento
     */
    public NFSeSefinNacionalAtvEvento setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return Endereço do Evento
     */
    public NFSeSefinNacionalEnderecoSimples getEndereco() {
        return endereco;
    }

    /**
     * Endereço do Evento
     *
     * @param endereco endereço do Evento
     */
    public NFSeSefinNacionalAtvEvento setEndereco(NFSeSefinNacionalEnderecoSimples endereco) {
        this.endereco = endereco;
        return this;
    }

}
