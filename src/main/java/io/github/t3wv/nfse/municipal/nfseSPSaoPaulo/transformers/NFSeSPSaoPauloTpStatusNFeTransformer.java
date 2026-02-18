package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.transformers;

import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos.TpStatusNFe;
import org.simpleframework.xml.transform.Transform;

public class NFSeSPSaoPauloTpStatusNFeTransformer implements Transform<TpStatusNFe>{
    @Override
    public TpStatusNFe read(String value) {
        return TpStatusNFe.valueOfCodigo(value);
    }

    @Override
    public String write(TpStatusNFe value) {
        return value.getCodigo();
    }
}