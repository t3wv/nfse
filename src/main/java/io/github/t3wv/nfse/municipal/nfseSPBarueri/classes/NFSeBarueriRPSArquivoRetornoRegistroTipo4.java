package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRPSOutrosValoresTipo;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo4 {
    private final int tipoRegistro;
    private final NFSeBarueriRPSOutrosValoresTipo outrosValores;
    private final BigDecimal valor;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo4(String linha) {
        this.tipoRegistro = Integer.parseInt(linha.substring(0, 1).trim());
        this.outrosValores = NFSeBarueriRPSOutrosValoresTipo.valueOfCodigo(linha.substring(1, 3).trim());
        this.valor = StringUtils.stripStart(linha.substring(3, 18).trim(), "0").isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(3, 18).trim()).movePointLeft(2);
    }
}
