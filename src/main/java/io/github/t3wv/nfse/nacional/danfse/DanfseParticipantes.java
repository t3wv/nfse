package io.github.t3wv.nfse.nacional.danfse;

import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalEmitente;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalEndereco;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfDPSTipoEmitente;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoIBSCBSIndDest;
import io.github.t3wv.nfse.nacional.classes.nfsenacional.NFSeSefinNacionalInfoPessoa;

import java.util.Arrays;

import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.CM;
import static io.github.t3wv.nfse.nacional.danfse.DanfseCanvas.LINHA;

/**
 * Blocos do prestador/fornecedor, tomador/adquirente, destinatário e intermediário da operação (itens 2.1.3 a 2.1.6 da NT 008).
 * Os blocos sem dados na NFS-e são suprimidos e trocados pela mensagem das notas 2 e 3 do item 2.4.5.
 */
final class DanfseParticipantes {

    static final String TOMADOR_NAO_IDENTIFICADO = "TOMADOR/ADQUIRENTE DA OPERAÇÃO NÃO IDENTIFICADO NA NFS-e";
    static final String DESTINATARIO_NAO_IDENTIFICADO = "DESTINATÁRIO DA OPERAÇÃO NÃO IDENTIFICADO NA NFS-e";
    static final String DESTINATARIO_E_O_TOMADOR = "O DESTINATÁRIO É O PRÓPRIO TOMADOR/ADQUIRENTE DA OPERAÇÃO";
    static final String INTERMEDIARIO_NAO_IDENTIFICADO = "INTERMEDIÁRIO DA OPERAÇÃO NÃO IDENTIFICADO NA NFS-e";

    /** Altura do bloco suprimido: mínimo de 0,32 cm (notas 2, 3 e 4 do item 2.4.5) e o espaço até o bloco seguinte. */
    static final float ALTURA_SUPRIMIDO = 0.34f * CM;
    private static final int LINHAS_POR_CAMPO = 2;

    /**
     * Dados de um participante já formatados para impressão; os campos sem informação ficam com um traço.
     */
    private static final class Participante {
        private String documento = DanfseFormatador.SEM_INFORMACAO;
        private String inscricaoMunicipal = DanfseFormatador.SEM_INFORMACAO;
        private String telefone = DanfseFormatador.SEM_INFORMACAO;
        private String nome = DanfseFormatador.SEM_INFORMACAO;
        private String municipio = DanfseFormatador.SEM_INFORMACAO;
        private String codigoIbgeCep = DanfseFormatador.SEM_INFORMACAO;
        private String endereco = DanfseFormatador.SEM_INFORMACAO;
        private String email = DanfseFormatador.SEM_INFORMACAO;
    }

    /**
     * Classe utilitária, não deve ser instanciada.
     */
    private DanfseParticipantes() {
    }

    /**
     * Desenha os quatro blocos a partir do cursor; ao final, o cursor fica no topo do bloco do serviço prestado.
     *
     * @param canvas área de desenho
     * @param nota NFS-e
     */
    static void desenhar(final DanfseCanvas canvas, final DanfseNota nota) {
        prestador(canvas, nota);
        tomador(canvas, nota);
        destinatario(canvas, nota);
        intermediario(canvas, nota);
    }

    private static void prestador(final DanfseCanvas canvas, final DanfseNota nota) {
        final var prest = nota.dps().getPrestador();
        final var participante = new Participante();
        if (prest != null) {
            preencher(participante, nota, informado(prest.getCNPJ(), prest.getCPF(), prest.getNIF()), prest.getInscricaoMunicipal(),
                    prest.getTelefone(), prest.getNome(), prest.getEndereco(), prest.getEmail());
        }
        completarComEmitente(participante, nota, NFSeSefinNacionalInfDPSTipoEmitente.PRESTADOR);
        linhasDoParticipante(canvas, "PRESTADOR / FORNECEDOR", participante, true);

        final var regime = prest == null ? null : prest.getRegimeTributario();
        final var simplesNacional = regime == null || regime.getOpSimplesNacional() == null ? null : regime.getOpSimplesNacional().getDescricao();
        final var apuracao = regime == null || regime.getRegimeApuracaoAposLimiteSimplesNacional() == null ? null
                : regime.getRegimeApuracaoAposLimiteSimplesNacional().getDescricao();
        canvas.campo(0, 1, "Simples Nacional na Data de Competência", DanfseFormatador.ouTraco(DanfseFormatador.limitar(simplesNacional, 40)));
        canvas.campo(1, 2, "Regime de Apuração Tributária pelo SN", DanfseFormatador.ouTraco(DanfseFormatador.limitar(apuracao, 80)));
        canvas.avancar(LINHA);
    }

