package io.github.t3wv.nacional.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRegimesEspeciaisResponse {
    @JsonProperty("dataHoraProcessamento")
    private LocalDateTime dataHoraProcessamento;

    @JsonProperty("tipoAmbiente")
    private Integer tipoAmbiente;

    @JsonProperty("regimesEspeciais")
    private Map<String, Map<String, List<NFSeParametrosMunicipaisRegimeEspecial>>> regimesEspeciais;

    @JsonProperty("mensagem")
    private String mensagem;

    public LocalDateTime getDataHoraProcessamento() {
        return dataHoraProcessamento;
    }

    public Integer getTipoAmbiente() {
        return tipoAmbiente;
    }

    public Map<String, Map<String, List<NFSeParametrosMunicipaisRegimeEspecial>>> getRegimesEspeciais() {
        return regimesEspeciais;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "NFSeParametrosMunicipaisRegimesEspeciaisResponse{" +
                "dataHoraProcessamento=" + dataHoraProcessamento +
                ", tipoAmbiente=" + tipoAmbiente +
                ", regimesEspeciais=" + regimesEspeciais +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
