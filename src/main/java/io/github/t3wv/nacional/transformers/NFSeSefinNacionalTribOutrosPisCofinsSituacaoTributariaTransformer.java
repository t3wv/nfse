package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributariaTransformer implements Transform<NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria>{
    @Override
    public NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria read(String value) {
        return NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria value) {
        return value.getCodigo();
    }
}