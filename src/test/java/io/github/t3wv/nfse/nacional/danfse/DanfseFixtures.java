package io.github.t3wv.nfse.nacional.danfse;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalNFSe;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalNFSeFixtures;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

/**
 * XMLs de NFS-e fictícios dos testes do DANFSe (de {@link NFSeSefinNacionalNFSeFixtures}) e leitura do texto dos PDFs gerados.
 * <ul>
 *   <li>{@link #COMPLETA}: todos os grupos impressos, em produção restrita (tpAmb = 2);</li>
 *   <li>{@link #MINIMA}: só os grupos obrigatórios, sem tomador, sem IBS/CBS, não sujeita ao ISSQN e com competência em 2027.</li>
 * </ul>
 */
final class DanfseFixtures {

    static final String COMPLETA = "nfse-completa";
    static final String MINIMA = "nfse-minima";

    private DanfseFixtures() {
    }

    /**
     * @param nome {@link #COMPLETA} ou {@link #MINIMA}
     * @return conteúdo do XML
     */
    static String xml(final String nome) {
        return switch (nome) {
            case COMPLETA -> NFSeSefinNacionalNFSeFixtures.XML_COMPLETA;
            case MINIMA -> NFSeSefinNacionalNFSeFixtures.XML_MINIMA;
            default -> throw new IllegalArgumentException("XML de teste desconhecido: " + nome);
        };
    }

    /**
     * @param nome {@link #COMPLETA} ou {@link #MINIMA}
     * @return NFS-e lida do XML
     */
    static NFSeSefinNacionalNFSe nfse(final String nome) {
        try {
            return new NFSePersister().read(NFSeSefinNacionalNFSe.class, xml(nome));
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    static DanfseNota nota(final String nome) {
        return new DanfseNota(nfse(nome));
    }

    /**
     * @param pdf bytes do PDF
     * @return texto da página, na ordem em que foi desenhado
     */
    static String texto(final byte[] pdf) {
        try (final var documento = Loader.loadPDF(pdf)) {
            return new PDFTextStripper().getText(documento);
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Caractere desenhado na página e a altura da sua linha de base, em pontos a partir do topo.
     */
    static final class Glifo {
        final String texto;
        final float y;

        Glifo(final String texto, final float y) {
            this.texto = texto;
            this.y = y;
        }
    }

    /**
     * @param pdf bytes do PDF
     * @return todos os caracteres desenhados, com a posição vertical de cada um
     */
    static List<Glifo> glifos(final byte[] pdf) {
        final List<Glifo> glifos = new ArrayList<>();
        try (final var documento = Loader.loadPDF(pdf)) {
            final var leitor = new PDFTextStripper() {
                @Override
                protected void writeString(final String texto, final List<TextPosition> posicoes) {
                    posicoes.forEach(posicao -> glifos.add(new Glifo(posicao.getUnicode(), posicao.getYDirAdj())));
                }
            };
            leitor.getText(documento);
            return glifos;
        } catch (final IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
