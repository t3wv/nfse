package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriOutrosValoresTipo;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class NFSeBarueriRPSArquivoRetornoRegistroTipo4 extends NFSeBarueriRPSArquivoRetornoRegistro<NFSeBarueriRPSArquivoRetornoRegistroTipo4> {

    public static final String TIPO_REGISTRO = "4";

    private NFSeBarueriOutrosValoresTipo tipoOutrosValores;
    private BigDecimal valor;

    public NFSeBarueriOutrosValoresTipo getTipoOutrosValores() {
        return tipoOutrosValores;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo4 setTipoOutrosValores(NFSeBarueriOutrosValoresTipo tipoOutrosValores) {
        this.tipoOutrosValores = tipoOutrosValores;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public NFSeBarueriRPSArquivoRetornoRegistroTipo4 setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoRetornoRegistroTipo4 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoRetornoRegistroTipo4()
                .setTipoOutrosValores(NFSeBarueriOutrosValoresTipo.valueOfCodigo(linha.substring(1, 3)))
                .setValor(new BigDecimal(StringUtils.trimToEmpty(linha.substring(3, 18))).movePointLeft(2));
    }

    @Override
    public String toLinha() {
        return "%s%s%s".formatted(
                TIPO_REGISTRO,
                tipoOutrosValores.getCodigo(),
                StringUtils.leftPad(valor.movePointRight(2).toPlainString().replace(".", ""), 15, '0'));
    }
}
