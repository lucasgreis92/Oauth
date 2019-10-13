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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByDsUsuario", query = "SELECT u FROM Usuario u WHERE u.dsUsuario = :dsUsuario")
    , @NamedQuery(name = "Usuario.findByDsSenha", query = "SELECT u FROM Usuario u WHERE u.dsSenha = :dsSenha")
    , @NamedQuery(name = "Usuario.findByIeAtivo", query = "SELECT u FROM Usuario u WHERE u.ieAtivo = :ieAtivo")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "usuario_gem", sequenceName = "\"usuario_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_gem")
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ds_usuario")
    private String dsUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ds_senha")
    private String dsSenha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ie_ativo")
    private boolean ieAtivo;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<AcessoProdutoUsuario> acessoProdutoUsuarioList;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String dsUsuario, String dsSenha, boolean ieAtivo) {
        this.idUsuario = idUsuario;
        this.dsUsuario = dsUsuario;
        this.dsSenha = dsSenha;
        this.ieAtivo = ieAtivo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDsUsuario() {
        return dsUsuario;
    }

    public void setDsUsuario(String dsUsuario) {
        this.dsUsuario = dsUsuario;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
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

    @XmlTransient
    public List<AcessoProdutoUsuario> getAcessoProdutoUsuarioList() {
        return acessoProdutoUsuarioList;
    }

    public void setAcessoProdutoUsuarioList(List<AcessoProdutoUsuario> acessoProdutoUsuarioList) {
        this.acessoProdutoUsuarioList = acessoProdutoUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lgrapp.oauth.Usuario[ idUsuario=" + idUsuario + " ]";
    }

}
