package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriOutrosValoresTipo;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo3 extends NFSeBarueriRPSArquivoEnvioRegistro<NFSeBarueriRPSArquivoEnvioRegistroTipo3> {

    static final String TIPO_REGISTRO = "3";
    private NFSeBarueriOutrosValoresTipo outrosValoresTipo;
    private BigDecimal valor;

    public NFSeBarueriOutrosValoresTipo getOutrosValoresTipo() {
        return outrosValoresTipo;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo3 setOutrosValoresTipo(NFSeBarueriOutrosValoresTipo outrosValoresTipo) {
        this.outrosValoresTipo = outrosValoresTipo;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo3 setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoEnvioRegistroTipo3 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoEnvioRegistroTipo3()
                .setOutrosValoresTipo(NFSeBarueriOutrosValoresTipo.valueOfCodigo(linha.substring(1, 3)))
                .setValor(new BigDecimal(StringUtils.trimToEmpty(linha.substring(3, 18))).movePointLeft(2))
                .setErros(parseErros(linha));
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s",
                getTipoRegistro(),
                this.outrosValoresTipo.getCodigo(),
                StringUtils.leftPad(this.valor.setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, '0'));
    }
}
