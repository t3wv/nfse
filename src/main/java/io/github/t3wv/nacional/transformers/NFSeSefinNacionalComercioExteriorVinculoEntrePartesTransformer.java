package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalComercioExteriorVinculoEntrePartes;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalComercioExteriorVinculoEntrePartesTransformer implements Transform<NFSeSefinNacionalComercioExteriorVinculoEntrePartes>{
    @Override
    public NFSeSefinNacionalComercioExteriorVinculoEntrePartes read(String value) {
        return NFSeSefinNacionalComercioExteriorVinculoEntrePartes.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalComercioExteriorVinculoEntrePartes value) {
        return value.getCodigo();
    }
}

