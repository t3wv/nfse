package io.github.t3wv.nfse.nacional.classes.nfsenacional;

/**
 * XMLs de NFS-e nacional fictícios, usados pelos testes do modelo e do DANFSe.
 */
public final class NFSeSefinNacionalNFSeFixtures {

    /**
     * NFS-e com todos os grupos que o DANFSe imprime, em produção restrita (tpAmb = 2): prestador emitente, tomador,
     * intermediário, destinatário no exterior, substituição, obra, pedido, ISSQN com suspensão e benefício, PIS/COFINS
     * retidos e IBS/CBS. A DPS é válida no XSD 1.01.
     */
    public static final String XML_COMPLETA = """
            <?xml version="1.0" encoding="utf-8"?>
            <NFSe versao="1.01" xmlns="http://www.sped.fazenda.gov.br/nfse">
                <infNFSe Id="NFS35503082211222333000181000000000123426091234567895">
                    <xLocEmi>São Paulo</xLocEmi>
                    <xLocPrestacao>São Paulo</xLocPrestacao>
                    <nNFSe>1234</nNFSe>
                    <cLocIncid>3550308</cLocIncid>
                    <xLocIncid>São Paulo</xLocIncid>
                    <xTribNac>Análise e desenvolvimento de sistemas.</xTribNac>
                    <xTribMun>Desenvolvimento de programas de computador sob encomenda.</xTribMun>
                    <xNBS>Serviços de desenvolvimento de software</xNBS>
                    <verAplic>SefinNac_Pre_1.4.0</verAplic>
                    <ambGer>2</ambGer>
                    <tpEmis>1</tpEmis>
                    <procEmi>1</procEmi>
                    <cStat>100</cStat>
                    <dhProc>2026-09-15T10:20:30-03:00</dhProc>
                    <nDFSe>99887766</nDFSe>
                    <emit>
                        <CNPJ>11222333000181</CNPJ>
                        <IM>12345678</IM>
                        <xNome>EMPRESA PRESTADORA EXEMPLO LTDA</xNome>
                        <enderNac>
                            <xLgr>AVENIDA PAULISTA</xLgr>
                            <nro>1000</nro>
                            <xCpl>CONJUNTO 101</xCpl>
                            <xBairro>BELA VISTA</xBairro>
                            <cMun>3550308</cMun>
                            <UF>SP</UF>
                            <CEP>01310100</CEP>
                        </enderNac>
                        <fone>11987654321</fone>
                        <email>fiscal@prestadora.example.com</email>
                    </emit>
                    <valores>
                        <vCalcDR>500.00</vCalcDR>
                        <tpBM>2</tpBM>
                        <vCalcBM>250.00</vCalcBM>
                        <vBC>8750.00</vBC>
                        <pAliqAplic>2.00</pAliqAplic>
                        <vISSQN>175.00</vISSQN>
                        <vTotalRet>1325.00</vTotalRet>
                        <vLiq>8475.00</vLiq>
                    </valores>
                    <xOutInf>Informação de uso da administração tributária municipal.</xOutInf>
                    <IBSCBS>
                        <cLocalidadeIncid>3509502</cLocalidadeIncid>
                        <xLocalidadeIncid>Campinas</xLocalidadeIncid>
                        <valores>
                            <vBC>8000.00</vBC>
                            <vCalcReeRepRes>100.00</vCalcReeRepRes>
                            <uf>
                                <pIBSUF>0.10</pIBSUF>
                                <pRedAliqUF>10.00</pRedAliqUF>
                                <pAliqEfetUF>0.09</pAliqEfetUF>
                            </uf>
                            <mun>
                                <pIBSMun>0.05</pIBSMun>
                                <pRedAliqMun>20.00</pRedAliqMun>
                                <pAliqEfetMun>0.04</pAliqEfetMun>
                            </mun>
                            <fed>
                                <pCBS>0.90</pCBS>
                                <pRedAliqCBS>30.00</pRedAliqCBS>
                                <pAliqEfetCBS>0.63</pAliqEfetCBS>
                            </fed>
                        </valores>
                        <totCIBS>
                            <vTotNF>8530.20</vTotNF>
                            <gIBS>
                                <vIBSTot>10.40</vIBSTot>
                                <gIBSUFTot>
                                    <vIBSUF>7.20</vIBSUF>
                                </gIBSUFTot>
                                <gIBSMunTot>
                                    <vIBSMun>3.20</vIBSMun>
                                </gIBSMunTot>
                            </gIBS>
                            <gCBS>
                                <vCBS>44.80</vCBS>
                            </gCBS>
                        </totCIBS>
                    </IBSCBS>
                    <DPS versao="1.01" xmlns="http://www.sped.fazenda.gov.br/nfse">
                        <infDPS Id="DPS355030821122233300018100001000000000000077">
                            <tpAmb>2</tpAmb>
                            <dhEmi>2026-09-15T10:15:00-03:00</dhEmi>
                            <verAplic>ERP_Exemplo_2.0</verAplic>
                            <serie>1</serie>
                            <nDPS>77</nDPS>
                            <dCompet>2026-09-15</dCompet>
                            <tpEmit>1</tpEmit>
                            <cLocEmi>3550308</cLocEmi>
                            <subst>
                                <chSubstda>35503082211222333000181000000000123326091234567891</chSubstda>
                                <cMotivo>99</cMotivo>
                                <xMotivo>Correção dos dados do tomador</xMotivo>
                            </subst>
                            <prest>
                                <CNPJ>11222333000181</CNPJ>
                                <IM>12345678</IM>
                                <fone>11987654321</fone>
                                <email>fiscal@prestadora.example.com</email>
                                <regTrib>
                                    <opSimpNac>3</opSimpNac>
                                    <regApTribSN>2</regApTribSN>
                                    <regEspTrib>2</regEspTrib>
                                </regTrib>
                            </prest>
                            <toma>
                                <CNPJ>11444777000161</CNPJ>
                                <IM>987654</IM>
                                <xNome>EMPRESA TOMADORA DE SERVIÇOS DE TECNOLOGIA DA INFORMAÇÃO E CONSULTORIA EMPRESARIAL S.A.</xNome>
                                <end>
                                    <endNac>
                                        <cMun>3509502</cMun>
                                        <CEP>13015904</CEP>
                                    </endNac>
                                    <xLgr>RUA BARÃO DE JAGUARA</xLgr>
                                    <nro>1481</nro>
                                    <xCpl>SALA 1203, BLOCO B, EDIFÍCIO CENTRO EMPRESARIAL</xCpl>
                                    <xBairro>CENTRO</xBairro>
                                </end>
                                <fone>1932345678</fone>
                                <email>contas.a.pagar@tomadora.example.com</email>
                            </toma>
                            <interm>
                                <CPF>52998224725</CPF>
                                <xNome>INTERMEDIÁRIO PESSOA FÍSICA</xNome>
                                <end>
                                    <endNac>
                                        <cMun>3304557</cMun>
                                        <CEP>20040002</CEP>
                                    </endNac>
                                    <xLgr>AVENIDA RIO BRANCO</xLgr>
                                    <nro>1</nro>
                                    <xBairro>CENTRO</xBairro>
                                </end>
                            </interm>
                            <serv>
                                <locPrest>
                                    <cLocPrestacao>3550308</cLocPrestacao>
                                </locPrest>
                                <cServ>
                                    <cTribNac>010101</cTribNac>
                                    <cTribMun>001</cTribMun>
                                    <xDescServ>Desenvolvimento de módulo de faturamento conforme proposta comercial 2026/042.
                                        Inclui levantamento de requisitos, implementação, testes e implantação em ambiente de produção.
                                    </xDescServ>
                                    <cNBS>115021000</cNBS>
                                </cServ>
                                <obra>
                                    <inscImobFisc>000.111.222-3</inscImobFisc>
                                    <cObra>123456789012</cObra>
                                </obra>
                                <infoCompl>
                                    <idDocTec>ART-2026-0001</idDocTec>
                                    <docRef>CONTRATO 2026/042</docRef>
                                    <xPed>PED-4500012345</xPed>
                                    <gItemPed>
                                        <xItemPed>10</xItemPed>
                                        <xItemPed>20</xItemPed>
                                    </gItemPed>
                                    <xInfComp>Pagamento em 30 dias.</xInfComp>
                                </infoCompl>
                            </serv>
                            <valores>
                                <vServPrest>
                                    <vServ>10000.00</vServ>
                                </vServPrest>
                                <vDescCondIncond>
                                    <vDescIncond>750.00</vDescIncond>
                                    <vDescCond>50.00</vDescCond>
                                </vDescCondIncond>
                                <vDedRed>
                                    <vDR>500.00</vDR>
                                </vDedRed>
                                <trib>
                                    <tribMun>
                                        <tribISSQN>1</tribISSQN>
                                        <exigSusp>
                                            <tpSusp>2</tpSusp>
                                            <nProcesso>123456789012345678901234567890</nProcesso>
                                        </exigSusp>
                                        <BM>
                                            <nBM>35503080100001</nBM>
                                            <vRedBCBM>250.00</vRedBCBM>
                                        </BM>
                                        <tpRetISSQN>2</tpRetISSQN>
                                    </tribMun>
                                    <tribFed>
                                        <piscofins>
                                            <CST>01</CST>
                                            <vBCPisCofins>10000.00</vBCPisCofins>
                                            <pAliqPis>0.65</pAliqPis>
                                            <pAliqCofins>3.00</pAliqCofins>
                                            <vPis>65.00</vPis>
                                            <vCofins>300.00</vCofins>
                                            <tpRetPisCofins>1</tpRetPisCofins>
                                        </piscofins>
                                        <vRetCP>110.00</vRetCP>
                                        <vRetIRRF>150.00</vRetIRRF>
                                        <vRetCSLL>100.00</vRetCSLL>
                                    </tribFed>
                                    <totTrib>
                                        <vTotTrib>
                                            <vTotTribFed>1234.56</vTotTribFed>
                                            <vTotTribEst>0.00</vTotTribEst>
                                            <vTotTribMun>175.00</vTotTribMun>
                                        </vTotTrib>
                                    </totTrib>
                                </trib>
                            </valores>
                            <IBSCBS>
                                <finNFSe>0</finNFSe>
                                <indFinal>0</indFinal>
                                <cIndOp>100301</cIndOp>
                                <indDest>1</indDest>
                                <dest>
                                    <CNPJ>12345678000195</CNPJ>
                                    <xNome>DESTINATÁRIO DA OPERAÇÃO EXEMPLO</xNome>
                                    <end>
                                        <endExt>
                                            <cPais>US</cPais>
                                            <cEndPost>33101</cEndPost>
                                            <xCidade>Miami</xCidade>
                                            <xEstProvReg>Florida</xEstProvReg>
                                        </endExt>
                                        <xLgr>BISCAYNE BOULEVARD</xLgr>
                                        <nro>200</nro>
                                        <xBairro>DOWNTOWN</xBairro>
                                    </end>
                                    <fone>13055550100</fone>
                                    <email>destinatario@example.com</email>
                                </dest>
                                <valores>
                                    <trib>
                                        <gIBSCBS>
                                            <CST>200</CST>
                                            <cClassTrib>200001</cClassTrib>
                                        </gIBSCBS>
                                    </trib>
                                </valores>
                            </IBSCBS>
                        </infDPS>
                    </DPS>
                </infNFSe>
                <Signature xmlns="http://www.w3.org/2000/09/xmldsig#">
                    <SignedInfo>
                        <CanonicalizationMethod Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/>
                        <SignatureMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"/>
                        <Reference URI="#NFS35503082211222333000181000000000123426091234567895">
                            <Transforms>
                                <Transform Algorithm="http://www.w3.org/2000/09/xmldsig#enveloped-signature"/>
                                <Transform Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/>
                            </Transforms>
                            <DigestMethod Algorithm="http://www.w3.org/2001/04/xmlenc#sha256"/>
                            <DigestValue>AAAA</DigestValue>
                        </Reference>
                    </SignedInfo>
                    <SignatureValue>AAAA</SignatureValue>
                    <KeyInfo>
                        <X509Data>
                            <X509Certificate>AAAA</X509Certificate>
                        </X509Data>
                    </KeyInfo>
                </Signature>
            </NFSe>""";

