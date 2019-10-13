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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByDsCliente", query = "SELECT c FROM Cliente c WHERE c.dsCliente = :dsCliente")
    , @NamedQuery(name = "Cliente.findByIeAtivo", query = "SELECT c FROM Cliente c WHERE c.ieAtivo = :ieAtivo")
    , @NamedQuery(name = "Cliente.findByClientId", query = "SELECT c FROM Cliente c WHERE c.clientId = :clientId")
    , @NamedQuery(name = "Cliente.findByClientSecret", query = "SELECT c FROM Cliente c WHERE c.clientSecret = :clientSecret")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "cliente_gem", sequenceName = "\"cliente_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_gem")
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ds_cliente")
    private String dsCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ie_ativo")
    private boolean ieAtivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "client_id")
    private String clientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "client_secret")
    private String clientSecret;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<ClienteProduto> clienteProdutoList;

    public Cliente() {
    }

    public Cliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Long idCliente, String dsCliente, boolean ieAtivo, String clientId, String clientSecret) {
        this.idCliente = idCliente;
        this.dsCliente = dsCliente;
        this.ieAtivo = ieAtivo;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getDsCliente() {
        return dsCliente;
    }

    public void setDsCliente(String dsCliente) {
        this.dsCliente = dsCliente;
    }

    public boolean getIeAtivo() {
        return ieAtivo;
    }

    public void setIeAtivo(boolean ieAtivo) {
        this.ieAtivo = ieAtivo;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<ClienteProduto> getClienteProdutoList() {
        return clienteProdutoList;
    }

    public void setClienteProdutoList(List<ClienteProduto> clienteProdutoList) {
        this.clienteProdutoList = clienteProdutoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lgrapp.oauth.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
