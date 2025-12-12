package io.github.t3wv.municipal.nfseSPSaoPaulo.requests;

import io.github.t3wv.municipal.nfseSPSaoPaulo.classes.TpCPFCNPJ;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "Cabecalho")
@Namespace(reference = "")
public class NFSeSPSaoPauloRequestConsultaNFeCabecalho {

    @Attribute(name = "Versao")
    protected String versao;

    @Element(name = "CPFCNPJRemetente")
    protected TpCPFCNPJ cpfCnpjRemetente;

    public String getVersao() {
        return versao;
    }

    public NFSeSPSaoPauloRequestConsultaNFeCabecalho setVersao(String versao) {
        this.versao = versao;
        return this;
    }

    public TpCPFCNPJ getCpfCnpjRemetente() {
        return cpfCnpjRemetente;
    }

    public NFSeSPSaoPauloRequestConsultaNFeCabecalho setCpfCnpjRemetente(TpCPFCNPJ cpfCnpjRemetente) {
        this.cpfCnpjRemetente = cpfCnpjRemetente;
        return this;
    }
}
