package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalInfDPSTipoEmitente;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfDPSTipoEmitenteTransformer implements Transform<NFSeSefinNacionalInfDPSTipoEmitente>{
    @Override
    public NFSeSefinNacionalInfDPSTipoEmitente read(String value) {
        return NFSeSefinNacionalInfDPSTipoEmitente.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfDPSTipoEmitente value) {
        return value.getCodigo();
    }
}

