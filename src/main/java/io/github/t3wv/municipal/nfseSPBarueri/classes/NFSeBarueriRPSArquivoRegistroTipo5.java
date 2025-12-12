package io.github.t3wv.municipal.nfseSPBarueri.classes;

import org.apache.commons.lang3.StringUtils;

public class NFSeBarueriRPSArquivoRegistroTipo5 {
    static final String TIPO_REGISTRO_BODY = "5";

    private NFSeBarueriRPS rps;

    public NFSeBarueriRPSArquivoRegistroTipo5(NFSeBarueriRPS rps) {
        this.rps = rps;
    }

    public String getLinha() {
        final StringBuilder linha = new StringBuilder();
        linha.append(TIPO_REGISTRO_BODY); // 1/1/1
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getCodigoClassificacaoCreditoPresumido()), 2)); // 1/2/3
        linha.append(this.rps.getEnteGovernamentalTipo() != null ? this.rps.getEnteGovernamentalTipo().getCodigo() : " "); // 1/4/4
        linha.append(this.rps.getEnteGovernamentalOperacaoTipo() != null ? this.rps.getEnteGovernamentalOperacaoTipo().getCodigo() : " "); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getChaveNFSeReferenciada()), 50)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getCodigoNCM()), 8)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDescricaoBemMovel()), 8)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getQuantidadeBemMovel()), 8)); // 1/5/5
        linha.append(this.rps.isDoacao() != null ? (this.rps.isDoacao() ? "1" : "0") : " "); // 1/5/5
        linha.append(this.rps.isDestinatarioEstrangeiro() != null ? (this.rps.isDestinatarioEstrangeiro() ? "1" : "0") : " "); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioDocumento()), 14)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioRazaoSocial()), 60)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioEnderecoRua()), 75)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioEnderecoNumero()), 9)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioEnderecoComplemento()), 30)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioEnderecoBairro()), 40)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioEnderecoCidade()), 40)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioCidadeCodigo()), 7)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioUF()), 2)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioPaisCodigo()), 3)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioCEP()), 8)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioEmail()), 80)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioNIF()), 40)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioEstrangeiroCodigoPostal()), 11)); // 1/5/5
        linha.append(StringUtils.rightPad(StringUtils.trimToEmpty(this.rps.getDestinatarioEstrangeiroEstadoProvinciaRegiao()), 60)); // 1/5/5

        return linha.toString();
    }
}
