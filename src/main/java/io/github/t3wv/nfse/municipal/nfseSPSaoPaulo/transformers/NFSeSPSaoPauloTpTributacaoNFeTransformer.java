package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.transformers;

import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos.TpTributacaoNFe;
import org.simpleframework.xml.transform.Transform;

public class NFSeSPSaoPauloTpTributacaoNFeTransformer implements Transform<TpTributacaoNFe>{
    @Override
    public TpTributacaoNFe read(String value) {
        return TpTributacaoNFe.valueOfCodigo(value);
    }

    @Override
    public String write(TpTributacaoNFe value) {
        return value.getCodigo();
    }
}