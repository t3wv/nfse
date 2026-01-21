package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class NFSeBarueriRPSArquivoEnvio {
    private final String inscricaoMunicipalContribuinte;
    private final String documentoContribuinte;
    private final String layoutVersao;
    private final LocalDateTime dataGeracao;
    private final List<NFSeBarueriRPS> rpsList;

    public NFSeBarueriRPSArquivoEnvio(final String inscricaoMunicipalContribuinte, final String documentoContribuinte, final String layoutVersao, final LocalDateTime dataGeracao, final List<NFSeBarueriRPS> listaNotas) {
        this.inscricaoMunicipalContribuinte = inscricaoMunicipalContribuinte;
        this.documentoContribuinte = documentoContribuinte;
        this.layoutVersao = layoutVersao;
        this.dataGeracao = dataGeracao;
        this.rpsList = listaNotas;
    }

    private List<String> geraArquivo() {
        final List<String> linhasArquivo = new ArrayList<>();

        //gera o cabecalho
        final NFSeBarueriRPSArquivoEnvioRegistroTipo1 cabecalho = new NFSeBarueriRPSArquivoEnvioRegistroTipo1(this.inscricaoMunicipalContribuinte, this.layoutVersao, this.dataGeracao);
        linhasArquivo.add(cabecalho.getLinha());

        int numeroDeLinhas = 1;
        for (final var rps : this.rpsList) {
            //gero linha do conteudo do arquivo
            final NFSeBarueriRPSArquivoEnvioRegistroTipo2 arquivoRegistroTipo2 = new NFSeBarueriRPSArquivoEnvioRegistroTipo2(rps);
            linhasArquivo.add(arquivoRegistroTipo2.getLinha());
            numeroDeLinhas++;

            if (rps.getOutrosValores() != null && !rps.getOutrosValores().isEmpty()) {
                for (final var outroValor : rps.getOutrosValores()) {
                    final NFSeBarueriRPSArquivoEnvioRegistroTipo3 arquivoRegistroTipo3 = new NFSeBarueriRPSArquivoEnvioRegistroTipo3(outroValor);
                    linhasArquivo.add(arquivoRegistroTipo3.getLinha());
                    numeroDeLinhas++;
                }
            }

            final NFSeBarueriRPSArquivoEnvioRegistroTipo4 arquivoRegistroTipo4 = new NFSeBarueriRPSArquivoEnvioRegistroTipo4(rps);
            linhasArquivo.add(arquivoRegistroTipo4.getLinha());
            numeroDeLinhas++;

            final var arquivoRegistroTipo5Linha = new NFSeBarueriRPSArquivoEnvioRegistroTipo5(rps).getLinha();
            if(arquivoRegistroTipo5Linha.trim().length() > 1) {
                linhasArquivo.add(arquivoRegistroTipo5Linha);
                numeroDeLinhas++;
            }
        }

        //gera o rodape
        final NFSeBarueriRPSArquivoEnvioRegistroTipo9 arquivoRegistroTipo9 = new NFSeBarueriRPSArquivoEnvioRegistroTipo9(numeroDeLinhas + 1, this.getValorTotalServico(), this.getValorTotalNaoIncluidoBasecalculoISS());
        linhasArquivo.add(arquivoRegistroTipo9.getLinha());

        //retorna o arquivo gerados
        return linhasArquivo;
    }

    BigDecimal getValorTotalServico() {
        BigDecimal retValue = BigDecimal.ZERO;
        for (final var rps : this.rpsList) {
            retValue = rps.getValorServico() != null ? retValue.add(rps.getValorServico()) : retValue;
        }
        return retValue;
    }

    BigDecimal getValorTotalNaoIncluidoBasecalculoISS() {
        BigDecimal retValue = BigDecimal.ZERO;
        for (final var rps : this.rpsList) {
            if (rps.getOutrosValores() != null && !rps.getOutrosValores().isEmpty()) {
                retValue = retValue.add(rps.getOutrosValores().stream()
                        .map(NFSeBarueriRPSOutrosValores::getValor)
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        }
        return retValue;
    }

    public String getInscricaoMunicipalContribuinte() {
        return inscricaoMunicipalContribuinte;
    }

    public String getDocumentoContribuinte() {
        return documentoContribuinte;
    }

    public String getNomeArquivo() {
        return String.format("RPS_%s.txt", dataGeracao.format(DateTimeFormatter.ofPattern("DDDAAAAAAAA")));
    }

    public byte[] geraConteudoArquivo() throws Exception {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try(Writer writer = new OutputStreamWriter(baos, StandardCharsets.ISO_8859_1)) {
                for (final String linha : this.geraArquivo()) {
                    writer.write(linha);
                    writer.write((char) 13);
                    writer.write((char) 10);
                }
                writer.flush();
            }
            return baos.toByteArray();
        }
    }

    public String getArquivoBase64() throws Exception {
        return Base64.getEncoder().encodeToString(this.geraConteudoArquivo());
    }
}
