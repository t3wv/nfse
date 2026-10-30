package io.github.t3wv.nfse.nacional;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.*;
import io.github.t3wv.nfse.utils.NFSePersister;
import io.github.t3wv.nfse.utils.NFSeUtils;
import io.github.t3wv.nfse.utils.NFSeXmlValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.transform.stream.StreamSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * DPS no leiaute da NT SE/CGNFS-e 009 (XSD de produção restrita de 20/10/2026), validada contra o XSD
 * oficial. O XML aqui não é assinado, então o único erro aceito é a falta do ds:Signature.
 */
public class NFSeSefinNacionalDPSNT009Test {

    @Test
    public void dpsSimplesValidaNoLeiauteNT009() throws Exception {
        final var dps = dpsBase();
        final var xml = dps.toXml();

        Assertions.assertEquals(List.of(), errosExcetoAssinatura(xml));
        // finNFSe saiu do grupo IBSCBS para o infDPS, antes do cLocEmi
        Assertions.assertTrue(xml.indexOf("<finNFSe>0</finNFSe>") < xml.indexOf("<cLocEmi>"), xml);
        Assertions.assertEquals(1, xml.split("<finNFSe>", -1).length - 1, xml);
        // CST e cClassTrib ficam em trib, não mais dentro do gIBSCBS
        Assertions.assertTrue(xml.contains("<trib><CST>000</CST><cClassTrib>000001</cClassTrib></trib>"), xml);
        // xDescServ vem depois do cNBS
        Assertions.assertTrue(xml.indexOf("<cNBS>") < xml.indexOf("<xDescServ>"), xml);
    }

    @Test
    public void dpsComAjusteBCImovelEBensMoveisValidaNoLeiauteNT009() throws Exception {
        final var dps = dpsBase();
        dps.getInfDPS().getValores().setValoresAjusteBaseCalculo(new NFSeSefinNacionalInfoAjusteBC()
                .setvAjusteBCISSQN(new BigDecimal("10.00"))
                .setDocumentos(List.of(new NFSeSefinNacionalDocAjusteBC()
                        .setTpAjusteBC(NFSeSefinNacionalDocAjusteBCTipoAjuste.MATERIAIS)
                        .setvTotDoc(new BigDecimal("50.00"))
                        .setvAjusteAplic(new BigDecimal("10.00"))
                        .setDtEmiDoc(LocalDate.of(2026, 10, 1))
                        .setDocumento(new NFSeSefinNacionalInfoIBSCBSDocumentoOutro().setnDoc("123").setxDoc("Nota de materiais")))));
        dps.getInfDPS().getInfoIBSCBS()
                .setImovel(new NFSeSefinNacionalInfoIBSCBSInfoImovel()
                        .setcMun("2910800")
                        .setgLocacao(new NFSeSefinNacionalInfoIBSCBSImovelLocacao()
                                .setpCopropriedade(new BigDecimal("100.00"))
                                .setvTotOper(new BigDecimal("100.00")))
                        .setgUnidImob(List.of(new NFSeSefinNacionalInfoIBSCBSImovelUnidade()
                                .setEnd(new NFSeSefinNacionalInfoIBSCBSImovelEndereco()
                                        .setCep("44001000").setxLgr("RUA TESTE").setNro("100").setxBairro("CENTRO"))
                                .setgAjusteBCLocImoveis(List.of(new NFSeSefinNacionalInfoIBSCBSImovelAjusteBC()
                                        .setTpAjusteBCLocImoveis(NFSeSefinNacionalInfoIBSCBSImovelTipoAjusteBC.CONDOMINIO)
                                        .setvAjusteBCLocImoveis(new BigDecimal("5.00")))))))
                .setBensMoveis(List.of(new NFSeSefinNacionalInfoIBSCBSBensMoveis()
                        .setcNCMBemMovel("84713012").setxNCMBemMovel("Notebook").setQtdNCMBemMovel(1)));

        Assertions.assertEquals(List.of(), errosExcetoAssinatura(dps.toXml()));
    }

