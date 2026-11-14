package io.github.t3wv.nfse.nacional.danfse;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoIBSCBSImovelUnidade;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoIBSCBSInfoImovel;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.Alinhamento.ESQUERDA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.CM;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.ESPESSURA_DIVISORIA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.LARGURA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.PRETO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.RECUO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.TAMANHO_CONTEUDO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.TAMANHO_ROTULO;

/**
 * Bloco de informações complementares e canhoto opcional (itens 2.1.12, 2.1.13 e 2.3.3 da NT 008). As informações
 * complementares ocupam o espaço que sobra até o canhoto, ou até o fim do corpo quando o canhoto é suprimido.
 */
final class DanfseRodape {

    /** Linha do título das informações complementares (0,39 cm e o espaço até o conteúdo). */
    static final float ALTURA_TITULO = 0.41f * CM;
    private static final float ALTURA_CANHOTO = 0.67f * CM;
    /** Fim do corpo do DANFSe: 0,30 cm antes da beira do papel, a mesma distância do topo e das laterais. */
    static final float FIM_DO_CORPO = PDRectangle.A4.getHeight() - 0.30f * CM;
    /** O canhoto fica rente ao fim do corpo, sem espaço vazio até a borda da página. */
    static final float TOPO_CANHOTO = FIM_DO_CORPO - ALTURA_CANHOTO;
    private static final float FOLGA_INFERIOR = 3f;
    private static final String SEPARADOR = " | ";

    /**
     * Classe utilitária, não deve ser instanciada.
     */
    private DanfseRodape() {
    }

    /**
     * @param canhoto true se o canhoto é impresso
     * @return limite inferior das informações complementares: o topo do canhoto ou, sem ele, o fim do corpo, em pontos a
     * partir do topo da página
     */
    static float limiteInferior(final boolean canhoto) {
        return canhoto ? TOPO_CANHOTO : FIM_DO_CORPO;
    }

    /**
     * União dos campos de informações complementares, na ordem e com os títulos do item 2.4.5, separados por pipes e limitada a
     * 2000 caracteres.
     *
     * @param nota NFS-e
     * @return informações complementares, ou string vazia se a NFS-e não tiver nenhuma
     */
    static String informacoes(final DanfseNota nota) {
        final var dps = nota.dps();
        final var servico = dps.getServicoPrestado();
        final var complemento = servico == null ? null : servico.getInformacoesComplementares();
        final var obra = servico == null ? null : servico.getObra();
        final var evento = servico == null ? null : servico.getEvento();
        final var imovel = nota.ibsCbsDps() == null ? null : nota.ibsCbsDps().getImovel();
        final var inscricaoObra = obra == null ? null : obra.getInscricaoImobiliariaFiscal();
        final var inscricaoImobiliaria = DanfseFormatador.texto(inscricaoObra).isEmpty() ? inscricoesDoImovel(imovel) : inscricaoObra;

        final List<String> partes = new ArrayList<>();
        adicionar(partes, "Inf. Cont.: ", complemento == null ? null : complemento.getInformacoesComplementares());
        adicionar(partes, "NFS-e Subst.: ", dps.getSubstituicaoNfse() == null ? null : dps.getSubstituicaoNfse().getChaveNFSe());
        adicionar(partes, "Doc. Ref.: ", complemento == null ? null : complemento.getReferenciaDocumento());
        adicionar(partes, "Cod. Obra: ", obra == null ? null : obra.getNumeroIdentificacaoObra());
        adicionar(partes, "Insc. Imob.: ", inscricaoImobiliaria);
        adicionar(partes, "Cod. Evt.: ", evento == null ? null : evento.getId());
        adicionar(partes, "Doc. Tec.: ", complemento == null ? null : complemento.getIdDocResponsabilidadeTecnica());
        adicionar(partes, "Núm. Ped.: ", complemento == null ? null : complemento.getNumeroPedido());
        adicionar(partes, "Item Ped.: ", complemento == null || complemento.getItensPedido() == null ? null
                : DanfseFormatador.juntar(", ", complemento.getItensPedido().toArray(new String[0])));
        adicionar(partes, "Inf. A. T. Mun.: ", nota.inf().getInformacoesUsoAdministracaoTributaria());
        return DanfseFormatador.limitar(String.join(SEPARADOR, partes), 2000);
    }

    /**
     * Inscrições imobiliárias das unidades do imóvel (gUnidImob, NT 009), separadas por vírgula; null se não houver.
     */
    private static String inscricoesDoImovel(final NFSeSefinNacionalInfoIBSCBSInfoImovel imovel) {
        if (imovel == null || imovel.getgUnidImob() == null) {
            return null;
        }
        final var inscricoes = imovel.getgUnidImob().stream()
                .filter(Objects::nonNull)
                .map(NFSeSefinNacionalInfoIBSCBSImovelUnidade::getInscImobFisc)
                .filter(inscricao -> !DanfseFormatador.texto(inscricao).isEmpty())
                .toList();
        return inscricoes.isEmpty() ? null : String.join(", ", inscricoes);
    }

    private static void adicionar(final List<String> partes, final String titulo, final String valor) {
        final var texto = DanfseFormatador.texto(valor);
        if (!texto.isEmpty()) {
            partes.add(titulo + texto);
        }
    }

