package io.github.t3wv.municipal;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.municipal.nfseSPBarueri.classes.*;
import io.github.t3wv.municipal.nfseSPBarueri.enums.*;
import io.github.t3wv.municipal.nfseSPBarueri.webservices.WSRPS;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;

public class NFSeSPBarueriTest {

    private static NFSeConfig config;

    @Disabled
    @BeforeAll
    static void prepara() {
        config = new NFSeConfig(
                System.getenv("CERTIFICADO_PATH"),
                System.getenv("CERTIFICADO_SENHA"),
                System.getenv("CADEIA_CERTIFICADOS_PATH"),
                System.getenv("CADEIA_CERTIFICADOS_SENHA"), true);
    }

    @Disabled
    @Test
    public void testeEmiteCancela() throws Exception {
        final var rps = new NFSeBarueriRPS()
                .setRPSSerie("")
                .setRPSNumero("")
                .setRPSDataEmissao(LocalDate.now())
                .setRPSHoraEmissao(LocalTime.now())
                .setRPSSituacao(NFSeBarueriRPSSituacao.ENVIADO)
                .setRPSCodigoServicoPrestado("")
                .setRPSLocalPrestacaoServico(NFSeBarueriRPSLocalPrestacaoServico.OUTROS)
                .setRPSServicoPrestadoEmViasPublicas(NFSeBarueriRPSServicoPrestadoViasPublicas.SIM)
                .setRPSEnderecoServicoPrestado("")
                .setRPSEnderecoServicoPrestadoNumero("")
                .setRPSEnderecoServicoPrestadoComplemento("")
                .setRPSEnderecoServicoPrestadoBairro("")
                .setRPSEnderecoServicoPrestadoCidade("")
                .setRPSEnderecoServicoPrestadoUF("")
                .setRPSEnderecoServicoPrestadoCodigoPostal("")
                .setRPSQuantidadeServicoPrestado("")
                .setRPSValorServico(BigDecimal.valueOf(0.01))
                .setRPSTomadorTipo(NFSeBarueriRPSTomadorTipo.BRASILEIRO)
                .setRPSServicoExportacao(NFSeBarueriRPSServicoExportacao.NAO)
                .setRPSTomadorDocumento("")
                .setRPSTomadorRazaoSocial("")
                .setRPSTomadorEndereco("")
                .setRPSTomadorEnderecoNumero("")
                .setRPSTomadorEnderecoComplemento("")
                .setRPSTomadorEnderecoBairro("")
                .setRPSTomadorEnderecoCidade("")
                .setRPSTomadorEnderecoUF("")
                .setRPSTomadorEnderecoCodigoPostal("")
                .setRPSTomadorEmail("")
                .setRPSDiscriminacaoServicos("")
                .setOptanteSimplesNacional(NFSeBarueriRPSOptanteSimplesNacional.NAO_OPTANTE)
                .setRegimeApuracaoTributariaSimplesNacional(NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional.LEGISLACAO_FEDERAL_E_MUNICIPAL_TRIBUTO)
                .setServicoPrestadoCidadeCodigoIBGE("")
                .setTomadorCidadeCodigoIBGE("")
                .setVinculoEntrePartes(NFSeBarueriRPSVinculoEntrePartes.SEM_VINCULO);

        final var arquivoRps = new NFSeBarueriRPSArquivo("", "", "PMB003", LocalDateTime.now(), List.of(rps));
        Files.write(Paths.get("".formatted(arquivoRps.getNomeArquivo())), arquivoRps.geraConteudoArquivo().toByteArray());

        // Envio o lote para emissão
        NFSeBarueriLoteEnviarArquivoRequest request = new NFSeBarueriLoteEnviarArquivoRequest(arquivoRps);
        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioEmissao = new WSRPS(config).NFeLoteEnviarArquivo(request);
        Files.write(Paths.get("".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())), arquivoRps.geraConteudoArquivo().toByteArray());
        Thread.sleep(2000);

