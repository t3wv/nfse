package io.github.t3wv.nfse.nacional.classes.adn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

/**
 * Item do lote devolvido pela distribuição de DF-e do ADN.
 *
 * <p>O conteúdo fiscal em si vem em {@link #getArquivoXml()}, ainda empacotado; use
 * {@link #getXml()} para obter o XML pronto para leitura.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeAdnDocumentoDistribuido {

    @JsonProperty("nsu")
    private Long nsu;

    @JsonProperty("chaveAcesso")
    private String chaveAcesso;

    @JsonProperty("tipoDocumento")
    private NFSeAdnTipoDocumento tipoDocumento;

    @JsonProperty("tipoEvento")
    private String tipoEvento;

    @JsonProperty("arquivoXml")
    private String arquivoXml;

    @JsonProperty("dataHoraGeracao")
    private LocalDateTime dataHoraGeracao;

    public Long getNsu() {
        return nsu;
    }

    public NFSeAdnDocumentoDistribuido setNsu(Long nsu) {
        this.nsu = nsu;
        return this;
    }

    /**
     * Chave de acesso do documento. Atenção: a chave da NFS-e tem <b>50 dígitos</b>, e não 44
     * como a da NF-e.
     */
    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public NFSeAdnDocumentoDistribuido setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
        return this;
    }

    public NFSeAdnTipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public NFSeAdnDocumentoDistribuido setTipoDocumento(NFSeAdnTipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return this;
    }

    /**
     * Código do evento; preenchido apenas quando {@link #getTipoDocumento()} é
     * {@link NFSeAdnTipoDocumento#EVENTO}.
     */
    public String getTipoEvento() {
        return tipoEvento;
    }

    public NFSeAdnDocumentoDistribuido setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
        return this;
    }

    /**
     * Conteúdo do documento como devolvido pelo ADN: <b>base64 de um gzip</b>. Para obter o XML
     * legível use {@link #getXml()}.
     */
    public String getArquivoXml() {
        return arquivoXml;
    }

    public NFSeAdnDocumentoDistribuido setArquivoXml(String arquivoXml) {
        this.arquivoXml = arquivoXml;
        return this;
    }

    public LocalDateTime getDataHoraGeracao() {
        return dataHoraGeracao;
    }

    public NFSeAdnDocumentoDistribuido setDataHoraGeracao(LocalDateTime dataHoraGeracao) {
        this.dataHoraGeracao = dataHoraGeracao;
        return this;
    }

    /**
     * Desempacota {@link #getArquivoXml()} e devolve o XML do documento.
     *
     * <p>O ADN entrega o conteúdo comprimido em gzip antes do base64 — sem descompactar, o
     * resultado é ilegível. O cabeçalho gzip ({@code 0x1F8B}) é conferido antes de inflar, de modo
     * que um eventual retorno sem compressão continue sendo tratado.
     *
     * @return XML do documento, ou {@code null} se não houver conteúdo.
     * @throws IOException Se o conteúdo estiver corrompido.
     */
    public String getXml() throws IOException {
        if (this.arquivoXml == null || this.arquivoXml.isBlank()) {
            return null;
        }
        final byte[] conteudo = Base64.getDecoder().decode(this.arquivoXml);
        if (conteudo.length < 2 || (conteudo[0] & 0xFF) != 0x1F || (conteudo[1] & 0xFF) != 0x8B) {
            return new String(conteudo, StandardCharsets.UTF_8);
        }
        try (final GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(conteudo))) {
            return new String(gzip.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    @Override
    public String toString() {
        return "NFSeAdnDocumentoDistribuido{" +
               "nsu=" + nsu +
               ", chaveAcesso='" + chaveAcesso + '\'' +
               ", tipoDocumento=" + tipoDocumento +
               ", tipoEvento='" + tipoEvento + '\'' +
               ", dataHoraGeracao=" + dataHoraGeracao +
               '}';
    }
}
