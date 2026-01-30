package io.github.t3wv.nfse.municipal.nfseSCSaoJose.enums;

public enum NFSeSCSaoJoseSituacaoTributaria {

    TRIBUTADA_INTEGRALMENTE("0", "O valor do imposto será lançado para o emissor da nota"),
    TRIBUTADA_INTEGRALMENTE_ISSRF("1", "O valor do imposto não será lançado, pois será recolhido pelo tomador, caso seja órgão público municipal"),
    TRIBUTADA_INTEGRALMENTE_SUJEITA_SUBSTITUICAO_TRIBUTARIA("2", "O valor do imposto não será lançado, pois será recolhido pelo tomador (substituto tributário), caso não seja um órgão público municipal"),
    tributada_ReduCAO_base_CAlculo("3", "O valor do imposto será lançado para o emissor da nota, porém, na apuração da base de cálculo, será descontado o valor da tag <valor_deducao> (esta situação tributária somente se aplica, caso o serviço consignado seja o de código 1705)"),
    Tributada_reduCAo_base_CAlculo_ISSRF("4", "O valor do imposto não será lançado, pois será recolhido pelo tomador, caso seja órgão público municipal, porém na apuração da base de cálculo será descontado o valor da tag <valor_deducao> (esta situação tributária somente se aplica, caso o serviço consignado seja o de código 1705)"),
    Tributada_reduCAo_base_cAlculo_sujeita_SubstituiCAo_TributAria("5", "O valor do imposto não será lançado, pois será recolhido pelo tomador, caso não seja um órgão público municipal, porém na apuração da base de cálculo será descontado o valor da tag <valor_deducao> (esta situação tributária somente se aplica, caso o serviço consignado seja o de código 1705)"),
    ISENTA("6", "Não irá gerar valor de imposto, pois o prestador é isento"),
    IMUNE("7", "Não irá gerar valor do imposto, pois o prestador é imune"),
    NAO_TRIBUTADA_ISS_REGIME_FIXO("8", "Não irá influenciar no cálculo do imposto, pois o valor é previamente calculado"),
    NAO_TRIBUTADA_ISS_REGIME_ESTIMATIVA("9", "Não irá influenciar no cálculo do imposto, pois o valor é previamente estimado"),
    NAO_TRIBUTADA_ISS_REGIME_CONTRUCAO_CIVIL("10", "Não irá gerar valor de imposto, pois foi recolhido antecipadamente (esta situação tributária somente se aplica, caso os serviços consignados sejam os de código 1701, 1702, 1703, 1705, 1719)"),
    NAO_TRIBUTADA("14", "Não irá gerar valor do imposto, pois a prestação de serviço não está sujeita ao ISS"),
    NAOTRIBUTADA_ATO_COOPERADO("15", "Não irá gerar valor do imposto, pois a prestação de serviço para cooperados não está sujeita ao ISS, porém, mesmo que cooperativa e caso o serviço seja prestado para um não cooperado, deve-se utilizar das outras situações tributárias, de acordo com o caso");

    private final String codigo;
    private final String descricao;

    NFSeSCSaoJoseSituacaoTributaria(final String codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static NFSeSCSaoJoseSituacaoTributaria valueOfCodigo(String codigo) {
        for (NFSeSCSaoJoseSituacaoTributaria tipo : NFSeSCSaoJoseSituacaoTributaria.values()) {
            if (tipo.getCodigo().equalsIgnoreCase(codigo)) {
                return tipo;
            }
        }
        return null;
    }
}
