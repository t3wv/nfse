package io.github.t3wv.nfse.municipal.nfseSCSaoJose.transformers;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.enums.NFSeSCSaoJosePessoaTipo;
import org.simpleframework.xml.transform.Transform;

public class NFSeSCSaoJosePessoaTipoTransformer implements Transform<NFSeSCSaoJosePessoaTipo>{
    @Override
    public NFSeSCSaoJosePessoaTipo read(String value) {
        return NFSeSCSaoJosePessoaTipo.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSCSaoJosePessoaTipo value) {
        return value.getCodigo();
    }
}

