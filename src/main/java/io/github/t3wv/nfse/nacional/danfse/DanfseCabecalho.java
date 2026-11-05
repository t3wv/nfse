package io.github.t3wv.nfse.nacional.danfse;

import java.util.ArrayList;

import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.Alinhamento.CENTRO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.Alinhamento.ESQUERDA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.CM;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.LARGURA;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.PRETO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.RECUO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.TAMANHO_ROTULO_IDENTIFICACAO;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.VERMELHO;

/**
 * Cabeçalho (logomarca, descrição do documento, município e ambientes) e bloco de identificação da NFS-e, com o QR Code
 * (itens 2.1.1, 2.1.2 e 2.4.3 da NT 008).
 */
final class DanfseCabecalho {

    /** Endereço de consulta do QR Code, seguido da chave de acesso (item 2.4.3). */
    static final String URL_CONSULTA_PUBLICA = "https://www.nfse.gov.br/ConsultaPublica/?tpc=1&chave=";
    static final String SEM_VALIDADE_JURIDICA = "NFS-e SEM VALIDADE JURÍDICA";

    // medidas da tabela do item 2.4.5, em centimetros a partir do topo do papel
    private static final float TOPO_CABECALHO = 0.30f;
    private static final float ALTURA_CABECALHO = 1.16f;
    private static final float TOPO_IDENTIFICACAO = 1.48f;
    private static final float ALTURA_CHAVE = 0.77f;
    private static final float ALTURA_LINHA_IDENTIFICACAO = 0.69f;
    /** Topo do bloco do prestador, logo abaixo do bloco de identificação. */
    static final float TOPO_PRESTADOR = 4.34f;

    private static final float TAMANHO_DESCRICAO = 9f;
    private static final float TAMANHO_MUNICIPIO = 8f;
    private static final float TAMANHO_AMBIENTE = 6f;
    private static final float TAMANHO_COMPLEMENTO_QR_CODE = 6f;
    private static final String COMPLEMENTO_QR_CODE = "A autenticidade desta NFS-e pode ser verificada pela leitura deste código QR ou pela consulta da chave de acesso no portal nacional da NFS-e";

    /**
     * Classe utilitária, não deve ser instanciada.
     */
    private DanfseCabecalho() {
    }

    /**
     * Desenha o cabeçalho e a identificação da NFS-e; ao final, o cursor fica no topo do bloco do prestador.
     *
     * @param canvas área de desenho
     * @param nota NFS-e
     */
    static void desenhar(final DanfseCanvas canvas, final DanfseNota nota) {
        cabecalho(canvas, nota);
        identificacao(canvas, nota);
        canvas.posicionar(TOPO_PRESTADOR * CM);
    }

    /**
     * Desenha o cabeçalho sombreado: logomarca da NFS-e à esquerda, "DANFSe v2.0" ao centro e município e ambientes à direita.
     */
    private static void cabecalho(final DanfseCanvas canvas, final DanfseNota nota) {
        canvas.posicionar(TOPO_CABECALHO * CM);
        canvas.sombrear(0, LARGURA, ALTURA_CABECALHO * CM);
        canvas.avancar(0.14f * CM);
        canvas.imagem(0.19f * CM, 4.00f * CM, 0.85f * CM, DanfseLogomarca.PNG);
        canvas.avancar(-0.14f * CM);

        final var descricao = new ArrayList<String>();
        descricao.add("DANFSe v2.0");
        descricao.add("Documento Auxiliar da NFS-e");
        if (nota.homologacao()) {
            descricao.add(SEM_VALIDADE_JURIDICA);
        }
        final var alturaLinha = canvas.alturaLinha(TAMANHO_DESCRICAO);
        final var primeiraBase = (ALTURA_CABECALHO * CM - descricao.size() * alturaLinha) / 2 + TAMANHO_DESCRICAO * 0.85f;
        for (int i = 0; i < descricao.size(); i++) {
            final var cor = i == 2 ? VERMELHO : PRETO;
            canvas.texto(DanfseCanvas.coluna(1), primeiraBase + i * alturaLinha, DanfseCanvas.larguraColunas(1, 2), descricao.get(i), TAMANHO_DESCRICAO, true, CENTRO, cor);
        }

        final var x = DanfseCanvas.coluna(3) + RECUO;
        final var largura = DanfseCanvas.larguraColunas(3, 1) - RECUO;
        final var municipio = municipio(nota);
        if (municipio != null) {
            canvas.texto(x, 0.40f * CM, largura, "Município: " + municipio, TAMANHO_MUNICIPIO, false, ESQUERDA, PRETO);
        }
        final var inf = nota.inf();
        final var ambienteGerador = inf.getAmbienteGeracao() == null ? DanfseFormatador.SEM_INFORMACAO : inf.getAmbienteGeracao().getCodigo();
        final var tipoAmbiente = nota.dps().getTipoAmbiente() == null ? DanfseFormatador.SEM_INFORMACAO : nota.dps().getTipoAmbiente().getCodigo();
        canvas.texto(x, 0.86f * CM, largura, "Ambiente Gerador: " + ambienteGerador, TAMANHO_AMBIENTE, false, ESQUERDA, PRETO);
        canvas.texto(x, 1.11f * CM, largura, "Tipo de Ambiente: " + tipoAmbiente, TAMANHO_AMBIENTE, false, ESQUERDA, PRETO);
    }

