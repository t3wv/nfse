package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfNFSeProcessoEmissao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfNFSeProcessoEmissaoTransformer implements Transform<NFSeSefinNacionalInfNFSeProcessoEmissao>{
    @Override
    public NFSeSefinNacionalInfNFSeProcessoEmissao read(String value) {
        return NFSeSefinNacionalInfNFSeProcessoEmissao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfNFSeProcessoEmissao value) {
        return value.getCodigo();
    }
}

