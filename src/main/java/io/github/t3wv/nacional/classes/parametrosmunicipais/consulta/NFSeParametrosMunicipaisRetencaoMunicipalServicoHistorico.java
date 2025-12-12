package io.github.t3wv.nacional.classes.parametrosmunicipais.consulta;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeParametrosMunicipaisRetencaoMunicipalServicoHistorico {
    @JsonProperty("dtIni")
    private LocalDateTime dtIni;

    @JsonProperty("dtFim")
    private LocalDateTime dtFim;

    public LocalDateTime getDtIni() {
        return dtIni;
    }

    public void setDtIni(LocalDateTime dtIni) {
        this.dtIni = dtIni;
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDateTime dtFim) {
        this.dtFim = dtFim;
    }
}
