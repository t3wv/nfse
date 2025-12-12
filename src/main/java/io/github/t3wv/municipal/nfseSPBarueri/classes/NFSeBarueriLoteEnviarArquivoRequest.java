package io.github.t3wv.municipal.nfseSPBarueri.classes;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

@Root(name = "NFeLoteEnviarArquivo")
@Namespace(reference = "http://www.barueri.sp.gov.br/nfe")
public class NFSeBarueriLoteEnviarArquivoRequest {

    @Element(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;

    @Element(name = "CPFCNPJContrib")
    private String cpfCnpjContrib;

    @Element(name = "NomeArquivoRPS")
    private String nomeArquivoRPS;

    @Element(name = "ApenasValidaArq")
    private Boolean apenasValidaArq;

    @Element(name = "ArquivoRPSBase64")
    private String arquivoRPSBase64;

    public NFSeBarueriLoteEnviarArquivoRequest(NFSeBarueriRPSArquivo arquivo) throws Exception {
        this.inscricaoMunicipal = arquivo.getInscricaoMunicipalContribuinte();
        this.cpfCnpjContrib = arquivo.getDocumentoContribuinte();
        this.nomeArquivoRPS = arquivo.getNomeArquivo();
        this.apenasValidaArq = false;
        this.arquivoRPSBase64 = arquivo.getArquivoBase64();
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
        return this;
    }

    public String getCpfCnpjContrib() {
        return cpfCnpjContrib;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setCpfCnpjContrib(String cpfCnpjContrib) {
        this.cpfCnpjContrib = cpfCnpjContrib;
        return this;
    }

    public String getNomeArquivoRPS() {
        return nomeArquivoRPS;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setNomeArquivoRPS(String nomeArquivoRPS) {
        this.nomeArquivoRPS = nomeArquivoRPS;
        return this;
    }

    public Boolean getApenasValidaArq() {
        return apenasValidaArq;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setApenasValidaArq(Boolean apenasValidaArq) {
        this.apenasValidaArq = apenasValidaArq;
        return this;
    }

    public String getArquivoRPSBase64() {
        return arquivoRPSBase64;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setArquivoRPSBase64(String arquivoRPSBase64) {
        this.arquivoRPSBase64 = arquivoRPSBase64;
        return this;
    }

    public String toXml() throws Exception {
        Persister serializer = new Persister();
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}