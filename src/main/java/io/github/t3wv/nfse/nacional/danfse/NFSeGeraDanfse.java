package io.github.t3wv.nfse.nacional.danfse;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalNFSe;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.LARGURA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.RECUO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.TAMANHO_CONTEUDO;

/**
 * Gera o DANFSe (Documento Auxiliar da NFS-e de padrão nacional) em PDF, a partir do XML da NFS-e, sem acessar o Sistema
 * Nacional. O leiaute segue a NT 008 (Especificações Técnicas do DANFSe, versão 1.02): modelo do Anexo I, página única A4 retrato.
 * <p>
 * A NT não permite imprimir informações que não constem do XML (item 2.1). Por isso o nome do município dos participantes só
 * aparece quando o próprio XML o informa para aquele código IBGE (como o local de emissão ou de incidência); nos demais casos,
 * sai o código do município e a UF.
 */
public class NFSeGeraDanfse {

    /** Abertura do elemento NFSe, com ou sem prefixo de namespace. */
    private static final Pattern ELEMENTO_NFSE = Pattern.compile("<([A-Za-z_][\\w.-]*:)?NFSe[\\s>/]");
    private static final String MENSAGEM_XML_NAO_INFORMADO = "XML da NFS-e não informado";
    private static final String MENSAGEM_NAO_E_NFSE = "O XML não é de uma NFS-e de padrão nacional (elemento raiz NFSe)";
    private static final String MENSAGEM_XML_INVALIDO = "XML da NFS-e inválido";
    private static final String MENSAGEM_NFSE_NAO_INFORMADA = "NFS-e não informada";
    private static final String MENSAGEM_NFSE_SEM_DADOS = "NFS-e sem os dados obrigatórios do DANFSe (infNFSe, emit, valores e DPS com infDPS, prest e serv)";
    private static final String MENSAGEM_ERRO_GERAR_PDF = "Erro ao gerar o PDF do DANFSe";

    /**
     * Gera o DANFSe em PDF a partir do XML da NFS-e, com o canhoto e sem marca d'água.
     *
     * @param xmlNfse XML da NFS-e (elemento raiz NFSe), como devolvido pelo Sistema Nacional
     * @return bytes do PDF
     * @throws IllegalArgumentException se o XML for vazio, inválido ou não for de uma NFS-e
     */
    public byte[] gerar(final String xmlNfse) {
        return this.gerar(ler(xmlNfse), new DanfseOpcoes());
    }

    /**
     * Gera o DANFSe em PDF a partir do XML da NFS-e.
     *
     * @param xmlNfse XML da NFS-e (elemento raiz NFSe), como devolvido pelo Sistema Nacional
     * @param opcoes opções de impressão (canhoto e situação); se nulas, valem as opções padrão
     * @return bytes do PDF
     * @throws IllegalArgumentException se o XML for vazio, inválido ou não for de uma NFS-e
     */
    public byte[] gerar(final String xmlNfse, final DanfseOpcoes opcoes) {
        return this.gerar(ler(xmlNfse), opcoes);
    }

    /**
     * Gera o DANFSe em PDF a partir da NFS-e, com o canhoto e sem marca d'água.
     *
     * @param nfse NFS-e
     * @return bytes do PDF
     * @throws IllegalArgumentException se a NFS-e for nula ou estiver sem os grupos obrigatórios
     */
    public byte[] gerar(final NFSeSefinNacionalNFSe nfse) {
        return this.gerar(nfse, new DanfseOpcoes());
    }

    /**
     * Gera o DANFSe em PDF a partir da NFS-e.
     *
     * @param nfse NFS-e
     * @param opcoes opções de impressão (canhoto e situação); se nulas, valem as opções padrão
     * @return bytes do PDF
     * @throws IllegalArgumentException se a NFS-e for nula ou estiver sem os grupos obrigatórios
     */
    public byte[] gerar(final NFSeSefinNacionalNFSe nfse, final DanfseOpcoes opcoes) {
        validar(nfse);
        return renderizar(new DanfseNota(nfse), opcoes == null ? new DanfseOpcoes() : opcoes);
    }

    /**
     * Lê o XML da NFS-e.
     *
     * @param xmlNfse XML da NFS-e
     * @return NFS-e
     * @throws IllegalArgumentException se o XML for nulo, vazio, inválido ou não for de uma NFS-e
     */
    NFSeSefinNacionalNFSe ler(final String xmlNfse) {
        if (xmlNfse == null || xmlNfse.isBlank()) {
            throw new IllegalArgumentException(MENSAGEM_XML_NAO_INFORMADO);
        }
        if (!raizNfse(xmlNfse)) {
            throw new IllegalArgumentException(MENSAGEM_NAO_E_NFSE);
        }
        try {
            return new NFSePersister().read(NFSeSefinNacionalNFSe.class, xmlNfse);
        } catch (final Exception e) {
            throw new IllegalArgumentException(MENSAGEM_XML_INVALIDO, e);
        }
    }

