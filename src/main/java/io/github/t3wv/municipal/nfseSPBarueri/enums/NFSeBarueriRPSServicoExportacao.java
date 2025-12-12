package io.github.t3wv.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSServicoExportacao {
    SIM("1"),
    NAO("2");

    private final String codigo;

    NFSeBarueriRPSServicoExportacao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
