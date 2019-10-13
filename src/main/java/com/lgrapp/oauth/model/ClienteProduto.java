/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "cliente_produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteProduto.findAll", query = "SELECT c FROM ClienteProduto c")
    , @NamedQuery(name = "ClienteProduto.findByIdClienteProduto", query = "SELECT c FROM ClienteProduto c WHERE c.idClienteProduto = :idClienteProduto")
    , @NamedQuery(name = "ClienteProduto.findByIeAtivo", query = "SELECT c FROM ClienteProduto c WHERE c.ieAtivo = :ieAtivo")})
public class ClienteProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "cliente_produto_gem", sequenceName = "\"cliente_produto_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_produto_gem")
    @Column(name = "id_cliente_produto")
    private Long idClienteProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ie_ativo")
    private boolean ieAtivo;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;

    public ClienteProduto() {
    }

    public ClienteProduto(Long idClienteProduto) {
        this.idClienteProduto = idClienteProduto;
    }

    public ClienteProduto(Long idClienteProduto, boolean ieAtivo) {
        this.idClienteProduto = idClienteProduto;
        this.ieAtivo = ieAtivo;
    }

    public Long getIdClienteProduto() {
        return idClienteProduto;
    }

    public void setIdClienteProduto(Long idClienteProduto) {
        this.idClienteProduto = idClienteProduto;
    }

    public boolean getIeAtivo() {
        return ieAtivo;
    }

    public void setIeAtivo(boolean ieAtivo) {
        this.ieAtivo = ieAtivo;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteProduto != null ? idClienteProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteProduto)) {
            return false;
        }
        ClienteProduto other = (ClienteProduto) object;
        if ((this.idClienteProduto == null && other.idClienteProduto != null) || (this.idClienteProduto != null && !this.idClienteProduto.equals(other.idClienteProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lgrapp.oauth.ClienteProduto[ idClienteProduto=" + idClienteProduto + " ]";
    }

}
