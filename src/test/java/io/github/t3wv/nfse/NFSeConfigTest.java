package io.github.t3wv.nfse;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class NFSeConfigTest implements NFSeConfig {

    private final String certificadoPath;
    private final String certificadoSenha;
    private final String cadeiaCertificadosPath;
    private final String cadeiaCertificadosSenha;

    private KeyStore keyStoreCertificado = null;
    private KeyStore keyStoreCadeia = null;

    public NFSeConfigTest() {
        this.certificadoPath = System.getenv("CERTIFICADO_PATH");
        this.certificadoSenha = System.getenv("CERTIFICADO_SENHA");
        this.cadeiaCertificadosPath = System.getenv("CADEIA_CERTIFICADOS_PATH");
        this.cadeiaCertificadosSenha = System.getenv("CADEIA_CERTIFICADOS_SENHA");
    }

    public String getCertificadoSenha() {
        return certificadoSenha;
    }

    public String getCadeiaCertificadosSenha() {
        return cadeiaCertificadosSenha;
    }

    public KeyStore getKeyStoreCertificado() throws KeyStoreException {
        if (this.keyStoreCertificado == null && StringUtils.isNotBlank(this.certificadoPath)) {
            this.keyStoreCertificado = KeyStore.getInstance("PKCS12");
            try (InputStream certificadoStream = new FileInputStream(this.certificadoPath)) {
                this.keyStoreCertificado.load(certificadoStream, this.getCertificadoSenha().toCharArray());
            } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possivel montar o KeyStore com a cadeia de certificados", e);
            }
        }
        return this.keyStoreCertificado;
    }

    public KeyStore getKeyStoreCadeia() throws KeyStoreException {
        if (this.keyStoreCadeia == null && StringUtils.isNotBlank(this.cadeiaCertificadosPath)) {
            this.keyStoreCadeia = KeyStore.getInstance("JKS");
            try (InputStream cadeia = new FileInputStream(this.cadeiaCertificadosPath)) {
                this.keyStoreCadeia.load(cadeia, this.getCadeiaCertificadosSenha().toCharArray());
            } catch (CertificateException | NoSuchAlgorithmException | IOException e) {
                this.keyStoreCadeia = null;
                throw new KeyStoreException("Nao foi possivel montar o KeyStore com o certificado", e);
            }
        }
        return this.keyStoreCadeia;
    }

    public boolean isTeste() {
        return true;
    }
}
