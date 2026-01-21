package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRPSServicoExportacao;
import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.NFSeBarueriRPSTomadorTipo;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo4 {
    static final String TIPO_REGISTRO_BODY = "4";

    private NFSeBarueriRPS rps;

    public NFSeBarueriRPSArquivoEnvioRegistroTipo4(NFSeBarueriRPS rps) {
        this.rps = rps;
    }

    public String getLinha() {
        final var isTomadorEstrangeiro = NFSeBarueriRPSTomadorTipo.ESTRANGEIRO.equals(this.rps.getTomadorTipo());
        final var isExportacao = NFSeBarueriRPSServicoExportacao.SIM.equals(this.rps.getServicoExportacao());

        final StringBuilder linha = new StringBuilder();
        linha.append(TIPO_REGISTRO_BODY); // 1/1/1
        linha.append(this.rps.getOptanteSimplesNacional() != null ? this.rps.getOptanteSimplesNacional().getCodigo() : " ");// 1/2/2
        linha.append(isExportacao ? this.rps.getRegimeApuracaoTributariaSimplesNacional().getCodigo() : " "); // 1/3/3
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(isExportacao && this.rps.getPaisTomadorEstrangeiro() != null ? this.rps.getPaisTomadorEstrangeiro().getCodigo() : ""), 3)); // 3/4/6
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(!isExportacao ? this.rps.getServicoPrestadoCidadeCodigoIBGE() : ""), 7)); // 7/7/13
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(!isTomadorEstrangeiro ? this.rps.getTomadorCidadeCodigoIBGE() : ""), 7)); // 7/14/20
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(isTomadorEstrangeiro ? this.rps.getNIF() : ""), 40)); // 40/21/60
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(isExportacao || isTomadorEstrangeiro ? this.rps.getCodigoNBS() : ""), 9)); // 9/61/69
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(isTomadorEstrangeiro ? this.rps.getTomadorEnderecoCodigoPostal() : ""), 11)); // 11/70/80
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(isTomadorEstrangeiro ? this.rps.getTomadorEstrangeiroEstadoProvinciaRegiao() : ""), 60)); // 60/81/140
        linha.append(StringUtils.rightPad(isExportacao || isTomadorEstrangeiro ? this.rps.getVinculoEntrePartes().getCodigo() : "", 1)); // 1/141/141
        linha.append(StringUtils.rightPad("", 30)); // 30/142/171 - Reservado para uso futuro
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(isExportacao ? this.rps.getEnderecoServicoPrestadoCodigoPostal() : ""), 11)); // 11/172/182
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(isExportacao ? this.rps.getEstadoProvinciaRegiaoServicoPrestadoExterior() : ""), 60)); // 60/183/242
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getNomeDoEvento()), 255)); // 255/243/497
        linha.append(StringUtils.rightPad(this.rps.getDataInicioEvento() != null ? new SimpleDateFormat("yyyyMMdd").format(this.rps.getDataInicioEvento()) : "", 8)); // 8/498/505
        linha.append(StringUtils.rightPad(this.rps.getDataTerminoEvento() != null ? new SimpleDateFormat("yyyyMMdd").format(this.rps.getDataTerminoEvento()) : "", 8)); // 8/506/513
        linha.append(StringUtils.rightPad(this.rps.getJustificativaCancelamento() != null ? this.rps.getJustificativaCancelamento().getCodigo() : "", 1)); // 1/514/514
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getCodigoIndicadorOperacaoFornecimento()), 6)); // 6/515/520
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getCodigoClassificacaoTributariaIBSCBS()), 6)); // 6/521/526
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getCodigoSituacaoTributariaIBSCBS()), 3)); // 3/527/529
        linha.append(StringUtils.rightPad(this.rps.isOperacaoConsumoPessoal() ? "1" : "0", 1)); // 1/530/530
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getIndicadorDestinatarioServico() != null ? this.rps.getIndicadorDestinatarioServico().getCodigo() : null), 1)); // 1/531/531

        return linha.toString();
    }
}
