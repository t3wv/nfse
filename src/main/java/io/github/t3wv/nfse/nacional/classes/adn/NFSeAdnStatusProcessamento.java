package io.github.t3wv.nfse.nacional.classes.adn;

/**
 * Status do processamento de uma consulta de distribuição de DF-e no ADN.
 */
public enum NFSeAdnStatusProcessamento {

    /**
     * Existem documentos no lote retornado.
     */
    DOCUMENTOS_LOCALIZADOS,

    /**
     * Não há documentos a partir do NSU informado. É o critério de parada da drenagem,
     * já que o ADN não devolve um teto de NSU.
     */
    NENHUM_DOCUMENTO_LOCALIZADO,

    /**
     * A requisição foi rejeitada; o detalhamento vem em {@code Erros}.
     */
    REJEICAO
}
