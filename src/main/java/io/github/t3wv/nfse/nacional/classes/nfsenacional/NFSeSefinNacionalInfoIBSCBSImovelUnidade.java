package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Unidade imobiliária (TCRTCUnidadesImobiliarias, NT SE/CGNFS-e 009). Informe cCIB ou end, um dos dois
 */
@Root(name = "gUnidImob")
public class NFSeSefinNacionalInfoIBSCBSImovelUnidade {
    @Element(name = "inscImobFisc", required = false)
    protected String inscImobFisc;
    @Element(name = "cCIB", required = false)
    protected String cCIB;
    @Element(name = "end", required = false)
    protected NFSeSefinNacionalInfoIBSCBSImovelEndereco end;
    @ElementList(name = "gAjusteBCLocImoveis", entry = "gAjusteBCLocImoveis", inline = true, required = false)
    protected List<NFSeSefinNacionalInfoIBSCBSImovelAjusteBC> gAjusteBCLocImoveis;

    /**
     * Inscrição imobiliária fiscal
     * @return inscImobFisc
     */
    public String getInscImobFisc() {
        return inscImobFisc;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelUnidade setInscImobFisc(String inscImobFisc) {
        this.inscImobFisc = inscImobFisc;
        return this;
    }

    /**
     * Código do Cadastro Imobiliário Brasileiro (CIB)
     * @return cCIB
     */
    public String getcCIB() {
        return cCIB;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelUnidade setcCIB(String cCIB) {
        this.cCIB = cCIB;
        return this;
    }

    /**
     * Endereço do imóvel, quando não há CIB
     * @return end
     */
    public NFSeSefinNacionalInfoIBSCBSImovelEndereco getEnd() {
        return end;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelUnidade setEnd(NFSeSefinNacionalInfoIBSCBSImovelEndereco end) {
        this.end = end;
        return this;
    }

    /**
     * Ajustes da base de cálculo do IBS/CBS na locação (até 1.000)
     * @return gAjusteBCLocImoveis
     */
    public List<NFSeSefinNacionalInfoIBSCBSImovelAjusteBC> getgAjusteBCLocImoveis() {
        return gAjusteBCLocImoveis;
    }

    public NFSeSefinNacionalInfoIBSCBSImovelUnidade setgAjusteBCLocImoveis(List<NFSeSefinNacionalInfoIBSCBSImovelAjusteBC> gAjusteBCLocImoveis) {
        this.gAjusteBCLocImoveis = gAjusteBCLocImoveis;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSImovelUnidade{" +
                "inscImobFisc=" + inscImobFisc +
                ", cCIB=" + cCIB +
                ", end=" + end +
                ", gAjusteBCLocImoveis=" + gAjusteBCLocImoveis +
                '}';
    }
}
