package io.github.t3wv.municipal.nfseSPSaoPaulo.classes;

public enum TpStatusNFe {


    /**
     * Normal.
     * 
     */
    N,

    /**
     * Cancelada.
     * 
     */
    C,

    /**
     * Extraviada.
     * 
     */
    E;

    public String value() {
        return name();
    }

    public static TpStatusNFe fromValue(String v) {
        return valueOf(v);
    }

}