    private static void tomador(final DanfseCanvas canvas, final DanfseNota nota) {
        final var tomador = nota.dps().getTomador();
        if (tomador == null && nota.dps().getTipoEmitente() != NFSeSefinNacionalInfDPSTipoEmitente.TOMADOR) {
            suprimir(canvas, TOMADOR_NAO_IDENTIFICADO);
            return;
        }
        linhasDoParticipante(canvas, "TOMADOR / ADQUIRENTE", pessoa(nota, tomador, NFSeSefinNacionalInfDPSTipoEmitente.TOMADOR), true);
    }

    private static void destinatario(final DanfseCanvas canvas, final DanfseNota nota) {
        final var ibsCbs = nota.ibsCbsDps();
        if (ibsCbs != null && ibsCbs.getIndDest() == NFSeSefinNacionalInfoIBSCBSIndDest.TOMADOR) {
            suprimir(canvas, DESTINATARIO_E_O_TOMADOR);
            return;
        }
        final var dest = ibsCbs == null ? null : ibsCbs.getDest();
        if (dest == null) {
            suprimir(canvas, DESTINATARIO_NAO_IDENTIFICADO);
            return;
        }
        final var participante = new Participante();
        preencher(participante, nota, informado(dest.getCNPJ(), dest.getCPF(), dest.getNIF()), null, dest.getTelefone(), dest.getNome(),
                dest.getEndereco(), dest.getEmail());
        linhasDoParticipante(canvas, "DESTINATÁRIO DA OPERAÇÃO", participante, false);
    }

    private static void intermediario(final DanfseCanvas canvas, final DanfseNota nota) {
        final var intermediario = nota.dps().getIntermediario();
        if (intermediario == null && nota.dps().getTipoEmitente() != NFSeSefinNacionalInfDPSTipoEmitente.INTERMEDIARIO) {
            suprimir(canvas, INTERMEDIARIO_NAO_IDENTIFICADO);
            return;
        }
        linhasDoParticipante(canvas, "INTERMEDIÁRIO DA OPERAÇÃO", pessoa(nota, intermediario, NFSeSefinNacionalInfDPSTipoEmitente.INTERMEDIARIO), true);
    }

    private static void suprimir(final DanfseCanvas canvas, final String texto) {
        canvas.blocoSuprimido(texto, ALTURA_SUPRIMIDO);
        canvas.avancar(ALTURA_SUPRIMIDO);
    }

    /**
     * Desenha as três primeiras linhas do bloco: documento, inscrição e telefone; nome, município e código IBGE/CEP; endereço e
     * e-mail. O destinatário não tem inscrição municipal no leiaute.
     */
    private static void linhasDoParticipante(final DanfseCanvas canvas, final String titulo, final Participante participante, final boolean comInscricao) {
        canvas.divisoria();
        canvas.tituloBloco(titulo);
        canvas.campo(1, 1, "CNPJ / CPF / NIF", participante.documento);
        if (comInscricao) {
            canvas.campo(2, 1, "Indicador Municipal (Inscrição)", participante.inscricaoMunicipal);
        }
        canvas.campo(3, 1, "Telefone", participante.telefone);
        canvas.avancar(LINHA);
        // nome, endereco e e-mail podem ter 80 caracteres, que nem sempre cabem numa linha de 10,19 cm: usam ate duas linhas
        final var linhasNome = canvas.campo(0, 2, "Nome / Nome Empresarial", participante.nome, LINHAS_POR_CAMPO);
        canvas.campo(2, 1, "Município / Sigla UF", participante.municipio);
        canvas.campo(3, 1, "Código IBGE / CEP", participante.codigoIbgeCep);
        canvas.avancar(canvas.alturaLinhaDeCampos(linhasNome));
        final var linhasEndereco = canvas.campo(0, 2, "Endereço", participante.endereco, LINHAS_POR_CAMPO);
        final var linhasEmail = canvas.campo(2, 2, "E-mail", participante.email, LINHAS_POR_CAMPO);
        canvas.avancar(canvas.alturaLinhaDeCampos(Math.max(linhasEndereco, linhasEmail)));
    }

    /**
     * Tomador ou intermediário; quando ele é o emitente da NFS-e, os dados que faltam na DPS vêm do grupo do emitente.
     */
    private static Participante pessoa(final DanfseNota nota, final NFSeSefinNacionalInfoPessoa pessoa, final NFSeSefinNacionalInfDPSTipoEmitente papel) {
        final var participante = new Participante();
        if (pessoa != null) {
            preencher(participante, nota, informado(pessoa.getCNPJ(), pessoa.getCPF(), pessoa.getNIF()), pessoa.getInscricaoMunicipal(),
                    pessoa.getTelefone(), pessoa.getNome(), pessoa.getEndereco(), pessoa.getEmail());
        }
        completarComEmitente(participante, nota, papel);
        return participante;
    }

