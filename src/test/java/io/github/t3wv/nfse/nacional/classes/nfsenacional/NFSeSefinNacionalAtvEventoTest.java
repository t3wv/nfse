package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import io.github.t3wv.nfse.nacional.WSSefinNFSe;
import io.github.t3wv.nfse.utils.NFSePersister;
import io.github.t3wv.nfse.utils.NFSeXmlValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.stream.StreamSource;
import java.time.LocalDate;

/**
 * Grupo atvEvento da DPS conforme o TCAtvEvento do leiaute 1.01: xNome, dtIni, dtFim e a escolha entre idAtvEvt e end.
 */
class NFSeSefinNacionalAtvEventoTest {

    // O mesmo XSD da DPS que a lib usa no envio (producao restrita, leiaute da NT 009).
    private static final String XSD_DPS = WSSefinNFSe.XSD_DPS;

    private static String xmlComEvento(final String evento) {
        // atvEvento vem depois de obra e antes de infoCompl no grupo serv
        return NFSeSefinNacionalNFSeFixtures.XML_COMPLETA.replace("</obra>",
                "</obra>\n<atvEvento><xNome>Show de rock</xNome><dtIni>2026-09-10</dtIni><dtFim>2026-09-12</dtFim>" + evento + "</atvEvento>");
    }

    private static NFSeSefinNacionalAtvEvento lerEvento(final String evento) throws Exception {
        return new NFSePersister().read(NFSeSefinNacionalNFSe.class, xmlComEvento(evento)).getInfNFSe().getDPS().getInfDPS().getServicoPrestado().getEvento();
    }

    private static NFSeSefinNacionalDPS dps() throws Exception {
        return new NFSePersister().read(NFSeSefinNacionalNFSe.class, xmlComEvento("<idAtvEvt>X</idAtvEvt>")).getInfNFSe().getDPS();
    }

    private static void assertValidoNoXsd(final NFSeSefinNacionalDPS dps) throws Exception {
        final var validador = new NFSeXmlValidator(new StreamSource(NFSeSefinNacionalAtvEventoTest.class.getClassLoader().getResource(XSD_DPS).toURI().toString()));
        final var erros = validador.validateAndGetErrors(dps.toXml()).getLeft();
        Assertions.assertTrue(erros.isEmpty(), String.join("; ", erros));
    }

    @Test
    void deveLerEventoComIdentificacaoDaAtividade() throws Exception {
        final var evento = lerEvento("<idAtvEvt>EVT-2026-001</idAtvEvt>");
        Assertions.assertEquals("Show de rock", evento.getDescricao());
        Assertions.assertEquals(LocalDate.of(2026, 9, 10), evento.getDataInicio());
        Assertions.assertEquals(LocalDate.of(2026, 9, 12), evento.getDataFim());
        Assertions.assertEquals("EVT-2026-001", evento.getId());
        Assertions.assertNull(evento.getEndereco());
    }

    @Test
    void deveLerEventoComEnderecoNacional() throws Exception {
        final var evento = lerEvento("<end><CEP>01310100</CEP><xLgr>AVENIDA PAULISTA</xLgr><nro>1000</nro><xBairro>BELA VISTA</xBairro></end>");
        Assertions.assertNull(evento.getId());
        Assertions.assertEquals("01310100", evento.getEndereco().getCEP());
        Assertions.assertNull(evento.getEndereco().getEnderecoExterior());
        Assertions.assertEquals("AVENIDA PAULISTA", evento.getEndereco().getLogradouro());
    }

    @Test
    void deveLerEventoComEnderecoNoExterior() throws Exception {
        final var evento = lerEvento("<end><endExt><cEndPost>33101</cEndPost><xCidade>Miami</xCidade><xEstProvReg>Florida</xEstProvReg></endExt>"
                + "<xLgr>BISCAYNE BOULEVARD</xLgr><nro>200</nro><xBairro>DOWNTOWN</xBairro></end>");
        Assertions.assertNull(evento.getEndereco().getCEP());
        Assertions.assertEquals("Miami", evento.getEndereco().getEnderecoExterior().getCidade());
    }

    @Test
    void deveRecusarOsNomesDoLeiaute100() {
        Assertions.assertThrows(Exception.class, () -> lerEvento("<id>EVT-2026-001</id>").getId());
        Assertions.assertThrows(Exception.class, () -> new NFSePersister().read(NFSeSefinNacionalNFSe.class,
                xmlComEvento("<idAtvEvt>X</idAtvEvt>").replace("<xNome>Show de rock</xNome>", "<desc>Show de rock</desc>")));
    }

    @Test
    void deveGerarDpsValidaNoXsdComIdentificacaoDaAtividade() throws Exception {
        final var dps = dps();
        dps.getInfDPS().getServicoPrestado().setEvento(new NFSeSefinNacionalAtvEvento().setDescricao("Show de rock")
                .setDataInicio(LocalDate.of(2026, 9, 10)).setDataFim(LocalDate.of(2026, 9, 12)).setId("EVT-2026-001"));
        Assertions.assertTrue(dps.toXml().contains("<atvEvento><xNome>Show de rock</xNome><dtIni>2026-09-10</dtIni><dtFim>2026-09-12</dtFim>"
                + "<idAtvEvt>EVT-2026-001</idAtvEvt></atvEvento>"));
        assertValidoNoXsd(dps);
    }

    @Test
    void deveGerarDpsValidaNoXsdComEnderecoDoEvento() throws Exception {
        final var dps = dps();
        dps.getInfDPS().getServicoPrestado().setEvento(new NFSeSefinNacionalAtvEvento().setDescricao("Show de rock")
                .setDataInicio(LocalDate.of(2026, 9, 10)).setDataFim(LocalDate.of(2026, 9, 12))
                .setEndereco(new NFSeSefinNacionalEnderecoSimples().setCEP("01310100").setLogradouro("AVENIDA PAULISTA").setNumero("1000").setBairro("BELA VISTA")));
        Assertions.assertFalse(dps.toXml().contains("<idAtvEvt>"));
        assertValidoNoXsd(dps);
    }
}
