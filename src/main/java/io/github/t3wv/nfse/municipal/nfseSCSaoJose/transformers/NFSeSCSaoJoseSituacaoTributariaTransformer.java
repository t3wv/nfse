package io.github.t3wv.nfse.municipal.nfseSCSaoJose.transformers;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.enums.NFSeSCSaoJoseSituacaoTributaria;
import org.simpleframework.xml.transform.Transform;

public class NFSeSCSaoJoseSituacaoTributariaTransformer implements Transform<NFSeSCSaoJoseSituacaoTributaria>{
    @Override
    public NFSeSCSaoJoseSituacaoTributaria read(String value) {
        return NFSeSCSaoJoseSituacaoTributaria.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSCSaoJoseSituacaoTributaria value) {
        return value.getCodigo();
    }
}

