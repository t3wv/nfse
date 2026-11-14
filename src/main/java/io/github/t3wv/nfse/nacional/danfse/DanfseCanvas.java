package io.github.t3wv.nfse.nacional.danfse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceCMYK;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Primitivas de desenho do DANFSe sobre o PDFBox: campos com rótulo, texto com quebra e reticências, linhas, sombreamento,
 * QR Code, imagem e marca d'água. O DANFSe tem uma única página A4 retrato (NT 008, item 2.2).
 * <p>
 * Todas as medidas são em pontos; o eixo x é relativo à margem esquerda do corpo (0,30 cm) e o eixo y cresce para baixo a
 * partir do topo da página. O cursor vertical marca o topo do próximo elemento e os métodos de desenho não o movem: quem chama
 * usa {@link #avancar(float)}.
 */
final class DanfseCanvas {

    /**
     * Alinhamento horizontal do texto dentro da largura informada.
     */
    enum Alinhamento {ESQUERDA, CENTRO, DIREITA}

    static final float CM = 72f / 2.54f;
    /** Borda esquerda do corpo do DANFSe (coluna "Esq." da tabela do item 2.4.5). */
    static final float ESQUERDA = 0.30f * CM;
    /** Largura do corpo do DANFSe. */
    static final float LARGURA = 20.40f * CM;
    /** Distância da borda da página (1 ponto) até o fim do formulário, entre 0,15 cm e 0,20 cm (item 2.2.2). */
    static final float MARGEM_BORDA = 0.18f * CM;
    static final float RECUO = 3f;

    /** Preto sólido (K100), item 2.4. */
    static final PDColor PRETO = cmyk(0, 0, 0, 1);
    /** Vermelho sólido (M100/Y100) da expressão de homologação, item 2.4.3. */
    static final PDColor VERMELHO = cmyk(0, 1, 1, 0);
    /** Cinza claro (5% de densidade) do sombreamento do cabeçalho, item 2.2.3. */
    static final PDColor CINZA_SOMBREAMENTO = cmyk(0, 0, 0, 0.05f);
    /** Cinza (K35) da marca d'água, itens 2.5.1 e 2.5.2. */
    static final PDColor CINZA_MARCA_DAGUA = cmyk(0, 0, 0, 0.35f);

    static final float ESPESSURA_DIVISORIA = 0.5f;
    static final float ESPESSURA_BORDA = 1f;
    static final String RETICENCIAS = "...";

    /** Títulos dos blocos: 7 pontos, negrito, caixa alta (item 2.4.1). */
    static final float TAMANHO_TITULO = 7f;
    /** Títulos dos campos: 6 pontos, negrito (item 2.4.2). */
    static final float TAMANHO_ROTULO = 6f;
    /** Títulos dos campos de identificação da NFS-e: 7 pontos, negrito, caixa alta (item 2.4.2). */
    static final float TAMANHO_ROTULO_IDENTIFICACAO = 7f;
    /** Conteúdo dos campos: 7 pontos, formato normal (itens 2.4.3 e 2.4.4). */
    static final float TAMANHO_CONTEUDO = 7f;

    /** Passo vertical das linhas de campos (0,63 cm de campo, como na coluna "Sup." do item 2.4.5). */
    static final float LINHA = 0.645f * CM;
    /** Distância entre colunas vizinhas. */
    private static final float ESPACO_COLUNAS = 0.02f * CM;
    /** Início das quatro colunas de 5,09 cm (0,30, 5,41, 10,51 e 15,62 cm da borda do papel), a partir da margem do corpo. */
    private static final float[] COLUNAS = {0f, 5.11f * CM, 10.21f * CM, 15.32f * CM};

    private static final float ESPACO_LINHA = 1.15f;
    private static final float TAMANHO_MARCA_DAGUA = 90f;

    private final PDDocument documento;
    private final PDPage pagina;
    private final PDPageContentStream conteudo;
    private final PDFont fonte;
    private final PDFont negrito;
    private float y;
    private String marcaDagua;

    /**
     * Cria a página A4 do DANFSe no documento, com o cursor no topo da página.
     *
     * @param documento documento onde a página é criada
     */
    DanfseCanvas(final PDDocument documento) {
        this(documento, 0f);
    }

    /**
     * Cria a página A4 do DANFSe no documento, com o cursor no topo da página e uma margem de segurança de impressão.
     * <p>
     * O leiaute da NT 008 deixa a borda a 0,18 cm da beira do papel, dentro da área que muitas impressoras não imprimem. Com a
     * margem de segurança, todo o desenho (borda, textos, QR Code) é reduzido proporcionalmente e centralizado, de modo que a
     * borda da página fique a essa distância da beira do papel, como na DANFE.
     *
     * @param documento documento onde a página é criada
     * @param margemSegurancaCm distância mínima, em cm, entre a borda do DANFSe e a beira do papel; zero mantém o leiaute da NT 008
     */
    DanfseCanvas(final PDDocument documento, final float margemSegurancaCm) {
        this.documento = documento;
        this.pagina = new PDPage(PDRectangle.A4);
        this.documento.addPage(this.pagina);
        // fontes padrão do PDF, sem embutir: a Helvetica tem as métricas da Arial pedida no item 2.4, e o WinAnsi cobre o
        // Latin-1 aceito pelos textos do leiaute da NFS-e
        this.fonte = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
        this.negrito = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
        try {
            this.conteudo = new PDPageContentStream(documento, this.pagina);
            final var margem = margemSegurancaCm * CM;
            if (margem > MARGEM_BORDA) {
                final var larguraPagina = this.pagina.getMediaBox().getWidth();
                final var alturaPagina = this.pagina.getMediaBox().getHeight();
                final var escala = Math.min((larguraPagina - 2 * margem) / (larguraPagina - 2 * MARGEM_BORDA),
                        (alturaPagina - 2 * margem) / (alturaPagina - 2 * MARGEM_BORDA));
                this.conteudo.transform(new Matrix(escala, 0, 0, escala, larguraPagina * (1 - escala) / 2, alturaPagina * (1 - escala) / 2));
            }
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static PDColor cmyk(final float c, final float m, final float y, final float k) {
        return new PDColor(new float[]{c, m, y, k}, PDDeviceCMYK.INSTANCE);
    }

    /**
     * @return posição vertical do cursor, em pontos a partir do topo da página
     */
    float y() {
        return this.y;
    }

    /**
     * Posiciona o cursor.
     *
     * @param y posição vertical, em pontos a partir do topo da página
     */
    void posicionar(final float y) {
        this.y = y;
    }

    /**
     * Move o cursor para baixo (ou para cima, se negativo).
     *
     * @param altura deslocamento em pontos
     */
    void avancar(final float altura) {
        this.y += altura;
    }

    /**
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @return altura de uma linha de texto, em pontos
     */
    float alturaLinha(final float tamanhoFonte) {
        return tamanhoFonte * ESPACO_LINHA;
    }

    /**
     * Prepara o texto para o PDF: troca caracteres de controle por espaço e o que está fora do WinAnsi das fontes por "?".
     *
     * @param texto texto original, ou null
     * @return texto que a fonte consegue desenhar
     */
    private static String limpar(final String texto) {
        final var resultado = new StringBuilder();
        if (texto != null) {
            texto.codePoints().forEach(codigo -> resultado.appendCodePoint(Character.isISOControl(codigo) ? ' '
                    : WinAnsiEncoding.INSTANCE.contains(GlyphList.getAdobeGlyphList().codePointToName(codigo)) ? codigo : '?'));
        }
        return resultado.toString();
    }

    /**
     * @param texto texto a medir
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @param emNegrito true para medir na fonte em negrito
     * @return largura do texto, em pontos
     */
    float largura(final String texto, final float tamanhoFonte, final boolean emNegrito) {
        return larguraNaFonte(emNegrito ? this.negrito : this.fonte, limpar(texto), tamanhoFonte);
    }

    private static float larguraNaFonte(final PDFont fonteDoTexto, final String texto, final float tamanhoFonte) {
        try {
            return fonteDoTexto.getStringWidth(texto) / 1000f * tamanhoFonte;
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Corta o fim do texto e acrescenta reticências quando ele não cabe na largura (item 2.1).
     *
     * @param texto texto a ajustar, ou null
     * @param largura largura máxima, em pontos
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @param emNegrito true para medir na fonte em negrito
     * @return o texto inteiro, se couber, ou o começo dele seguido de reticências
     */
    String caber(final String texto, final float largura, final float tamanhoFonte, final boolean emNegrito) {
        final var fonteDoTexto = emNegrito ? this.negrito : this.fonte;
        final var limpo = limpar(texto);
        if (larguraNaFonte(fonteDoTexto, limpo, tamanhoFonte) <= largura) {
            return limpo;
        }
        return comReticencias(fonteDoTexto, limpo, largura, tamanhoFonte);
    }

    /**
     * Corta o fim do texto até ele caber na largura seguido de reticências.
     */
    private static String comReticencias(final PDFont fonteDoTexto, final String texto, final float largura, final float tamanhoFonte) {
        var corte = texto.length();
        while (corte > 0 && larguraNaFonte(fonteDoTexto, DanfseFormatador.semSeparadorNoFim(texto.substring(0, corte)) + RETICENCIAS, tamanhoFonte) > largura) {
            corte--;
        }
        return corte == 0 ? "" : DanfseFormatador.semSeparadorNoFim(texto.substring(0, corte)) + RETICENCIAS;
    }

    /**
     * Mantém só as primeiras linhas do texto quebrado; quando alguma linha é descartada, a última mantida termina com
     * reticências, cortada se preciso para caber na largura (item 2.1).
     *
     * @param linhas linhas do texto, de {@link #quebrar(String, float, float, boolean)}
     * @param quantidade quantidade de linhas mantidas
     * @param largura largura das linhas, em pontos
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @return as linhas mantidas
     */
    List<String> cortarLinhas(final List<String> linhas, final int quantidade, final float largura, final float tamanhoFonte) {
        final List<String> mantidas = new ArrayList<>(linhas.subList(0, Math.min(quantidade, linhas.size())));
        if (!mantidas.isEmpty() && mantidas.size() < linhas.size()) {
            final var ultima = mantidas.size() - 1;
            mantidas.set(ultima, comReticencias(this.fonte, mantidas.get(ultima), largura, tamanhoFonte));
        }
        return mantidas;
    }

    /**
     * Quebra o texto por palavras (e por caractere, quando a palavra não cabe), respeitando as quebras de linha.
     *
     * @param texto texto a quebrar, ou null
     * @param largura largura máxima de cada linha, em pontos
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @param emNegrito true para medir na fonte em negrito
     * @return linhas que cabem na largura (pelo menos uma)
     */
    List<String> quebrar(final String texto, final float largura, final float tamanhoFonte, final boolean emNegrito) {
        final var fonteDoTexto = emNegrito ? this.negrito : this.fonte;
        final List<String> linhas = new ArrayList<>();
        for (final var paragrafo : (texto == null ? "" : texto).split("\r?\n", -1)) {
            quebrarParagrafo(fonteDoTexto, limpar(paragrafo), largura, tamanhoFonte, linhas);
        }
        return linhas;
    }

    /**
     * Quebra um parágrafo (sem quebras de linha) e acrescenta as linhas resultantes à lista.
     */
    private static void quebrarParagrafo(final PDFont fonteDoTexto, final String paragrafo, final float largura, final float tamanhoFonte, final List<String> linhas) {
        var atual = new StringBuilder();
        for (final var palavra : paragrafo.split(" ")) {
            if (palavra.isEmpty()) {
                continue;
            }
            final var candidato = atual.length() == 0 ? palavra : atual + " " + palavra;
            if (larguraNaFonte(fonteDoTexto, candidato, tamanhoFonte) <= largura) {
                atual = new StringBuilder(candidato);
                continue;
            }
            if (atual.length() > 0) {
                linhas.add(atual.toString());
                atual = new StringBuilder();
            }
            if (larguraNaFonte(fonteDoTexto, palavra, tamanhoFonte) <= largura) {
                atual.append(palavra);
                continue;
            }
            for (final var c : palavra.toCharArray()) {
                if (atual.length() > 0 && larguraNaFonte(fonteDoTexto, atual.toString() + c, tamanhoFonte) > largura) {
                    linhas.add(atual.toString());
                    atual = new StringBuilder();
                }
                atual.append(c);
            }
        }
        linhas.add(atual.toString());
    }

    /**
     * Escreve uma única linha de texto, cortada com reticências se não couber na largura; não move o cursor.
     *
     * @param x deslocamento horizontal a partir da margem esquerda do corpo, em pontos
     * @param base linha de base do texto, em pontos abaixo do cursor
     * @param largura largura disponível, em pontos
     * @param texto texto a escrever
     * @param tamanhoFonte tamanho da fonte, em pontos
     * @param emNegrito true para a fonte em negrito
     * @param alinhamento alinhamento do texto dentro da largura
     * @param cor cor do texto
     */
    void texto(final float x, final float base, final float largura, final String texto, final float tamanhoFonte, final boolean emNegrito,
               final Alinhamento alinhamento, final PDColor cor) {
        final var fonteDoTexto = emNegrito ? this.negrito : this.fonte;
        final var ajustado = caber(texto, largura, tamanhoFonte, emNegrito);
        final var sobra = Math.max(0f, largura - larguraNaFonte(fonteDoTexto, ajustado, tamanhoFonte));
        final var deslocamento = alinhamento == Alinhamento.DIREITA ? sobra : alinhamento == Alinhamento.CENTRO ? sobra / 2 : 0;
        escrever(fonteDoTexto, tamanhoFonte, cor, ESQUERDA + x + deslocamento, this.y + base, ajustado);
    }

    /**
     * Escreve as linhas já quebradas, uma abaixo da outra, a partir da linha de base informada; não move o cursor.
     *
     * @param x deslocamento horizontal a partir da margem esquerda do corpo, em pontos
     * @param base linha de base da primeira linha, em pontos abaixo do cursor
     * @param largura largura disponível, em pontos
     * @param linhas linhas a escrever
     * @param tamanhoFonte tamanho da fonte, em pontos
     */
    void linhas(final float x, final float base, final float largura, final List<String> linhas, final float tamanhoFonte) {
        for (int i = 0; i < linhas.size(); i++) {
            texto(x, base + i * alturaLinha(tamanhoFonte), largura, linhas.get(i), tamanhoFonte, false, Alinhamento.ESQUERDA, PRETO);
        }
    }

    /**
     * @param indice coluna, de 0 a 3
     * @return início da coluna, a partir da margem esquerda do corpo, em pontos
     */
    static float coluna(final int indice) {
        return COLUNAS[indice];
    }

    /**
     * @param inicio primeira coluna, de 0 a 3
     * @param quantidade quantidade de colunas ocupadas
     * @return largura das colunas (5,09, 10,19 ou 20,40 cm), em pontos
     */
    static float larguraColunas(final int inicio, final int quantidade) {
        final var fim = inicio + quantidade >= COLUNAS.length ? LARGURA + ESPACO_COLUNAS : COLUNAS[inicio + quantidade];
        return fim - COLUNAS[inicio] - ESPACO_COLUNAS;
    }

    /**
     * Desenha a linha divisória do bloco, de 0,5 ponto (item 2.2.3), na largura do corpo e no nível do cursor.
     */
    void divisoria() {
        linhaHorizontal(0, LARGURA, ESPESSURA_DIVISORIA);
    }

    /**
     * Desenha o título do bloco na primeira coluna, em caixa alta e negrito (item 2.4.1), sem fundo: a divisória do bloco fica
     * com a mesma espessura em toda a largura.
     *
     * @param titulo título do bloco
     */
    void tituloBloco(final String titulo) {
        texto(RECUO, 1.5f + TAMANHO_TITULO * 0.72f, larguraColunas(0, 1) - 2 * RECUO, titulo, TAMANHO_TITULO, true, Alinhamento.ESQUERDA, PRETO);
    }

    /**
     * Desenha um campo a partir do cursor: título de 6 pontos em negrito em cima e conteúdo de 7 pontos embaixo, numa linha só,
     * cortado com reticências se não couber; não move o cursor.
     *
     * @param coluna primeira coluna, de 0 a 3
     * @param colunas quantidade de colunas ocupadas
     * @param rotulo título do campo
     * @param valor conteúdo do campo
     */
    void campo(final int coluna, final int colunas, final String rotulo, final String valor) {
        campo(coluna, colunas, rotulo, TAMANHO_ROTULO, valor);
    }

    /**
     * Como {@link #campo(int, int, String, String)}, com o título no tamanho informado.
     *
     * @param coluna primeira coluna, de 0 a 3
     * @param colunas quantidade de colunas ocupadas
     * @param rotulo título do campo
     * @param tamanhoRotulo tamanho da fonte do título, em pontos
     * @param valor conteúdo do campo
     */
    void campo(final int coluna, final int colunas, final String rotulo, final float tamanhoRotulo, final String valor) {
        final var x = coluna(coluna) + RECUO;
        final var largura = larguraColunas(coluna, colunas) - 2 * RECUO;
        final var baseRotulo = 1.5f + tamanhoRotulo * 0.72f;
        texto(x, baseRotulo, largura, rotulo, tamanhoRotulo, true, Alinhamento.ESQUERDA, PRETO);
        texto(x, baseRotulo + 1.5f + TAMANHO_CONTEUDO, largura, valor, TAMANHO_CONTEUDO, false, Alinhamento.ESQUERDA, PRETO);
    }

    /**
     * Como {@link #campo(int, int, String, String)}, mas o conteúdo pode ocupar mais de uma linha, até o máximo informado
     * (item 2.1); o que passar disso termina com reticências.
     *
     * @param coluna primeira coluna, de 0 a 3
     * @param colunas quantidade de colunas ocupadas
     * @param rotulo título do campo
     * @param valor conteúdo do campo
     * @param maximoLinhas quantidade máxima de linhas do conteúdo
     * @return quantidade de linhas ocupadas pelo conteúdo
     */
    int campo(final int coluna, final int colunas, final String rotulo, final String valor, final int maximoLinhas) {
        final var x = coluna(coluna) + RECUO;
        final var largura = larguraColunas(coluna, colunas) - 2 * RECUO;
        final var baseRotulo = 1.5f + TAMANHO_ROTULO * 0.72f;
        texto(x, baseRotulo, largura, rotulo, TAMANHO_ROTULO, true, Alinhamento.ESQUERDA, PRETO);
        final var linhas = cortarLinhas(quebrar(valor, largura, TAMANHO_CONTEUDO, false), maximoLinhas, largura, TAMANHO_CONTEUDO);
        linhas(x, baseRotulo + 1.5f + TAMANHO_CONTEUDO, largura, linhas, TAMANHO_CONTEUDO);
        return linhas.size();
    }

    /**
     * @param linhasConteudo quantidade de linhas do conteúdo do campo mais alto da linha
     * @return passo vertical da linha de campos, crescido das linhas de conteúdo além da primeira, em pontos
     */
    float alturaLinhaDeCampos(final int linhasConteudo) {
        return LINHA + Math.max(0, linhasConteudo - 1) * alturaLinha(TAMANHO_CONTEUDO);
    }

    /**
     * Desenha, no lugar de um bloco suprimido, a linha divisória e o texto centralizado (item 2.3 e notas 2, 3 e 4 do item 2.4.5).
     *
     * @param texto texto do bloco suprimido
     * @param altura altura do bloco, em pontos
     */
    void blocoSuprimido(final String texto, final float altura) {
        divisoria();
        texto(0, (altura + TAMANHO_CONTEUDO * 0.72f) / 2, LARGURA, texto, TAMANHO_CONTEUDO, false, Alinhamento.CENTRO, PRETO);
    }

    /**
     * Preenche um retângulo com o cinza claro do sombreamento; não move o cursor.
     *
     * @param x deslocamento horizontal a partir da margem esquerda do corpo, em pontos
     * @param largura largura do retângulo, em pontos
     * @param altura altura do retângulo a partir do cursor, em pontos
     */
    void sombrear(final float x, final float largura, final float altura) {
        try {
            this.conteudo.setNonStrokingColor(CINZA_SOMBREAMENTO);
            this.conteudo.addRect(ESQUERDA + x, base(this.y + altura), largura, altura);
            this.conteudo.fill();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Desenha uma linha horizontal no nível do cursor; não move o cursor.
     *
     * @param x deslocamento horizontal a partir da margem esquerda do corpo, em pontos
     * @param largura comprimento da linha, em pontos
     * @param espessura espessura do traço, em pontos
     */
    void linhaHorizontal(final float x, final float largura, final float espessura) {
        traco(ESQUERDA + x, this.y, ESQUERDA + x + largura, this.y, espessura);
    }

    /**
     * Desenha uma linha vertical a partir do cursor, para baixo; não move o cursor.
     *
     * @param x deslocamento horizontal a partir da margem esquerda do corpo, em pontos
     * @param altura comprimento da linha, em pontos
     * @param espessura espessura do traço, em pontos
     */
    void linhaVertical(final float x, final float altura, final float espessura) {
        traco(ESQUERDA + x, this.y, ESQUERDA + x, this.y + altura, espessura);
    }

    /**
     * Desenha o contorno de um retângulo a partir do cursor; não move o cursor.
     *
     * @param x deslocamento horizontal a partir da margem esquerda do corpo, em pontos
     * @param largura largura do retângulo, em pontos
     * @param altura altura do retângulo, em pontos
     * @param espessura espessura do traço, em pontos
     */
    void retangulo(final float x, final float largura, final float altura, final float espessura) {
        contorno(ESQUERDA + x, this.y, largura, altura, espessura);
    }

    private void traco(final float x1, final float y1, final float x2, final float y2, final float espessura) {
        try {
            this.conteudo.setStrokingColor(PRETO);
            this.conteudo.setLineWidth(espessura);
            this.conteudo.moveTo(x1, base(y1));
            this.conteudo.lineTo(x2, base(y2));
            this.conteudo.stroke();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void contorno(final float x, final float topo, final float largura, final float altura, final float espessura) {
        try {
            this.conteudo.setStrokingColor(PRETO);
            this.conteudo.setLineWidth(espessura);
            this.conteudo.addRect(x, base(topo + altura), largura, altura);
            this.conteudo.stroke();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Desenha a borda de 1 ponto da página (item 2.2.3), entre 0,15 cm e 0,20 cm da beira do papel (item 2.2.2).
     */
    void bordaDaPagina() {
        final var largura = this.pagina.getMediaBox().getWidth() - 2 * MARGEM_BORDA;
        final var altura = this.pagina.getMediaBox().getHeight() - 2 * MARGEM_BORDA;
        contorno(MARGEM_BORDA, MARGEM_BORDA, largura, altura, ESPESSURA_BORDA);
    }

    /**
     * Desenha um QR Code quadrado a partir do cursor.
     *
     * @param x deslocamento horizontal a partir da margem esquerda do corpo, em pontos
     * @param tamanho lado do quadrado, em pontos
     * @param texto conteúdo codificado
     * @throws IllegalArgumentException se o conteúdo não puder ser codificado
     */
    void qrCode(final float x, final float tamanho, final String texto) {
        try {
            final var parametros = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            parametros.put(EncodeHintType.MARGIN, 0);
            parametros.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            final var matriz = new QRCodeWriter().encode(texto, BarcodeFormat.QR_CODE, 0, 0, parametros);
            final var modulo = tamanho / matriz.getWidth();
            this.conteudo.setNonStrokingColor(PRETO);
            for (int linha = 0; linha < matriz.getHeight(); linha++) {
                for (int coluna = 0; coluna < matriz.getWidth(); coluna++) {
                    if (matriz.get(coluna, linha)) {
                        this.conteudo.addRect(ESQUERDA + x + coluna * modulo, base(this.y + (linha + 1) * modulo), modulo, modulo);
                    }
                }
            }
            this.conteudo.fill();
        } catch (final Exception e) {
            throw new IllegalArgumentException("Não foi possível gerar o QR Code", e);
        }
    }

    /**
     * Desenha a imagem centralizada na caixa a partir do cursor, mantendo a proporção.
     *
     * @param x deslocamento horizontal a partir da margem esquerda do corpo, em pontos
     * @param largura largura da caixa, em pontos
     * @param altura altura da caixa, em pontos
     * @param imagem bytes da imagem
     */
    void imagem(final float x, final float largura, final float altura, final byte[] imagem) {
        try {
            final var figura = PDImageXObject.createFromByteArray(this.documento, imagem, "logo");
            final var escala = Math.min(largura / figura.getWidth(), altura / figura.getHeight());
            final var w = figura.getWidth() * escala;
            final var h = figura.getHeight() * escala;
            this.conteudo.drawImage(figura, ESQUERDA + x + (largura - w) / 2, base(this.y + altura - (altura - h) / 2), w, h);
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Define o texto da marca d'água, aplicada sobre a página ao fechar o documento.
     *
     * @param texto texto da marca d'água, ou null para não aplicar
     */
    void marcaDagua(final String texto) {
        this.marcaDagua = texto;
    }

    /**
     * Fecha a página e aplica a marca d'água, se houver.
     */
    void fechar() {
        try {
            this.conteudo.close();
            if (this.marcaDagua != null) {
                desenharMarcaDagua();
            }
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Desenha a marca d'água na diagonal da página, em cinza K35, fonte normal (itens 2.5.1 e 2.5.2). A mistura "multiplicar"
     * escurece só o papel: o texto em preto continua legível por baixo dela.
     */
    private void desenharMarcaDagua() throws IOException {
        final var texto = limpar(this.marcaDagua);
        final var larguraPagina = this.pagina.getMediaBox().getWidth();
        final var alturaPagina = this.pagina.getMediaBox().getHeight();
        final var largura = larguraNaFonte(this.fonte, texto, TAMANHO_MARCA_DAGUA);
        final var angulo = Math.atan2(alturaPagina, larguraPagina);
        // centraliza a linha de base deslocada de meia altura das maiusculas, para o texto ficar no centro da pagina
        final var meiaAltura = TAMANHO_MARCA_DAGUA * 0.35;
        final var mistura = new PDExtendedGraphicsState();
        mistura.setBlendMode(BlendMode.MULTIPLY);
        try (final var fluxo = new PDPageContentStream(this.documento, this.pagina, PDPageContentStream.AppendMode.APPEND, true, true)) {
            fluxo.setGraphicsStateParameters(mistura);
            fluxo.setNonStrokingColor(CINZA_MARCA_DAGUA);
            fluxo.beginText();
            fluxo.setFont(this.fonte, TAMANHO_MARCA_DAGUA);
            fluxo.setTextMatrix(Matrix.getRotateInstance(angulo,
                    (float) (larguraPagina / 2 - largura / 2 * Math.cos(angulo) + meiaAltura * Math.sin(angulo)),
                    (float) (alturaPagina / 2 - largura / 2 * Math.sin(angulo) - meiaAltura * Math.cos(angulo))));
            fluxo.showText(texto);
            fluxo.endText();
        }
    }

    /**
     * Escreve uma linha de texto com a linha de base na posição informada (a partir do topo da página).
     */
    private void escrever(final PDFont fonteDoTexto, final float tamanho, final PDColor cor, final float x, final float yBase, final String texto) {
        if (texto.isEmpty()) {
            return;
        }
        try {
            this.conteudo.beginText();
            this.conteudo.setFont(fonteDoTexto, tamanho);
            this.conteudo.setNonStrokingColor(cor);
            this.conteudo.newLineAtOffset(x, base(yBase));
            this.conteudo.showText(texto);
            this.conteudo.endText();
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Converte a posição a partir do topo da página para a coordenada do PDF, que cresce a partir da base.
     */
    private float base(final float aPartirDoTopo) {
        return this.pagina.getMediaBox().getHeight() - aPartirDoTopo;
    }
}
