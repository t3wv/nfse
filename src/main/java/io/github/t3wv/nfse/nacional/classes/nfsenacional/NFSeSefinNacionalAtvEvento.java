
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

import java.time.LocalDate;

/**
 * Grupo de informações do DPS relativas à Atividade do Evento (TCAtvEvento do leiaute 1.01).
 * Deve ser informado o identificador da atividade de evento ou o endereço do evento, não os dois.
 */

@Root(name = "atvEvento")
public class NFSeSefinNacionalAtvEvento {

    @Element(name = "xNome")
    protected String descricao;
    @Element(name = "dtIni")
    protected LocalDate dataInicio;
    @Element(name = "dtFim")
    protected LocalDate dataFim;
    @Element(name = "idAtvEvt", required = false)
    protected String id;
    @Element(name = "end", required = false)
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
     * @return Identificação da Atividade de Evento (código identificador de evento determinado pela Administração Tributária
     * Municipal), ou null quando informado o endereço do evento
     */
    public String getId() {
        return id;
    }

    /**
     * Identificação da Atividade de Evento (código identificador de evento determinado pela Administração Tributária Municipal),
     * com até 30 caracteres. Alternativa ao endereço do evento.
     *
     * @param id Identificação da Atividade de Evento
     */
    public NFSeSefinNacionalAtvEvento setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @return Endereço do Evento, ou null quando informada a identificação da atividade de evento
     */
    public NFSeSefinNacionalEnderecoSimples getEndereco() {
        return endereco;
    }

    /**
     * Endereço do Evento. Alternativa à identificação da atividade de evento.
     *
     * @param endereco endereço do Evento
     */
    public NFSeSefinNacionalAtvEvento setEndereco(NFSeSefinNacionalEnderecoSimples endereco) {
        this.endereco = endereco;
        return this;
    }

}
