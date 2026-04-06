
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relativas a pedágio
 */
@Root(name = "explRod")
public class NFSeSefinNacionalExploracaoRodoviaria {

    @Element(name="categVeic")
    protected NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo categoriaVeiculo;
    @Element(name="nEixos")
    protected String numeroEixos;
    @Element(name="rodagem")
    protected NFSeSefinNacionalExploracaoRodoviariaTipoRodagem tipoRodagem;
    @Element(name="sentido")
    protected String sentido;
    @Element(name="placa")
    protected String placaVeiculo;
    @Element(name="codAcessoPed")
    protected String codigoAcesso;
    @Element(name="codContrato")
    protected String codigoContrato;

    /**
     * @return Categorias do veículo para cobrança
     */
    public NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo getCategoriaVeiculo() {
        return categoriaVeiculo;
    }

    /**
     * @param categoriaVeiculo Categorias do veículo para cobrança
     */
    public NFSeSefinNacionalExploracaoRodoviaria setCategoriaVeiculo(NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo categoriaVeiculo) {
        this.categoriaVeiculo = categoriaVeiculo;
        return this;
    }

    /**
     * @return Número de eixos do veículo
     */
    public String getNumeroEixos() {
        return numeroEixos;
    }

    /**
     * @param numeroEixos Número de eixos do veículo
     */
    public NFSeSefinNacionalExploracaoRodoviaria setNumeroEixos(String numeroEixos) {
        this.numeroEixos = numeroEixos;
        return this;
    }

    /**
     * @return Tipo de rodagem do veículo
     */
    public NFSeSefinNacionalExploracaoRodoviariaTipoRodagem getTipoRodagem() {
        return tipoRodagem;
    }

    /**
     * @param tipoRodagem Tipo de rodagem do veículo
     */
    public NFSeSefinNacionalExploracaoRodoviaria setTipoRodagem(NFSeSefinNacionalExploracaoRodoviariaTipoRodagem tipoRodagem) {
        this.tipoRodagem = tipoRodagem;
        return this;
    }

    /**
     * @return Orientação de passagem do veículo: ângulo em graus a partir do norte geográfico em sentido horário, número inteiro de 0 a 359, onde 0º seria o norte, 90º o leste, 180º o sul, 270º o oeste. Precisão mínima de 10
     */
    public String getSentido() {
        return sentido;
    }

    /**
     * @param sentido Orientação de passagem do veículo: ângulo em graus a partir do norte geográfico em sentido horário, número inteiro de 0 a 359, onde 0º seria o norte, 90º o leste, 180º o sul, 270º o oeste. Precisão mínima de 10
     */
    public NFSeSefinNacionalExploracaoRodoviaria setSentido(String sentido) {
        this.sentido = sentido;
        return this;
    }

    /**
     * @return Placa do veículo
     */
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * @param placaVeiculo Placa do veículo
     */
    public NFSeSefinNacionalExploracaoRodoviaria setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
        return this;
    }

    /**
     * @return Código de acesso gerado automaticamente pelo sistema emissor da concessionária.
     */
    public String getCodigoAcesso() {
        return codigoAcesso;
    }

    /**
     * @param codigoAcesso Código de acesso gerado automaticamente pelo sistema emissor da concessionária.
     */
    public NFSeSefinNacionalExploracaoRodoviaria setCodigoAcesso(String codigoAcesso) {
        this.codigoAcesso = codigoAcesso;
        return this;
    }

    /**
     * @return Código de contrato gerado automaticamente pelo sistema nacional no cadastro da concessionária.
     */
    public String getCodigoContrato() {
        return codigoContrato;
    }

    /**
     * @param codigoContrato Código de contrato gerado automaticamente pelo sistema nacional no cadastro da concessionária.
     */
    public NFSeSefinNacionalExploracaoRodoviaria setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
        return this;
    }

}
