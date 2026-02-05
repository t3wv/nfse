package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.transformers;

import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos.TpIndDest;
import org.simpleframework.xml.transform.Transform;

public class NFSeSPSaoPauloTpIndDestTransformer implements Transform<TpIndDest>{
    @Override
    public TpIndDest read(String value) {
        return TpIndDest.valueOfCodigo(value);
    }

    @Override
    public String write(TpIndDest value) {
        return value.getCodigo();
    }
}