package io.github.t3wv.municipal.nfseSPBarueri.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class NFSeBarueriRPSArquivoRegistroTipo1 {

    static final String TIPO_REGISTRO_HEADER = "1";
    private String inscricaoContribuinte;
    private String versaoLayout;
    private LocalDateTime dataGeracao;

    NFSeBarueriRPSArquivoRegistroTipo1(final String inscricaoContribuinte, final String versaoLayout, final LocalDateTime dataGeracao) {
        this.inscricaoContribuinte = inscricaoContribuinte;
        this.versaoLayout = versaoLayout;
        this.dataGeracao = dataGeracao;
    }

    public String getInscricaoContribuinte() {
        return inscricaoContribuinte;
    }

    public NFSeBarueriRPSArquivoRegistroTipo1 setInscricaoContribuinte(String inscricaoContribuinte) {
        this.inscricaoContribuinte = inscricaoContribuinte;
        return this;
    }

    public String getVersaoLayout() {
        return versaoLayout;
    }

    public NFSeBarueriRPSArquivoRegistroTipo1 setVersaoLayout(String versaoLayout) {
        this.versaoLayout = versaoLayout;
        return this;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public NFSeBarueriRPSArquivoRegistroTipo1 setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
        return this;
    }

    public String getIdentificacaoRemessaContribuinte(){
        return dataGeracao.format(new DateTimeFormatterBuilder().appendValueReduced(ChronoField.YEAR, 2, 2, 2000).appendValue(ChronoField.DAY_OF_YEAR, 3).appendValue(ChronoField.SECOND_OF_DAY, 5).toFormatter());
    }

    /* Padrao para evitar problemas de transmissões em curtos periodos de tempo
    * 1 - Tipo da linha - Cabeçalho (1 posição)
    * 2 - Inscrição do municipal do contribuinte (7 posições)
    * 3 - Versão do layout do arquivo (6 posições)
    *
    * Segundo a documentação as últimas 11 posições devem ser preenchidas conforme o contribuinte desejar desde que sejam únicas
    * 4 - Separador de campos 0 (1 posição), Ano (2 posições), dia do ano (3 posições) e segundos do dia (5 posições) da geração do arquivo
    *
    * Totalizando 25 posições
    */
    public String getLinha() {
        return String.format("%s%s%s0%s", TIPO_REGISTRO_HEADER, inscricaoContribuinte, versaoLayout, this.getIdentificacaoRemessaContribuinte());
    }
}
