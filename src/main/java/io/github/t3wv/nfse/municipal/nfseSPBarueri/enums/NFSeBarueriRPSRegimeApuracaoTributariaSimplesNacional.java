package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional {

    SIMPLES_NACIONAL("1"),
    SIMPLES_NACIONAL_ISSQN_TRIBUTO_MUNICIPAL("2"),
    LEGISLACAO_FEDERAL_E_MUNICIPAL_TRIBUTO("3");


    private final String codigo;

    NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional valueOfCodigo(String codigo) {
        for (NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional regime : NFSeBarueriRPSRegimeApuracaoTributariaSimplesNacional.values()) {
            if (regime.getCodigo().equals(codigo)) {
                return regime;
            }
        }
        return null;
    }
}