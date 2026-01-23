package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

public abstract class NFSeBarueriRPSArquivoRetornoRegistro<T> {

    public abstract String getTipoRegistro();

    public abstract T fromLinha(String linha);

    public abstract String toLinha();

    @Override
    public String toString() {
        return this.toLinha();
    }
}