        // Consulto o status do arquivo enviado
        final NFSeBarueriLoteStatusArquivoResponse responseStatusEmissao = new WSRPS(config).NFeLoteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioEmissao.getResultado().getProtocoloRemessa()));
        Files.writeString(Paths.get("".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())), responseStatusEmissao.toXml());
        Thread.sleep(2000);

        // Baixo o arquivo de retorno da emissão
        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarEmissao = new WSRPS(config).NFeLoteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("", "", responseStatusEmissao.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
        Files.writeString(Paths.get("".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())), responseBaixarEmissao.toXml());

        final NFSeBarueriLoteBaixarArquivoResult resultadoEmissao = responseBaixarEmissao.getResultado();
        final byte[] arquivoB64 = Base64.getDecoder().decode(resultadoEmissao.getArquivoRPSBase64());
        Files.write(Paths.get(String.format("",arquivoRps.getNomeArquivo())), arquivoB64);
        final var linhasArquivoEmissao = resultadoEmissao.getLinhas();
        final var errosEmissao = NFSeBarueriLoteBaixarArquivoResult.parseErros(linhasArquivoEmissao);

        // Se houverem erros, lanço exceção
        Assertions.assertTrue(errosEmissao.isEmpty(), String.format("Foram encontrados erros no retorno da emissao da NFS-e: %s", String.join(";\n ", errosEmissao)));

        // Caso não haja erros, extraio os dados relevantes da nota e prossigo com o cancelamento
        final var serieNf = StringUtils.stripStart(linhasArquivoEmissao[1].substring(1, 6).trim(), "0");
        final var numeroNf = StringUtils.stripStart(linhasArquivoEmissao[1].substring(6, 12).trim(), "0");
        final var chaveNFSeNacional = StringUtils.stripStart(linhasArquivoEmissao[1].substring(1628, 1678).trim(), "0");

        // Realizo o cancelamento da nota através do mesmo objeto RPS, alterando os campos necessários para o cancelamento
        rps.setRPSSituacao(NFSeBarueriRPSSituacao.CANCELADO)
                .setRPSMotivoCancelamento(NFSeBarueriRPSCodigoMotivoCancelamento.CANCELAMENTO)
                .setNFSubstituidaDescricaoCancelamento("Teste de cancelamento")
                .setNFSubstituidaNumero(numeroNf.trim())
                .setNFSerie(serieNf)
                .setNFSubstituidaDataEmissao(rps.getRPSDataEmissao())//
                .setRPSCodigoServicoPrestado("101001220");

        // Gero o arquivo no formato que deve ser enviado dentro do SOAP para o cancelamento
        final var arquivoRpsCancelamento = new NFSeBarueriRPSArquivo("", "", "PMB003", LocalDateTime.now(), List.of(rps));

        // Envio o lote para cancelamento
        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioCancelamento = new WSRPS(config).NFeLoteEnviarArquivo(new NFSeBarueriLoteEnviarArquivoRequest(arquivoRpsCancelamento));
        Thread.sleep(5000);

        // Consulto o status do arquivo de cancelamento enviado
        final NFSeBarueriLoteStatusArquivoResponse responseStatusCancelamento = new WSRPS(config).NFeLoteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioCancelamento.getResultado().getProtocoloRemessa()));
        Thread.sleep(5000);

        // Baixo o arquivo de retorno do cancelamento
        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarCancelamento = new WSRPS(config).NFeLoteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("", "", responseStatusCancelamento.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
        final NFSeBarueriLoteBaixarArquivoResult resultadoCancelamento = responseBaixarCancelamento.getResultado();
        final byte[] arquivoCancelamentoB64 = Base64.getDecoder().decode(resultadoCancelamento.getArquivoRPSBase64());
        Files.write(Paths.get(String.format("",arquivoRps.getNomeArquivo())), arquivoCancelamentoB64);
        final var errosCancelamento = NFSeBarueriLoteBaixarArquivoResult.parseErros(resultadoCancelamento.getLinhas());

        // Se houverem erros, lanço exceção
        Assertions.assertTrue(errosCancelamento.isEmpty(), String.format("Foram encontrados erros no retorno do cancelmaneto da NFS-e: %s", String.join("; ", errosCancelamento)));

    }

    @Disabled
    @Test
    public void testeCancelamentoBarueri() throws Exception {
        final var rps = new NFSeBarueriRPS()
                .setRPSSerie("")
                .setRPSNumero("")
                .setRPSDataEmissao(LocalDate.now())
                .setRPSHoraEmissao(LocalTime.now())
                .setRPSSituacao(NFSeBarueriRPSSituacao.CANCELADO)
                .setRPSMotivoCancelamento(NFSeBarueriRPSCodigoMotivoCancelamento.CANCELAMENTO)
                .setNFSubstituidaNumero("")
                .setNFSubstituidaDataEmissao(LocalDate.of(2025, 12, 3))//
                .setNFSubstituidaDescricaoCancelamento("")
                .setRPSCodigoServicoPrestado("")
                .setRPSLocalPrestacaoServico(NFSeBarueriRPSLocalPrestacaoServico.OUTROS)
                .setRPSServicoPrestadoEmViasPublicas(NFSeBarueriRPSServicoPrestadoViasPublicas.SIM)
                .setRPSEnderecoServicoPrestado("")
                .setRPSEnderecoServicoPrestadoNumero("")
                .setRPSEnderecoServicoPrestadoComplemento("")
                .setRPSEnderecoServicoPrestadoBairro("")
                .setRPSEnderecoServicoPrestadoCidade("")
                .setRPSEnderecoServicoPrestadoUF("")
                .setRPSEnderecoServicoPrestadoCodigoPostal("")
                .setRPSQuantidadeServicoPrestado("")
                .setRPSValorServico(BigDecimal.valueOf(2.99))
                .setRPSTomadorTipo(NFSeBarueriRPSTomadorTipo.BRASILEIRO)
                .setRPSServicoExportacao(NFSeBarueriRPSServicoExportacao.NAO)
                .setRPSTomadorDocumento("")
                .setRPSTomadorRazaoSocial("")
                .setRPSTomadorEndereco("")
                .setRPSTomadorEnderecoNumero("")
                .setRPSTomadorEnderecoComplemento("")
                .setRPSTomadorEnderecoBairro("")
                .setRPSTomadorEnderecoCidade("")
                .setRPSTomadorEnderecoUF("")
                .setRPSTomadorEnderecoCodigoPostal("")
                .setRPSTomadorEmail("")
                .setRPSDiscriminacaoServicos("")
                .setOptanteSimplesNacional(NFSeBarueriRPSOptanteSimplesNacional.NAO_OPTANTE)
                .setRegimeApuracaoTributariaSimplesNacional(NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional.LEGISLACAO_FEDERAL_E_MUNICIPAL_TRIBUTO)
                .setServicoPrestadoCidadeCodigoIBGE("")
                .setTomadorCidadeCodigoIBGE("")
                .setVinculoEntrePartes(NFSeBarueriRPSVinculoEntrePartes.SEM_VINCULO);


        final var arquivoRps = new NFSeBarueriRPSArquivo("", "", "PMB002", LocalDateTime.now(), List.of(rps));
        Files.write(Paths.get("".formatted(arquivoRps.getNomeArquivo())), arquivoRps.geraConteudoArquivo().toByteArray());
        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioCancelamento = new WSRPS(config).NFeLoteEnviarArquivo(new NFSeBarueriLoteEnviarArquivoRequest(arquivoRps));
        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseEnvioCancelamento.toXml());
        Thread.sleep(5000);
        final NFSeBarueriLoteStatusArquivoResponse responseStatusCancelamento = new WSRPS(config).NFeLoteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioCancelamento.getResultado().getProtocoloRemessa()));
        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseStatusCancelamento.toXml());
        Thread.sleep(5000);
        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarCancelamento = new WSRPS(config).NFeLoteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("", "", responseStatusCancelamento.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseBaixarCancelamento.toXml());

    }
}
