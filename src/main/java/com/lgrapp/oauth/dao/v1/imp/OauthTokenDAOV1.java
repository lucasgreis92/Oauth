/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.dao.v1.imp;

import com.lgrapp.oauth.dao.AbstractDAO;
import com.lgrapp.oauth.dao.v1.custom.IOauthTokenDAOV1;
import com.lgrapp.oauth.model.AcessoProdutoUsuario;
import com.lgrapp.oauth.model.OauthToken;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adm
 */
@Named("oauthTokenDAOV1")
public class OauthTokenDAOV1 extends AbstractDAO<OauthToken> implements IOauthTokenDAOV1 {

    @PersistenceContext(unitName = "oauth_PU")
    private EntityManager entityManager;

    public OauthTokenDAOV1() {
        super(OauthToken.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<OauthToken> findAllActive() {
        Query query = entityManager.createNamedQuery("OauthToken.findAllActive");
        query.setParameter("dt_atual", new Date());
        return query.getResultList();
    }

    @Override
    public OauthToken findByAccessToken(String access_token) {
        Query query = entityManager.createNamedQuery("OauthToken.findByAccessToken");
        query.setParameter("access_token", access_token);
        return (OauthToken) query.getSingleResult();
    }
}
