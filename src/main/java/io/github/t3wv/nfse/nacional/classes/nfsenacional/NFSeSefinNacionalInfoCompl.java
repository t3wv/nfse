
package io.github.t3wv.nfse.nacional.classes.nfsenacional;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * Grupo de informações complementares disponível para todos os serviços prestados
 */

@Root(name = "infoCompl")
public class NFSeSefinNacionalInfoCompl {

    @Element(name = "idDocTec", required = false)
    protected String idDocResponsabilidadeTecnica;
    @Element(name = "docRef", required = false)
    protected String referenciaDocumento;
    @Element(name = "xPed", required = false)
    protected String numeroPedido;
    // ArrayList, e nao List: com o tipo declarado diferente do objeto, o persister grava o atributo "class", que o XSD recusa
    @ElementList(name = "gItemPed", entry = "xItemPed", required = false)
    protected ArrayList<String> itensPedido;
    @Element(name = "xInfComp", required = false)
    protected String informacoesComplementares;

    /**
     * @return Identificador de Documento de Responsabilidade Técnica: ART, RRT, DRT, Outros.
     */
    public String getIdDocResponsabilidadeTecnica() {
        return idDocResponsabilidadeTecnica;
    }

    /**
     * @param idDocResponsabilidadeTecnica Identificador de Documento de Responsabilidade Técnica: ART, RRT, DRT, Outros.
     */
    public NFSeSefinNacionalInfoCompl setIdDocResponsabilidadeTecnica(String idDocResponsabilidadeTecnica) {
        this.idDocResponsabilidadeTecnica = idDocResponsabilidadeTecnica;
        return this;
    }

    /**
     * Chave da nota, número identificador da nota, número do contrato ou outro identificador de documento emitido pelo prestador de serviços,
     * que subsidia a emissão dessa nota pelo tomador do serviço ou intermediário
     * (preenchimento obrigatório caso a nota esteja sendo emitida pelo Tomador ou intermediário do serviço)
     * @return Referência do documento
     */
    public String getReferenciaDocumento() {
        return referenciaDocumento;
    }

    /**
     * Chave da nota, número identificador da nota, número do contrato ou outro identificador de documento emitido pelo prestador de serviços,
     * que subsidia a emissão dessa nota pelo tomador do serviço ou intermediário
     * (preenchimento obrigatório caso a nota esteja sendo emitida pelo Tomador ou intermediário do serviço)
     * @param referenciaDocumento Referência do documento
     */
    public NFSeSefinNacionalInfoCompl setReferenciaDocumento(String referenciaDocumento) {
        this.referenciaDocumento = referenciaDocumento;
        return this;
    }

    /**
     * @return Número do pedido/ordem de compra/ordem de serviço/projeto que autoriza a prestação do serviço
     */
    public String getNumeroPedido() {
        return numeroPedido;
    }

    /**
     * @param numeroPedido Número do pedido/ordem de compra/ordem de serviço/projeto que autoriza a prestação do serviço
     */
    public NFSeSefinNacionalInfoCompl setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
        return this;
    }

    /**
     * @return Números dos itens do pedido/ordem de compra/ordem de serviço/projeto informado em xPed (até 99)
     */
    public List<String> getItensPedido() {
        return itensPedido;
    }

    /**
     * @param itensPedido Números dos itens do pedido/ordem de compra/ordem de serviço/projeto informado em xPed (até 99)
     */
    public NFSeSefinNacionalInfoCompl setItensPedido(List<String> itensPedido) {
        this.itensPedido = itensPedido == null ? null : new ArrayList<>(itensPedido);
        return this;
    }

    /**
     * @return Informações complementares
     */
    public String getInformacoesComplementares() {
        return informacoesComplementares;
    }

    /**
     * @param informacoesComplementares Informações complementares
     */
    public NFSeSefinNacionalInfoCompl setInformacoesComplementares(String informacoesComplementares) {
        this.informacoesComplementares = informacoesComplementares;
        return this;
    }

}
