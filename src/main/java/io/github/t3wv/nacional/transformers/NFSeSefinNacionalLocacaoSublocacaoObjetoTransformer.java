package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalLocacaoSublocacaoObjeto;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalLocacaoSublocacaoObjetoTransformer implements Transform<NFSeSefinNacionalLocacaoSublocacaoObjeto>{
    @Override
    public NFSeSefinNacionalLocacaoSublocacaoObjeto read(String value) {
        return NFSeSefinNacionalLocacaoSublocacaoObjeto.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalLocacaoSublocacaoObjeto value) {
        return value.getCodigo();
    }
}

