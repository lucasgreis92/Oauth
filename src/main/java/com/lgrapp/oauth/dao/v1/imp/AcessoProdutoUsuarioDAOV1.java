/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.dao.v1.imp;

import com.lgrapp.oauth.dao.AbstractDAO;
import com.lgrapp.oauth.dao.v1.custom.IAcessoProdutoUsuarioDAOV1;
import com.lgrapp.oauth.model.AcessoProdutoUsuario;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adm
 */
@Named("acessoProdutoUsuarioDAOV1")
public class AcessoProdutoUsuarioDAOV1 extends AbstractDAO<AcessoProdutoUsuario> implements IAcessoProdutoUsuarioDAOV1 {

    @PersistenceContext(unitName = "oauth_PU")
    private EntityManager entityManager;

    public AcessoProdutoUsuarioDAOV1() {
        super(AcessoProdutoUsuario.class);
    }

    @Override
    public AcessoProdutoUsuario findByUrlProdutoUsername(String urlProduto, String username) {
        Query query = entityManager.createNamedQuery("AcessoProdutoUsuario.findByUrlProdutoUsername");
        query.setParameter("dsUsuario", username);
        query.setParameter("dsUrlProduto", urlProduto);
        return (AcessoProdutoUsuario) query.getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
