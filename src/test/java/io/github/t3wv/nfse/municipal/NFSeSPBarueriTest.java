package io.github.t3wv.nfse.municipal;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.WSRPS;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.classes.*;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.*;
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
import java.util.stream.Collectors;

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
                .setRpsSerie("")
                .setRpsNumero("")
                .setRpsDataEmissao(LocalDate.now())
                .setRpsHoraEmissao(LocalTime.now())
                .setRpsSituacao(NFSeBarueriRPSSituacao.ENVIADO)
                .setCodigoServicoPrestado("")
                .setLocalPrestacaoServico(NFSeBarueriRPSLocalPrestacaoServico.OUTROS)
                .setServicoPrestadoEmViasPublicas(NFSeBarueriRPSServicoPrestadoViasPublicas.SIM)
                .setEnderecoServicoPrestado("")
                .setEnderecoServicoPrestadoNumero("")
                .setEnderecoServicoPrestadoComplemento("")
                .setEnderecoServicoPrestadoBairro("")
                .setEnderecoServicoPrestadoCidade("")
                .setEnderecoServicoPrestadoUF("")
                .setEnderecoServicoPrestadoCodigoPostal("")
                .setQuantidadeServicoPrestado("")
                .setValorServico(BigDecimal.valueOf(0.01))
                .setTomadorTipo(NFSeBarueriRPSTomadorTipo.BRASILEIRO)
                .setServicoExportacao(NFSeBarueriRPSServicoExportacao.NAO)
                .setTomadorDocumento("")
                .setTomadorRazaoSocial("")
                .setTomadorEndereco("")
                .setTomadorEnderecoNumero("")
                .setTomadorEnderecoComplemento("")
                .setTomadorEnderecoBairro("")
                .setTomadorEnderecoCidade("")
                .setTomadorEnderecoUF("")
                .setTomadorEnderecoCodigoPostal("")
                .setTomadorEmail("")
                .setDiscriminacaoServicos("")
                .setOptanteSimplesNacional(NFSeBarueriRPSOptanteSimplesNacional.NAO_OPTANTE)
                .setRegimeApuracaoTributariaSimplesNacional(NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional.LEGISLACAO_FEDERAL_E_MUNICIPAL_TRIBUTO)
                .setServicoPrestadoCidadeCodigoIBGE("")
                .setTomadorCidadeCodigoIBGE("")
                .setVinculoEntrePartes(NFSeBarueriRPSVinculoEntrePartes.SEM_VINCULO);

        final var arquivoRps = new NFSeBarueriRPSArquivoEnvio("", "", "PMB003", LocalDateTime.now(), List.of(rps));
        Files.write(Paths.get("".formatted(arquivoRps.getNomeArquivo())), arquivoRps.geraConteudoArquivo());

        // Envio o lote para emissão
        NFSeBarueriLoteEnviarArquivoRequest request = new NFSeBarueriLoteEnviarArquivoRequest(arquivoRps);
        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioEmissao = new WSRPS(config).loteEnviarArquivo(request);
        Files.write(Paths.get("".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())), arquivoRps.geraConteudoArquivo());
        Thread.sleep(2000);

        // Consulto o status do arquivo enviado
        final NFSeBarueriLoteStatusArquivoResponse responseStatusEmissao = new WSRPS(config).loteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioEmissao.getResultado().getProtocoloRemessa()));
        Files.writeString(Paths.get("".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())), responseStatusEmissao.toXml());
        Thread.sleep(2000);

        // Baixo o arquivo de retorno da emissão
        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarEmissao = new WSRPS(config).loteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("", "", responseStatusEmissao.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
        Files.writeString(Paths.get("".formatted(responseEnvioEmissao.getResultado().getProtocoloRemessa())), responseBaixarEmissao.toXml());

        final NFSeBarueriLoteBaixarArquivoResult resultadoEmissao = responseBaixarEmissao.getResultado();
        final byte[] arquivoB64 = Base64.getDecoder().decode(resultadoEmissao.getArquivoRPSBase64());
        Files.write(Paths.get(String.format("",arquivoRps.getNomeArquivo())), arquivoB64);
        final var arquivoRetorno = resultadoEmissao.getArquivoRetorno();
        final var errosEmissao = resultadoEmissao.getErros();

        // Se houverem erros, lanço exceção
        Assertions.assertTrue(errosEmissao.isEmpty(), String.format("Foram encontrados erros no retorno da emissao da NFS-e: %s", errosEmissao.entrySet().stream().map((entry) -> "Linha %s - Código %s: %s -  %s".formatted(entry.getKey(), entry.getValue().getCodigo(), entry.getValue().getDescricao(), entry.getValue().getSolucao())).collect(Collectors.joining("; "))));

        // Caso não haja erros, extraio os dados relevantes da nota e prossigo com o cancelamento
        final var serieNf = arquivoRetorno.getNotas().getFirst().getSerieNFe();
        final var numeroNf = arquivoRetorno.getNotas().getFirst().getNumeroNFe();
        final var chaveNFSeNacional = arquivoRetorno.getNotas().getFirst().getChaveAcessoNFSeNacional();

        // Realizo o cancelamento da nota através do mesmo objeto RPS, alterando os campos necessários para o cancelamento
        rps.setRpsSituacao(NFSeBarueriRPSSituacao.CANCELADO)
                .setMotivoCancelamento(NFSeBarueriRPSCodigoMotivoCancelamento.CANCELAMENTO)
                .setNotaSubstituidaDescricaoCancelamento("Teste de cancelamento")
                .setNotaSubstituidaNumero(String.valueOf(numeroNf))
                .setNotaSerie(serieNf)
                .setNotaSubstituidaDataEmissao(rps.getRpsDataEmissao())//
                .setCodigoServicoPrestado("101001220")
                .setChaveNFSeReferenciada(chaveNFSeNacional);

        // Gero o arquivo no formato que deve ser enviado dentro do SOAP para o cancelamento
        final var arquivoRpsCancelamento = new NFSeBarueriRPSArquivoEnvio("", "", "PMB003", LocalDateTime.now(), List.of(rps));

        // Envio o lote para cancelamento
        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioCancelamento = new WSRPS(config).loteEnviarArquivo(new NFSeBarueriLoteEnviarArquivoRequest(arquivoRpsCancelamento));
        Thread.sleep(5000);

        // Consulto o status do arquivo de cancelamento enviado
        final NFSeBarueriLoteStatusArquivoResponse responseStatusCancelamento = new WSRPS(config).loteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioCancelamento.getResultado().getProtocoloRemessa()));
        Thread.sleep(5000);

        // Baixo o arquivo de retorno do cancelamento
        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarCancelamento = new WSRPS(config).loteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("", "", responseStatusCancelamento.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
        final NFSeBarueriLoteBaixarArquivoResult resultadoCancelamento = responseBaixarCancelamento.getResultado();
        final byte[] arquivoCancelamentoB64 = Base64.getDecoder().decode(resultadoCancelamento.getArquivoRPSBase64());
        Files.write(Paths.get(String.format("",arquivoRps.getNomeArquivo())), arquivoCancelamentoB64);
        final var errosCancelamento = resultadoCancelamento.getErros();

        // Se houverem erros, lanço exceção
        Assertions.assertTrue(errosCancelamento.isEmpty(), String.format("Foram encontrados erros no retorno do cancelmaneto da NFS-e: %s", errosCancelamento.entrySet().stream().map((entry) -> "Linha %s - Código %s: %s -  %s".formatted(entry.getKey(), entry.getValue().getCodigo(), entry.getValue().getDescricao(), entry.getValue().getSolucao())).collect(Collectors.joining("; "))));
    }

    @Disabled
    @Test
    public void testeCancelamentoBarueri() throws Exception {
        final var rps = new NFSeBarueriRPS()
                .setRpsSerie("")
                .setRpsNumero("")
                .setRpsDataEmissao(LocalDate.now())
                .setRpsHoraEmissao(LocalTime.now())
                .setRpsSituacao(NFSeBarueriRPSSituacao.CANCELADO)
                .setMotivoCancelamento(NFSeBarueriRPSCodigoMotivoCancelamento.CANCELAMENTO)
                .setNotaSubstituidaNumero("")
                .setNotaSubstituidaDataEmissao(LocalDate.of(2025, 12, 3))//
                .setNotaSubstituidaDescricaoCancelamento("")
                .setCodigoServicoPrestado("")
                .setLocalPrestacaoServico(NFSeBarueriRPSLocalPrestacaoServico.OUTROS)
                .setServicoPrestadoEmViasPublicas(NFSeBarueriRPSServicoPrestadoViasPublicas.SIM)
                .setEnderecoServicoPrestado("")
                .setEnderecoServicoPrestadoNumero("")
                .setEnderecoServicoPrestadoComplemento("")
                .setEnderecoServicoPrestadoBairro("")
                .setEnderecoServicoPrestadoCidade("")
                .setEnderecoServicoPrestadoUF("")
                .setEnderecoServicoPrestadoCodigoPostal("")
                .setQuantidadeServicoPrestado("")
                .setValorServico(BigDecimal.valueOf(2.99))
                .setTomadorTipo(NFSeBarueriRPSTomadorTipo.BRASILEIRO)
                .setServicoExportacao(NFSeBarueriRPSServicoExportacao.NAO)
                .setTomadorDocumento("")
                .setTomadorRazaoSocial("")
                .setTomadorEndereco("")
                .setTomadorEnderecoNumero("")
                .setTomadorEnderecoComplemento("")
                .setTomadorEnderecoBairro("")
                .setTomadorEnderecoCidade("")
                .setTomadorEnderecoUF("")
                .setTomadorEnderecoCodigoPostal("")
                .setTomadorEmail("")
                .setDiscriminacaoServicos("")
                .setOptanteSimplesNacional(NFSeBarueriRPSOptanteSimplesNacional.NAO_OPTANTE)
                .setRegimeApuracaoTributariaSimplesNacional(NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional.LEGISLACAO_FEDERAL_E_MUNICIPAL_TRIBUTO)
                .setServicoPrestadoCidadeCodigoIBGE("")
                .setTomadorCidadeCodigoIBGE("")
                .setVinculoEntrePartes(NFSeBarueriRPSVinculoEntrePartes.SEM_VINCULO);


        final var arquivoRps = new NFSeBarueriRPSArquivoEnvio("", "", "PMB002", LocalDateTime.now(), List.of(rps));
        Files.write(Paths.get("".formatted(arquivoRps.getNomeArquivo())), arquivoRps.geraConteudoArquivo());
        final NFSeBarueriLoteEnviarArquivoResponse responseEnvioCancelamento = new WSRPS(config).loteEnviarArquivo(new NFSeBarueriLoteEnviarArquivoRequest(arquivoRps));
        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseEnvioCancelamento.toXml());
        Thread.sleep(5000);
        final NFSeBarueriLoteStatusArquivoResponse responseStatusCancelamento = new WSRPS(config).loteStatusArquivo(new NFSeBarueriLoteStatusArquivoRequest("", "", responseEnvioCancelamento.getResultado().getProtocoloRemessa()));
        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseStatusCancelamento.toXml());
        Thread.sleep(5000);
        final NFSeBarueriLoteBaixarArquivoResponse responseBaixarCancelamento = new WSRPS(config).loteBaixarArquivo(new NFSeBarueriLoteBaixarArquivoRequest("", "", responseStatusCancelamento.getResultado().getListaNfeArquivosRPS().getNomeArqRetorno()));
        Files.writeString(Paths.get("".formatted(responseEnvioCancelamento.getResultado().getProtocoloRemessa())), responseBaixarCancelamento.toXml());

    }
}
