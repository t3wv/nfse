package io.github.t3wv.nfse.utils;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.NFSeConfigTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NFSeCadeiaCertificadosTest {

    private static NFSeConfig config;

    @Disabled
    @BeforeAll
    static void prepara() {
        config = new NFSeConfigTest();
    }

    @Test
    @Disabled("Geracao de cacerts. Executar sob demanda.")
    public void geraCadeiaCertificados() throws Exception {
        Files.write(Paths.get("/tmp/nfse_cacerts.jks"), NFSeCadeiaCertificados.geraCadeiaCertificados(config));
    }
}
