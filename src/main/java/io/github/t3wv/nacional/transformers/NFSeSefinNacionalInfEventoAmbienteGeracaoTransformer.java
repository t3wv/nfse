package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalInfEventoAmbienteGeracao;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalInfEventoAmbienteGeracaoTransformer implements Transform<NFSeSefinNacionalInfEventoAmbienteGeracao>{
    @Override
    public NFSeSefinNacionalInfEventoAmbienteGeracao read(String value) {
        return NFSeSefinNacionalInfEventoAmbienteGeracao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfEventoAmbienteGeracao value) {
        return value.getCodigo();
    }
}