package io.github.t3wv.nfse.nacional;

import io.github.t3wv.nfse.NFSeConfig;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.*;
import io.github.t3wv.nfse.nacional.classes.parametrosmunicipais.consulta.NFSeParametrosMunicipaisConvenio;
import io.github.t3wv.nfse.nacional.classes.parametrosmunicipais.consulta.NFSeParametrosMunicipaisConvenioResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 */
public class WSFacade {

    private final WSParametrosMunicipais wsParametrosMunicipais;
    private final WSDANFSe wsDANFSe;
    private final WSSefinNFSe wsSefinNFSe;

    public WSFacade(final NFSeConfig config) {
        this.wsParametrosMunicipais = new WSParametrosMunicipais(config);
        this.wsDANFSe = new WSDANFSe(config);
        this.wsSefinNFSe = new WSSefinNFSe(config);
    }

    /**
     * Faz o download do DANFSe em PDF utilizando a chave de acesso da NFSe.
     *
     * @param nfseChaveAcesso Chave de acesso da NFSe com 50 dígitos.
     * @return Array de bytes representando o arquivo PDF do DANFSe.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public byte[] downloadNotaPdf(final String nfseChaveAcesso) throws Exception {
        return wsDANFSe.downloadDANFSePdfByChaveAcesso(nfseChaveAcesso);
    }

    /**
     * Faz o download do XML da NFSe utilizando a chave de acesso da NFSe.
     *
     * @param nfseChaveAcesso Chave de acesso da NFSe com 50 dígitos.
     * @return Array de bytes representando o arquivo XML da NFSe.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public String downloadNotaXml(final String nfseChaveAcesso) throws Exception {
        return wsSefinNFSe.buscarNFSeXmlByChaveAcesso(nfseChaveAcesso);
    }

    /**
     * Consulta a alíquota de um serviço específico em um município na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
     * @param codigoServico   Código do serviço para o qual a alíquota será consultada.
     * @return Valor da alíquota do serviço no município.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public BigDecimal consultaAliquotaMunicipioServicoCompetencia(final String codigoMunicipio, final String codigoServico) throws Exception {
        return wsParametrosMunicipais.consultaAliquotaMunicipioServicoCompetencia(codigoMunicipio, codigoServico, LocalDate.now()).getAliq();
    }

    /**
     * Consulta o status do convênio de um município na API de Parâmetros Municipais do Governo Federal.
     *
     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) para o qual o convênio será consultado.
     * @return Objeto {@link NFSeParametrosMunicipaisConvenioResponse} contendo as informações sobre o status do convenio do município
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public NFSeParametrosMunicipaisConvenio consultaConvenioMunicipio(final String codigoMunicipio) throws Exception {
        return wsParametrosMunicipais.consultaConvenioMunicipio(codigoMunicipio).getParametrosConvenio();
    }

    /**
     * Emite uma NFSe utilizando um Documento de Prestação de Serviço (DPS) na API de NFSe da SEFIN Nacional.
     *
     * @param dps Objeto {@link NFSeSefinNacionalDPS} representando o Documento de Prestação de Serviço a ser utilizado para emitir a NFSe.
     * @return Objeto {@link NFSeSefinNacionalNFSePostResponseSucesso} contendo as informações sobre a NFSe emitida.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public Map.Entry<Integer, Object> emitirNFSe(final NFSeSefinNacionalDPS dps) throws Exception {
        return wsSefinNFSe.emitirNFSeByDPS(dps);
    }

    /**
     * Cancela uma NFSe utilizando um evento de cancelamento na API de NFSe da SEFIN Nacional.
     *
     * @param eventoCancelamento Objeto {@link NFSeSefinNacionalPedRegEvt} representando o evento de cancelamento da NFSe.
     * @return Objeto {@link NFSeSefinNacionalNFSePostResponseSucesso} contendo as informações sobre o cancelamento da NFSe.
     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
     */
    public Map.Entry<Integer, Object> cancelarNFSe(final NFSeSefinNacionalPedRegEvt eventoCancelamento) throws Exception {
        return wsSefinNFSe.enviarPedidoRegistroEvento(eventoCancelamento);
    }

    public Map.Entry<Integer, Object> consultaEventosNFSe(final String chave) throws Exception {
        return wsSefinNFSe.solicitarEventos(chave, null, null);
    }

    public Map.Entry<Integer, Object> consultaEventoNFSe(final String chave, final String evento, final Integer sequencial) throws Exception {
        return wsSefinNFSe.solicitarEventos(chave, evento, sequencial);
    }

