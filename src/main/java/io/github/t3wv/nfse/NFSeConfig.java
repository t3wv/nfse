package io.github.t3wv.nfse;

import java.security.KeyStore;
import java.security.KeyStoreException;

public interface NFSeConfig {

    String getCertificadoSenha();

    String getCadeiaCertificadosSenha();

    KeyStore getKeyStoreCertificado() throws KeyStoreException;

    KeyStore getKeyStoreCadeia() throws KeyStoreException;

    boolean isTeste();
}
