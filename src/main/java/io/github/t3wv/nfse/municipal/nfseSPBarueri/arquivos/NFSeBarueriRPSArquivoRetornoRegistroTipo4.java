package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriOutrosValoresTipo;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo4 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo4> {

    static final String TIPO_REGISTRO = "4";
    private NFSeBarueriOutrosValoresTipo outrosValores;
    private BigDecimal valor;

    public NFSeBarueriRPSArquivoRetornoRegistroTipo4() {
//        this.outrosValores = NFSeBarueriOutrosValoresTipo.valueOfCodigo(linha.substring(1, 3).trim());
//        this.valor = StringUtils.stripStart(linha.substring(3, 18).trim(), "0").isEmpty() ? BigDecimal.ZERO : new BigDecimal(linha.substring(3, 18).trim()).movePointLeft(2);
    }


    public NFSeBarueriOutrosValoresTipo getOutrosValores() {
        return outrosValores;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo4 fromLinha(String linha) {
        return null;
    }

    @Override
    public String toLinha() {
        return "";
    }
}
