package io.github.t3wv.nfse.nacional.classes.nfsenacional;


import org.simpleframework.xml.Root;

@Root(name = "tpEmis")
public enum NFSeSefinNacionalInfNFSeTipoEmissao {

    WEB_SERVICE("1", "Emissão com aplicativo do contribuinte (via Web Service)"),
    WEB("2", "Emissão com aplicativo disponibilizado pelo fisco (Web)"),
    APP("3", "Emissão com aplicativo disponibilizado pelo fisco (App)");

    private final String codigo;
    private final String descricao;

    NFSeSefinNacionalInfNFSeTipoEmissao(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSefinNacionalInfNFSeTipoEmissao valueOfCodigo(final String codigo) {
        for (final NFSeSefinNacionalInfNFSeTipoEmissao tipo : NFSeSefinNacionalInfNFSeTipoEmissao.values()) {
            if (tipo.getCodigo().equals(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}