package io.github.t3wv.nfse.nacional.danfse;

import java.util.List;

import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.Alinhamento.ESQUERDA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.CM;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.LARGURA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.LINHA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.PRETO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.RECUO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.TAMANHO_CONTEUDO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.TAMANHO_ROTULO;

/**
 * Bloco do serviço prestado: códigos, local da prestação, descrição do código de tributação e descrição do serviço (item 2.1.7
 * da NT 008). A descrição do serviço ocupa as linhas que precisar, até 1300 caracteres.
 */
final class DanfseServico {

    /** Linha da descrição do código de tributação, sem título (0,38 cm e o espaço até a linha seguinte). */
    private static final float ALTURA_DESCRICAO_CODIGO = 0.40f * CM;
    /** Distância do topo do quadro da descrição do serviço até a base da primeira linha de texto. */
    private static final float BASE_PRIMEIRA_LINHA = 1.5f + TAMANHO_ROTULO * 0.72f + 1.5f + TAMANHO_CONTEUDO;
    private static final float FOLGA_INFERIOR = 3f;

    /**
     * Classe utilitária, não deve ser instanciada.
     */
    private DanfseServico() {
    }

    /**
     * @return altura das linhas do bloco antes da descrição do serviço, em pontos
     */
    static float alturaFixa() {
        return LINHA + ALTURA_DESCRICAO_CODIGO;
    }

    /**
     * Quebra a descrição do serviço na largura do bloco, limitada a 1300 caracteres (item 2.4.5).
     *
     * @param canvas área de desenho, usada para medir o texto
     * @param nota NFS-e
     * @return linhas da descrição
     */
    static List<String> linhasDescricao(final DanfseCanvas canvas, final DanfseNota nota) {
        final var servico = nota.dps().getServicoPrestado();
        final var descricao = servico == null || servico.getCServ() == null ? null : servico.getCServ().getDescricaoServico();
        return canvas.quebrar(DanfseFormatador.ouTraco(DanfseFormatador.limitar(descricao, 1300)), LARGURA - 2 * RECUO, TAMANHO_CONTEUDO, false);
    }

    /**
     * @param canvas área de desenho
     * @param linhas quantidade de linhas da descrição
     * @return altura do quadro da descrição do serviço, com o mínimo de 0,63 cm (item 2.4.5), em pontos
     */
    static float alturaDescricao(final DanfseCanvas canvas, final int linhas) {
        return Math.max(LINHA, BASE_PRIMEIRA_LINHA + (linhas - 1) * canvas.alturaLinha(TAMANHO_CONTEUDO) + FOLGA_INFERIOR);
    }

    /**
     * Desenha o bloco a partir do cursor; ao final, o cursor fica no topo do bloco seguinte.
     *
     * @param canvas área de desenho
     * @param nota NFS-e
     * @param linhasDescricao linhas da descrição do serviço já ajustadas ao espaço da página
     * @param alturaDescricao altura reservada para a descrição do serviço, em pontos
     */
    static void desenhar(final DanfseCanvas canvas, final DanfseNota nota, final List<String> linhasDescricao, final float alturaDescricao) {
        final var servico = nota.dps().getServicoPrestado();
        final var codigos = servico == null ? null : servico.getCServ();
        final var localPrestacao = servico == null ? null : servico.getLocalPrestacao();

        canvas.divisoria();
        canvas.tituloBloco("SERVIÇO PRESTADO");
        final var codigoTributacao = codigos == null ? DanfseFormatador.SEM_INFORMACAO
                : DanfseFormatador.ouTraco(DanfseFormatador.codigoTributacaoNacional(codigos.getCodigoNacionalTributacaoISSQN())) + " / "
                + DanfseFormatador.ouTraco(codigos.getCodigoMunicipalTributacaoISSQN());
        canvas.campo(1, 1, "Código de Tributação Nacional / Municipal", DanfseFormatador.limitar(codigoTributacao, 14));
        canvas.campo(2, 1, "Código da NBS", DanfseFormatador.nbs(codigos == null ? null : codigos.getCodigoNBS()));
        final var codigoMunicipio = localPrestacao == null ? null : localPrestacao.getCodigoMunicipio();
        final var pais = localPrestacao == null ? null : localPrestacao.getCodigoPais();
        canvas.campo(3, 1, "Local da Prestação / Sigla UF / País", DanfseFormatador.limitar(
                local(nota.inf().getLocalPrestacao(), codigoMunicipio, pais), 42));
        canvas.avancar(LINHA);

        // sem titulo: a descricao municipal do codigo de tributacao, se houver, senao a nacional
        final var descricaoMunicipal = DanfseFormatador.texto(nota.inf().getDescricaoMunicipalISSQN());
        final var descricaoCodigo = descricaoMunicipal.isEmpty() ? nota.inf().getDescricaoNacionalISSQN() : descricaoMunicipal;
        canvas.texto(RECUO, 1.5f + TAMANHO_CONTEUDO * 0.72f, LARGURA - 2 * RECUO, DanfseFormatador.ouTraco(DanfseFormatador.limitar(descricaoCodigo, 170)),
                TAMANHO_CONTEUDO, false, ESQUERDA, PRETO);
        canvas.avancar(ALTURA_DESCRICAO_CODIGO);

        canvas.texto(RECUO, 1.5f + TAMANHO_ROTULO * 0.72f, LARGURA - 2 * RECUO, "Descrição do Serviço", TAMANHO_ROTULO, true, ESQUERDA, PRETO);
        canvas.linhas(RECUO, BASE_PRIMEIRA_LINHA, LARGURA - 2 * RECUO, linhasDescricao, TAMANHO_CONTEUDO);
        canvas.avancar(alturaDescricao);
    }

    /**
     * Local como "Município / UF / País", com um traço no lugar de cada parte sem informação, como no DANFSe gerado pelo
     * Sistema Nacional.
     *
     * @param nome nome do município informado na NFS-e, ou null
     * @param codigoMunicipio código IBGE do município, ou null
     * @param pais código ISO do país, ou null
     * @return local formatado
     */
    static String local(final String nome, final String codigoMunicipio, final String pais) {
        final var municipio = DanfseFormatador.texto(nome).isEmpty() ? codigoMunicipio : nome;
        if (DanfseFormatador.texto(municipio).isEmpty() && DanfseFormatador.texto(pais).isEmpty()) {
            return DanfseFormatador.SEM_INFORMACAO;
        }
        return DanfseFormatador.ouTraco(municipio) + " / " + DanfseFormatador.ouTraco(DanfseFormatador.uf(codigoMunicipio)) + " / " + DanfseFormatador.ouTraco(pais);
    }
}
