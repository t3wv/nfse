package io.github.t3wv.municipal.nfseSPBarueri.webservices;

import io.github.t3wv.NFSeConfig;
import io.github.t3wv.municipal.nfseSPBarueri.classes.*;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public class WSFacade {
    private WSRPS wsRPS;

    public WSFacade(final NFSeConfig config) throws KeyManagementException, UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        // inicia os servicos disponiveis da nfe
        this.wsRPS = new WSRPS(config);
    }

    public NFSeBarueriLoteEnviarArquivoResponse NFeLoteEnviarArquivo(NFSeBarueriLoteEnviarArquivoRequest request) throws Exception {
        return this.wsRPS.NFeLoteEnviarArquivo(request);
    }
    public NFSeBarueriLoteStatusArquivoResponse NFeLoteStatusArquivo(final NFSeBarueriLoteStatusArquivoRequest request) throws Exception {
        return this.wsRPS.NFeLoteStatusArquivo(request);
    }
    public NFSeBarueriLoteBaixarArquivoResponse NFeLoteBaixarArquivo(NFSeBarueriLoteBaixarArquivoRequest request) throws Exception {
        return this.wsRPS.NFeLoteBaixarArquivo(request);
    }
}
