package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

public enum TpTipoRPS {


    /**
     * Recibo Provisório de Serviços.
     * 
     */
    RPS("RPS"),

    /**
     * Recibo Provisório de Serviços proveniente de Nota Fiscal Conjugada (Mista).
     * 
     */
    RPS_M("RPS-M"),

    /**
     * Cupom.
     * 
     */
    RPS_C("RPS-C");

    private final String value;

    TpTipoRPS(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TpTipoRPS fromValue(String v) {
        for (TpTipoRPS c: TpTipoRPS.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
