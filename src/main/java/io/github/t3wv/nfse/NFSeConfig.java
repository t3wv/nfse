package io.github.t3wv.nfse;

import java.security.KeyStore;
import java.security.KeyStoreException;

public interface NFSeConfig {

    String getCertificadoSenha();

    String getCadeiaCertificadosSenha();

    KeyStore getKeyStoreCertificado() throws KeyStoreException;

    KeyStore getKeyStoreCadeia() throws KeyStoreException;

    boolean isTeste();

    /**
     * Timeout da requisição HTTP GET, em segundos.
     */
    default int getHttpGetTimeoutSegundos() {
        return 30;
    }

    /**
     * Timeout da requisição HTTP POST, em segundos.
     */
    default int getHttpPostTimeoutSegundos() {
        return 30;
    }
}
