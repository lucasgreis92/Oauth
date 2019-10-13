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
@Table(name = "oauth_parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OauthParametros.findAll", query = "SELECT o FROM OauthParametros o")
    , @NamedQuery(name = "OauthParametros.findByIdOauthParametros", query = "SELECT o FROM OauthParametros o WHERE o.idOauthParametros = :idOauthParametros")
    , @NamedQuery(name = "OauthParametros.findByGrantType", query = "SELECT o FROM OauthParametros o WHERE o.grantType = :grantType")
    , @NamedQuery(name = "OauthParametros.findByClientId", query = "SELECT o FROM OauthParametros o WHERE o.clientId = :clientId")
    , @NamedQuery(name = "OauthParametros.findByClientSecret", query = "SELECT o FROM OauthParametros o WHERE o.clientSecret = :clientSecret")
    , @NamedQuery(name = "OauthParametros.findByUsername", query = "SELECT o FROM OauthParametros o WHERE o.username = :username")
    , @NamedQuery(name = "OauthParametros.findByPassword", query = "SELECT o FROM OauthParametros o WHERE o.password = :password")})
public class OauthParametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "oauth_parametros_gem", sequenceName = "\"oauth_parametros_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_parametros_gem")
    @Column(name = "id_oauth_parametros")
    private Long idOauthParametros;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "grant_type")
    private String grantType;
    @Size(min = 1, max = 500)
    @Column(name = "client_id")
    private String clientId;
    @Size(min = 1, max = 500)
    @Column(name = "client_secret")
    private String clientSecret;
    @Size(min = 1, max = 500)
    @Column(name = "username")
    private String username;
    @Size(min = 1, max = 500)
    @Column(name = "password")
    private String password;
    @Size(min = 1, max = 500)
    @Column(name = "refresh_token")
    private String refresh_token;
    @Size(min = 1, max = 500)
    @Column(name = "ds_authorization")
    private String authorization;

    public OauthParametros() {
    }

    public OauthParametros(Long idOauthParametros) {
        this.idOauthParametros = idOauthParametros;
    }

    public OauthParametros(Long idOauthParametros, String grantType, String clientId, String clientSecret, String username, String password) {
        this.idOauthParametros = idOauthParametros;
        this.grantType = grantType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.username = username;
        this.password = password;
    }

    public Long getIdOauthParametros() {
        return idOauthParametros;
    }

    public void setIdOauthParametros(Long idOauthParametros) {
        this.idOauthParametros = idOauthParametros;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOauthParametros != null ? idOauthParametros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OauthParametros)) {
            return false;
        }
        OauthParametros other = (OauthParametros) object;
        if ((this.idOauthParametros == null && other.idOauthParametros != null) || (this.idOauthParametros != null && !this.idOauthParametros.equals(other.idOauthParametros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lgrapp.oauth.OauthParametros[ idOauthParametros=" + idOauthParametros + " ]";
    }

}
