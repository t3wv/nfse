
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.*;

/**
 * <p>Java class for TCInfoEventoAnulacaoRejeicao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TCInfoEventoAnulacaoRejeicao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CPFAgTrib" type="{http://www.sped.fazenda.gov.br/nfse}TSCPF"/&gt;
 *         &lt;element name="idEvManifRej" type="{http://www.sped.fazenda.gov.br/nfse}TSIdNumEvento"/&gt;
 *         &lt;element name="xMotivo" type="{http://www.sped.fazenda.gov.br/nfse}TSMotivo"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */

@Root(name = "InfoEventoAnulacaoRejeicao")
public class NFSeSefinNacionalInfoEventoAnulacaoRejeicao {

    @Element(name = "CPFAgTrib", required = false)
    protected String cpfAgTrib;
    @Element(required = true)
    protected String idEvManifRej;
    @Element(required = true)
    protected String xMotivo;

    public String getCPFAgTrib() {
        return cpfAgTrib;
    }

    public NFSeSefinNacionalInfoEventoAnulacaoRejeicao setCPFAgTrib(String value) {
        this.cpfAgTrib = value;
        return this;
    }

    public String getIdEvManifRej() {
        return idEvManifRej;
    }

    public NFSeSefinNacionalInfoEventoAnulacaoRejeicao setIdEvManifRej(String value) {
        this.idEvManifRej = value;
        return this;
    }

    public String getXMotivo() {
        return xMotivo;
    }

    public NFSeSefinNacionalInfoEventoAnulacaoRejeicao setXMotivo(String value) {
        this.xMotivo = value;
        return this;
    }

}