    /**
     * NFS-e só com os grupos obrigatórios: sem tomador, sem IBS/CBS, não sujeita ao ISSQN (tribISSQN = 4), com o item 99 do
     * código de tributação nacional e competência em 2027.
     */
    public static final String XML_MINIMA = """
            <?xml version="1.0" encoding="utf-8"?>
            <NFSe versao="1.01" xmlns="http://www.sped.fazenda.gov.br/nfse">
                <infNFSe Id="NFS35057081211222333000181000000000005627011234567890">
                    <xLocEmi>Barueri</xLocEmi>
                    <xLocPrestacao>Barueri</xLocPrestacao>
                    <nNFSe>56</nNFSe>
                    <xTribNac>Serviços sem a incidência de ISSQN e ICMS.</xTribNac>
                    <verAplic>Sistema NFS-e</verAplic>
                    <ambGer>1</ambGer>
                    <tpEmis>2</tpEmis>
                    <cStat>100</cStat>
                    <dhProc>2027-01-15T09:00:00-03:00</dhProc>
                    <emit>
                        <CNPJ>11222333000181</CNPJ>
                        <xNome>EMPRESA PRESTADORA EXEMPLO LTDA</xNome>
                        <enderNac>
                            <xLgr>ALAMEDA RIO NEGRO</xLgr>
                            <nro>500</nro>
                            <xBairro>ALPHAVILLE</xBairro>
                            <cMun>3505708</cMun>
                            <UF>SP</UF>
                            <CEP>06454000</CEP>
                        </enderNac>
                    </emit>
                    <valores>
                        <vLiq>1500.00</vLiq>
                    </valores>
                    <DPS versao="1.01" xmlns="http://www.sped.fazenda.gov.br/nfse">
                        <infDPS Id="DPS350570821122233300018100005000000000000056">
                            <tpAmb>1</tpAmb>
                            <dhEmi>2027-01-15T08:59:00-03:00</dhEmi>
                            <verAplic>Sistema NFS-e</verAplic>
                            <serie>5</serie>
                            <nDPS>56</nDPS>
                            <dCompet>2027-01-15</dCompet>
                            <tpEmit>1</tpEmit>
                            <cLocEmi>3505708</cLocEmi>
                            <prest>
                                <CNPJ>11222333000181</CNPJ>
                                <regTrib>
                                    <opSimpNac>1</opSimpNac>
                                    <regEspTrib>0</regEspTrib>
                                </regTrib>
                            </prest>
                            <serv>
                                <locPrest>
                                    <cLocPrestacao>3505708</cLocPrestacao>
                                </locPrest>
                                <cServ>
                                    <cTribNac>990101</cTribNac>
                                    <xDescServ>Cessão de direitos de exibição.</xDescServ>
                                </cServ>
                            </serv>
                            <valores>
                                <vServPrest>
                                    <vServ>1500.00</vServ>
                                </vServPrest>
                                <trib>
                                    <tribMun>
                                        <tribISSQN>4</tribISSQN>
                                        <tpRetISSQN>1</tpRetISSQN>
                                    </tribMun>
                                    <totTrib>
                                        <indTotTrib>0</indTotTrib>
                                    </totTrib>
                                </trib>
                            </valores>
                        </infDPS>
                    </DPS>
                </infNFSe>
                <Signature xmlns="http://www.w3.org/2000/09/xmldsig#">
                    <SignedInfo>
                        <CanonicalizationMethod Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/>
                        <SignatureMethod Algorithm="http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"/>
                        <Reference URI="#NFS35057081211222333000181000000000005627011234567890">
                            <Transforms>
                                <Transform Algorithm="http://www.w3.org/2000/09/xmldsig#enveloped-signature"/>
                                <Transform Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/>
                            </Transforms>
                            <DigestMethod Algorithm="http://www.w3.org/2001/04/xmlenc#sha256"/>
                            <DigestValue>AAAA</DigestValue>
                        </Reference>
                    </SignedInfo>
                    <SignatureValue>AAAA</SignatureValue>
                    <KeyInfo>
                        <X509Data>
                            <X509Certificate>AAAA</X509Certificate>
                        </X509Data>
                    </KeyInfo>
                </Signature>
            </NFSe>""";

    private NFSeSefinNacionalNFSeFixtures() {
    }
}
