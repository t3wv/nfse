package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Informações de operações com bens imóveis (TCRTCInfoImovel), reestruturado pela NT SE/CGNFS-e 009
 */
@Root(name = "imovel")
public class NFSeSefinNacionalInfoIBSCBSInfoImovel {
    // Obrigatório no XSD da NT 009; required = false só para ler o imovel do leiaute anterior, sem cMun.
    // Numa DPS nova sem ele, quem recusa é a SEFIN (a validação local em WSSefinNFSe é um assert).
    @Element(name = "cMun", required = false)
    protected String cMun;
    @Element(name = "gLocacao", required = false)
    protected NFSeSefinNacionalInfoIBSCBSImovelLocacao gLocacao;
    @ElementList(name = "gUnidImob", entry = "gUnidImob", inline = true, required = false)
    protected List<NFSeSefinNacionalInfoIBSCBSImovelUnidade> gUnidImob;

    /**
     * Código IBGE do município do imóvel
     * @return cMun
     */
    public String getcMun() {
        return cMun;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoImovel setcMun(String cMun) {
        this.cMun = cMun;
        return this;
    }

    /**
     * Informações da locação, cessão onerosa ou arrendamento do imóvel
     * @return gLocacao
     */
    public NFSeSefinNacionalInfoIBSCBSImovelLocacao getgLocacao() {
        return gLocacao;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoImovel setgLocacao(NFSeSefinNacionalInfoIBSCBSImovelLocacao gLocacao) {
        this.gLocacao = gLocacao;
        return this;
    }

    /**
     * Unidades imobiliárias (até 99)
     * @return gUnidImob
     */
    public List<NFSeSefinNacionalInfoIBSCBSImovelUnidade> getgUnidImob() {
        return gUnidImob;
    }

    public NFSeSefinNacionalInfoIBSCBSInfoImovel setgUnidImob(List<NFSeSefinNacionalInfoIBSCBSImovelUnidade> gUnidImob) {
        this.gUnidImob = gUnidImob;
        return this;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalInfoIBSCBSInfoImovel{" +
                "cMun=" + cMun +
                ", gLocacao=" + gLocacao +
                ", gUnidImob=" + gUnidImob +
                '}';
    }
}
