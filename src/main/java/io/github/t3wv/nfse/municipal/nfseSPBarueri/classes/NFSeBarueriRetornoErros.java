package io.github.t3wv.nfse.municipal.nfseSPBarueri.classes;

public enum NFSeBarueriRetornoErros {
    ERRO_100("100", "Tipo de Registro Inválido", "Informar Tipo Especificado: 1"),
    ERRO_101("101", "Inscrição do Prestador de Serviços não encontrada na base de dados da PMB", "Informar Número Correto do Prestador de Serviços"),
    ERRO_102("102", "Identificação da Remessa do Contribuinte inválida ou já informada em outro arquivo de remessa", "Informar Número válido e único/exclusivo. Um número outra enviado jamais poderá ser enviado novamente"),
    ERRO_103("103", "Versão do Layout inválida", "Versão atual \"PMB004\""),
    ERRO_200("200", "Tipo de Registro Inválido", "Informar Tipo Especificado: 2"),
    ERRO_201("201", "Tipo de RPS Inválido", "Informar Tipo Especificado: RPS / RPS-C"),
    ERRO_202("202", "Número de Série do RPS Inválida", "Informar o Número de Série do RPS Válida"),
    ERRO_203("203", "Número de Série da Nf-e Inválida", "Informar o Número de Série da NF-e Válida"),
    ERRO_204("204", "Número de RPS não Informado ou inválido. Numeração máxima permitida 0009999999", "Informar o Número do RPS"),
    ERRO_205("205", "Número de RPS já enviado", "Informar um Número de RPS Válido"),
    ERRO_206("206", "Numero do RPS enviado em Duplicidade no Arquivo", "Informar o RPS apenas uma vez no arquivo, caso envie vários arquivos simultâneos enviar o RPS uma vez em apenas 1 dos arquivos."),
    ERRO_207("207", "NF-e não consta na base de dados da PMB, não pode ser cancelada/substituida", "Informar NF-e Válida."),
    ERRO_208("208", "Data Inválida", "A  data  informada  deverá  estar  no  formato  AAAAMMDD,  ou seja,  4  dígitos  para  ano  seguido  de  2  dígitos  para  o  mês seguido de 2 dígitos para o dia."),
    ERRO_209("209", "Data de Emissão não poderá ser inferior a 09/09/2008", "Informar uma Data Válida"),
    ERRO_210("210", "Data de Emissão do RPS não pode ser superior a Data de Hoje", "Informar uma Data Válida"),
    ERRO_211("211", "Hora de Emissão do RPS Inválida", "A hora informada deverá estar no formato HHMMSS, ou seja, 2 dígitos para hora em seguida 2 dígitos para os minutos e e 2 dígitos para os segundos."),
    ERRO_212("212", "Situação do RPS Inválida", "Informar a Situação Especificada: E para RPS Enviado / C para RPS Cancelado / R para Reenvio, correção de informação após rejeite pelo ADN"),
    ERRO_213("213", "Código do Motivo de Cancelamento Inválido", "Informar  o  Código  Especificado:  01  para  Extravio  /  02  para Dados Incorretos / 03 para Substituição"),
    ERRO_214("214", "Campo Descrição do Cancelamento não informado", "Informar a Descrição do Cancelamento"),
    ERRO_215("215", "NFe não pode ser cancelada, guia em aberto para nota fiscal correspondente", "Cancelar a guia correspondente a nota fiscal"),
    ERRO_216("216", "Código de Atividade não encontrada na base da PMB", "Informar Código de Atividade Válido"),
    ERRO_217("217", "Local da Prestação do Serviço Inválido", "Informar  o  Local  Especificado:1  para  serviço  prestado  no Município / 2 para serviço prestado fora do Município"),
    ERRO_218("218", "Serviço Prestado em Vias Públicas Inválido", "Informe  1  para  serviço  prestado  em  vias  públicas  /  2  para serviço não prestado em vias públicas."),
    ERRO_219("219", "Campo Endereco do Serviço Prestado é obrigatório", "Informar Endereço"),
    ERRO_220("220", "Campo Número do Logradouro do Serviço Prestado é obrigatório", "Informar Número"),
    ERRO_221("221", "Campo Bairro do Serviço Prestado é obrigatório", "Informar Bairro"),
    ERRO_222("222", "Campo Cidade do Serviço Prestado é obrigatório", "Informar Cidade"),
    ERRO_223("223", "Campo UF do Serviço Prestado é obrigatório", "Informar UF"),
    ERRO_224("224", "Campo UF do Serviço Prestado invalido", "Informar UF Válido"),
    ERRO_225("225", "Campo CEP do Serviço Prestado invalido", "Informar CEP"),
    ERRO_226("226", "Quantidade de Serviço não deverá ser inferior a zero e/ou Quantidade de Serviço deverá ser numérico", "Informar um Valor Válido."),
    ERRO_227("227", "Valor do Serviço não pode ser menor que zero e/ou Valor do Serviço deverá ser numérico", "Informar um Valor Válido."),
    ERRO_228("228", "Reservado", "-"),
    ERRO_229("229", "Reservado", "-"),
    ERRO_230("230", "Valor Total das Retenções não deverá ser inferior a zero e/ou Valor Total das Retenções deverá ser numérico", "Informar um Valor Válido."),
    ERRO_231("231", "Valor Total das Retenções não poderá ser superior ao Valor Total do serviço prestado", "Informar um Valor Válido."),
    ERRO_232("232", "Valor Total dos Retenções não confere com os valores deduçoes informadas para este RPS", "Informar Somatória dos Valores de Retenções informadas no registro 3  referente a este RPS"),
    ERRO_233("233", "Identificador de tomodor estrangeiro inválido", "Informe 1 Para Tomador Estrangeiro 2 para Tomador Brasileiro"),
    ERRO_234("234", "Código  do  Pais  de  Nacionalidade  do  Tomador  Estrangeiro inválido", "Informe um código de pais válido"),
    ERRO_235("235", "Identificador se Serviço Prestado é exportação inválido", "Informe 1 Para Serviço exportado 2 para Serviço não exportado."),
    ERRO_236("236", "Indicador CPF/CNPJ Inválido", "Informar Indicador do CPF/CNPJ Especificado:1 para CPF / 2 para CNPJ"),
    ERRO_237("237", "CPNJ do Tomador Inválido", "Informar o CPNJ do Tomador Válido"),
    ERRO_238("238", "Campo Nome ou Razão Social do Tomador de Serviços é Obrigatório", "Informar Razão Social"),
    ERRO_239("239", "Campo Endereço do Tomador de Serviços é Obrigatório", "Informar Endereço"),
    ERRO_240("240", "Campo Número do Logradouro do Tomador de Serviços", "Informar Número"),
    ERRO_241("241", "Campo Bairro do Tomador de Serviços é Obrigatório", "Informar Bairro"),
    ERRO_242("242", "Campo Cidade do Tomador de Serviços é Obrigatório", "Informar Cidade"),
    ERRO_243("243", "Campo UF do Tomador de Serviços é Obrigatório", "Informar UF Tomador"),
    ERRO_244("244", "Campo UF do Tomador de Serviços Inválido", "Informar UF Tomador Válida"),
    ERRO_245("245", "Campo CEP do Tomador de Serviços Inválido", "Informar CEP"),
    ERRO_246("246", "Email do Tomador de Serviços Inválido", "Informar e-mail Válido"),
    ERRO_247("247", "Campo Fatura deverá ser numérico", "Informar um conteudo válido."),
    ERRO_248("248", "Valor da Fatura não deverá ser inferior a zero e/ou Valor da Fatura deverá ser numérico", "Informar um Valor Válido."),
    ERRO_249("249", "Campo Forma de Pagamento não informado", "Informar Forma de Pagamento"),
    ERRO_250("250", "Campo Discriminação de Serviço não informado e/ou fora dos padrões estabelecidos no layout", "Informar a Discriminação do Serviço"),
    ERRO_251("251", "Valor Total do Serviço superior ao permitido (campo valor do serviço multiplicado pelo campo quantidade)", "Informar valores validos"),
    ERRO_252("252", "Data Inválida", "A  data  informada  deverá  estar  no  formato  AAAAMMDD,  ou seja,  4  dígitos  para  ano  seguido  de  2  dígitos  para  o  mês seguido de 2 dígitos para o dia."),
    ERRO_253("253", "NFe não pode ser cancelada, data de emissão superior a 90 dias", "Informar NF-e valida para cancelamento/substituição"),
    ERRO_254("254", "Nota Fiscal Já Cancelada", "Informar NF-e valida para cancelamento/substituição"),
    ERRO_255("255", "Nota Fiscal com valores zerados", "O valor  da nota fiscal  é calculado:  (quantidade do  serviço  x preço  unitário)  +  valor  'VN'  informado  no  registro  3.  Esse resultado pode ser zero desde que o valor do serviço ou VN seja diferente de zero."),
    ERRO_256("256", "Contribuinte com condição diferente de ativo", "Artigo  3º.  Os  contribuintes  com  restrições  cadastrais  estão impedidos    de    utilizar    os    sistemas    ora    instituídos. -Contribuinte  com  situação  diferente  de  ativo  não  poderá converter RPS emitidos após a data da alteração da situação. Dúvidas entrar em contato com o Depto. Técnico de Tributos Mobiliários no Tel. 4199-8050."),
    ERRO_257("257", "Nota Fiscal enviada em Duplicidade no Arquivo", "Informar a Nota Fiscal apenas uma vez no arquivo, caso envie vários arquivos simultâneos enviar a Nota uma vez em apenas 1 dos arquivos."),
    ERRO_258("258", "NFe não pode ser cancelada ou substituida competência já encerrada", "Para prosseguir é necessário retificar o movimento através do menu \"Retificar Serviços Prestados\""),
    ERRO_259("259", "Data de Emissão do RPS refere-se a competência já encerrada", "Para prosseguir é necessário retificar o movimento através do menu \"Retificar Serviços Prestados\""),
    ERRO_260("260", "Código de Atividade não permitido", "Informar  um  Código  de  Atividade  vinculado  ao  Perfil  do Contribuinte ou um Código de Atividade tributada."),
    ERRO_261("261", "Código de Atividade Bloqueado", "Informar  um  Código  de  Atividade  vinculado  ao  Perfil  do Contribuinte   (Atingido   o   limite   permitido   de   notas   para atividade não vinculadas ao cadastro do contribuinte)."),
    ERRO_262("262", "Situação do RPS \"R\" para correção de informação junto ao ADN, não permitida", "Não   há   apontamento   de   rejeito   pelo   ADN   para   o   RPS informado, logo não é possível reenvio de informação"),
    ERRO_263("263", "Campo Endereco do Tomador é obrigatório", "Informar Endereço"),
    ERRO_264("264", "Campo Número do Logradouro do Tomador é obrigatório", "Informar Número"),
    ERRO_265("265", "Campo Bairro do Tomador é obrigatório", "Informar Bairro"),
    ERRO_266("266", "Campo Cidade do Tomador é obrigatório", "Informar Cidade"),
    ERRO_300("300", "Tipo de Registro Inválido", "Informar Tipo Especificado: 3"),
    ERRO_301("301", "Código de Outros Valores Inválido", "Informar o Código Especificado: 01 - para IRRF | 02 - para PIS/PASEP | 03 - para COFINS 04 - para CSLL | 05 - para Contribuição Previdenciária | VN  -  para  Valor  não  Incluso  na  Base  de  Cálculo  (exceto tributos  federais).  Esse  campo  somado  ao  valor  total  dos serviços resulta no Valor total da nota."),
    ERRO_302("302", "Caso seja retenção: Valor da Retenção não poderá ser menor/igual a zero Caso seja 'VN' Valor deve ser diferente de zero", "Caso não tenha retenção não informar o registro ou informe um  valor  maior  que  zero.  Se  for  'VN'  informar  um  valor diferente de zero ou simplesmente não informe esse registro"),
    ERRO_303("303", "Soma do serviço prestado e valor 'VN' não poderá ser inferior a zero.", "Informar um Valor Válido."),
    ERRO_304("304", "Código de Outros Valores enviado em Duplicidade no mesmo RPS", "Informar uma única vez cada código por registro RPS"),
    ERRO_305("305", "Conforme Lei Complementar 419 / 2017, ficam  revogados,  a partir   de   30  de  dezembro  de  2017,  todos   os   regimes especiais   e   soluções   de   consulta   cujo   resultado   ermitiu redução   do   preço   do  serviço  ou  da  base  de  cálculo  do Imposto Sobre Serviço de Qualquer Natureza.", "Não informar este tipo de dedução para RPS cuja a data base de cálculo seja superior à 29/12/2017."),
    ERRO_800("800", "Tipo de Registro Inválido", "Informar Tipo Especificado: 4"),
    ERRO_801("801", "Campo Optante Simples Nacional não informado e/ou fora dos padrões estabelecidos no layout", "Informar  Situação  do  Prestador  de  Serviço  /  contribuinte perante o Simples Nacional: 1 - Não Optante; 2 - Optante - Microempreendedor Individual (MEI); 3  -  Optante  -  Microempresa  ou  Empresa  de  Pequeno  Porte (ME/EPP);"),
    ERRO_802("802", "Campo Regime de Apuração Tributária pelo Simples Nacional do Prestador de Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Informar  somente  quando  o  campo  ‘o  ‘Enquadramento  do Prestador do Serviço no Simples Nacional’  estiver preenchido com a opção ‘3’: 1 – Regime de apuração dos tributos federais e municipal pelo Simples Nacional; 2  –  Regime  de  apuração  dos  tributos  federais  pelo  Simples Nacional e o ISSQN pela NFS-e conforme respectiva legislação municipal do tributo; 3 – Regime de apuração dos tributos federais e municipal pela NFS-e conforme respectivas legilações federal e municipal de cada tributo;"),
    ERRO_803("803", "Campo Código do País do local do Serviço Prestado não informado e/ou fora dos padrões estabelecidos no layout", "Informar código do pais do local do Serviço Prestado,  conforme tabela de paises, informado somente quando  o campo “Serviço prestado é exportação” no registro  tipo “2”. *Exceto para serviços prestados no Brasil."),
    ERRO_804("804", "Campo Código da Cidade do Local da Prestação do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "Informar o código do município do endereço do  prestador do serviço conforme tabela do IBGE,  somente para serviços prestados no Brasil. Tabela disponível em: https://www.ibge.gov.br/explica/codigos-dos-municipios.php"),
    ERRO_805("805", "Campo Código Cidade do Tomador não informado e/ou fora dos padrões estabelecidos no layout", "Informar o código do município do Tomador conforme  tabela do IBGE, somente para Tomador nacional. Tabela disponível em: https://www.ibge.gov.br/explica/codigos-dos-municipios.php"),
    ERRO_806("806", "Campo NIF não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente quando tomador de serviço estrangeiro, identificado no Registro tipo “2” Número   de   identificação   fiscal   fornecido   por   órgão   de administração tributária no exterior."),
    ERRO_807("807", "Campo Código NBS  não informado e/ou fora dos padrões estabelecidos no layout", "Informar o Código NBS correspondente ao respectivo código de serviço prestado. Essa correspondência deve considerar os quatro  primeiros  dígitos  do  código  de  serviço  (Item  da  LC 116/03   x   NBS),   conforme   a   Tabela   do   Anexo   VIII   - CorrelaçãoItemNBSIndOp Tabela disponível em: https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica"),
    ERRO_808("808", "Campo Código de Endereço Postal - Tomador Estrangeiro não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente quando tomador de serviço estrangeiro, identificado no Registro tipo “2” Informar o código alfanumérico do Endereçamento Postal no exterior do tomador do serviço."),
    ERRO_809("809", "Campo Estado/Província/Região - Tomador Estrangeiro não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente quando tomador de serviço estrangeiro, identificado no Registro tipo “2” Informar o Estado/província/região no exerior do tomador do serviço."),
    ERRO_810("810", "Campo Vinculo entre as partes do negócio não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente quando tomador de serviço estrangeiro, identificado no Registro tipo “2” ou quando o local de prestação do serviço é no exterior (campo ‘serviço prestado é exportação’ no registro tipo ‘2’) 0 - Sem vínculo com o Tomador / Prestador 1 - Controlada; 2 - Controladora; 3 - Coligada; 4 - Matriz; 5 - Filial ou sucursal; 6 - Outro vínculo;"),
    ERRO_811("811", "Campo Código de Endereço Postal - Serviço prestado no Exterior não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente quando o local de prestação do serviço é no exterior (campo ‘serviço prestado é exportação’ no registro tipo ‘2’). Informar o Código de Endereçamento Postal alfanumérico do endereço quando o serviço é prestado no exterior"),
    ERRO_812("812", "Campo Estado/Província/Região - Serviço prestado no Exterior não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente quando o local de prestação do serviço é no exterior (campo ‘serviço prestado é exportação’ no registro tipo ‘2’). Informar Estado/província/região no exerior do local de prestação do serviço"),
    ERRO_813("813", "Campo Nome do Evento não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente para  atividades com código de serviço iniciados em 12 (Serviços relativos à atividades de eventos, diversões, lazer, entretenimento e congeneres). Informar Nome do evento Artístico, Cultural, Esportivo, entre outros."),
    ERRO_814("814", "Campo Data de início da atividade de evento não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente para atividades com código de serviço iniciados em 12 (Serviços relativos à atividades de eventos, diversões, lazer, entretenimento e congeneres). Informar Data válida de início da atividade de evento. Ano, Mês e Dia (AAAAMMDD)."),
    ERRO_815("815", "Campo Data de fim da atividade de evento não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente para  atividades com código de serviço iniciados em 12 (Serviços relativos à atividades de eventos, diversões, lazer, entretenimento e congeneres). Informar Data válida de fim da atividade de evento. Ano, Mês e Dia (AAAAMMDD)"),
    ERRO_816("816", "Campo Código de justificativa de cancelamento substituição: não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório  somente  para  os  casos  de  RPS  com  Código  de Motivo de Cancelamento “03 - Substitução” no registro Tipo “2 Informar Código de justificativa de cancelamento substituição: 1 - Desenquadramento de NFS-e do Simples Nacional; 2 - Enquadramento de NFS-e no Simples Nacional; 3 - Inclusão Retroativa de Imunidade/Isenção para NFS-e; 4 - Exclusão Retroativa de Imunidade/Isenção para NFS-e; 5 - Rejeição de NFS-e pelo tomador ou pelo intermediário se responsável pelo recolhimento do tributo; 9 - Outros;"),
    ERRO_817("817", "Campo Código Indicador da operação de fornecimento não informado e/ou fora dos padrões estabelecidos no layout", "*Informar o código Indicador de Operação, que deve  orresponder: • Aos 4 primeiros dígitos do código do serviço prestado,  conforme relação do Anexo VIII (Item LC116 x indOp); • Ao código NBS informado, de acordo com o Anexo  VIII - (NBS x indOp); Tabela disponível em: https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica/rtc"),
    ERRO_818("818", "Campo Código de Classificação Tributária do IBS e da CBS não informado e/ou fora dos padrões estabelecidos no layout", "*Informar o código de classificação tributária informado, que deve corresponder: • Aos 4 primeiros dígitos do código do serviço prestado, conforme relação do Anexo VIII (Item LC116 x cClassTrib); • Ao código NBS informado, de acordo com o Anexo VIII - (NBS x cClassTrib); •  Ao Código Indicador de Operação conforme relação do Anexo VIII (indOp x cClassTrib); O Anexo VIII - correlação LC116 X cClassTrib está disponível em: https://www.gov.br/nfse/pt-br/biblioteca/documentacao-tecnica A relação de códigos de classificação tributária está disponível em: https://dfe-"),
    ERRO_819("819", "Campo Código de Situação Tributária IBS CBS não informado e/ou fora dos padrões estabelecidos no layout", "Informar Código de Situação Tributária do IBS e da  CBS Tabela disponível em: https://dfe-portal.svrs.rs.gov.br/DFE/TabelaClassificacaoTributaria"),
    ERRO_820("820", "Campo Operação de uso ou consumo pessoal não informado e/ou fora dos padrões estabelecidos no layout", "Indicar se a operação da nota fiscal de serviços é de uso ou consumo pessoal. (O Art. 57 LC 214/2025 estabelece situação onde um bem ou serviço adquirido é de caráter pessoal.) Opções: 0=Não  | 1=Sim"),
    ERRO_821("821", "Campo Indicador do Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "Informar uma das opções abaixo: 0 – Destinatário é o próprio tomador/adquirente identificado na NFS-e (tomador=adquirente=destinatário); 1 – Destinatário não é o próprio adquirente, podendo ser outra pessoa, física ou jurídica (ou equiparada), ou um estabelecimento diferente do indicado como tomador (tomador=adquirente≠destinatário);"),
    ERRO_822("822", "Tipo de Registro Inválido", "Informar Tipo Especificado: 5"),
    ERRO_823("823", "Campo Código e classificação do crédito presumido IBS e CBS. não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • Código da classificação tributária informado no Registro 4 exigir a informação do código do crédito presumido. O codigo de crédito presumido deve corresponder à classificação tributária, conforme tabela disponível abaixo, é necessário aplicar o filtro de visão aberta por cClassTrib, tabela com correlação disponível em: https://dfe-portal.svrs.rs.gov.br/DFE/ClassificacaoTributaria  Tabela com Códigos Crédito Presumido IBS/CBS, disponível em: https://dfe-portal.svrs.rs.gov.br/DFE/TabelaCreditoPresumido"),
    ERRO_824("824", "Campo Tipo de Ente Governamental  para o caso de aquisição de serviços pela administração pública  não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente para compras governamentais. Este campo deve ser preenchido quando o adquirente/tomador do serviço for um dos órgãos públicos listados abaixo. Tipo de Ente Governamental: 1 = União 2 = Estado 3 = Distrito Federal 4 = Município"),
    ERRO_825("825", "Campo Tipo de Operação com entes Governamentais ou sobre bens imóveis. não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente quando: • Atividade com código de serviço iniciado em '25.05'  OU • Atividade com código de serviço iniciado em '15.09'  OU • Atividade com código de serviço iniciado em '17.12'  OU • Atividade com código de serviço iniciado em '10.05' OU • Campo 'tipo de ente governamental é preenchido' Opções: 1 – Fornecimento com pagamento posterior; 2 - Recebimento do pagamento com fornecimento já realizado; 3 – Fornecimento com pagamento já realizado; 4 – Recebimento do pagamento com fornecimento posterior; 5 – Fornecimento e recebimento do pagamento concomitantes."),
    ERRO_826("826", "Campo Chave da NFS-e referenciada  não informado e/ou fora dos padrões estabelecidos no layout", "Obrigatório somente quando: • Campo 'Tipo de Operação com entes Governamentais ou sobre bens imóveis' é preenchido com 2; OU Campo 'Tipo de Operação om entes Governamentais ou sobre bens imóveis' é preenchido com 3."),
    ERRO_827("827", "Campo Código da Nomenclatura Comum do Mercosul - NCM do bem móvel objeto de locação não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando:   • O código de serviço prestado é iniciado em '990401' Preencher com código NCM da tabela disponível em: https://www.gov.br/receitafederal/pt-br/assuntos/aduana-e-comercio-exterior/classificacao-fiscal-de-mercadorias/download-ncm-nomenclatura-comum-do-mercosul"),
    ERRO_828("828", "Campo Descrição do bem móvel objeto de locação não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O código de serviço prestado é iniciado em '990401'"),
    ERRO_829("829", "Campo Quantidade para bem móvel objeto de locação não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O código de serviço prestado é iniciado em '990401'"),
    ERRO_830("830", "Campo Indicador de operação de doação não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O campo 'Código de Classificação Tributária do IBS e da CBS' do registro 4 é preenchido com '410003'; • OU o campo 'Código de Classificação Tributária do IBS e da CBS' do registro 4 é preenchido com '410026'. Opções: 1 - Doação com contraprestação 2 - Doação sem contraprestação"),
    ERRO_831("831", "Campo Destinatário do serviço é estrangeiro? não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O campo 'Indicador do Destinatário do Serviço' do Registro 4 é preenchido com '1'. Opções: 1 - Sim 2 - Nâo"),
    ERRO_832("832", "Campo CPF/ CNPJ do Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O campo 'Indicador do Destinatário do Serviço' do Registro 4 é preenchido com '1'. E • O campo 'Destinarário do serviço é estrangeiro?' é preenchido com  '2'- Não."),
    ERRO_833("833", "Campo Razão Social / Nome do  Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório para as seguintes situações: • Se o campo 'Indicador do Destinatário do Serviço' do Registro 4 é preenchido com '1'."),
    ERRO_834("834", "Campo Endereço Logradouro do  Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O campo 'Indicador do Destinatário do Serviço' do Registro 4 é preenchido com '1'."),
    ERRO_835("835", "Campo Numero Logradouro do  Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O campo 'Indicador do Destinatário do Serviço' do Registro 4 é preenchido com '1'."),
    ERRO_836("836", "Campo Complemento Logradouro do  Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Quando existir a informação, obrigatório quando: • O campo 'Indicador do Destinatário do Serviço' do Registro 4 é preenchido com '1'."),
    ERRO_837("837", "Campo Bairro Logradouro do  Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O campo 'Indicador do Destinatário do Serviço' do Registro 4 é preenchido com '1'."),
    ERRO_838("838", "Campo Cidade Logradouro do  Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório para as seguintes situações: • Se o campo 'Indicador do Destinatário do Serviço' do Registro 4 é preenchido com '1'."),
    ERRO_839("839", "Campo Código da Cidade do Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Obrigatório somente quando: • O campo 'Indicador do Destinatário do Serviço' do  Registro 4 é preenchido com '1'  E  • O campo 'Destinarário do serviço é estrangeiro?' do  Registro 5 é preenchido com '2' (Não).  Preencher com o código do município conforme tabela  do IBGE, disponível em: https://www.ibge.gov.br/explica/codigos-dos-municipios.php"),
    ERRO_840("840", "Campo UF Logradouro do Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "• O campo 'Indicador do Destinatário do Serviço' é preenchido com '1'; E • O campo 'Destinatário do Serviço é estrangeiro?' é preenchido com  '2 - Não';"),
    ERRO_841("841", "Campo Código do País do Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "Código País do Destinatário - conforme tabela de paises. *Informar somente quando: • O campo 'Indicador do Destinatário do Serviço' é preenchido com '1'; E • O campo 'Destinatário do Serviço é estrangeiro?' é preenchido com  '1 -Sim';"),
    ERRO_842("842", "Campo CEP Logradouro do Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "*Informar somente quando: • O campo 'Indicador do Destinatário do Serviço' é preenchido com '1'; E • O campo 'Destinatário do Serviço é estrangeiro?' é preenchido com  '2 - Não'; Para CEP que não possui os 8 dígitos, completar com zeros a esquerda. Exemplos: 06401220, 00206540"),
    ERRO_843("843", "Campo e-mail do Destinatário do Serviço não informado e/ou fora dos padrões estabelecidos no layout", "Permitido no máximo 3 e-mails, usando o caracter '|' (pipe ou barra vertical) como delimitador de e-mail, sendo o primeiro considerado principal. * Poderá ser preenchido quando o campo Destinatário do Serviço'do Registro 4  é preenchido com '1';"),
    ERRO_844("844", "Campo NIF do Destinatário não informado e/ou fora dos padrões estabelecidos no layout", "*Informar somente quando: • Se o campo 'Indicador do Destinatário do Serviço' é preenchido com '1'; E • Se o campo 'Destinatário do Serviço é estrangeiro?' é preenchido com  '1 -Sim';"),
    ERRO_845("845", "Campo Código de Endereço Postal - Destinatário Estrangeiro não informado e/ou fora dos padrões estabelecidos no layout", "*Informar somente quando: • O campo 'Indicador do Destinatário do Serviço' é preenchido com '1'; E • O campo 'Destinatário do Serviço é estrangeiro?' é preenchido com  '1 -Sim';"),
    ERRO_846("846", "Campo Estado/Província/Região - Destinatário Estrangeiro não informado e/ou fora dos padrões estabelecidos no layout", "*Informar somente quando: • O campo 'Indicador do Destinatário do Serviço' é preenchido com '1'; E • O campo 'Destinatário do Serviço é estrangeiro?' é preenchido com  '1 -Sim';"),
    ERRO_400("400", "Tipo de Registro Inválido", "Informar Tipo Especificado: 9"),
    ERRO_401("401", "Número de Linhas não confere com número de linhas do tipo 1,2,3 e 9 enviadas no arquivo", "Informe o número de linhas (tipo 1,2,3 e 9)"),
    ERRO_402("402", "Valor Total dos Serviços não confere os valores de serviços enviados no arquivo", "Informar Somatória dos Valores Totais de Serviços Prestados (Soma    dos    valores    dos    serviços    multiplicados    pelas quantidades de cada serviço)"),
    ERRO_403("403", "Valor Total das Retenções e Total de outros valores informados no registro 3 não confere com total informado", "Informar  Somatória  dos  Valores  Totais  lançados  no  Registro tipo 3."),
    ERRO_000("000", "Lay-Out do arquivo fora dos padrões", "O arquivo enviado não é um arquivo de Remessa da NFe de Barueri.  Enviar  um  arquivo  com  os  Registros:  1,  2,  4,  9  e opcionalmente o registro tipo 3"),
    ERRO_500("500", "Lay-Out do arquivo fora dos padrões", "Os registros válidos esperados no arquivo são tipo: 1,2,3,4 e 9"),
    ERRO_600("600", "Lay-Out do arquivo fora dos padrões", "Deve haver apenas um registro tipo 9 e esse deve ser o último registro do arquivo"),
    ERRO_601("601", "Não foi informado um registro do tipo 4 para um registro do tipo 2", "Um registro do tipo 4 é obrigatório para cada registro 2"),
    ERRO_602("602", "Foi detectado dois ou mais registros tipo 4 e apenas um registro tipo 2.", "A relação de registros tipo 2 e tipo 4 é de um para um, ou seja, para cada registro tipo 2 deve existir apenas um registro tipo 4."),
    ERRO_603("603", "Registro fora de sequência", "O registro atual está fora da sequência esperada."),
    ERRO_604("604", "Não foi informado um registro do tipo 5 para um registro do tipo 4", "O Registro 5 é obrigatório quando as informações no Registro 4 ativam regras de validação que exigem sua inclusão."),
    ERRO_605("605", "Foi detectado dois ou mais registros tipo 5 e apenas um registro tipo 4.", "A relação de registros tipo 4 e tipo 5 é de um para um, ou seja, para cada registro tipo 4 pode existir apenas um registro tipo 5."),
    ERRO_700("700", "Quantidade de RPS superior ao padrão", "Enviar um arquivo com no máximo 1000 RPS"),
    ERRO_900("900", "Tamanho do Registro diferente da especificação do layout", "Reveja as posições/tamanho para cada registro, certifique-se que o tamanho dos registros conferem com o layout e contém o caracter de fim de linha conforme especificado no layout"),
    ERRO_901("901", "Arquivo com ausência de um dos Registros: 1, 2, 4, 5 ou 9", "Reveja   os   registros   do   arquivo,   certifique-se   que   todos registros   mencionados   estão   presentes   em   seu   arquivo. Também  certifique-se  que  todos  os  registros  do  arquivo contém o caracter de fim de linha conforme especificado no layout");

    private final String codigo;
    private final String descricao;
    private final String solucao;

    NFSeBarueriRetornoErros(final String codigo, final String descricao, final String solucao) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.solucao = solucao;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public static NFSeBarueriRetornoErros valueOfCodigo(final String codigo) {
        for (final NFSeBarueriRetornoErros erro : values()) {
            if (erro.getCodigo().equalsIgnoreCase(codigo)) {
                return erro;
            }
        }
        return null;
    }
}

