
package io.github.t3wv.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Grupo de informações específicas de endereço nacional
 */

@Root(name = "EnderNac")
public class NFSeSefinNacionalEnderNac {

    @Element(name = "cMun")
    protected String codigoMunicipio;
    @Element(name = "CEP")
    protected String cep;

    /**
     * Código do município conforme tabela do IBGE
     */
    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    /**
     * @param codigoMunicipio Código do município conforme tabela do IBGE
     */
    public NFSeSefinNacionalEnderNac setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
        return this;
    }

    /**
     * CEP do endereço
     */
    public String getCEP() {
        return cep;
    }

    /**
     * @param cep CEP do endereço
     */
    public NFSeSefinNacionalEnderNac setCEP(String cep) {
        this.cep = cep;
        return this;
    }
}
