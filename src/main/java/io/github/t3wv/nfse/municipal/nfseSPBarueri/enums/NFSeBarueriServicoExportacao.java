package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriServicoExportacao {
    SIM("1"),
    NAO("2");

    private final String codigo;

    NFSeBarueriServicoExportacao(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriServicoExportacao valueOfCodigo(String codigo) {
        for (NFSeBarueriServicoExportacao exportacao : NFSeBarueriServicoExportacao.values()) {
            if (exportacao.getCodigo().equals(codigo)) {
                return exportacao;
            }
        }
        return null;
    }
}