    /**
     * Confere se o elemento raiz do XML é NFSe: antes dele só podem vir o BOM, espaços, a declaração XML e outras instruções de
     * processamento, e comentários. O prólogo é percorrido com indexOf, em tempo linear: uma expressão regular com repetição
     * sobre ele retrocede demais (e até estoura a pilha) com entradas como muitos "?&gt;&lt;?" seguidos.
     *
     * @param xml XML não vazio
     * @return true se a raiz é o elemento NFSe
     */
    private static boolean raizNfse(final String xml) {
        var posicao = xml.startsWith("﻿") ? 1 : 0;
        while (true) {
            while (posicao < xml.length() && Character.isWhitespace(xml.charAt(posicao))) {
                posicao++;
            }
            final String abertura;
            final String fechamento;
            if (xml.startsWith("<?", posicao)) {
                abertura = "<?";
                fechamento = "?>";
            } else if (xml.startsWith("<!--", posicao)) {
                abertura = "<!--";
                fechamento = "-->";
            } else {
                break;
            }
            final var fim = xml.indexOf(fechamento, posicao + abertura.length());
            if (fim < 0) {
                return false;
            }
            posicao = fim + fechamento.length();
        }
        return ELEMENTO_NFSE.matcher(xml).region(posicao, xml.length()).lookingAt();
    }

    /**
     * Exige os grupos sem os quais o DANFSe não pode ser desenhado.
     *
     * @param nfse NFS-e
     * @throws IllegalArgumentException se a NFS-e for nula ou estiver sem os grupos obrigatórios
     */
    private static void validar(final NFSeSefinNacionalNFSe nfse) {
        if (nfse == null) {
            throw new IllegalArgumentException(MENSAGEM_NFSE_NAO_INFORMADA);
        }
        final var inf = nfse.getInfNFSe();
        if (inf == null || inf.getEmitente() == null || inf.getValores() == null || inf.getDPS() == null || inf.getDPS().getInfDPS() == null
                || inf.getDPS().getInfDPS().getPrestador() == null || inf.getDPS().getInfDPS().getServicoPrestado() == null) {
            throw new IllegalArgumentException(MENSAGEM_NFSE_SEM_DADOS);
        }
    }

    /**
     * Desenha a página única do DANFSe. A descrição do serviço e as informações complementares ocupam o espaço que sobra dos
     * demais blocos (itens 2.3.1 a 2.3.3); se as duas não couberem inteiras, são cortadas com reticências, a começar pela mais
     * longa, mantendo a linha dos totais aproximados dos tributos.
     *
     * @param nota NFS-e validada
     * @param opcoes opções de impressão
     * @return bytes do PDF
     */
    private static byte[] renderizar(final DanfseNota nota, final DanfseOpcoes opcoes) {
        try (final var documento = new PDDocument(); final var saida = new ByteArrayOutputStream()) {
            final var canvas = new DanfseCanvas(documento, opcoes.getMargemSegurancaCm() == null ? 0f : opcoes.getMargemSegurancaCm());
            DanfseCabecalho.desenhar(canvas, nota);
            DanfseParticipantes.desenhar(canvas, nota);

            final var disponivel = DanfseRodape.limiteInferior(opcoes.isCanhoto()) - canvas.y() - DanfseServico.alturaFixa()
                    - DanfseTributos.altura(nota) - DanfseRodape.ALTURA_TITULO;
            final var largura = LARGURA - 2 * RECUO;
            final var totais = DanfseRodape.linhas(canvas, DanfseRodape.totaisAproximados(nota));
            List<String> descricao = DanfseServico.linhasDescricao(canvas, nota);
            List<String> informacoes = DanfseRodape.linhas(canvas, DanfseRodape.informacoes(nota));
            while (DanfseServico.alturaDescricao(canvas, descricao.size()) + DanfseRodape.alturaInformacoes(canvas, informacoes.size() + totais.size()) > disponivel
                    && (descricao.size() > 1 || informacoes.size() > 1)) {
                if (informacoes.size() >= descricao.size()) {
                    informacoes = canvas.cortarLinhas(informacoes, informacoes.size() - 1, largura, TAMANHO_CONTEUDO);
                } else {
                    descricao = canvas.cortarLinhas(descricao, descricao.size() - 1, largura, TAMANHO_CONTEUDO);
                }
            }

            DanfseServico.desenhar(canvas, nota, descricao, DanfseServico.alturaDescricao(canvas, descricao.size()));
            DanfseTributos.desenhar(canvas, nota);
            DanfseRodape.desenhar(canvas, nota, informacoes, totais, opcoes.isCanhoto());
            canvas.bordaDaPagina();
            canvas.marcaDagua(opcoes.getSituacao().getMarcaDagua());
            canvas.fechar();
            documento.save(saida);
            return saida.toByteArray();
        } catch (final IOException e) {
            throw new IllegalStateException(MENSAGEM_ERRO_GERAR_PDF, e);
        }
    }
}
