package io.github.t3wv.nfse.nacional.danfse;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfDPS;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfNFSe;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfNFSeIBSCBS;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoIBSCBS;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalNFSe;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTipoAmbiente;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTribFederal;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTribMunicipal;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTribOutrosPisCofins;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalTribTotal;

import java.util.HashMap;
import java.util.Map;

/**
 * Acesso aos grupos da NFS-e usados pelo DANFSe, com os grupos opcionais podendo ser nulos.
 * <p>
 * O XML só traz o código IBGE dos municípios dos participantes; o nome sai apenas quando o próprio XML o informa para o mesmo
 * código (local de emissão, de prestação e de incidência do ISSQN e do IBS/CBS). Nos demais casos, o DANFSe mostra o código e a
 * UF.
 */
final class DanfseNota {

    private final NFSeSefinNacionalNFSe nfse;
    private final Map<String, String> municipios = new HashMap<>();

    /**
     * @param nfse NFS-e já validada (com infNFSe, DPS e infDPS)
     */
    DanfseNota(final NFSeSefinNacionalNFSe nfse) {
        this.nfse = nfse;
        final var inf = inf();
        final var dps = dps();
        // xLocEmi descreve o cLocEmi, e nao o municipio do endereco do emitente, que pode ser outro
        conhecer(dps.getCodigoMunicipioEmissao(), inf.getLocalEmissao());
        if (dps.getServicoPrestado() != null && dps.getServicoPrestado().getLocalPrestacao() != null) {
            conhecer(dps.getServicoPrestado().getLocalPrestacao().getCodigoMunicipio(), inf.getLocalPrestacao());
        }
        conhecer(inf.getCodigoLocalIncidenciaISSQN(), inf.getLocalIncidenciaISSQN());
        if (ibsCbsNota() != null) {
            conhecer(ibsCbsNota().getcLocalidadeIncid(), ibsCbsNota().getxLocalidadeIncid());
        }
    }

    private void conhecer(final String codigo, final String nome) {
        final var codigoNormalizado = DanfseFormatador.texto(codigo);
        final var nomeNormalizado = DanfseFormatador.texto(nome);
        if (!codigoNormalizado.isEmpty() && !nomeNormalizado.isEmpty()) {
            this.municipios.putIfAbsent(codigoNormalizado, nomeNormalizado);
        }
    }

    /**
     * @param codigoMunicipio código IBGE do município
     * @return nome do município informado no XML para este código, ou null
     */
    String nomeMunicipio(final String codigoMunicipio) {
        return this.municipios.get(DanfseFormatador.texto(codigoMunicipio));
    }

    /**
     * Município e UF de um código IBGE, como "Município / UF"; sem o nome no XML, sai o código no lugar dele.
     *
     * @param codigoMunicipio código IBGE do município
     * @return "Nome / UF", "código / UF" ou um traço
     */
    String municipioUf(final String codigoMunicipio) {
        final var codigo = DanfseFormatador.texto(codigoMunicipio);
        if (codigo.isEmpty()) {
            return DanfseFormatador.SEM_INFORMACAO;
        }
        final var nome = nomeMunicipio(codigo);
        return DanfseFormatador.juntar(" / ", nome == null ? codigo : nome, DanfseFormatador.uf(codigo));
    }

    NFSeSefinNacionalInfNFSe inf() {
        return this.nfse.getInfNFSe();
    }

    NFSeSefinNacionalInfDPS dps() {
        return this.nfse.getInfNFSe().getDPS().getInfDPS();
    }

    /**
     * @return true se a NFS-e foi gerada em produção restrita (tpAmb = 2), quando o DANFSe leva a expressão "NFS-e SEM
     * VALIDADE JURÍDICA" (item 2.4.3)
     */
    boolean homologacao() {
        return dps().getTipoAmbiente() == NFSeSefinNacionalTipoAmbiente.HOMOLOGACAO;
    }

    /**
     * @return chave de acesso com 50 dígitos
     */
    String chaveAcesso() {
        return DanfseFormatador.chaveAcesso(inf().getId());
    }

    /**
     * @return grupo IBS/CBS calculado pelo Sistema Nacional (infNFSe/IBSCBS), ou null
     */
    NFSeSefinNacionalInfNFSeIBSCBS ibsCbsNota() {
        return inf().getIbsCbs();
    }

    /**
     * @return grupo IBS/CBS informado na DPS (infDPS/IBSCBS), ou null
     */
    NFSeSefinNacionalInfoIBSCBS ibsCbsDps() {
        return dps().getInfoIBSCBS();
    }

    NFSeSefinNacionalTribMunicipal tribMun() {
        final var valores = dps().getValores();
        return valores == null || valores.getTributos() == null ? null : valores.getTributos().getTributosMunicipais();
    }

    NFSeSefinNacionalTribFederal tribFed() {
        final var valores = dps().getValores();
        return valores == null || valores.getTributos() == null ? null : valores.getTributos().getTributosNacionais();
    }

    NFSeSefinNacionalTribOutrosPisCofins pisCofins() {
        return tribFed() == null ? null : tribFed().getPiscofins();
    }

    NFSeSefinNacionalTribTotal totTrib() {
        final var valores = dps().getValores();
        return valores == null || valores.getTributos() == null ? null : valores.getTributos().getTotalTributos();
    }
}
