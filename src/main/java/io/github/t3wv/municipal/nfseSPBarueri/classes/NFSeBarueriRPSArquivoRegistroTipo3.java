package io.github.t3wv.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

public class NFSeBarueriRPSArquivoRegistroTipo3 {
    static final String TIPO_REGISTRO_BODY = "3";
    private final NFSeBarueriRPSOutrosValores outrosValores;

    public NFSeBarueriRPSArquivoRegistroTipo3(NFSeBarueriRPSOutrosValores outrosValores) {
        this.outrosValores = outrosValores;
    }

    public String getLinha() {
        final StringBuilder linha = new StringBuilder();
        linha.append(TIPO_REGISTRO_BODY);
        linha.append(this.getCodigoOutrosValores());
        linha.append(this.getOutrosValoresValor());
        return linha.toString();
    }

    private String getCodigoOutrosValores() {
        return this.outrosValores.getTipo().getCodigo();
    }

    private String getOutrosValoresValor() {
        return StringUtils.leftPad(this.outrosValores.getValor().toPlainString().replaceAll("[^0-9]", ""), 15, "0");
    }


}
