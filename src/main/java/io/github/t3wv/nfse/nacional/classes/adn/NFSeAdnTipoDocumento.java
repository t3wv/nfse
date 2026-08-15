package io.github.t3wv.nfse.nacional.classes.adn;

/**
 * Tipo do documento fiscal devolvido em cada item do lote de distribuição do ADN.
 */
public enum NFSeAdnTipoDocumento {

    NENHUM,

    /**
     * Declaração de Prestação de Serviços.
     */
    DPS,

    PEDIDO_REGISTRO_EVENTO,

    /**
     * Nota Fiscal de Serviço eletrônica.
     */
    NFSE,

    /**
     * Evento vinculado a uma NFS-e; o código do evento vem em {@code TipoEvento}.
     */
    EVENTO,

    /**
     * Comprovante de Não Conversão.
     */
    CNC
}
