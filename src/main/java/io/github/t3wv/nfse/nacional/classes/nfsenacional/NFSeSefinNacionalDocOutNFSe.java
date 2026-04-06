
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

@Root(name = "NFSeMun")
public class NFSeSefinNacionalDocOutNFSe {

    @Element(name = "cMunNFSeMun")
    protected String codigoMunicipio;
    @Element(name = "nNFSeMun")
    protected String numeroNFSe;
    @Element(name = "cVerifNFSeMun")
    protected String codigoVerificacao;

    /**
     * @return Código Município emissor da nota eletrônica municipal (Tabela do IBGE)
     */
    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    /**
     * @param codigoMunicipio Código Município emissor da nota eletrônica municipal (Tabela do IBGE)
     */
    public NFSeSefinNacionalDocOutNFSe setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
        return this;
    }

    /**
     * @return Número da nota eletrônica municipal
     */
    public String getNumeroNFSe() {
        return numeroNFSe;
    }

    /**
     * @param numeroNFSe Número da nota eletrônica municipal
     */
    public NFSeSefinNacionalDocOutNFSe setNumeroNFSe(String numeroNFSe) {
        this.numeroNFSe = numeroNFSe;
        return this;
    }

    /**
     * @return Código de Verificação da nota eletrônica municipal
     */
    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    /**
     * @param codigoVerificacao Código de Verificação da nota eletrônica municipal
     */
    public NFSeSefinNacionalDocOutNFSe setCodigoVerificacao(String codigoVerificacao) {
        this.codigoVerificacao = codigoVerificacao;
        return this;
    }

}
