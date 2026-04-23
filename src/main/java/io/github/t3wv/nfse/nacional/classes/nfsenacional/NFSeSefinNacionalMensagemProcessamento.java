package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NFSeSefinNacionalMensagemProcessamento {
    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("complemento")
    private String complemento;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "NFSeSefinNacionalPostMensagemProcessamento{" +
               ", codigo='" + codigo + '\'' +
               ", descricao='" + descricao + '\'' +
               ", complemento='" + complemento + '\'' +
               '}';
    }
}
