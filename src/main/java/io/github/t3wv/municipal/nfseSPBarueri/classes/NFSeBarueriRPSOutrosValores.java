package io.github.t3wv.municipal.nfseSPBarueri.classes;

import io.github.t3wv.municipal.nfseSPBarueri.enums.NFSeBarueriRPSOutrosValoresTipo;

import java.math.BigDecimal;

public class NFSeBarueriRPSOutrosValores {
    private NFSeBarueriRPSOutrosValoresTipo tipo;
    private BigDecimal valor;

    public NFSeBarueriRPSOutrosValoresTipo getTipo() {
        return tipo;
    }

    public NFSeBarueriRPSOutrosValores setTipo(NFSeBarueriRPSOutrosValoresTipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public NFSeBarueriRPSOutrosValores setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }
}
