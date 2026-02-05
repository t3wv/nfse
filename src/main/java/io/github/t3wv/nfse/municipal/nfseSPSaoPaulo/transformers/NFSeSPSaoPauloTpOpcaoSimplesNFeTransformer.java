package io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.transformers;

import io.github.t3wv.nfse.municipal.nfseSPSaoPaulo.tipos.TpOpcaoSimplesNFe;
import org.simpleframework.xml.transform.Transform;

public class NFSeSPSaoPauloTpOpcaoSimplesNFeTransformer implements Transform<TpOpcaoSimplesNFe>{
    @Override
    public TpOpcaoSimplesNFe read(String value) {
        return TpOpcaoSimplesNFe.valueOfCodigo(value);
    }

    @Override
    public String write(TpOpcaoSimplesNFe value) {
        return value.getCodigo();
    }
}