    /**
     * Linha fixa dos totais aproximados dos tributos (Lei nº 12.741/2012), obrigatória (nota 10 do item 2.4.5), em valores
     * monetários ou percentuais, como informado na DPS.
     *
     * @param nota NFS-e
     * @return texto dos totais aproximados dos tributos
     */
    static String totaisAproximados(final DanfseNota nota) {
        final var prefixo = "Totais Aproximados dos Tributos cfe. Lei nº 12.741/2012: ";
        final var totTrib = nota.totTrib();
        if (totTrib != null && totTrib.getValorTotalTributos() != null) {
            final var valores = totTrib.getValorTotalTributos();
            return prefixo + "Federais: " + DanfseFormatador.valor(valores.getValorTributosFederais()) + "; Estaduais: "
                    + DanfseFormatador.valor(valores.getValorTributosEstaduais()) + "; Municipais: " + DanfseFormatador.valor(valores.getValorTributosMunicipais());
        }
        if (totTrib != null && totTrib.getPercentualTotalTributos() != null) {
            final var percentuais = totTrib.getPercentualTotalTributos();
            return prefixo + "Federais: " + DanfseFormatador.percentual(percentuais.getPercentualTributosFederais()) + "; Estaduais: "
                    + DanfseFormatador.percentual(percentuais.getPercentualTributosEstaduais()) + "; Municipais: "
                    + DanfseFormatador.percentual(percentuais.getPercentualTributosMunicipais());
        }
        if (totTrib != null && totTrib.getPercentualTotalSimplesNacional() != null) {
            return prefixo + "Simples Nacional: " + DanfseFormatador.percentual(totTrib.getPercentualTotalSimplesNacional());
        }
        final var semInformacao = DanfseFormatador.SEM_INFORMACAO;
        return prefixo + "Federais: " + semInformacao + "; Estaduais: " + semInformacao + "; Municipais: " + semInformacao;
    }

    /**
     * @param canvas área de desenho, usada para medir o texto
     * @param texto texto a quebrar
     * @return linhas do texto na largura do bloco, ou nenhuma linha se o texto estiver vazio
     */
    static List<String> linhas(final DanfseCanvas canvas, final String texto) {
        return texto.isEmpty() ? new ArrayList<>() : canvas.quebrar(texto, LARGURA - 2 * RECUO, TAMANHO_CONTEUDO, false);
    }

    /**
     * @param canvas área de desenho
     * @param linhas quantidade de linhas das informações complementares, contando as dos totais aproximados dos tributos
     * @return altura ocupada pelo conteúdo do bloco, sem o título, em pontos
     */
    static float alturaInformacoes(final DanfseCanvas canvas, final int linhas) {
        return 1.5f + TAMANHO_CONTEUDO * 0.72f + (linhas - 1) * canvas.alturaLinha(TAMANHO_CONTEUDO) + FOLGA_INFERIOR;
    }

    /**
     * Desenha as informações complementares a partir do cursor e, se pedido, o canhoto no pé do corpo do DANFSe.
     *
     * @param canvas área de desenho
     * @param nota NFS-e
     * @param linhasInformacoes linhas das informações complementares, já ajustadas ao espaço da página
     * @param linhasTotais linhas dos totais aproximados dos tributos
     * @param canhoto true para imprimir o canhoto
     */
    static void desenhar(final DanfseCanvas canvas, final DanfseNota nota, final List<String> linhasInformacoes, final List<String> linhasTotais,
                         final boolean canhoto) {
        canvas.divisoria();
        canvas.tituloBloco("INFORMAÇÕES COMPLEMENTARES");
        canvas.avancar(ALTURA_TITULO);
        final List<String> linhas = new ArrayList<>(linhasInformacoes);
        linhas.addAll(linhasTotais);
        canvas.linhas(RECUO, 1.5f + TAMANHO_CONTEUDO * 0.72f, LARGURA - 2 * RECUO, linhas, TAMANHO_CONTEUDO);
        if (canhoto) {
            canhoto(canvas, nota);
        }
    }

    /**
     * Desenha o canhoto: data de cientificação, identificação e assinatura e número e chave da NFS-e (item 2.1.13).
     */
    private static void canhoto(final DanfseCanvas canvas, final DanfseNota nota) {
        canvas.posicionar(TOPO_CANHOTO);
        canvas.retangulo(0, LARGURA, ALTURA_CANHOTO, ESPESSURA_DIVISORIA);
        canvas.linhaVertical(DanfseCanvas.coluna(1) - 0.01f * CM, ALTURA_CANHOTO, ESPESSURA_DIVISORIA);
        canvas.linhaVertical(DanfseCanvas.coluna(2) - 0.01f * CM, ALTURA_CANHOTO, ESPESSURA_DIVISORIA);
        final var baseRotulo = 1.5f + TAMANHO_ROTULO * 0.72f + 1f;
        canvas.texto(RECUO, baseRotulo, DanfseCanvas.larguraColunas(0, 1) - 2 * RECUO, "DATA CIENTIFICAÇÃO:", TAMANHO_ROTULO, true, ESQUERDA, PRETO);
        canvas.texto(DanfseCanvas.coluna(1) + RECUO, baseRotulo, DanfseCanvas.larguraColunas(1, 1) - 2 * RECUO, "IDENTIFICAÇÃO E ASSINATURA", TAMANHO_ROTULO,
                true, ESQUERDA, PRETO);
        canvas.texto(DanfseCanvas.coluna(2) + RECUO, baseRotulo, DanfseCanvas.larguraColunas(2, 2) - 2 * RECUO, "Nº NFS-e / CHAVE NFS-e", TAMANHO_ROTULO,
                true, ESQUERDA, PRETO);
        final var numeroChave = DanfseFormatador.limitar(DanfseFormatador.ouTraco(nota.inf().getNumeroNFSe()) + " / " + nota.chaveAcesso(), 66);
        canvas.texto(DanfseCanvas.coluna(2) + RECUO, baseRotulo + 1.5f + TAMANHO_CONTEUDO, DanfseCanvas.larguraColunas(2, 2) - 2 * RECUO, numeroChave,
                TAMANHO_CONTEUDO, false, ESQUERDA, PRETO);
        canvas.avancar(ALTURA_CANHOTO);
    }
}
