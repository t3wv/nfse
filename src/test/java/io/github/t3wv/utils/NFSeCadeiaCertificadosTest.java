package io.github.t3wv.utils;

import io.github.t3wv.NFSeConfig;
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
        config = new NFSeConfig(null, null, null, "senha", false);
    }

    @Test
    @Disabled("Geracao de cacerts de homologacao. Executar sob demanda.")
    public void geraCadeiaCertificadoHomologacao() throws Exception {
        Files.write(Paths.get("/tmp/cacerts_homologacao.jks"), NFSeCadeiaCertificados.geraCadeiaCertificados(config));
    }

    @Test
    @Disabled("Geracao de cacerts de producao. Executar sob demanda.")
    public void geraCadeiaCertificadoProducao() throws Exception {
        Files.write(Paths.get("/tmp/cacerts_homologacao.jks"), NFSeCadeiaCertificados.geraCadeiaCertificados(config));
    }
}
