package io.github.t3wv.nfse.municipal.nfseSPBarueri.enums;

public enum NFSeBarueriRegimeApuracaoTributariaSimplesNacional {

    SIMPLES_NACIONAL("1"),
    SIMPLES_NACIONAL_ISSQN_TRIBUTO_MUNICIPAL("2"),
    LEGISLACAO_FEDERAL_E_MUNICIPAL_TRIBUTO("3");


    private final String codigo;

    NFSeBarueriRegimeApuracaoTributariaSimplesNacional(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static NFSeBarueriRegimeApuracaoTributariaSimplesNacional valueOfCodigo(String codigo) {
        for (NFSeBarueriRegimeApuracaoTributariaSimplesNacional regime : NFSeBarueriRegimeApuracaoTributariaSimplesNacional.values()) {
            if (regime.getCodigo().equals(codigo)) {
                return regime;
            }
        }
        return null;
    }
}