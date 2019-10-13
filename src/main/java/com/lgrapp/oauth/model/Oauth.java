/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adm
 */
@Entity
@Table(name = "oauth")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oauth.findAll", query = "SELECT o FROM Oauth o")
    , @NamedQuery(name = "Oauth.findByIdOauth", query = "SELECT o FROM Oauth o WHERE o.idOauth = :idOauth")
    , @NamedQuery(name = "Oauth.findByDtOauth", query = "SELECT o FROM Oauth o WHERE o.dtOauth = :dtOauth")
    , @NamedQuery(name = "Oauth.findByRefreshToken", query = "SELECT o FROM Oauth o WHERE o.refreshToken = :refreshToken")
    , @NamedQuery(name = "Oauth.findByExpiresIn", query = "SELECT o FROM Oauth o WHERE o.expiresIn = :expiresIn")
    , @NamedQuery(name = "Oauth.findByTokenType", query = "SELECT o FROM Oauth o WHERE o.tokenType = :tokenType")})
public class Oauth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @SequenceGenerator(name = "oauth_gem", sequenceName = "\"oauth_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_gem")
    @Column(name = "id_oauth")
    private Long idOauth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_oauth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtOauth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "refresh_token")
    private String refreshToken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expires_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiresIn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "token_type")
    private String tokenType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOauth")
    private List<OauthToken> oauthTokenList;
    @JoinColumn(name = "id_acesso_produto_usuario", referencedColumnName = "id_acesso_produto_usuario")
    @ManyToOne(optional = false)
    private AcessoProdutoUsuario idAcessoProdutoUsuario;
    @JoinColumn(name = "id_oauth_parametros", referencedColumnName = "id_oauth_parametros")
    @ManyToOne(optional = false)
    private OauthParametros idOauthParametros;

    public Oauth() {
    }

    public Oauth(Long idOauth) {
        this.idOauth = idOauth;
    }

    public Oauth(Long idOauth, Date dtOauth, String refreshToken, Date expiresIn, String tokenType) {
        this.idOauth = idOauth;
        this.dtOauth = dtOauth;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
    }

    public Long getIdOauth() {
        return idOauth;
    }

    public void setIdOauth(Long idOauth) {
        this.idOauth = idOauth;
    }

    public Date getDtOauth() {
        return dtOauth;
    }

    public void setDtOauth(Date dtOauth) {
        this.dtOauth = dtOauth;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Date expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @XmlTransient
    public List<OauthToken> getOauthTokenList() {
        return oauthTokenList;
    }

    public void setOauthTokenList(List<OauthToken> oauthTokenList) {
        this.oauthTokenList = oauthTokenList;
    }

    public AcessoProdutoUsuario getIdAcessoProdutoUsuario() {
        return idAcessoProdutoUsuario;
    }

    public void setIdAcessoProdutoUsuario(AcessoProdutoUsuario idAcessoProdutoUsuario) {
        this.idAcessoProdutoUsuario = idAcessoProdutoUsuario;
    }

    public OauthParametros getIdOauthParametros() {
        return idOauthParametros;
    }

    public void setIdOauthParametros(OauthParametros idOauthParametros) {
        this.idOauthParametros = idOauthParametros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOauth != null ? idOauth.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oauth)) {
            return false;
        }
        Oauth other = (Oauth) object;
        if ((this.idOauth == null && other.idOauth != null) || (this.idOauth != null && !this.idOauth.equals(other.idOauth))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lgrapp.oauth.Oauth[ idOauth=" + idOauth + " ]";
    }

}
