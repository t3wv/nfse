
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * Grupo de informações relativas à valores do serviço prestado
 */

@Root(name = "infoValores")
public class NFSeSefinNacionalInfoValores {

    @Element(name="vServPrest")
    protected NFSeSefinNacionalVServPrest valoresServicoPrestado;
    @Element(name="vDescCondIncond", required = false)
    protected NFSeSefinNacionalVDescCondIncond valoresDescontosCondicionadosIncondicionados;
    @Element(name="vAjusteBC", required = false)
    protected NFSeSefinNacionalInfoAjusteBC valoresAjusteBaseCalculo;
    @Element(name="trib")
    protected NFSeSefinNacionalInfoTributacao tributos;

    /**
     * @return Valores do Serviço Prestado
     */
    public NFSeSefinNacionalVServPrest getValoresServicoPrestado() {
        return valoresServicoPrestado;
    }

    /**
     * Define os Valores do Serviço Prestado
     *
     * @param valoresServicoPrestado Valores do Serviço Prestado
     */
    public NFSeSefinNacionalInfoValores setValoresServicoPrestado(NFSeSefinNacionalVServPrest valoresServicoPrestado) {
        this.valoresServicoPrestado = valoresServicoPrestado;
        return this;
    }

    /**
     * @return Valores dos Descontos Condicionados e Incondicionados
     */
    public NFSeSefinNacionalVDescCondIncond getValoresDescontosCondicionadosEIncondicionados() {
        return valoresDescontosCondicionadosIncondicionados;
    }

    /**
     * Define os Valores dos Descontos Condicionados e Incondicionados
     *
     * @param valoresDescontosCondicionadosIncondicionados Valores dos Descontos Condicionados e Incondicionados
     */
    public NFSeSefinNacionalInfoValores setValoresDescontosCondicionadosEIncondicionados(NFSeSefinNacionalVDescCondIncond valoresDescontosCondicionadosIncondicionados) {
        this.valoresDescontosCondicionadosIncondicionados = valoresDescontosCondicionadosIncondicionados;
        return this;
    }

    /**
     * @return Valores para ajuste da base de cálculo (vAjusteBC, NT SE/CGNFS-e 009; substitui o vDedRed)
     */
    public NFSeSefinNacionalInfoAjusteBC getValoresAjusteBaseCalculo() {
        return valoresAjusteBaseCalculo;
    }

    /**
     * Define os valores para ajuste da base de cálculo (vAjusteBC, NT SE/CGNFS-e 009; substitui o vDedRed)
     *
     * @param value valores para ajuste da base de cálculo
     */
    public NFSeSefinNacionalInfoValores setValoresAjusteBaseCalculo(NFSeSefinNacionalInfoAjusteBC value) {
        this.valoresAjusteBaseCalculo = value;
        return this;
    }

    /**
     * @return tributos
     */
    public NFSeSefinNacionalInfoTributacao getTributos() {
        return tributos;
    }

    /**
     * @param value tributos
     */
    public NFSeSefinNacionalInfoValores setTributos(NFSeSefinNacionalInfoTributacao value) {
        this.tributos = value;
        return this;
    }

}
