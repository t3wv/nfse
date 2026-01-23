package io.github.t3wv.nfse.municipal.nfseSPBarueri.transformers;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriArquivoRetornoSituacaoArquivo;
import org.simpleframework.xml.transform.Transform;

public class NFSeBarueriArquivoRetornoSituacaoArquivoTransformer implements Transform<NFSeBarueriArquivoRetornoSituacaoArquivo> {
    @Override
    public NFSeBarueriArquivoRetornoSituacaoArquivo read(String value) {
        return NFSeBarueriArquivoRetornoSituacaoArquivo.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeBarueriArquivoRetornoSituacaoArquivo value) {
        return value.getCodigo();
    }
}