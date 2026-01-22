package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

import java.math.RoundingMode;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo3 extends NFSeBarueriRPSArquivoEnvioRegistro<NFSeBarueriRPSArquivoEnvioRegistroTipo3> {
    static final String TIPO_REGISTRO = "3";
//    private final NFSeBarueriRPSOutrosValores outrosValores;
//
//
//    public NFSeBarueriRPSArquivoEnvioRegistroTipo3(NFSeBarueriRPSOutrosValores outrosValores) {
//        this.outrosValores = outrosValores;
//    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

//    private String getCodigoOutrosValores() {
//        return this.outrosValores.getTipo().getCodigo();
//    }
//
//    private String getOutrosValoresValor() {
//        return StringUtils.leftPad(this.outrosValores.getValor().setScale(2, RoundingMode.HALF_UP).toPlainString().replaceAll("[^0-9]", ""), 15, "0");
//    }

    @Override
    public String toLinha() {
//        final StringBuilder linha = new StringBuilder();
//        linha.append(TIPO_REGISTRO);
//        linha.append(this.getCodigoOutrosValores());
//        linha.append(this.getOutrosValoresValor());
//        return linha.toString();
        return null;
    }

    @Override
    public NFSeBarueriRPSArquivoEnvioRegistroTipo3 fromLinha(String linha) {
        return null;
    }
}
