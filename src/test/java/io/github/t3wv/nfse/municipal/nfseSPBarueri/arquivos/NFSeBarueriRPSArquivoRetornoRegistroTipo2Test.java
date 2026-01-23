package io.github.t3wv.nfse.municipal.nfseSPBarueri.arquivos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFSeBarueriRPSArquivoRetornoRegistroTipo2Test {

    @Test
    void testFromLinhaAndToLinha() {
        final var linha = "2    000068520260115170949674H.0626.2223.5803499-T5   00008160821NC202601150000000000        30456242000155CINE ELI SERGIPE CINEMAS LTDA                                                                       Av Joao Rodrigues                                                                                   42                           Industrial                              Aracaju                                 SE49065450                                                  teste@t3w.io                                                                                                                                            Compartilhamento da receita de exibi��o em 'Cinema'|Filme: Traicao Entre Amigas|Per�odo de exibi��o: 11/12/2025 a 17/12/2025|Salas exibi��o:|Centerplex Aracaju 4: (ISS Exibidor: 2,00%, Participa��o: 50,00%, Renda: R$ 239,83, Total: R$ 117,52|)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     35057081203918609000647000000000068526011709499672";
        assertEquals(linha, new NFSeBarueriRPSArquivoRetornoRegistroTipo2().fromLinha(linha).toLinha());
    }
}