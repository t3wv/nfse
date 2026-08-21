package io.github.t3wv.nfse.utils;

import io.github.t3wv.nfse.NFSeConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NFSeHttpClientTimeoutTest {

    @Test
    void shouldUseDefaultHttpTimeoutsFromConfig() {
        NFSeConfig config =
                new NFSeConfig() {
                    @Override
                    public String getCertificadoSenha() {
                        return null;
                    }

                    @Override
                    public String getCadeiaCertificadosSenha() {
                        return null;
                    }

                    @Override
                    public java.security.KeyStore getKeyStoreCertificado() {
                        return null;
                    }

                    @Override
                    public java.security.KeyStore getKeyStoreCadeia() {
                        return null;
                    }

                    @Override
                    public boolean isTeste() {
                        return true;
                    }
                };

        Assertions.assertEquals(30, config.getHttpGetTimeoutSegundos());
        Assertions.assertEquals(30, config.getHttpPostTimeoutSegundos());
    }

    @Test
    void shouldAllowCustomHttpTimeoutsFromConfig() {
        NFSeConfig config =
                new NFSeConfig() {
                    @Override
                    public String getCertificadoSenha() {
                        return null;
                    }

                    @Override
                    public String getCadeiaCertificadosSenha() {
                        return null;
                    }

                    @Override
                    public java.security.KeyStore getKeyStoreCertificado() {
                        return null;
                    }

                    @Override
                    public java.security.KeyStore getKeyStoreCadeia() {
                        return null;
                    }

                    @Override
                    public boolean isTeste() {
                        return true;
                    }

                    @Override
                    public int getHttpPostTimeoutSegundos() {
                        return 120;
                    }
                };

        Assertions.assertEquals(30, config.getHttpGetTimeoutSegundos());
        Assertions.assertEquals(120, config.getHttpPostTimeoutSegundos());
    }
}
