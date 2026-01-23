package io.github.t3wv.nfse.municipal.nfseSPBarueri.services;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import java.io.StringWriter;

@Root(name = "NFeLoteEnviarArquivo")
@Namespace(reference = "http://www.barueri.sp.gov.br/nfe")
public class NFSeBarueriLoteEnviarArquivoRequest {

    @Element(name = "InscricaoMunicipal")
    private String inscricaoMunicipal;

    @Element(name = "CPFCNPJContrib")
    private String cpfCnpjContribuinte;

    @Element(name = "NomeArquivoRPS")
    private String nomeArquivoRPS;

    @Element(name = "ApenasValidaArq")
    private Boolean apenasValidaArquivo;

    @Element(name = "ArquivoRPSBase64")
    private String arquivoRPSBase64;

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
        return this;
    }

    public String getCpfCnpjContribuinte() {
        return cpfCnpjContribuinte;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setCpfCnpjContribuinte(String cpfCnpjContribuinte) {
        this.cpfCnpjContribuinte = cpfCnpjContribuinte;
        return this;
    }

    public String getNomeArquivoRPS() {
        return nomeArquivoRPS;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setNomeArquivoRPS(String nomeArquivoRPS) {
        this.nomeArquivoRPS = nomeArquivoRPS;
        return this;
    }

    public Boolean getApenasValidaArquivo() {
        return apenasValidaArquivo;
    }

    public NFSeBarueriLoteEnviarArquivoRequest setApenasValidaArquivo(Boolean apenasValidaArquivo) {
        this.apenasValidaArquivo = apenasValidaArquivo;
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
        final var writer = new StringWriter();
        new NFSePersister().write(this, writer);
        return writer.toString();
    }
}