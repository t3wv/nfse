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

## Consultar nota emitida
``` java
//PDF
final var pdf = facade.downloadNotaPdf("0000..."); //chave de acesso (50 caracteres)
Files.write(Paths.get("/tmp/%s.pdf".formatted(chave)), pdf); //grava em algum local

//XML
final var xml = facade.downloadNotaXml("0000..."); //chave de acesso (50 caracteres)
Files.writeString(Paths.get("/tmp/%s.xml".formatted(chave)), xml); //grava em algum local
```

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


