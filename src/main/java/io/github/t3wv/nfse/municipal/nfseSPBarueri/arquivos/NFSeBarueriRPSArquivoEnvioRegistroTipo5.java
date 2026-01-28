package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import io.github.t3wv.nfse.municipal.nfseSPBarueri.enums.*;
import org.apache.commons.lang3.StringUtils;

public class NFSeBarueriRPSArquivoEnvioRegistroTipo5 extends NFSeBarueriRPSArquivoEnvioRegistro<NFSeBarueriRPSArquivoEnvioRegistroTipo5> {

    public static final String TIPO_REGISTRO = "5";

    private String codigoClassificacaoCreditoPresumidoIBSCBS;
    private NFSeBarueriEnteGovernamentalTipo tipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica;
    private NFSeBarueriEnteGovernamentalOperacaoTipo tipoOperacaoEnteGovernamentalOuSobreBensImoveis;
    private String chaveNFSeReferenciada;
    private String codigoNCM;
    private String descricaoBemMovelObjetoLocacao;
    private Integer quantidadeBemMovelObjetoLocacao;
    private NFSeBarueriIndicadorOperacaoDoacao indicadorOperacaoDoacao;
    private Boolean destinatarioServicoEstrangeiro;
    private String cpfCnpjDestinatarioServico;
    private String razaoSocialDestinatarioServico;
    private String enderecoLogradouroDestinatarioServico;
    private String enderecoNumeroDestinatarioServico;
    private String enderecoComplementoDestinatarioServico;
    private String enderecoBairroDestinatarioServico;
    private String enderecoCidadeDestinatarioServico;
    private String enderecoCodigoCidadeDestinatarioServico;
    private String enderecoUFDestinatarioServico;
    private NFSeBarueriPais enderecoPaisDestinatarioServico;
    private String enderecoCEPDestinatarioServico;
    private String emailDestinatarioServico;
    private String nifDestinatarioServico;
    private String codigoEnderecoPostalDestinatarioEstrangeiro;
    private String estadoProvinciaRegiaoDestinatarioEstrangeiro;

