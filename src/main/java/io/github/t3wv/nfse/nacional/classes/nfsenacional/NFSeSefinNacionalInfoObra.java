
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações do DPS relativas à serviço de obra
 */

@Root(name = "obra")
public class NFSeSefinNacionalInfoObra {

    @Element(name = "cObra", required = false)
    String numeroIdentificacaoObra;
    @Element(name = "inscImobFisc", required = false)
    String inscricaoImobiliariaFiscal;
    @Element(name = "cCIB", required = false)
    String cCIB;
    @Element(name = "end", required = false)
    NFSeSefinNacionalEnderObraEvento endereco;

    /**
     * Número de identificação da obra
     * Cadastro Nacional de Obras (CNO) ou Cadastro Específico do INSS (CEI).
     *
     * @return Número de identificação da obra
     */
    public String getNumeroIdentificacaoObra() {
        return numeroIdentificacaoObra;
    }

    /**
     * Define o número de identificação da obra
     * Cadastro Nacional de Obras (CNO) ou Cadastro Específico do INSS (CEI).
     *
     * @param value Número de identificação da obra
     */
    public NFSeSefinNacionalInfoObra setNumeroIdentificacaoObra(String value) {
        this.numeroIdentificacaoObra = value;
        return this;
    }

    /**
     * Inscrição imobiliária fiscal (código fornecido pela Prefeitura Municipal para a identificação da obra ou para fins de recolhimento do IPTU)
     *
     * @return Inscrição imobiliária fiscal
     */
    public String getInscricaoImobiliariaFiscal() {
        return inscricaoImobiliariaFiscal;
    }

    /**
     * Define a inscrição imobiliária fiscal (código fornecido pela Prefeitura Municipal para a identificação da obra ou para fins de recolhimento do IPTU)
     *
     * @param value Inscrição imobiliária fiscal
     */
    public NFSeSefinNacionalInfoObra setInscricaoImobiliariaFiscal(String value) {
        this.inscricaoImobiliariaFiscal = value;
        return this;
    }

    /**
     * Código do Cadastro Imobiliário Brasileiro - CIB
     *
     * @return Código do Cadastro Imobiliário Brasileiro
     */
    public String getCCIB() {
        return cCIB;
    }

    /**
     * Define o código do Cadastro Imobiliário Brasileiro - CIB
     *
     * @param value Código do Cadastro Imobiliário Brasileiro
     */
    public NFSeSefinNacionalInfoObra setCCIB(String value) {
        this.cCIB = value;
        return this;
    }

    /**
     * Endereço da obra
     *
     * @return Endereço da obra
     */
    public NFSeSefinNacionalEnderObraEvento getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço da obra
     *
     * @param value Endereço da obra
     */
    public NFSeSefinNacionalInfoObra setEndereco(NFSeSefinNacionalEnderObraEvento value) {
        this.endereco = value;
        return this;
    }

}