    /**
     * Busca uma NFS-e (Nota Fiscal de Serviços Eletrônica) pelo número de chave de acesso.
     *
     * <p>A chave de acesso é normalizada antes da consulta, removendo quaisquer caracteres
     * não numéricos. Após a normalização, é validado se a chave possui exatamente 50 dígitos.
     * A requisição é direcionada ao ambiente de homologação ou produção conforme a configuração
     * definida em {@code config.isTeste()}.
     *
     * <p>Os possíveis retornos são:
     * <ul>
     *   <li>{@code 200 OK} – Consulta realizada com sucesso. O valor do par será uma instância
     *       de {@link NFSeSefinNacionalGetResponse} contendo os dados da NFS-e.</li>
     *   <li>{@code 400 Bad Request} – Requisição inválida.</li>
     *   <li>{@code 401 Unauthorized} – Não autorizado.</li>
     *   <li>{@code 403 Forbidden} – Acesso proibido.</li>
     *   <li>{@code 404 Not Found} – NFS-e não encontrada.</li>
     *       Para os casos 400, 401, 403 e 404, o valor do par será uma instância de
     *       {@link NFSeSefinNacionalResponseErro} contendo os detalhes do erro retornado pela API.
     * </ul>
     *
     * @param chaveAcesso chave de acesso da NFS-e, podendo conter caracteres não numéricos
     *                    que serão removidos automaticamente antes da validação e consulta;
     *                    após normalização, deve conter exatamente 50 dígitos numéricos
     * @return um {@link Map.Entry} onde a chave é o código de status HTTP da resposta
     *         ({@link java.net.HttpURLConnection#HTTP_OK} para sucesso, ou o código de erro
     *         correspondente) e o valor é o objeto deserializado da resposta
     *         ({@link NFSeSefinNacionalGetResponse} ou {@link NFSeSefinNacionalResponseErro})
     * @throws IllegalArgumentException se a chave de acesso normalizada não contiver
     *                                  exatamente 50 dígitos numéricos
     * @throws IllegalStateException    se a API retornar um código de status HTTP não tratado
     * @throws Exception                se ocorrer qualquer erro de I/O, URI inválida ou falha
     *                                  na desserialização da resposta
     */
    public Map.Entry<Integer, Object> buscarNFSeByChaveAcesso(final String chaveAcesso) throws Exception {
        return wsSefinNFSe.buscarNFSeByChaveAcesso(chaveAcesso);
    }

//    /**
//     * Consulta os eventos de cancelamento de uma NFSe na API de NFSe da SEFIN Nacional.
//     * Itera os possíveis eventos de cancelamento
//     * Caso encontre um evento correspondente, retorna o xml do evento.
//     *
//     * @param chave da NFSe
//     * @return Objeto {@link NFSeSefinNacionalEvento} contendo as informações sobre o evento de cancelamento da NFSe.
//     * @throws Exception Caso erro.
//     */
//    public Map.Entry<Integer, Object> consultaEventoCancelamentoNFSe(final String chave) throws Exception {
//        for (String codigoEvento : NFSeSefinNacionalInfPedRegEventoTE.EVENTOS_CANCELAMENTO) {
//            NFSeSefinNacionalNFSePostResponseSucesso resposta = consultaEventoNFSe(chave, codigoEvento, 1);
//            if (resposta != null) {
//                return resposta;
//            }
//        }
//        return null;
//    }


    //REVISAR

//    /**
//     * Consulta o histórico de alíquotas de um serviço específico em um município na API de Parâmetros Municipais do Governo Federal.
//     *
//     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
//     * @param codigoServico   Código do serviço para o qual o histórico de alíquotas será consultado.
//     * @return Objeto {@link NFSeParametrosMunicipaisAliquotasResponse} contendo as informações sobre o histórico de alíquotas do serviço no município.
//     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
//     */
//    public NFSeParametrosMunicipaisAliquotasResponse consultaHistoricoAliquotaMunicipioServico(final String codigoMunicipio, final String codigoServico) throws Exception {
//        return wsParametrosMunicipais.consultaHistoricoAliquotaMunicipioServico(codigoMunicipio, codigoServico);
//    }
//
//    /**
//     * Consulta os benefícios fiscais de um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
//     *
//     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o benefício é aplicado.
//     * @param numeroBeneficio Número do benefício fiscal a ser consultado.
//     * @param competencia     Data de competência.
//     * @return Objeto {@link NFSeParametrosMunicipaisBeneficioResponse} contendo as informações sobre o benefício fiscal no município para a competência especificada.
//     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
//     */
//    public NFSeParametrosMunicipaisBeneficioResponse consultaBeneficioMunicipioBeneficioCompetencia(final String codigoMunicipio, final String numeroBeneficio, final LocalDate competencia) throws Exception {
//        return wsParametrosMunicipais.consultaBeneficioMunicipioBeneficioCompetencia(codigoMunicipio, numeroBeneficio, competencia);
//    }
//
//    /**
//     * Consulta os regimes especiais de um serviço específico em um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
//     *
//     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde o serviço é prestado.
//     * @param codigoServico   Código do serviço para o qual os regimes especiais serão consultados.
//     * @param competencia     Data de competência.
//     * @return Objeto {@link NFSeParametrosMunicipaisRegimesEspeciaisResponse} contendo as informações sobre os regimes especiais do serviço no município para a competência especificada.
//     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
//     */
//    public NFSeParametrosMunicipaisRegimesEspeciaisResponse consultaRegimesEspeciaisMunicipioServicoCompetencia(final String codigoMunicipio, final String codigoServico, final LocalDate competencia) throws Exception {
//        return wsParametrosMunicipais.consultaRegimesEspeciaisMunicipioServicoCompetencia(codigoMunicipio, codigoServico, competencia);
//    }
//
//    /**
//     * Consulta as retenções de um município para uma determinada competência na API de Parâmetros Municipais do Governo Federal.
//     *
//     * @param codigoMunicipio Código de 7 dígitos do município (IBGE) onde as retenções são aplicadas.
//     * @param competencia     Data de competência.
//     * @return Objeto {@link NFSeParametrosMunicipaisRetencoesResponse} contendo as informações sobre as retenções no município para a competência especificada.
//     * @throws Exception Se ocorrer um erro durante a requisição ou no processamento da resposta.
//     */
//    public NFSeParametrosMunicipaisRetencoesResponse consultaRetencoesMunicipioCompetencia(final String codigoMunicipio, final LocalDate competencia) throws Exception {
//        return wsParametrosMunicipais.consultaRetencoesMunicipioCompetencia(codigoMunicipio, competencia);
//    }
}