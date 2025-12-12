package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalTipoAmbiente;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTipoAmbienteTransformer implements Transform<NFSeSefinNacionalTipoAmbiente>{
    @Override
    public NFSeSefinNacionalTipoAmbiente read(String value) {
        return NFSeSefinNacionalTipoAmbiente.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTipoAmbiente value) {
        return value.getCodigo();
    }
}

