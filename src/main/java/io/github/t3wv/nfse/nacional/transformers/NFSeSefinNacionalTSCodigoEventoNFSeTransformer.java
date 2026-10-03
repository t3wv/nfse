package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTSCodigoEventoNFSe;
import org.simpleframework.xml.transform.Transform;

/**
 * Converte o código do XML para {@link NFSeSefinNacionalTSCodigoEventoNFSe} e vice-versa.
 *
 * @author Marcos Lombardi de Andrade
 */
public class NFSeSefinNacionalTSCodigoEventoNFSeTransformer implements Transform<NFSeSefinNacionalTSCodigoEventoNFSe> {

	@Override
    public NFSeSefinNacionalTSCodigoEventoNFSe read(String value) {
        return NFSeSefinNacionalTSCodigoEventoNFSe.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalTSCodigoEventoNFSe value) {
        return value.getCodigo();
    }
}
