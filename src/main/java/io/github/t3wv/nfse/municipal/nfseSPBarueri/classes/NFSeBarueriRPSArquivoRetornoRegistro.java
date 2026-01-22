package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

import static io.github.t3wv.nfse.municipal.nfseSPBarueri.classes.NFSeBarueriLoteBaixarArquivoResult.FORMATO_DATA;

public abstract class NFSeBarueriRPSArquivoRetornoRegistro {

    private final String linha;

    public NFSeBarueriRPSArquivoRetornoRegistro(String linha) {
        this.linha = linha;
    }

    public String getLinha() {
        return linha;
    }
}
