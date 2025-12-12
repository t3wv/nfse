package io.github.t3wv.nacional.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.NFSeSefinNacionalComercioExteriorMecanismoApoioTomador;
import org.simpleframework.xml.transform.Transform;

public class NFSeSefinNacionalComercioExteriorMecanismoApoioTomadorTransformer implements Transform<NFSeSefinNacionalComercioExteriorMecanismoApoioTomador>{
    @Override
    public NFSeSefinNacionalComercioExteriorMecanismoApoioTomador read(String value) {
        return NFSeSefinNacionalComercioExteriorMecanismoApoioTomador.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalComercioExteriorMecanismoApoioTomador value) {
        return value.getCodigo();
    }
}

