package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalTSCodJustCanc;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalTSCodJustCancTransformer implements Transform<NFSeSefinNacionalTSCodJustCanc>{
    @Override
    public NFSeSefinNacionalTSCodJustCanc read(String value) {
        return NFSeSefinNacionalTSCodJustCanc.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSCodJustCanc value) {
        return value.getCodigo();
    }
}