    /**
     * Município emissor e UF, como "Município / UF" (até 37 caracteres); não é exibido quando o item do código de tributação
     * nacional é 99 (item 2.4.5). O nome (xLocEmi) descreve o código do município emissor (cLocEmi), então a UF também sai desse
     * código, para os dois serem da mesma localidade; a UF do endereço do emitente só é usada quando o código não a identifica.
     *
     * @return município e UF, ou null quando não deve ser exibido
     */
    static String municipio(final DanfseNota nota) {
        final var servico = nota.dps().getServicoPrestado();
        final var codigoTributacao = servico == null || servico.getCServ() == null ? "" : DanfseFormatador.texto(servico.getCServ().getCodigoNacionalTributacaoISSQN());
        if (codigoTributacao.startsWith("99")) {
            return null;
        }
        final var emitente = nota.inf().getEmitente();
        final var endereco = emitente == null ? null : emitente.getEnderNac();
        final var ufEmissao = DanfseFormatador.uf(nota.dps().getCodigoMunicipioEmissao());
        final var uf = !ufEmissao.isEmpty() || endereco == null || endereco.getUF() == null ? ufEmissao : endereco.getUF().name();
        return DanfseFormatador.limitar(DanfseFormatador.juntar(" / ", nota.inf().getLocalEmissao(), uf), 37);
    }

    /**
     * Desenha a identificação da NFS-e: chave de acesso, números, datas, emitente, situação e finalidade, com o QR Code à direita.
     */
    private static void identificacao(final DanfseCanvas canvas, final DanfseNota nota) {
        final var inf = nota.inf();
        final var dps = nota.dps();
        canvas.posicionar(TOPO_IDENTIFICACAO * CM);
        canvas.divisoria();
        canvas.campo(0, 3, "CHAVE DE ACESSO DA NFS-e", TAMANHO_ROTULO_IDENTIFICACAO, nota.chaveAcesso());
        qrCode(canvas, nota);
        canvas.avancar(ALTURA_CHAVE * CM);

        canvas.campo(0, 1, "NÚMERO DA NFS-e", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.ouTraco(DanfseFormatador.limitar(inf.getNumeroNFSe(), 13)));
        canvas.campo(1, 1, "COMPETÊNCIA DA NFS-e", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.data(dps.getDataInicioPrestacaoServico()));
        canvas.campo(2, 1, "DATA E HORA DA EMISSÃO DA NFS-e", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.dataHora(inf.getDataHoraProcessamento()));
        canvas.avancar(ALTURA_LINHA_IDENTIFICACAO * CM);

        canvas.campo(0, 1, "NÚMERO DA DPS", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.limitar(String.valueOf(dps.getNumeroDPS()), 15));
        canvas.campo(1, 1, "SÉRIE DA DPS", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.ouTraco(DanfseFormatador.limitar(dps.getSerie(), 5)));
        canvas.campo(2, 1, "DATA E HORA DA EMISSÃO DA DPS", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.dataHora(dps.getDataHoraEmissao()));
        canvas.avancar(ALTURA_LINHA_IDENTIFICACAO * CM);

        final var emitente = dps.getTipoEmitente() == null ? null : DanfseFormatador.primeiraMaiuscula(dps.getTipoEmitente().getDescricao());
        canvas.campo(0, 1, "EMITENTE DA NFS-e", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.ouTraco(emitente));
        final var situacao = inf.getSituacao() == null ? null : inf.getSituacao().getDescricao();
        canvas.campo(1, 1, "SITUAÇÃO DA NFS-e", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.ouTraco(DanfseFormatador.limitar(situacao, 40)));
        final var ibsCbs = nota.ibsCbsDps();
        final var finalidade = ibsCbs == null || ibsCbs.getFinNFSe() == null ? null : ibsCbs.getFinNFSe().getDescricao();
        canvas.campo(2, 1, "FINALIDADE", TAMANHO_ROTULO_IDENTIFICACAO, DanfseFormatador.ouTraco(DanfseFormatador.limitar(finalidade, 40)));
    }

    /**
     * Desenha o QR Code de consulta (1,52 cm em X 17,48 cm e Y 1,67 cm) e, abaixo dele, a descrição complementar em três linhas
     * de 6 pontos (item 2.4.3).
     */
    private static void qrCode(final DanfseCanvas canvas, final DanfseNota nota) {
        final var topo = canvas.y();
        canvas.posicionar(1.67f * CM);
        canvas.qrCode((17.48f - 0.30f) * CM, 1.52f * CM, URL_CONSULTA_PUBLICA + nota.chaveAcesso());
        canvas.posicionar(3.36f * CM);
        final var largura = 4.72f * CM;
        final var linhas = canvas.quebrar(COMPLEMENTO_QR_CODE, largura, TAMANHO_COMPLEMENTO_QR_CODE, false);
        for (int i = 0; i < linhas.size(); i++) {
            canvas.texto((15.80f - 0.30f) * CM, TAMANHO_COMPLEMENTO_QR_CODE + i * canvas.alturaLinha(TAMANHO_COMPLEMENTO_QR_CODE), largura,
                    linhas.get(i), TAMANHO_COMPLEMENTO_QR_CODE, false, ESQUERDA, PRETO);
        }
        canvas.posicionar(topo);
    }
}
