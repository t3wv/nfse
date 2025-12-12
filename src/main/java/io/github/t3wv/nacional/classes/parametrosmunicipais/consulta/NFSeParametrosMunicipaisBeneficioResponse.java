package io.github.t3wv.nacional.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisBeneficioResponse {
    @JsonProperty("dataHoraProcessamento")
    private LocalDateTime dataHoraProcessamento;

    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("beneficio")
    private NFSeParametrosMunicipaisBeneficio beneficio;

    @JsonProperty("mensagem")
    private String mensagem;

    public LocalDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public void setDataHoraProcessamento(LocalDateTime dataHoraProcessamento) {
        this.dataHoraProcessamento = dataHoraProcessamento;
    }

    public Integer getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(Integer tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public NFSeParametrosMunicipaisBeneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(NFSeParametrosMunicipaisBeneficio beneficio) {
        this.beneficio = beneficio;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String toString() {
        return "NFSeParametrosMunicipaisBeneficioResponse{dataHoraProcessamento=" + dataHoraProcessamento + ", tipoAmbiente=" + tipoAmbiente + ", beneficio=" + beneficio + ", mensagem='" + mensagem + '\'' + '}';
    }
}
