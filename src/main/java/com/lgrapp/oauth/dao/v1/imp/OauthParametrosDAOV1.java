/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.dao.v1.imp;

import com.lgrapp.oauth.dao.AbstractDAO;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lgrapp.oauth.dao.v1.custom.IOauthParametrosDAOV1;
import com.lgrapp.oauth.model.OauthParametros;

/**
 *
 * @author adm
 */
@Named("oauthParametrosDAOV1")
public class OauthParametrosDAOV1 extends AbstractDAO<OauthParametros> implements IOauthParametrosDAOV1 {

    @PersistenceContext(unitName = "oauth_PU")
    private EntityManager entityManager;

    public OauthParametrosDAOV1() {
        super(OauthParametros.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
