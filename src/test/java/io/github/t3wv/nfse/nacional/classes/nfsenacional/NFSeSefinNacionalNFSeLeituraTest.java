package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import io.github.t3wv.nfse.utils.NFSePersister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Leitura de campos do leiaute 1.01 da NFS-e que o DANFSe imprime.
 */
class NFSeSefinNacionalNFSeLeituraTest {

    private static NFSeSefinNacionalNFSe ler(final String xml) throws Exception {
        return new NFSePersister().read(NFSeSefinNacionalNFSe.class, xml);
    }

    private static String xmlCompleto() {
        return NFSeSefinNacionalNFSeFixtures.XML_COMPLETA;
    }

    @Test
    void deveLerPedidoEItensDoPedidoDasInformacoesComplementares() throws Exception {
        final var complemento = ler(xmlCompleto()).getInfNFSe().getDPS().getInfDPS().getServicoPrestado().getInformacoesComplementares();
        Assertions.assertEquals("PED-4500012345", complemento.getNumeroPedido());
        Assertions.assertEquals(List.of("10", "20"), complemento.getItensPedido());
        Assertions.assertEquals("Pagamento em 30 dias.", complemento.getInformacoesComplementares());
    }

    @Test
    void deveLerOComplementoDoEnderecoDoEmitente() throws Exception {
        Assertions.assertEquals("CONJUNTO 101", ler(xmlCompleto()).getInfNFSe().getEmitente().getEnderNac().getXCpl());
    }

    @Test
    void deveLerORegimeEspecialOutros() throws Exception {
        final var xml = xmlCompleto().replace("<regEspTrib>2</regEspTrib>", "<regEspTrib>9</regEspTrib>");
        Assertions.assertEquals(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.OUTROS,
                ler(xml).getInfNFSe().getDPS().getInfDPS().getPrestador().getRegimeTributario().getRegimeEspecialTributacao());
    }
}
