package io.github.t3wv.nfse.nacional.classes.adn;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalMensagemProcessamento;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTipoAmbiente;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.OptionalLong;

/**
 * Resposta das consultas de distribuição de DF-e do ADN
 * ({@code LoteDistribuicaoNSUResponse}).
 *
 * <p>É o mesmo corpo para as respostas de sucesso e para as de negócio (HTTP 400 e 404) — o que
 * separa os casos é o {@link #getStatusProcessamento()}.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeAdnLoteDistribuicaoResponse {

    @JsonProperty("statusProcessamento")
    private NFSeAdnStatusProcessamento statusProcessamento;

    @JsonProperty("loteDFe")
    private List<NFSeAdnDocumentoDistribuido> loteDFe;

    @JsonProperty("alertas")
    private List<NFSeSefinNacionalMensagemProcessamento> alertas;

    @JsonProperty("erros")
    private List<NFSeSefinNacionalMensagemProcessamento> erros;

    @JsonProperty("tipoAmbiente")
    private NFSeSefinNacionalTipoAmbiente tipoAmbiente;

    @JsonProperty("versaoAplicativo")
    private String versaoAplicativo;

    @JsonProperty("dataHoraProcessamento")
    private ZonedDateTime dataHoraProcessamento;

    public NFSeAdnStatusProcessamento getStatusProcessamento() {
        return statusProcessamento;
    }

    public NFSeAdnLoteDistribuicaoResponse setStatusProcessamento(NFSeAdnStatusProcessamento statusProcessamento) {
        this.statusProcessamento = statusProcessamento;
        return this;
    }

    /**
     * Documentos do lote, nunca {@code null} — um lote sem documentos devolve lista vazia.
     */
    public List<NFSeAdnDocumentoDistribuido> getLoteDFe() {
        return this.loteDFe == null ? Collections.emptyList() : this.loteDFe;
    }

    public NFSeAdnLoteDistribuicaoResponse setLoteDFe(List<NFSeAdnDocumentoDistribuido> loteDFe) {
        this.loteDFe = loteDFe;
        return this;
    }

    public List<NFSeSefinNacionalMensagemProcessamento> getAlertas() {
        return this.alertas == null ? Collections.emptyList() : this.alertas;
    }

    public NFSeAdnLoteDistribuicaoResponse setAlertas(List<NFSeSefinNacionalMensagemProcessamento> alertas) {
        this.alertas = alertas;
        return this;
    }

    public List<NFSeSefinNacionalMensagemProcessamento> getErros() {
        return this.erros == null ? Collections.emptyList() : this.erros;
    }

    public NFSeAdnLoteDistribuicaoResponse setErros(List<NFSeSefinNacionalMensagemProcessamento> erros) {
        this.erros = erros;
        return this;
    }

    public NFSeSefinNacionalTipoAmbiente getTipoAmbiente() {
        return tipoAmbiente;
    }

    public NFSeAdnLoteDistribuicaoResponse setTipoAmbiente(NFSeSefinNacionalTipoAmbiente tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
        return this;
    }

    public String getVersaoAplicativo() {
        return versaoAplicativo;
    }

    public NFSeAdnLoteDistribuicaoResponse setVersaoAplicativo(String versaoAplicativo) {
        this.versaoAplicativo = versaoAplicativo;
        return this;
    }

    public ZonedDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public NFSeAdnLoteDistribuicaoResponse setDataHoraProcessamento(ZonedDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
        return this;
    }

    /**
     * Se o lote trouxe documentos para processar.
     */
    public boolean temDocumentos() {
        return NFSeAdnStatusProcessamento.DOCUMENTOS_LOCALIZADOS.equals(this.statusProcessamento)
               && !this.getLoteDFe().isEmpty();
    }

    /**
     * Se não há mais documentos a partir do NSU consultado — critério de parada da drenagem.
     */
    public boolean vazio() {
        return NFSeAdnStatusProcessamento.NENHUM_DOCUMENTO_LOCALIZADO.equals(this.statusProcessamento);
    }

    /**
     * Maior NSU presente no lote, para servir de ponto de partida da próxima chamada.
     *
     * <p>O ADN não devolve um teto de NSU equivalente ao {@code maxNSU} da NF-e: a drenagem é
     * guiada pela própria resposta. Por isso, quem itera deve avançar sempre a partir deste valor
     * e manter uma trava de iterações, para que um lote que repita NSU não vire laço infinito.
     *
     * @return o maior NSU do lote, ou {@link OptionalLong#empty()} se o lote não tem documentos.
     */
    public OptionalLong getMaiorNsu() {
        return this.getLoteDFe().stream()
            .map(NFSeAdnDocumentoDistribuido::getNsu)
            .filter(Objects::nonNull)
            .mapToLong(Long::longValue)
            .max();
    }

    @Override
    public String toString() {
        return "NFSeAdnLoteDistribuicaoResponse{" +
               "statusProcessamento=" + statusProcessamento +
               ", documentos=" + this.getLoteDFe().size() +
               ", alertas=" + this.getAlertas() +
               ", erros=" + this.getErros() +
               ", tipoAmbiente=" + tipoAmbiente +
               ", versaoAplicativo='" + versaoAplicativo + '\'' +
               ", dataHoraProcessamento=" + dataHoraProcessamento +
               '}';
    }
}
