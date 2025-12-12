package io.github.t3wv;

import org.apache.commons.lang3.StringUtils;
import org.simpleframework.xml.core.Persister;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class NFSeConfig {

    private Persister persister;
    private final String certificadoPath;
    private final String certificadoSenha;
    private final String cadeiaCertificadosPath;
    private final String cadeiaCertificadosSenha;
    private final boolean isTeste;
    private KeyStore keyStoreCertificado = null;
    private KeyStore keyStoreCadeia = null;

    public NFSeConfig(final String certificadoPath, final String certificadoSenha, final String cadeiaCertificadosPath, final String cadeiaCertificadosSenha, final boolean isTeste) {
        this.certificadoPath = certificadoPath;
        this.certificadoSenha = certificadoSenha;
        this.cadeiaCertificadosPath = cadeiaCertificadosPath;
        this.cadeiaCertificadosSenha = cadeiaCertificadosSenha;
        this.isTeste = isTeste;
    }

    public String getCertificadoPath() {
        return certificadoPath;
    }

    public String getCertificadoSenha() {
        return certificadoSenha;
    }

    public String getCadeiaCertificadosPath() {
        return cadeiaCertificadosPath;
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

    public NFSeConfig setKeyStoreCertificado(KeyStore keyStoreCertificado) {
        this.keyStoreCertificado = keyStoreCertificado;
        return this;
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

    public NFSeConfig setKeyStoreCadeia(KeyStore keyStoreCadeia) {
        this.keyStoreCadeia = keyStoreCadeia;
        return this;
    }

    public boolean isTeste() {
        return isTeste;
    }

    public Persister getPersister() {
        return persister;
    }

    public NFSeConfig setPersister(Persister persister) {
        this.persister = persister;
        return this;
    }
}