    @Test
    public void dpsNoLeiauteNT009FazIdaEVoltaPeloXml() throws Exception {
        final var xml = dpsBase().toXml();

        final var lida = new NFSePersister().read(NFSeSefinNacionalDPS.class, xml);

        Assertions.assertEquals(NFSeSefinNacionalInfoIBSCBSFinNFSe.REGULAR, lida.getInfDPS().getFinalidade());
        Assertions.assertEquals("000", lida.getInfDPS().getInfoIBSCBS().getValores().getTrib().getCST());
        Assertions.assertEquals("000001", lida.getInfDPS().getInfoIBSCBS().getValores().getTrib().getcClassTrib());
        Assertions.assertEquals("Servico de teste", lida.getInfDPS().getServicoPrestado().getCServ().getDescricaoServico());
    }

    @Test
    public void dpsNoLeiauteAnteriorAindaELidaSemEstrito() throws Exception {
        // Leiaute anterior à NT 009: finNFSe no IBSCBS, CST/cClassTrib no gIBSCBS, vDedRed,
        // gReeRepRes e imovel com cCIB. As NFS-e recebidas são lidas sem modo estrito
        // (NFSeSefinNacionalGetResponse, NFSeSefinNacionalNFSePostResponseSucesso).
        final var xmlAnterior = dpsBase().toXml()
                .replace("<finNFSe>0</finNFSe>", "")
                .replace("<IBSCBS>", "<IBSCBS><finNFSe>0</finNFSe>")
                .replace("<trib><CST>000</CST><cClassTrib>000001</cClassTrib></trib>",
                        "<gReeRepRes><documentos><docOutro><nDoc>1</nDoc><xDoc>Doc</xDoc></docOutro>"
                                + "<dtEmiDoc>2026-01-01</dtEmiDoc><dtCompDoc>2026-01-01</dtCompDoc>"
                                + "<tpReeRepRes>99</tpReeRepRes><vlrReeRepRes>1.00</vlrReeRepRes></documentos></gReeRepRes>"
                                + "<trib><gIBSCBS><CST>000</CST><cClassTrib>000001</cClassTrib></gIBSCBS></trib>")
                .replace("<indDest>0</indDest>", "<indDest>0</indDest><imovel><cCIB>12345678</cCIB></imovel>")
                .replace("</vServPrest>", "</vServPrest><vDedRed><pDR>10.00</pDR></vDedRed>");

        Assertions.assertThrows(Exception.class, () -> new NFSePersister().read(NFSeSefinNacionalDPS.class, xmlAnterior));
        final var lida = new NFSePersister(false).read(NFSeSefinNacionalDPS.class, xmlAnterior);

        Assertions.assertEquals("90010", String.valueOf(lida.getInfDPS().getNumeroDPS()));
        Assertions.assertEquals(NFSeSefinNacionalInfoIBSCBSIndDest.TOMADOR, lida.getInfDPS().getInfoIBSCBS().getIndDest());
    }

    @Test
    public void valoresDaNfseNoLeiauteAnteriorAindaSaoLidosSemEstrito() throws Exception {
        final var valores = new NFSePersister(false).read(NFSeSefinNacionalValoresNFSe.class,
                "<valores><vCalcDR>10.00</vCalcDR><vLiq>90.00</vLiq></valores>");

        Assertions.assertEquals(new BigDecimal("90.00"), valores.getVLiq());
    }

    @Test
    public void tipoDeAjusteDaNtForaDoXsdAtualAindaELido() throws Exception {
        final var doc = new NFSePersister(false).read(NFSeSefinNacionalDocAjusteBC.class,
                "<docAjusteBC><tpAjusteBC>1</tpAjusteBC><vTotDoc>10.00</vTotDoc><vAjusteAplic>10.00</vAjusteAplic>"
                        + "<docOutro><nDoc>1</nDoc><xDoc>Doc</xDoc></docOutro></docAjusteBC>");

        Assertions.assertEquals(NFSeSefinNacionalDocAjusteBCTipoAjuste.ALIMENTACAO_BEBIDAS_FRIGOBAR, doc.getTpAjusteBC());
    }

