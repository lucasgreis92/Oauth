/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto")
    , @NamedQuery(name = "Produto.findByDsProduto", query = "SELECT p FROM Produto p WHERE p.dsProduto = :dsProduto")
    , @NamedQuery(name = "Produto.findByIeAtivo", query = "SELECT p FROM Produto p WHERE p.ieAtivo = :ieAtivo")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "produto_gem", sequenceName = "\"produto_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_gem")
    @Column(name = "id_produto")
    private Long idProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ds_produto")
    private String dsProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ie_ativo")
    private boolean ieAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<ClienteProduto> clienteProdutoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduto")
    private List<AcessoProdutoUsuario> acessoProdutoUsuarioList;
    @Column(name = "ds_url_produto")
    private String dsUrlProduto;

    public Produto() {
    }

    public Produto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Long idProduto, String dsProduto, boolean ieAtivo) {
        this.idProduto = idProduto;
        this.dsProduto = dsProduto;
        this.ieAtivo = ieAtivo;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getDsProduto() {
        return dsProduto;
    }

    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }

    public boolean getIeAtivo() {
        return ieAtivo;
    }

    public void setIeAtivo(boolean ieAtivo) {
        this.ieAtivo = ieAtivo;
    }

    @XmlTransient
    public List<ClienteProduto> getClienteProdutoList() {
        return clienteProdutoList;
    }

    public void setClienteProdutoList(List<ClienteProduto> clienteProdutoList) {
        this.clienteProdutoList = clienteProdutoList;
    }

    @XmlTransient
    public List<AcessoProdutoUsuario> getAcessoProdutoUsuarioList() {
        return acessoProdutoUsuarioList;
    }

    public void setAcessoProdutoUsuarioList(List<AcessoProdutoUsuario> acessoProdutoUsuarioList) {
        this.acessoProdutoUsuarioList = acessoProdutoUsuarioList;
    }

    public String getDsUrlProduto() {
        return dsUrlProduto;
    }

    public void setDsUrlProduto(String dsUrlProduto) {
        this.dsUrlProduto = dsUrlProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lgrapp.oauth.Produto[ idProduto=" + idProduto + " ]";
    }

}
