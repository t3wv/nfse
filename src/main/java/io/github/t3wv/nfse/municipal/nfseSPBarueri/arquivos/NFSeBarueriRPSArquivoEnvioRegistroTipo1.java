package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.apache.commons.lang3.StringUtils;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo1 extends NFSeBarueriRPSArquivoEnvioRegistro<NFSeBarueriRPSArquivoEnvioRegistroTipo1> {

    public static final String TIPO_REGISTRO = "1";

    private String inscricaoContribuinte;
    private String versaoLayout;
    private String identificacaoRemessaContribuinte;

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    public String getInscricaoContribuinte() {
        return inscricaoContribuinte;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo1 setInscricaoContribuinte(String inscricaoContribuinte) {
        this.inscricaoContribuinte = inscricaoContribuinte;
        return this;
    }

    public String getVersaoLayout() {
        return versaoLayout;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo1 setVersaoLayout(String versaoLayout) {
        this.versaoLayout = versaoLayout;
        return this;
    }

    public String getIdentificacaoRemessaContribuinte() {
        return identificacaoRemessaContribuinte;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo1 setIdentificacaoRemessaContribuinte(String identificacaoRemessaContribuinte) {
        this.identificacaoRemessaContribuinte = identificacaoRemessaContribuinte;
        return this;
    }

    @Override
    public NFSeBarueriRPSArquivoEnvioRegistroTipo1 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoEnvioRegistroTipo1()
                .setInscricaoContribuinte(StringUtils.trimToEmpty(linha.substring(1, 8)))
                .setVersaoLayout(StringUtils.trimToEmpty(linha.substring(8, 14)))
                .setIdentificacaoRemessaContribuinte(StringUtils.trimToEmpty(linha.substring(14, 25)))
                .setErros(parseErros(linha));
    }

    @Override
    public String toLinha() {
        return String.format("%s%s%s%s",
                getTipoRegistro(),
                trataString(inscricaoContribuinte, 7),
                trataString(versaoLayout, 6),
                trataString(identificacaoRemessaContribuinte, 11));
    }
}
