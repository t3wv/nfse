package io.github.t3wv.nfse.municipal.nfseSPBarueri.services;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.io.StringWriter;

@Root(name = "NFeLoteStatusArquivo")
@Namespace(reference = "http://www.barueri.sp.gov.br/nfe")
public class NFSeBarueriLoteStatusArquivoRequest {

    @Element(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;

    @Element(name = "CPFCNPJContrib")
    private String cpfCnpjContrib;

    @Element(name = "ProtocoloRemessa")
    private String protocoloRemessa;

    public NFSeBarueriLoteStatusArquivoRequest(String inscricaoMunicipal, String cpfCnpjContrib, String protocoloRemessa) {
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.cpfCnpjContrib = cpfCnpjContrib;
        this.protocoloRemessa = protocoloRemessa;
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

    public String getProtocoloRemessa() {
        return protocoloRemessa;
    }

    public void setProtocoloRemessa(String protocoloRemessa) {
        this.protocoloRemessa = protocoloRemessa;
    }

    public String toXml() throws Exception {
        NFSePersister serializer = new NFSePersister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
