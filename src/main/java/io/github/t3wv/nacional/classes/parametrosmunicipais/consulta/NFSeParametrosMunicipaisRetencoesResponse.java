package io.github.t3wv.nacional.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRetencoesResponse {
    @JsonProperty("dataHoraProcessamento")
    private LocalDateTime dataHoraProcessamento;

    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("retencoes")
    private NFSeParametrosMunicipaisRetencoes retencoes;

    @JsonProperty("mensagem")
    private String mensagem;

    public LocalDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public Integer getTipoAmbiente() {
        return tipoAmbiente;
    }

    public NFSeParametrosMunicipaisRetencoes getRetencoes() {
        return retencoes;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "NFSeParametrosMunicipaisRetencoesResponse{" +
                "dataHoraProcessamento=" + dataHoraProcessamento +
                ", tipoAmbiente=" + tipoAmbiente +
                ", retencoes=" + retencoes +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }

}
