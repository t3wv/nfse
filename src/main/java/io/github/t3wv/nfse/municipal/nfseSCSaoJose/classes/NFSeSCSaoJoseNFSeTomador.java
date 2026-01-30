package io.github.t3wv.nfse.municipal.nfseSCSaoJose.classes;

import io.github.t3wv.nfse.municipal.nfseSCSaoJose.enums.NFSeSCSaoJosePessoaTipo;
import io.github.t3wv.nfse.transformers.NFSeBigDecimalTransformer;
import io.github.t3wv.nfse.transformers.NFSeBooleanTransformer;
import io.github.t3wv.nfse.transformers.NFSeRegistryMatcher;
import io.github.t3wv.nfse.utils.NFSePersister;
import org.simpleframework.xml.Element;

import java.io.StringWriter;
import java.math.BigDecimal;

public class NFSeSCSaoJoseNFSeTomador {
    @Element(name = "endereco_informado", required = false)
    private boolean enderecoInformado;

    @Element(name = "tipo")
    private NFSeSCSaoJosePessoaTipo tipoPessoa;

    @Element(name = "identificador", required = false)
    private String identificador;

    @Element(name = "estado", required = false)
    private String estado;

    @Element(name = "pais", required = false)
    private String pais;

    @Element(name = "siglaPais", required = false)
    private String siglaPais;

    @Element(name = "codigoIbgePais", required = false)
    private String codigoIbgePais;

    @Element(name = "cpfcnpj", required = false)
    private String cpfcnpj;

    @Element(name = "ie", required = false)
    private String ie;

    @Element(name = "nome_razao_social", required = false)
    private String nomeRazaoSocial;

    @Element(name = "sobrenome_nome_fantasia", required = false)
    private String sobrenomeNomeFantasia;

    @Element(name = "logradouro", required = false)
    private String logradouro;

    @Element(name = "email", required = false)
    private String email;

    @Element(name = "numero_residencia", required = false)
    private String numeroResidencia;

    @Element(name = "complemento", required = false)
    private String complemento;

    @Element(name = "ponto_referencia", required = false)
    private String pontoReferencia;

    @Element(name = "bairro", required = false)
    private String bairro;

    @Element(name = "cidade", required = false)
    private String cidade;

    @Element(name = "cep", required = false)
    private String cep;

    @Element(name = "ddd_fone_comercial", required = false)
    private String dddFoneComercial;

    @Element(name = "fone_comercial", required = false)
    private String foneComercial;

    @Element(name = "ddd_fone_residencial", required = false)
    private String dddFoneResidencial;

    @Element(name = "fone_residencial", required = false)
    private String foneResidencial;

    @Element(name = "ddd_fax", required = false)
    private String dddFax;

    @Element(name = "fone_fax", required = false)
    private String foneFax;

    // Adicionado porque retornou em uma das emissões essa tag vazia para o tomador :P
    @Element(name = "inscricao_municipal", required = false)
    private String inscricao_municipal;

    public boolean isEnderecoInformado() {
        return enderecoInformado;
    }

    public NFSeSCSaoJoseNFSeTomador setEnderecoInformado(boolean enderecoInformado) {
        this.enderecoInformado = enderecoInformado;
        return this;
    }

    public NFSeSCSaoJosePessoaTipo getTipoPessoa() {
        return tipoPessoa;
    }

    public NFSeSCSaoJoseNFSeTomador setTipoPessoa(NFSeSCSaoJosePessoaTipo tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
        return this;
    }

    public String getIdentificador() {
        return identificador;
    }

    public NFSeSCSaoJoseNFSeTomador setIdentificador(String identificador) {
        this.identificador = identificador;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public NFSeSCSaoJoseNFSeTomador setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public NFSeSCSaoJoseNFSeTomador setPais(String pais) {
        this.pais = pais;
        return this;
    }



    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public NFSeSCSaoJoseNFSeTomador setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
        return this;
    }

    public String getIe() {
        return ie;
    }

    public NFSeSCSaoJoseNFSeTomador setIe(String ie) {
        this.ie = ie;
        return this;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public NFSeSCSaoJoseNFSeTomador setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
        return this;
    }

    public String getSobrenomeNomeFantasia() {
        return sobrenomeNomeFantasia;
    }

    public NFSeSCSaoJoseNFSeTomador setSobrenomeNomeFantasia(String sobrenomeNomeFantasia) {
        this.sobrenomeNomeFantasia = sobrenomeNomeFantasia;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public NFSeSCSaoJoseNFSeTomador setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public NFSeSCSaoJoseNFSeTomador setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public NFSeSCSaoJoseNFSeTomador setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public NFSeSCSaoJoseNFSeTomador setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public NFSeSCSaoJoseNFSeTomador setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public NFSeSCSaoJoseNFSeTomador setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public NFSeSCSaoJoseNFSeTomador setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public NFSeSCSaoJoseNFSeTomador setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getDddFoneComercial() {
        return dddFoneComercial;
    }

    public NFSeSCSaoJoseNFSeTomador setDddFoneComercial(String dddFoneComercial) {
        this.dddFoneComercial = dddFoneComercial;
        return this;
    }

    public String getFoneComercial() {
        return foneComercial;
    }

    public NFSeSCSaoJoseNFSeTomador setFoneComercial(String foneComercial) {
        this.foneComercial = foneComercial;
        return this;
    }

    public String getDddFoneResidencial() {
        return dddFoneResidencial;
    }

    public NFSeSCSaoJoseNFSeTomador setDddFoneResidencial(String dddFoneResidencial) {
        this.dddFoneResidencial = dddFoneResidencial;
        return this;
    }

    public String getFoneResidencial() {
        return foneResidencial;
    }

    public NFSeSCSaoJoseNFSeTomador setFoneResidencial(String foneResidencial) {
        this.foneResidencial = foneResidencial;
        return this;
    }

    public String getDddFax() {
        return dddFax;
    }

    public NFSeSCSaoJoseNFSeTomador setDddFax(String dddFax) {
        this.dddFax = dddFax;
        return this;
    }

    public String getFoneFax() {
        return foneFax;
    }

    public NFSeSCSaoJoseNFSeTomador setFoneFax(String foneFax) {
        this.foneFax = foneFax;
        return this;
    }

    public String getSiglaPais() {
        return siglaPais;
    }

    public NFSeSCSaoJoseNFSeTomador setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
        return this;
    }

    public String getCodigoIbgePais() {
        return codigoIbgePais;
    }

    public NFSeSCSaoJoseNFSeTomador setCodigoIbgePais(String codigoIbgePais) {
        this.codigoIbgePais = codigoIbgePais;
        return this;
    }

    public String getInscricao_municipal() {
        return inscricao_municipal;
    }

    public NFSeSCSaoJoseNFSeTomador setInscricao_municipal(String inscricao_municipal) {
        this.inscricao_municipal = inscricao_municipal;
        return this;
    }

    public String toXml() throws Exception {
        final var registryMatcher = new NFSeRegistryMatcher();
        registryMatcher.bind(boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(Boolean.class, new NFSeBooleanTransformer());
        registryMatcher.bind(BigDecimal.class, new NFSeBigDecimalTransformer());

        NFSePersister serializer = new NFSePersister(true, registryMatcher);
        StringWriter writer = new StringWriter();
        serializer.write(this, writer);
        return writer.toString();
    }
}
