package io.github.t3wv.nfse.municipal.nfseSPBarueri.services;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.io.StringWriter;

@Root(name = "NFeLoteBaixarArquivo")
@Namespace(reference = "http://www.barueri.sp.gov.br/nfe")
public class NFSeBarueriLoteBaixarArquivoRequest {

    @Element(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;

    @Element(name = "CPFCNPJContrib")
    private String cpfCnpjContrib;

    @Element(name = "NomeArqRetorno")
    private String nomeArqRetorno;

    public NFSeBarueriLoteBaixarArquivoRequest(String inscricaoMunicipal, String cpfCnpjContrib, String nomeArqRetorno) {
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.cpfCnpjContrib = cpfCnpjContrib;
        this.nomeArqRetorno = nomeArqRetorno;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getCpfCnpjContrib() {
        return cpfCnpjContrib;
    }

    public void setCpfCnpjContrib(String cpfCnpjContrib) {
        this.cpfCnpjContrib = cpfCnpjContrib;
    }

    public String getNomeArqRetorno() {
        return nomeArqRetorno;
    }

    public void setNomeArqRetorno(String nomeArqRetorno) {
        this.nomeArqRetorno = nomeArqRetorno;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
