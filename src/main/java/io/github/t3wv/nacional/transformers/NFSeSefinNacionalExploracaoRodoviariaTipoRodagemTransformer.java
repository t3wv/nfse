package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalExploracaoRodoviariaTipoRodagem;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalExploracaoRodoviariaTipoRodagemTransformer implements Transform<NFSeSefinNacionalExploracaoRodoviariaTipoRodagem>{
    @Override
    public NFSeSefinNacionalExploracaoRodoviariaTipoRodagem read(String value) {
        return NFSeSefinNacionalExploracaoRodoviariaTipoRodagem.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalExploracaoRodoviariaTipoRodagem value) {
        return value.getCodigo();
    }
}