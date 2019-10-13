/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.dao.v1.imp;

import com.lgrapp.oauth.dao.AbstractDAO;
import com.lgrapp.oauth.dao.v1.custom.IOauthDAOV1;
import com.lgrapp.oauth.model.Oauth;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adm
 */
@Named("oauthDAOV1")
public class OauthDAOV1 extends AbstractDAO<Oauth> implements IOauthDAOV1 {

    @PersistenceContext(unitName = "oauth_PU")
    private EntityManager entityManager;

    public OauthDAOV1() {
        super(Oauth.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
