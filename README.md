# NFS-e

Lib para emissão de notas fiscais de serviço brasileira.

## Geração dos CACERTS

``` java
[NFSeCadeiaCertificadosTest] (src/test/java/io/github/t3wv/utils/NFSeCadeiaCertificadosTest.java);
```

## Configuração das variáveis para execução dos testes

```
CADEIA_CERTIFICADOS_PATH=/tmp/cacerts.jks;
CADEIA_CERTIFICADOS_SENHA=senha;
CERTIFICADO_PATH=/tmp/certificado.pfx;
CERTIFICADO_SENHA=senha;
```

## Configurar facade para uso do sistema
``` java
final var facade = new WSFacade(
    new NFSeConfig(
        "/path/to/certificate.pfx",
        "certificate_pass",
        "/path/to/cacerts.jks",
        "cacerts_pass",
        false));
```

## Timeout HTTP (SEFIN / ADN)
Por padrão GET e POST usam 30 segundos. Em implementações de `NFSeConfig`, sobrescreva
`getHttpGetTimeoutSegundos()` e/ou `getHttpPostTimeoutSegundos()` quando a emissão (POST) demorar
mais que o default — por exemplo `return 120;` em `getHttpPostTimeoutSegundos()`.

## Consultar nota emitida
``` java
//PDF
final var pdf = facade.downloadNotaPdf("0000..."); //chave de acesso (50 caracteres)
Files.write(Paths.get("/tmp/%s.pdf".formatted(chave)), pdf); //grava em algum local

//XML
final var xml = facade.downloadNotaXml("0000..."); //chave de acesso (50 caracteres)
Files.writeString(Paths.get("/tmp/%s.xml".formatted(chave)), xml); //grava em algum local
```

## Consultar as notas emitidas contra o CNPJ (distribuição de DF-e do ADN)

A API de distribuição do ADN entrega os documentos em que o CNPJ do certificado figura como
**emitente, tomador ou intermediário** — é por ela que se descobrem as NFS-e emitidas *contra* um
CNPJ, papel que na NF-e cabe ao `NFeDistribuicaoDFe`.

O modelo é sequencial por NSU: guarda-se o último NSU processado e pedem-se os seguintes. O ADN
**não devolve um teto de NSU**, então a drenagem termina quando a resposta vem vazia — mantenha
sempre uma trava de iterações.

``` java
long nsu = 0;                 //recupere do seu armazenamento; 0 começa do início
long ultimoNsuProcessado = -1;
for (int pagina = 0; pagina < 100; pagina++) { //trava de iterações
    final var lote = facade.distribuirDFe(nsu);
    if (lote.vazio()) {
        break; //NENHUM_DOCUMENTO_LOCALIZADO: drenagem concluída
    }
    if (!lote.temDocumentos()) { //REJEICAO, ou um status que esta versão da lib não conhece
        throw new IllegalStateException("Distribuição rejeitada: %s".formatted(lote.getErros()));
    }
    final long maiorNsu = lote.getMaiorNsu().orElse(-1);
    if (maiorNsu <= ultimoNsuProcessado) {
        break; //o lote não trouxe nada novo: para em vez de girar até a trava
    }
    for (final var documento : lote.getLoteDFe()) {
        if (documento.getNsu() == null || documento.getNsu() <= ultimoNsuProcessado) {
            continue; //o NSU de partida pode voltar repetido no lote seguinte
        }
        documento.getTipoDocumento(); //NFSE, EVENTO, DPS, CNC...
        documento.getChaveAcesso();   //50 dígitos, não 44 como na NFe
        documento.getXml();           //XML já desempacotado (o ADN entrega em gzip + base64)
    }
    ultimoNsuProcessado = maiorNsu;
    nsu = maiorNsu; //próxima página parte do último NSU conhecido
}
```

Duas armadilhas que o exemplo acima evita de propósito:

- `temDocumentos()` é `false` tanto para lote vazio quanto para `REJEICAO` — quem usa só ele
  encerra a drenagem em silêncio diante de uma rejeição. O critério de parada é `vazio()`.
- o lote seguinte pode reincluir o NSU de partida; sem a comparação com o último NSU processado,
  o documento é reprocessado a cada página e o laço só termina na trava de iterações.

Consulta pontual de um NSU, sem avançar em lote:

``` java
final var lote = facade.consultarDFePorNsu(42);
```

Eventos vinculados a uma chave de acesso:

``` java
final var eventos = facade.consultarEventosPorChaveAcesso("0000..."); //chave de acesso (50 caracteres)
```

Para consultar outro CNPJ de mesma raiz que a do certificado:

``` java
final var lote = facade.distribuirDFe(nsu, "00000000000000");
```

> A autenticação é o próprio certificado (mTLS): não há token nem chave de API. Requisições sem
> certificado recebem `496 SSL Certificate Required`. As respostas `400` e `404` do ADN são de
> negócio — trazem o mesmo corpo, com o detalhamento em `getErros()` (por exemplo `E2215`, quando
> não existem documentos a partir do NSU informado).

## Consultar alíquota municipal de serviço
``` java
//Consulta a aliquota pra serviço 'Analise e desenvolvimento de sistemas" em "São José, SC"
final var aliquota = facade.consultaAliquotaMunicipioServicoCompetencia("4216602", "01.01.01.000");
Assertions.assertEquals(new BigDecimal("2"), aliquota);
```

## Consultar parametros do convenio
``` java
//Consulta a aliquota pra serviço 'Analise e desenvolvimento de sistemas" em "São José, SC"
final var parametrosMunicipaisConvenio = facade.consultaConvenioMunicipio("4216602");
Assertions.assertNotNull(parametrosMunicipaisConvenio);
Assertions.assertTrue(parametrosMunicipaisConvenio.isAderenteAmbienteNacional());
Assertions.assertFalse(parametrosMunicipaisConvenio.isAderenteEmissorNacional());
Assertions.assertFalse(parametrosMunicipaisConvenio.isAderenteMAN());
Assertions.assertTrue(parametrosMunicipaisConvenio.isPermiteAproveitametoDeCreditos());
Assertions.assertEquals(1, parametrosMunicipaisConvenio.getSituacaoEmissaoPadraoContribuintesRFB());
```