    @Test
    public void gRefNFSeEDocumentosVaziosNaoQuebramOXsd() throws Exception {
        final var dps = dpsBase();
        dps.getInfDPS().getInfoIBSCBS().setgRefNFSe(List.of("29108002259252217000131000000000000126100000000001"));
        dps.getInfDPS().getValores().setValoresAjusteBaseCalculo(new NFSeSefinNacionalInfoAjusteBC()
                .setvAjusteBCISSQN(new BigDecimal("10.00"))
                .setDocumentos(List.of()));
        final var xml = dps.toXml();

        Assertions.assertFalse(xml.contains("class="), xml);
        Assertions.assertFalse(xml.contains("<documentos"), xml);
        Assertions.assertEquals(List.of(), errosExcetoAssinatura(xml));
    }

    private static NFSeSefinNacionalDPS dpsBase() {
        final var tomador = new NFSeSefinNacionalInfoPessoa().setCPF("12345678909");
        tomador.setNome("TOMADOR HOMOLOGACAO");
        tomador.setEndereco(new NFSeSefinNacionalEndereco()
                .setEnderecoNacional(new NFSeSefinNacionalEnderNac().setCodigoMunicipio("2910800").setCEP("44001000"))
                .setLogradouro("RUA TESTE").setNumero("100").setBairro("CENTRO"));
        final var prestador = new NFSeSefinNacionalInfoPrestador()
                .setCNPJ("59252217000131")
                .setRegimeTributario(new NFSeSefinNacionalRegTrib()
                        .setOpSimplesNacional(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.ME_EPP)
                        .setRegimeEspecialTributacao(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.NENHUM));
        final var dps = new NFSeSefinNacionalDPS().setInfDPS(new NFSeSefinNacionalInfDPS()
                .setTipoAmbiente(NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO)
                .setDataHoraEmissao(ZonedDateTime.of(2026, 10, 29, 10, 0, 0, 0, ZoneId.of("-03:00")))
                .setVersaoApp("teste-nt009")
                .setSerie("1")
                .setNumeroDPS(90010)
                .setDataInicioPrestacaoServico(LocalDate.of(2026, 10, 29))
                .setTipoEmitente(NFSeSefinNacionalInfDPSTipoEmitente.PRESTADOR)
                .setCodigoMunicipioEmissao("2910800")
                .setPrestador(prestador)
                .setTomador(tomador)
                .setServicoPrestado(new NFSeSefinNacionalServ()
                        .setLocalPrestacao(new NFSeSefinNacionalLocPrest().setCodigoMunicipio("2910800"))
                        .setCServ(new NFSeSefinNacionalCServ()
                                .setCodigoNacionalTributacaoISSQN("010701")
                                .setDescricaoServico("Servico de teste")
                                .setCodigoNBS("114061100")))
                .setValores(new NFSeSefinNacionalInfoValores()
                        .setValoresServicoPrestado(new NFSeSefinNacionalVServPrest().setValorServicos(new BigDecimal("100.00")))
                        .setTributos(new NFSeSefinNacionalInfoTributacao()
                                .setTributosMunicipais(new NFSeSefinNacionalTribMunicipal()
                                        .setTributacaoISSQN(NFSeSefinNacionalTribMunicipalTributacaoISSQN.OPERACAO_TRIBUTAVEL)
                                        .setTipoRetencaoISSQN(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN.NAO_RETIDO))
                                .setTotalTributos(new NFSeSefinNacionalTribTotal().setIndicadorValorTotalTributos("0"))))
                .setInfoIBSCBS(new NFSeSefinNacionalInfoIBSCBS()
                        .setIndFinal(false)
                        .setcIndOp("100301")
                        .setIndDest(NFSeSefinNacionalInfoIBSCBSIndDest.TOMADOR)
                        .setValores(new NFSeSefinNacionalInfoIBSCBSInfoValoresIBSCBS()
                                .setTrib(new NFSeSefinNacionalInfoIBSCBSInfoTributos()
                                        .setCST("000")
                                        .setcClassTrib("000001")))));
        dps.getInfDPS().setId(NFSeUtils.gerarDPSId(dps));
        return dps;
    }

    private static List<String> errosExcetoAssinatura(final String xml) throws Exception {
        final var xsd = NFSeSefinNacionalDPSNT009Test.class.getClassLoader().getResource(WSSefinNFSe.XSD_DPS).toURI().toString();
        final var erros = new NFSeXmlValidator(new StreamSource(xsd)).validateAndGetErrors(xml).getLeft();
        return erros.stream().filter(erro -> !erro.contains("Signature")).toList();
    }
}
