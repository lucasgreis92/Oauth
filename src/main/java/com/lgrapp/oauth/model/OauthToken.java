/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "oauth_token")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OauthToken.findAll", query = "SELECT o FROM OauthToken o")
    , @NamedQuery(name = "OauthToken.findByIdOauthToken", query = "SELECT o FROM OauthToken o WHERE o.idOauthToken = :idOauthToken")
    , @NamedQuery(name = "OauthToken.findByAccessToken", query = "SELECT o FROM OauthToken o WHERE o.accessToken = :access_token")
    , @NamedQuery(name = "OauthToken.findByExpiresIn", query = "SELECT o FROM OauthToken o WHERE o.expiresIn = :expiresIn")
    , @NamedQuery(name = "OauthToken.findAllActive", query = "SELECT o FROM OauthToken o WHERE o.idOauth.expiresIn > :dt_atual")})
public class OauthToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "oauth_token_gem", sequenceName = "\"oauth_token_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_token_gem")
    @Column(name = "id_oauth_token")
    private Long idOauthToken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "access_token")
    private String accessToken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expires_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiresIn;
    @JoinColumn(name = "id_oauth", referencedColumnName = "id_oauth")
    @ManyToOne(optional = false)
    private Oauth idOauth;

    public OauthToken() {
    }

    public OauthToken(Long idOauthToken) {
        this.idOauthToken = idOauthToken;
    }

    public OauthToken(Long idOauthToken, String accessToken, Date expiresIn) {
        this.idOauthToken = idOauthToken;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public Long getIdOauthToken() {
        return idOauthToken;
    }

    public void setIdOauthToken(Long idOauthToken) {
        this.idOauthToken = idOauthToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Date expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Oauth getIdOauth() {
        return idOauth;
    }

    public void setIdOauth(Oauth idOauth) {
        this.idOauth = idOauth;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOauthToken != null ? idOauthToken.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OauthToken)) {
            return false;
        }
        OauthToken other = (OauthToken) object;
        if ((this.idOauthToken == null && other.idOauthToken != null) || (this.idOauthToken != null && !this.idOauthToken.equals(other.idOauthToken))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lgrapp.oauth.OauthToken[ idOauthToken=" + idOauthToken + " ]";
    }

}
