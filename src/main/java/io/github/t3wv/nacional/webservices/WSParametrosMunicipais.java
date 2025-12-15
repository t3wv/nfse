package io.github.t3wv.nacional.webservices;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.NFSeHttpClient;
import io.github.t3wv.NFSeLogger;
import io.github.t3wv.NFSeObjectMapper;
import io.github.t3wv.nacional.classes.parametrosmunicipais.consulta.*;

import java.net.URI;
import java.time.LocalDate;

public class WSParametrosMunicipais implements NFSeLogger {

    public static final String URL_BASE_PRODUCAO = "https://adn.nfse.gov.br/parametrizacao";
    public static final String URL_BASE_HOMOLOGACAO = "https://adn.producaorestrita.nfse.gov.br/parametrizacao";

    private final NFSeObjectMapper objectMapper = new NFSeObjectMapper();
    private final NFSeConfig config;


    public WSParametrosMunicipais(final NFSeConfig config) {
        this.config = config;
    }

    /**
     * Consulta o status do convênio de um município na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) para o qual o convênio será consultado.
     * @return Objeto {@link NFSeParametrosMunicipaisConvenioResponse} contendo as informações sobre o status do convenio do município
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisConvenioResponse consultaConvenioMunicipio(final String codigoMunicipio) throws Exception {
        //normaliza e valida o codigo do municipio
        final var codigoMunicipioNumerico = codigoMunicipio.replaceAll("\\D", "");
        if (!codigoMunicipioNumerico.matches("\\d{7}")) {
            throw new IllegalArgumentException("O código do município deve conter exatamente 7 dígitos numéricos (IBGE)!");
        }
        final var url = new URI(String.format("%s/%s/convenio", this.config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO, codigoMunicipioNumerico));
        final var response = new NFSeHttpClient(config).sendGetRequest(url);
        this.getLogger().info("Response: {}", response);
        if (response.statusCode() != 200) {
            throw new Exception("Consulta de parametros municipais retornou erro '%d' para o municipio '%s'!".formatted(response.statusCode(), codigoMunicipioNumerico));
        } else {
            return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisConvenioResponse.class);
        }
    }

    /**
     * Consulta a alíquota de um serviço específico em um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual a alíquota será consultada.
     * @param competencia     Data de competência no formato LocalDate (ano, mês, dia).
     * @return Objeto {@link NFSeParametrosMunicipaisAliquotasResponse} contendo as informações sobre a alíquota do serviço no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisAliquota consultaAliquotaMunicipioServicoCompetencia(final String codigoMunicipio, final String codigoServico, final LocalDate competencia) throws Exception {
        //normaliza e valida o codigo do municipio
        final var codigoMunicipioNumerico = codigoMunicipio.replaceAll("\\D", "");
        if (!codigoMunicipioNumerico.matches("\\d{7}")) {
            throw new IllegalArgumentException("O código do município deve conter exatamente 7 dígitos numéricos (IBGE)!");
        }

        //normaliza e valida o codigo do serviço, para que tenha 6 ou 9 dígitos numéricos
        final var codigoServicoNumerico = codigoServico.replaceAll("\\D", "");
        if (!codigoServicoNumerico.matches("\\d{6}|\\d{9}")) {
            throw new IllegalArgumentException("O código do serviço deve conter 6 ou 9 dígitos numéricos!");
        }
        final var codigoServicoNormalizado = codigoServicoNumerico.length() == 6 ? codigoServicoNumerico + "000" : codigoServicoNumerico;
        final var codigoServicoFormatado = String.format("%s.%s.%s.%s", codigoServicoNormalizado.substring(0, 2), codigoServicoNormalizado.substring(2, 4), codigoServicoNormalizado.substring(4, 6), codigoServicoNormalizado.substring(6, 9));


        //normaliza e valida a competencia
        final var competenciaNormalizada = competencia != null ? competencia : LocalDate.now();
        final var competenciaFormatada = formataCompetencia(competenciaNormalizada);

        //faz a consulta
        final var url = new URI(String.format("%s/%s/%s/%s/aliquota", this.config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO, codigoMunicipioNumerico, codigoServicoFormatado, competenciaFormatada));
        final var response = new NFSeHttpClient(config).sendGetRequest(url);
        this.getLogger().info("Response: {}", response);

        if (response.statusCode() != 200) {
            throw new Exception("Consulta de alíquotas retornou erro '%d' para o municipio '%s', serviço '%s', competência '%s'!".formatted(response.statusCode(), codigoMunicipioNumerico, codigoServicoFormatado, competenciaFormatada));
        } else {
            final var nfSeParametrosMunicipaisAliquotasResponse = this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisAliquotasResponse.class);
            return nfSeParametrosMunicipaisAliquotasResponse.getAliquotas() != null && nfSeParametrosMunicipaisAliquotasResponse.getAliquotas().containsKey(codigoServicoFormatado) ?
                    nfSeParametrosMunicipaisAliquotasResponse.getAliquotas().get(codigoServicoFormatado).getFirst() :
                    null;
        }
    }

    /**
     * Consulta o histórico de alíquotas de um serviço específico em um município na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual o histórico de alíquotas será consultado.
     * @return Objeto {@link NFSeParametrosMunicipaisAliquotasResponse} contendo as informações sobre o histórico de alíquotas do serviço no município.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisAliquotasResponse consultaHistoricoAliquotaMunicipioServico(final String codigoMunicipio, final String codigoServico) throws Exception {
        final var url = new URI(String.format("%s/%s/%s/historicoaliquotas", this.config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO, codigoMunicipio, codigoServico));
        final var response = new NFSeHttpClient(config).sendGetRequest(url);
        this.getLogger().info(response.body());
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisAliquotasResponse.class);
    }

    /**
     * Consulta os benefícios fiscais de um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o benefício é aplicado.
     * @param numeroBeneficio Número do benefício fiscal a ser consultado.
     * @param competencia     Data de competência no formato LocalDate (ano, mês, dia).
     * @return Objeto {@link NFSeParametrosMunicipaisBeneficioResponse} contendo as informações sobre o benefício fiscal no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisBeneficioResponse consultaBeneficioMunicipioBeneficioCompetencia(final String codigoMunicipio, final String numeroBeneficio, final LocalDate competencia) throws Exception {
        final var competenciaFormatada = formataCompetencia(competencia);
        final var url = new URI(String.format("%s/%s/%s/%s/beneficio", this.config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO, codigoMunicipio, numeroBeneficio, competenciaFormatada));
        final var response = new NFSeHttpClient(config).sendGetRequest(url);
        this.getLogger().info(response.body());
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisBeneficioResponse.class);
    }

    /**
     * Consulta os regimes especiais de um serviço específico em um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual os regimes especiais serão consultados.
     * @param competencia     Data de competência no formato LocalDate (ano, mês, dia).
     * @return Objeto {@link NFSeParametrosMunicipaisRegimesEspeciaisResponse} contendo as informações sobre os regimes especiais do serviço no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisRegimesEspeciaisResponse consultaRegimesEspeciaisMunicipioServicoCompetencia(final String codigoMunicipio, final String codigoServico, final LocalDate competencia) throws Exception {
        final var competenciaFormatada = formataCompetencia(competencia);
        final var url = new URI(String.format("%s/%s/%s/%s/regimes_especiais", this.config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO, codigoMunicipio, codigoServico, competenciaFormatada));
        final var response = new NFSeHttpClient(config).sendGetRequest(url);
        this.getLogger().info(response.body());
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisRegimesEspeciaisResponse.class);
    }

    /**
     * Consulta as retenções de um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde as retenções são aplicadas.
     * @param competencia     Data de competência no formato LocalDate (ano, mês, dia).
     * @return Objeto {@link NFSeParametrosMunicipaisRetencoesResponse} contendo as informações sobre as retenções no município para a competência especificada.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisRetencoesResponse consultaRetencoesMunicipioCompetencia(final String codigoMunicipio, final LocalDate competencia) throws Exception {
        final var competenciaFormatada = formataCompetencia(competencia);
        final var url = new URI(String.format("%s/%s/%s/retencoes", this.config.isTeste() ? URL_BASE_HOMOLOGACAO : URL_BASE_PRODUCAO, codigoMunicipio, competenciaFormatada));
        final var response = new NFSeHttpClient(config).sendGetRequest(url);
        this.getLogger().info(response.body());
        return this.objectMapper.convertValue(this.objectMapper.readTree(response.body()), NFSeParametrosMunicipaisRetencoesResponse.class);
    }


    private static String formataCompetencia(LocalDate competencia) {
        return String.format("%02d-%02d-%04d", competencia.getMonthValue(), competencia.getDayOfMonth(), competencia.getYear());
    }

}
