package io.github.t3wv.transformers;

import io.github.t3wv.nacional.classes.nfsenacional.*;
import io.github.t3wv.nacional.transformers.*;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.time.*;

public class NFSeRegistryMatcher extends RegistryMatcher {
    public NFSeRegistryMatcher() {
        super.bind(LocalDate.class, new NFSeLocalDateTransformer());
        super.bind(LocalTime.class, new NFSeLocalTimeTransformer());
        super.bind(ZonedDateTime.class, new NFSeDateTimeTransformer());
        super.bind(LocalDateTime.class, new NFSeLocalDateTimeTransformer());
        super.bind(YearMonth.class, new NFSeYearMonthTransformer());
        super.bind(ZonedDateTime.class, new NFSeZonedDateTimeTransformer());

        // NFSe
        super.bind(NFSeSefinNacionalTipoAmbiente.class, new NFSeSefinNacionalTipoAmbienteTransformer());
        super.bind(NFSeSefinNacionalInfDPSTipoEmitente.class, new NFSeSefinNacionalInfDPSTipoEmitenteTransformer());
        super.bind(NFSeSefinNacionalTSCodJustSubst.class, new NFSeSefinNacionalTSCodJustSubstTransformer());
        super.bind(NFSeSefinNacionalInfoPrestadorCodigoNaoNIF.class, new NFSeSefinNacionalInfoPrestadorCodigoNaoNIFTransformer());
        super.bind(NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacional.class, new NFSeSefinNacionalRegimeTributarioSituacaoSimplesNacionalTransformer());
        super.bind(NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimples.class, new NFSeSefinNacionalRegimeTributarioApuracaoAposLimiteSimplesTransformer());
        super.bind(NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacao.class, new NFSeSefinNacionalRegimeTributarioRegimeEspecialTributacaoTransformer());
        super.bind(NFSeSefinNacionalLocPrestOpcaoConsumoServico.class, new NFSeSefinNacionalLocPrestOpcaoConsumoServicoTransformer());
        super.bind(NFSeSefinNacionalComercioExteriorModoPrestacao.class, new NFSeSefinNacionalComercioExteriorModoPrestacaoTransformer());
        super.bind(NFSeSefinNacionalComercioExteriorVinculoEntrePartes.class, new NFSeSefinNacionalComercioExteriorVinculoEntrePartesTransformer());
        super.bind(NFSeSefinNacionalComercioExteriorMecanismoApoioPrestador.class, new NFSeSefinNacionalComercioExteriorMecanismoApoioPrestadorTransformer());
        super.bind(NFSeSefinNacionalComercioExteriorMecanismoApoioTomador.class, new NFSeSefinNacionalComercioExteriorMecanismoApoioTomadorTransformer());
        super.bind(NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBens.class, new NFSeSefinNacionalComercioExteriorMovimentacaoTemporariaBensTransformer());
        super.bind(NFSeSefinNacionalComercioExteriorCompartilharComMDIC.class, new NFSeSefinNacionalComercioExteriorCompartilharComMDICTransformer());
        super.bind(NFSeSefinNacionalLocacaoSublocacaoCategoriaServico.class, new NFSeSefinNacionalLocacaoSublocacaoCategoriaServicoTransformer());
        super.bind(NFSeSefinNacionalLocacaoSublocacaoObjeto.class, new NFSeSefinNacionalLocacaoSublocacaoObjetoTransformer());
        super.bind(NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculo.class, new NFSeSefinNacionalExploracaoRodoviariaCategoriaVeiculoTransformer());
        super.bind(NFSeSefinNacionalExploracaoRodoviariaTipoRodagem.class, new NFSeSefinNacionalExploracaoRodoviariaTipoRodagemTransformer());
        super.bind(NFSeSefinNacionalDocDedRedTipoDeducaoReducao.class, new NFSeSefinNacionalDocDedRedTipoDeducaoReducaoTransformer());
        super.bind(NFSeSefinNacionalTribMunicipalTributacaoISSQN.class, new NFSeSefinNacionalTribMunicipalTributacaoISSQNTransformer());
        super.bind(NFSeSefinNacionalBeneficioMunicipalTipoBeneficio.class, new NFSeSefinNacionalBeneficioMunicipalTipoBeneficioTransformer());
        super.bind(NFSeSefinNacionalExigSuspensaTipoSuspensao.class, new NFSeSefinNacionalExigSuspensaTipoSuspensaoTransformer());
        super.bind(NFSeSefinNacionalTribMunicipalTipoImunidade.class, new NFSeSefinNacionalTribMunicipalTipoImunidadeTransformer());
        super.bind(NFSeSefinNacionalTribMunicipalTipoRetencaoISSQN.class, new NFSeSefinNacionalTribMunicipalTipoRetencaoISSQNTransformer());
        super.bind(NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributaria.class, new NFSeSefinNacionalTribOutrosPisCofinsSituacaoTributariaTransformer());
        super.bind(NFSeSefinNacionalTribOutrosPisCofinsTipoRetencao.class, new NFSeSefinNacionalTribOutrosPisCofinsTipoRetencaoTransformer());
        super.bind(NFSeSefinNacionalInfEventoAmbienteGeracao.class, new NFSeSefinNacionalInfEventoAmbienteGeracaoTransformer());
        super.bind(NFSeSefinNacionalTSCodJustCanc.class, new NFSeSefinNacionalTSCodJustCancTransformer());
        super.bind(NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndef.class, new NFSeSefinNacionalTSCodJustAnaliseFiscalCancIndefTransformer());
    }
}
