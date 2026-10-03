package io.github.t3wv.nfse.nacional.transformers;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfNFSeSituacao;
import org.simpleframework.xml.transform.Transform;

/**
 * Converte o código do campo {@code cStat} do XML para {@link NFSeSefinNacionalInfNFSeSituacao} e vice-versa.
 *
 * @author Marcos Lombardi de Andrade
 */
public class NFSeSefinNacionalInfNFSeSituacaoTransformer implements Transform<NFSeSefinNacionalInfNFSeSituacao> {

	@Override
    public NFSeSefinNacionalInfNFSeSituacao read(String value) {
        return NFSeSefinNacionalInfNFSeSituacao.valueOfCodigo(value);
    }

    @Override
    public String write(NFSeSefinNacionalInfNFSeSituacao value) {
        return value.getCodigo();
    }
}
