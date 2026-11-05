package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import io.github.t3wv.nfse.utils.NFSePersister;
import io.github.t3wv.nfse.utils.NFSeXmlValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.stream.StreamSource;
import java.util.List;

/**
 * Listas da DPS (gItemPed e gRefNFSe): o XML gerado não pode levar o atributo "class" do persister, que o XSD 1.01 recusa.
 */
class NFSeSefinNacionalDPSListasTest {

    private static final String XSD_DPS = "NFSeNacional_nfse-esquemas_xsd-v1-01-20260209/Schemas/1.01/DPS_v1.01.xsd";
    private static final String CHAVE_1 = "35503082211222333000181000000000123326091234567891";
    private static final String CHAVE_2 = "35503082211222333000181000000000123226091234567892";

    private static String xml() {
        return NFSeSefinNacionalNFSeFixtures.XML_COMPLETA;
    }

    private static NFSeSefinNacionalDPS dps(final String xml) throws Exception {
        return new NFSePersister().read(NFSeSefinNacionalNFSe.class, xml).getInfNFSe().getDPS();
    }

    private static void assertValidoNoXsd(final String xml) throws Exception {
        final var validador = new NFSeXmlValidator(new StreamSource(NFSeSefinNacionalDPSListasTest.class.getClassLoader().getResource(XSD_DPS).toURI().toString()));
        final var erros = validador.validateAndGetErrors(xml).getLeft();
        Assertions.assertTrue(erros.isEmpty(), String.join("; ", erros));
    }

    @Test
    void deveGerarItensDoPedidoSemOAtributoClass() throws Exception {
        final var xml = dps(xml()).toXml();
        Assertions.assertTrue(xml.contains("<gItemPed><xItemPed>10</xItemPed><xItemPed>20</xItemPed></gItemPed>"), xml);
        assertValidoNoXsd(xml);
    }

    @Test
    void deveGerarNfseReferenciadasSemOAtributoClass() throws Exception {
        final var dps = dps(xml());
        // lista imutavel, como a de List.of: o setter copia para o tipo serializado sem o atributo "class"
        dps.getInfDPS().getInfoIBSCBS().setgRefNFSe(List.of(CHAVE_1, CHAVE_2));
        final var xml = dps.toXml();
        Assertions.assertTrue(xml.contains("<gRefNFSe><refNFSe>" + CHAVE_1 + "</refNFSe><refNFSe>" + CHAVE_2 + "</refNFSe></gRefNFSe>"), xml);
        assertValidoNoXsd(xml);
    }

    @Test
    void deveLerNfseReferenciadas() throws Exception {
        final var xml = xml().replace("<cIndOp>100301</cIndOp>",
                "<cIndOp>100301</cIndOp><gRefNFSe><refNFSe>" + CHAVE_1 + "</refNFSe><refNFSe>" + CHAVE_2 + "</refNFSe></gRefNFSe>");
        Assertions.assertEquals(List.of(CHAVE_1, CHAVE_2), dps(xml).getInfDPS().getInfoIBSCBS().getgRefNFSe());
    }

    @Test
    void deveAceitarListasNulas() throws Exception {
        final var dps = dps(xml());
        dps.getInfDPS().getInfoIBSCBS().setgRefNFSe(null);
        dps.getInfDPS().getServicoPrestado().getInformacoesComplementares().setItensPedido(null);
        final var xml = dps.toXml();
        Assertions.assertFalse(xml.contains("gRefNFSe"));
        Assertions.assertFalse(xml.contains("gItemPed"));
        assertValidoNoXsd(xml);
    }
}