    public String getCodigoClassificacaoCreditoPresumidoIBSCBS() {
        return codigoClassificacaoCreditoPresumidoIBSCBS;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setCodigoClassificacaoCreditoPresumidoIBSCBS(String codigoClassificacaoCreditoPresumidoIBSCBS) {
        this.codigoClassificacaoCreditoPresumidoIBSCBS = codigoClassificacaoCreditoPresumidoIBSCBS;
        return this;
    }

    public NFSeBarueriEnteGovernamentalTipo getTipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica() {
        return tipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setTipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica(NFSeBarueriEnteGovernamentalTipo tipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica) {
        this.tipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica = tipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica;
        return this;
    }

    public NFSeBarueriEnteGovernamentalOperacaoTipo getTipoOperacaoEnteGovernamentalOuSobreBensImoveis() {
        return tipoOperacaoEnteGovernamentalOuSobreBensImoveis;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setTipoOperacaoEnteGovernamentalOuSobreBensImoveis(NFSeBarueriEnteGovernamentalOperacaoTipo tipoOperacaoEnteGovernamentalOuSobreBensImoveis) {
        this.tipoOperacaoEnteGovernamentalOuSobreBensImoveis = tipoOperacaoEnteGovernamentalOuSobreBensImoveis;
        return this;
    }

    public String getChaveNFSeReferenciada() {
        return chaveNFSeReferenciada;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setChaveNFSeReferenciada(String chaveNFSeReferenciada) {
        this.chaveNFSeReferenciada = chaveNFSeReferenciada;
        return this;
    }

    public String getCodigoNCM() {
        return codigoNCM;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setCodigoNCM(String codigoNCM) {
        this.codigoNCM = codigoNCM;
        return this;
    }

    public String getDescricaoBemMovelObjetoLocacao() {
        return descricaoBemMovelObjetoLocacao;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setDescricaoBemMovelObjetoLocacao(String descricaoBemMovelObjetoLocacao) {
        this.descricaoBemMovelObjetoLocacao = descricaoBemMovelObjetoLocacao;
        return this;
    }

    public Integer getQuantidadeBemMovelObjetoLocacao() {
        return quantidadeBemMovelObjetoLocacao;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setQuantidadeBemMovelObjetoLocacao(Integer quantidadeBemMovelObjetoLocacao) {
        this.quantidadeBemMovelObjetoLocacao = quantidadeBemMovelObjetoLocacao;
        return this;
    }

    public NFSeBarueriIndicadorOperacaoDoacao getIndicadorOperacaoDoacao() {
        return indicadorOperacaoDoacao;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setIndicadorOperacaoDoacao(NFSeBarueriIndicadorOperacaoDoacao indicadorOperacaoDoacao) {
        this.indicadorOperacaoDoacao = indicadorOperacaoDoacao;
        return this;
    }

    public Boolean getDestinatarioServicoEstrangeiro() {
        return destinatarioServicoEstrangeiro;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setDestinatarioServicoEstrangeiro(Boolean destinatarioServicoEstrangeiro) {
        this.destinatarioServicoEstrangeiro = destinatarioServicoEstrangeiro;
        return this;
    }

    public String getCpfCnpjDestinatarioServico() {
        return cpfCnpjDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setCpfCnpjDestinatarioServico(String cpfCnpjDestinatarioServico) {
        this.cpfCnpjDestinatarioServico = cpfCnpjDestinatarioServico;
        return this;
    }

    public String getRazaoSocialDestinatarioServico() {
        return razaoSocialDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setRazaoSocialDestinatarioServico(String razaoSocialDestinatarioServico) {
        this.razaoSocialDestinatarioServico = razaoSocialDestinatarioServico;
        return this;
    }

    public String getEnderecoLogradouroDestinatarioServico() {
        return enderecoLogradouroDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoLogradouroDestinatarioServico(String enderecoLogradouroDestinatarioServico) {
        this.enderecoLogradouroDestinatarioServico = enderecoLogradouroDestinatarioServico;
        return this;
    }

    public String getEnderecoNumeroDestinatarioServico() {
        return enderecoNumeroDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoNumeroDestinatarioServico(String enderecoNumeroDestinatarioServico) {
        this.enderecoNumeroDestinatarioServico = enderecoNumeroDestinatarioServico;
        return this;
    }

    public String getEnderecoComplementoDestinatarioServico() {
        return enderecoComplementoDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoComplementoDestinatarioServico(String enderecoComplementoDestinatarioServico) {
        this.enderecoComplementoDestinatarioServico = enderecoComplementoDestinatarioServico;
        return this;
    }

    public String getEnderecoBairroDestinatarioServico() {
        return enderecoBairroDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoBairroDestinatarioServico(String enderecoBairroDestinatarioServico) {
        this.enderecoBairroDestinatarioServico = enderecoBairroDestinatarioServico;
        return this;
    }

    public String getEnderecoCidadeDestinatarioServico() {
        return enderecoCidadeDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoCidadeDestinatarioServico(String enderecoCidadeDestinatarioServico) {
        this.enderecoCidadeDestinatarioServico = enderecoCidadeDestinatarioServico;
        return this;
    }

    public String getEnderecoCodigoCidadeDestinatarioServico() {
        return enderecoCodigoCidadeDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoCodigoCidadeDestinatarioServico(String enderecoCodigoCidadeDestinatarioServico) {
        this.enderecoCodigoCidadeDestinatarioServico = enderecoCodigoCidadeDestinatarioServico;
        return this;
    }

    public String getEnderecoUFDestinatarioServico() {
        return enderecoUFDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoUFDestinatarioServico(String enderecoUFDestinatarioServico) {
        this.enderecoUFDestinatarioServico = enderecoUFDestinatarioServico;
        return this;
    }

    public NFSeBarueriPais getEnderecoPaisDestinatarioServico() {
        return enderecoPaisDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoPaisDestinatarioServico(NFSeBarueriPais enderecoPaisDestinatarioServico) {
        this.enderecoPaisDestinatarioServico = enderecoPaisDestinatarioServico;
        return this;
    }

    public String getEnderecoCEPDestinatarioServico() {
        return enderecoCEPDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEnderecoCEPDestinatarioServico(String enderecoCEPDestinatarioServico) {
        this.enderecoCEPDestinatarioServico = enderecoCEPDestinatarioServico;
        return this;
    }

    public String getEmailDestinatarioServico() {
        return emailDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEmailDestinatarioServico(String emailDestinatarioServico) {
        this.emailDestinatarioServico = emailDestinatarioServico;
        return this;
    }

    public String getNifDestinatarioServico() {
        return nifDestinatarioServico;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setNifDestinatarioServico(String nifDestinatarioServico) {
        this.nifDestinatarioServico = nifDestinatarioServico;
        return this;
    }

    public String getCodigoEnderecoPostalDestinatarioEstrangeiro() {
        return codigoEnderecoPostalDestinatarioEstrangeiro;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setCodigoEnderecoPostalDestinatarioEstrangeiro(String codigoEnderecoPostalDestinatarioEstrangeiro) {
        this.codigoEnderecoPostalDestinatarioEstrangeiro = codigoEnderecoPostalDestinatarioEstrangeiro;
        return this;
    }

    public String getEstadoProvinciaRegiaoDestinatarioEstrangeiro() {
        return estadoProvinciaRegiaoDestinatarioEstrangeiro;
    }

    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 setEstadoProvinciaRegiaoDestinatarioEstrangeiro(String estadoProvinciaRegiaoDestinatarioEstrangeiro) {
        this.estadoProvinciaRegiaoDestinatarioEstrangeiro = estadoProvinciaRegiaoDestinatarioEstrangeiro;
        return this;
    }

    @Override
    public String getTipoRegistro() {
        return TIPO_REGISTRO;
    }

    @Override
    public NFSeBarueriRPSArquivoEnvioRegistroTipo5 fromLinha(String linha) {
        return new NFSeBarueriRPSArquivoEnvioRegistroTipo5()
                .setCodigoClassificacaoCreditoPresumidoIBSCBS(linha.substring(1, 3))
                .setTipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica(NFSeBarueriEnteGovernamentalTipo.valueOfCodigo(linha.substring(3, 4)))
                .setTipoOperacaoEnteGovernamentalOuSobreBensImoveis(NFSeBarueriEnteGovernamentalOperacaoTipo.valueOfCodigo(linha.substring(4, 5)))
                .setChaveNFSeReferenciada(StringUtils.trimToNull(linha.substring(5, 50)))
                .setCodigoNCM(StringUtils.trimToNull(linha.substring(50, 63)))
                .setDescricaoBemMovelObjetoLocacao(StringUtils.trimToNull(linha.substring(63, 213)))
                .setQuantidadeBemMovelObjetoLocacao(Integer.parseInt(linha.substring(213, 216).trim()))
                .setIndicadorOperacaoDoacao(NFSeBarueriIndicadorOperacaoDoacao.valueOfCodigo(linha.substring(216, 217)))
                .setDestinatarioServicoEstrangeiro("1".equals(linha.substring(217, 218)))
                .setCpfCnpjDestinatarioServico(StringUtils.trimToNull(linha.substring(218, 232)))
                .setRazaoSocialDestinatarioServico(StringUtils.trimToNull(linha.substring(232, 292)))
                .setEnderecoLogradouroDestinatarioServico(StringUtils.trimToNull(linha.substring(292, 367)))
                .setEnderecoNumeroDestinatarioServico(StringUtils.trimToNull(linha.substring(367, 376)))
                .setEnderecoComplementoDestinatarioServico(StringUtils.trimToNull(linha.substring(376, 406)))
                .setEnderecoBairroDestinatarioServico(StringUtils.trimToNull(linha.substring(406, 446)))
                .setEnderecoCidadeDestinatarioServico(StringUtils.trimToNull(linha.substring(446, 486)))
                .setEnderecoCodigoCidadeDestinatarioServico(StringUtils.trimToNull(linha.substring(486, 493)))
                .setEnderecoUFDestinatarioServico(StringUtils.trimToNull(linha.substring(493, 495)))
                .setEnderecoPaisDestinatarioServico(NFSeBarueriPais.valueOfCodigo(linha.substring(495, 498)))
                .setEnderecoCEPDestinatarioServico(StringUtils.trimToNull(linha.substring(498, 506)))
                .setEmailDestinatarioServico(StringUtils.trimToNull(linha.substring(506, 586)))
                .setNifDestinatarioServico(StringUtils.trimToNull(linha.substring(586, 626)))
                .setCodigoEnderecoPostalDestinatarioEstrangeiro(StringUtils.trimToNull(linha.substring(626, 637)))
                .setEstadoProvinciaRegiaoDestinatarioEstrangeiro(StringUtils.trimToNull(linha.substring(637, 697)))
                .setErros(parseErros(linha));
    }

    @Override
    public String toLinha() {
        return String.format("%s",
                getTipoRegistro(),
                trataString(this.codigoClassificacaoCreditoPresumidoIBSCBS, 2),
                trataString(this.tipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica != null ? this.tipoEnteGovernamentalParaAquisicaoServicoPelaAdministracaoPublica.getCodigo() : "", 1),
                trataString(this.tipoOperacaoEnteGovernamentalOuSobreBensImoveis != null ? this.tipoOperacaoEnteGovernamentalOuSobreBensImoveis.getCodigo() : "", 1),
                trataString(this.chaveNFSeReferenciada, 50),
                trataString(this.codigoNCM, 8),
                trataString(this.descricaoBemMovelObjetoLocacao, 150),
                trataNumerico(this.quantidadeBemMovelObjetoLocacao , 3),
                trataString(this.indicadorOperacaoDoacao != null ? this.indicadorOperacaoDoacao.getCodigo() : "", 1),
                destinatarioServicoEstrangeiro != null && destinatarioServicoEstrangeiro ? "1" : "0",
                trataString(this.cpfCnpjDestinatarioServico, 14),
                trataString(this.razaoSocialDestinatarioServico, 60),
                trataString(this.enderecoLogradouroDestinatarioServico, 75),
                trataString(this.enderecoNumeroDestinatarioServico, 9),
                trataString(this.enderecoComplementoDestinatarioServico, 30),
                trataString(this.enderecoBairroDestinatarioServico, 40),
                trataString(this.enderecoCidadeDestinatarioServico, 40),
                trataString(this.enderecoCodigoCidadeDestinatarioServico, 7),
                trataString(this.enderecoUFDestinatarioServico, 2),
                trataString(this.enderecoPaisDestinatarioServico != null ? this.enderecoPaisDestinatarioServico.getCodigo() : "", 3),
                trataString(this.enderecoCEPDestinatarioServico, 8),
                trataString(this.emailDestinatarioServico, 80),
                trataString(this.nifDestinatarioServico, 40),
                trataString(this.codigoEnderecoPostalDestinatarioEstrangeiro, 11),
                trataString(this.estadoProvinciaRegiaoDestinatarioEstrangeiro, 60)
        );
    }
}
