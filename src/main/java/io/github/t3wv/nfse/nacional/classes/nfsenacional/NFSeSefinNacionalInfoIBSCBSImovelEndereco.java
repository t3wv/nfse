package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Endereço do imóvel (TCEnderImovel, NT SE/CGNFS-e 009)
 */
@Root(name = "end")
public class NFSeSefinNacionalInfoIBSCBSImovelEndereco {
    @Element(name = "CEP")
    protected String cep;
    @Element(name = "xLgr")
    protected String xLgr;
    @Element(name = "nro")
    protected String nro;
    @Element(name = "xCpl", required = false)
    protected String xCpl;
    @Element(name = "xBairro", required = false)
    protected String xBairro;

    /**
     * CEP
     * @return cep
     */
    public String getCep() {
        return cep;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelEndereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    /**
     * Logradouro
     * @return xLgr
     */
    public String getxLgr() {
        return xLgr;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelEndereco setxLgr(String xLgr) {
        this.xLgr = xLgr;
        return this;
    }

    /**
     * Número
     * @return nro
     */
    public String getNro() {
        return nro;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelEndereco setNro(String nro) {
        this.nro = nro;
        return this;
    }

    /**
     * Complemento
     * @return xCpl
     */
    public String getxCpl() {
        return xCpl;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelEndereco setxCpl(String xCpl) {
        this.xCpl = xCpl;
        return this;
    }

    /**
     * Bairro
     * @return xBairro
     */
    public String getxBairro() {
        return xBairro;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelEndereco setxBairro(String xBairro) {
        this.xBairro = xBairro;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSImovelEndereco{" +
                "cep=" + cep +
                ", xLgr=" + xLgr +
                ", nro=" + nro +
                ", xCpl=" + xCpl +
                ", xBairro=" + xBairro +
                '}';
    }
}
