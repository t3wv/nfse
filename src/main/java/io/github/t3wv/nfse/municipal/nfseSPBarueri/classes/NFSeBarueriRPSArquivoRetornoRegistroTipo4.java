package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriOutrosValoresTipo;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo4 extends NFSeBarueriRPSArquivoRetornoRegistro{
    private final int tipoRegistro;
    private final NFSeBarueriOutrosValoresTipo outrosValores;
    private final BigDecimal valor;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo4(String linha) {
        super(linha);
        this.tipoRegistro = Integer.parseInt(linha.substring(0, 1).trim());
        this.outrosValores = NFSeBarueriOutrosValoresTipo.valueOfCodigo(linha.substring(1, 3).trim());
        this.valor = StringUtils.stripStart(linha.substring(3, 18).trim(), "0").isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(3, 18).trim()).movePointLeft(2);
    }

    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public NFSeBarueriOutrosValoresTipo getOutrosValores() {
        return outrosValores;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
