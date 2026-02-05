package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos;

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
