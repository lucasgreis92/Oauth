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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "acesso_produto_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcessoProdutoUsuario.findAll", query = "SELECT a FROM AcessoProdutoUsuario a")
    , @NamedQuery(name = "AcessoProdutoUsuario.findByIdAcessoProdutoUsuario", query = "SELECT a FROM AcessoProdutoUsuario a WHERE a.idAcessoProdutoUsuario = :idAcessoProdutoUsuario")
    , @NamedQuery(name = "AcessoProdutoUsuario.findByIeAtivo", query = "SELECT a FROM AcessoProdutoUsuario a WHERE a.ieAtivo = :ieAtivo")
    ,@NamedQuery(name = "AcessoProdutoUsuario.findByUrlProdutoUsername", query = "SELECT a FROM AcessoProdutoUsuario a WHERE a.ieAtivo = true"
            + " and a.idUsuario.dsUsuario = :dsUsuario "
            + " and a.idProduto.dsUrlProduto = :dsUrlProduto")})
public class AcessoProdutoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "acesso_produto_usuario_gem", sequenceName = "\"acesso_produto_usuario_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acesso_produto_usuario_gem")
    @Column(name = "id_acesso_produto_usuario")
    private Long idAcessoProdutoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ie_ativo")
    private boolean ieAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAcessoProdutoUsuario")
    private List<Oauth> oauthList;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public AcessoProdutoUsuario() {
    }

    public AcessoProdutoUsuario(Long idAcessoProdutoUsuario) {
        this.idAcessoProdutoUsuario = idAcessoProdutoUsuario;
    }

    public AcessoProdutoUsuario(Long idAcessoProdutoUsuario, boolean ieAtivo) {
        this.idAcessoProdutoUsuario = idAcessoProdutoUsuario;
        this.ieAtivo = ieAtivo;
    }

    public Long getIdAcessoProdutoUsuario() {
        return idAcessoProdutoUsuario;
    }

    public void setIdAcessoProdutoUsuario(Long idAcessoProdutoUsuario) {
        this.idAcessoProdutoUsuario = idAcessoProdutoUsuario;
    }

    public boolean getIeAtivo() {
        return ieAtivo;
    }

    public void setIeAtivo(boolean ieAtivo) {
        this.ieAtivo = ieAtivo;
    }

    @XmlTransient
    public List<Oauth> getOauthList() {
        return oauthList;
    }

    public void setOauthList(List<Oauth> oauthList) {
        this.oauthList = oauthList;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcessoProdutoUsuario != null ? idAcessoProdutoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoProdutoUsuario)) {
            return false;
        }
        AcessoProdutoUsuario other = (AcessoProdutoUsuario) object;
        if ((this.idAcessoProdutoUsuario == null && other.idAcessoProdutoUsuario != null) || (this.idAcessoProdutoUsuario != null && !this.idAcessoProdutoUsuario.equals(other.idAcessoProdutoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lgrapp.oauth.AcessoProdutoUsuario[ idAcessoProdutoUsuario=" + idAcessoProdutoUsuario + " ]";
    }

}
