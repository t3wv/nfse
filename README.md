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
//XML
final var xml = facade.downloadNotaXml("0000..."); //chave de acesso (50 caracteres)
Files.writeString(Paths.get("/tmp/%s.xml".formatted(chave)), xml); //grava em algum local

//PDF (DANFSe gerado pela propria biblioteca a partir do XML, ver a secao abaixo)
final var pdf = facade.geraDanfse(xml);
Files.write(Paths.get("/tmp/%s.pdf".formatted(chave)), pdf); //grava em algum local
```

## Gerar o DANFSe em PDF (NT 008)

A API de geração do DANFSe do ADN foi suspensa em 03/08/2026 e o antigo `downloadNotaPdf` foi removido.
O DANFSe agora é gerado pela própria biblioteca, a partir do XML da NFS-e, sem acessar o Sistema
Nacional e sem certificado, conforme a **Nota Técnica nº 008 (Especificações Técnicas do DANFSe), versão 1.02**:
modelo do Anexo I (DANFSe v2.0), página única A4 retrato.

``` java
//a partir do XML da NFS-e (elemento raiz NFSe)
final var pdf = facade.geraDanfse(xml);

//ou a partir do objeto
final var pdf = facade.geraDanfse(nfse); //NFSeSefinNacionalNFSe

//ou sem o facade (nao precisa de NFSeConfig)
final var pdf = new NFSeGeraDanfse().gerar(xml);

//opcoes: sem o canhoto e com a marca d'agua de NFS-e cancelada (ou SUBSTITUIDA)
final var pdf = facade.geraDanfse(xml, new DanfseOpcoes()
        .setCanhoto(false)
        .setSituacao(DanfseSituacao.CANCELADA));
```

- **Canhoto:** sai por padrão (é opcional na NT). Sem ele, as informações complementares ocupam o espaço do bloco (item 2.3.3).
- **Cancelamento e substituição:** o XML da NFS-e não traz esses eventos, então quem gera o DANFSe informa a situação
  (`DanfseSituacao`); as canceladas e substituídas saem com a marca d'água "CANCELADA" ou "SUBSTITUÍDA" (itens 2.5.1 e 2.5.2).
- **Produção restrita:** NFS-e com `tpAmb` = 2 saem com "NFS-e SEM VALIDADE JURÍDICA" em vermelho no cabeçalho (item 2.4.3).
- **QR Code:** `https://www.nfse.gov.br/ConsultaPublica/?tpc=1&chave=` seguido da chave de acesso, com 1,52 cm (item 2.4.3).
- **Blocos sem dados:** tomador, destinatário e intermediário não informados, o destinatário que é o próprio tomador
  (`indDest` = 0) e as operações não sujeitas ao ISSQN (`tribISSQN` = 4) saem com as mensagens das notas 2 a 4 do item 2.4.5;
  as linhas do ISSQN sem dados são suprimidas (nota 5) e a linha do PIS/COFINS de apuração própria só sai para competência
  até 2026 (nota 6). Campos sem informação saem com um traço (nota 12).
- **PIS/COFINS retidos:** quando o `tpRetPisCofins` indica o PIS e/ou a COFINS retidos, o `vPis`/`vCofins` é somado às
  "Contribuições Sociais - Retidas" e o débito de apuração própria sai 0,00. A NT 1.02 descreve essa regra para o código 1;
  a biblioteca aplica a mesma regra, tributo a tributo, aos demais códigos do leiaute 1.01 com PIS ou COFINS retidos.
- **Município dos participantes:** a NT não permite imprimir informações que não constem do XML (item 2.1), e o XML só
  traz o código IBGE do município. O nome sai quando o próprio XML o informa para o mesmo código (local de emissão, de
  prestação e de incidência do ISSQN e do IBS/CBS); nos demais casos, sai `código / UF` (ex.: `3304557 / RJ`).
- **Textos longos:** os campos respeitam a quantidade de caracteres do item 2.4.5 e terminam com reticências quando não
  cabem. Nome, endereço e e-mail dos participantes usam até duas linhas. A descrição do serviço (até 1300 caracteres) e as
  informações complementares (até 2000) ocupam o espaço livre da página; se as duas não couberem, são cortadas com
  reticências, mantendo a linha dos totais aproximados dos tributos.
- **Fontes:** Helvetica e Helvetica Bold, fontes padrão do PDF com as métricas da Arial pedida no item 2.4 (a Microsoft
  Sans Serif não é livre para embutir). Cores em CMYK: preto K100, vermelho M100/Y100, fundo do cabeçalho K5 e marca d'água K35.
- **Logomarca:** a da NFS-e, embutida na biblioteca.

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


