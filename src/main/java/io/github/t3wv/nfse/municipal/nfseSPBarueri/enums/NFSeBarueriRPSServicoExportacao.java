package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

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

    public static NFSeBarueriRPSServicoExportacao valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSServicoExportacao exportacao : NFSeBarueriRPSServicoExportacao.values()) {
            if (exportacao.getCodigo().equals(codigo)) {
                return exportacao;
            }
        }
        return null;
    }
}