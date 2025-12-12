package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacaoTransformer implements Transform<NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao>{
    @Override
    public NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao read(String value) {
        return NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao value) {
        return value.getCodigo();
    }
}