    /**
     * O leiaute traz um só documento por participante (CNPJ, CPF ou NIF): devolve o que foi informado.
     */
    private static String informado(final String... documentos) {
        return Arrays.stream(documentos).filter(documento -> !DanfseFormatador.texto(documento).isEmpty()).findFirst().orElse(null);
    }

    private static void preencher(final Participante participante, final DanfseNota nota, final String documento,
                                  final String inscricaoMunicipal, final String telefone, final String nome, final NFSeSefinNacionalEndereco endereco,
                                  final String email) {
        participante.documento = DanfseFormatador.documento(documento);
        participante.inscricaoMunicipal = DanfseFormatador.ouTraco(DanfseFormatador.limitar(inscricaoMunicipal, 15));
        participante.telefone = DanfseFormatador.telefone(telefone);
        participante.nome = DanfseFormatador.ouTraco(DanfseFormatador.limitar(nome, 80));
        participante.email = DanfseFormatador.ouTraco(DanfseFormatador.limitar(email, 80));
        if (endereco != null) {
            participante.endereco = DanfseFormatador.ouTraco(DanfseFormatador.limitar(DanfseFormatador.juntar(", ", endereco.getLogradouro(),
                    endereco.getNumero(), endereco.getComplemento(), endereco.getBairro()), 80));
            final var nacional = endereco.getEnderecoNacional();
            final var exterior = endereco.getEnderecoExterior();
            if (nacional != null) {
                participante.municipio = DanfseFormatador.limitar(nota.municipioUf(nacional.getCodigoMunicipio()), 37);
                participante.codigoIbgeCep = DanfseFormatador.ouTraco(DanfseFormatador.juntar(" / ", nacional.getCodigoMunicipio(), DanfseFormatador.cep(nacional.getCEP())));
            } else if (exterior != null) {
                participante.municipio = DanfseFormatador.ouTraco(DanfseFormatador.limitar(DanfseFormatador.juntar(" / ", exterior.getCidade(), exterior.getEstadoProvinciaRegiao()), 37));
                participante.codigoIbgeCep = DanfseFormatador.ouTraco(DanfseFormatador.limitar(exterior.getCodigoPostal(), 21));
            }
        }
    }

    /**
     * Quando o participante é o emitente da NFS-e (tpEmit), a DPS costuma omitir nome e endereço, que o Sistema Nacional informa
     * no grupo do emitente (infNFSe/emit): completa com eles só os campos que ficaram sem informação.
     */
    private static void completarComEmitente(final Participante participante, final DanfseNota nota, final NFSeSefinNacionalInfDPSTipoEmitente papel) {
        final var tipoEmitente = nota.dps().getTipoEmitente() == null ? NFSeSefinNacionalInfDPSTipoEmitente.PRESTADOR : nota.dps().getTipoEmitente();
        final NFSeSefinNacionalEmitente emitente = nota.inf().getEmitente();
        if (tipoEmitente != papel || emitente == null) {
            return;
        }
        final var semInformacao = DanfseFormatador.SEM_INFORMACAO;
        if (semInformacao.equals(participante.documento)) {
            participante.documento = DanfseFormatador.documento(informado(emitente.getCNPJ(), emitente.getCPF()));
        }
        if (semInformacao.equals(participante.inscricaoMunicipal)) {
            participante.inscricaoMunicipal = DanfseFormatador.ouTraco(DanfseFormatador.limitar(emitente.getIM(), 15));
        }
        if (semInformacao.equals(participante.telefone)) {
            participante.telefone = DanfseFormatador.telefone(emitente.getFone());
        }
        if (semInformacao.equals(participante.nome)) {
            participante.nome = DanfseFormatador.ouTraco(DanfseFormatador.limitar(emitente.getXNome(), 80));
        }
        if (semInformacao.equals(participante.email)) {
            participante.email = DanfseFormatador.ouTraco(DanfseFormatador.limitar(emitente.getEmail(), 80));
        }
        final var endereco = emitente.getEnderNac();
        if (endereco != null && semInformacao.equals(participante.endereco)) {
            participante.endereco = DanfseFormatador.ouTraco(DanfseFormatador.limitar(DanfseFormatador.juntar(", ", endereco.getXLgr(), endereco.getNro(),
                    endereco.getXCpl(), endereco.getXBairro()), 80));
            final var nome = nota.nomeMunicipio(endereco.getCMun());
            final var uf = endereco.getUF() == null ? DanfseFormatador.uf(endereco.getCMun()) : endereco.getUF().name();
            participante.municipio = DanfseFormatador.ouTraco(DanfseFormatador.limitar(DanfseFormatador.juntar(" / ", nome == null ? endereco.getCMun() : nome, uf), 37));
            participante.codigoIbgeCep = DanfseFormatador.ouTraco(DanfseFormatador.juntar(" / ", endereco.getCMun(), DanfseFormatador.cep(endereco.getCEP())));
        }
    }
}
