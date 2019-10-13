/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.service.v1.imp;

import com.lgrapp.oauth.base.exception.UnauthorizedException;
import static com.lgrapp.oauth.controller.v1.OauthTokenControllerV1.getToken;
import com.lgrapp.oauth.dao.v1.custom.IAcessoProdutoUsuarioDAOV1;
import com.lgrapp.oauth.dao.v1.custom.IOauthDAOV1;
import com.lgrapp.oauth.dao.v1.custom.IOauthParametrosDAOV1;
import com.lgrapp.oauth.dao.v1.custom.IOauthTokenDAOV1;
import com.lgrapp.oauth.model.AcessoProdutoUsuario;
import com.lgrapp.oauth.model.Oauth;
import com.lgrapp.oauth.model.OauthParametros;
import com.lgrapp.oauth.model.OauthToken;
import com.lgrapp.oauth.service.AbstractService;
import com.lgrapp.oauth.service.v1.custom.IOauthTokenServiceV1;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author adm
 */
@Named("oauthTokenServiceV1")
public class OauthTokenServiceV1 extends AbstractService<OauthToken> implements IOauthTokenServiceV1 {

    @Inject
    @Named("oauthTokenDAOV1")
    IOauthTokenDAOV1 oauthTokenDAOV1;

    @Inject
    @Named("oauthDAOV1")
    IOauthDAOV1 oauthDAOV1;

    @Inject
    @Named("oauthParametrosDAOV1")
    IOauthParametrosDAOV1 oauthParametrosDAOV1;

    @Inject
    @Named("acessoProdutoUsuarioDAOV1")
    IAcessoProdutoUsuarioDAOV1 acessoProdutoUsuarioDAOV1;

    @Override
    public IOauthTokenDAOV1 getCrud() {
        return oauthTokenDAOV1;
    }

    @Override
    public OauthToken doAuthenticate(String urlProduto, String grant_type, String client_id,
            String client_secret, String username, String password, String refresh_token, String authorization) throws UnauthorizedException {

        if (grant_type == null || grant_type.isEmpty()) {
            throw new UnauthorizedException("Informe o grant_type.");
        }
//        if (client_id == null || client_id.isEmpty()) {
//            throw new UnauthorizedException("Informe o client_id.");
//        }
//        if (client_secret == null || client_secret.isEmpty()) {
//            throw new UnauthorizedException("Informe o client_secret.");
//        }
        if (grant_type.equalsIgnoreCase("password") && (username == null || username.isEmpty())) {
            throw new UnauthorizedException("Informe o username.");
        }
        if (grant_type.equalsIgnoreCase("password") && (password == null || password.isEmpty())) {
            throw new UnauthorizedException("Informe o password.");
        }
        if (grant_type.equalsIgnoreCase("refresh_token") && (refresh_token == null || refresh_token.isEmpty())) {
            throw new UnauthorizedException("Informe o refresh_token.");
        }
        if (grant_type.equalsIgnoreCase("refresh_token") && (authorization == null || authorization.isEmpty())) {
            throw new UnauthorizedException("Informe o authorization.");
        }
        AcessoProdutoUsuario acesso = null;
        OauthToken oauthToken = null;
        try {
            if (grant_type.equalsIgnoreCase("password")) {
                acesso = acessoProdutoUsuarioDAOV1.findByUrlProdutoUsername(urlProduto, username);
            } else if (grant_type.equalsIgnoreCase("refresh_token")) {
                oauthToken = oauthTokenDAOV1.findByAccessToken(authorization);
            } else {
                throw new UnauthorizedException("Dados inválidos");
            }

        } catch (Exception ex) {
            throw new UnauthorizedException("Dados inválidos");
        }
        if (grant_type.equalsIgnoreCase("refresh_token")) {
            if (oauthToken == null) {
                throw new UnauthorizedException("Dados inválidos");
            }
            Oauth oauth = oauthToken.getIdOauth();
            if (oauth == null) {
                throw new UnauthorizedException("Dados inválidos");
            }
            if (!oauth.getRefreshToken().equals(refresh_token)) {
                throw new UnauthorizedException("Dados inválidos");
            }
            if (oauth.getExpiresIn().before(new Date())) {
                throw new UnauthorizedException("Refresh_token expired");
            }
            oauth.setExpiresIn(new Date());
            acesso = oauth.getIdAcessoProdutoUsuario();
            oauthDAOV1.edit(oauth);
        }
        if (acesso == null) {
            throw new UnauthorizedException("Dados inválidos");
        }

        if (grant_type.equalsIgnoreCase("password") && !acesso.getIdUsuario().getDsSenha().equals(password)) {
            throw new UnauthorizedException("Dados inválidos");
        }
//        if (!acesso.getIdUsuario().getIdCliente().getClientId().equals(client_id)) {
//            throw new UnauthorizedException("Dados inválidos");
//        }
//        if (!acesso.getIdUsuario().getIdCliente().getClientSecret().equals(client_secret)) {
//            throw new UnauthorizedException("Dados inválidos");
//        }

        OauthParametros oauthParametros = new OauthParametros();
        oauthParametros.setClientId(client_id);
        oauthParametros.setClientSecret(client_secret);
        oauthParametros.setGrantType(grant_type);
        oauthParametros.setPassword(password);
        oauthParametros.setUsername(username);
        oauthParametros.setRefresh_token(refresh_token);
        oauthParametros.setAuthorization(authorization);
        Oauth oauth = new Oauth();
        oauth.setIdAcessoProdutoUsuario(acesso);
        oauth.setIdOauthParametros(oauthParametros);
        oauth.setDtOauth(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(oauth.getDtOauth());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        oauth.setExpiresIn(cal.getTime());
        oauth.setTokenType("Bearer");
        oauth.setRefreshToken(getToken(250));
        OauthToken token = new OauthToken();
        token.setIdOauth(oauth);
        if (oauth.getOauthTokenList() == null) {
            oauth.setOauthTokenList(new ArrayList<OauthToken>());
        }
        oauth.getOauthTokenList().add(token);
        cal.setTime(oauth.getDtOauth());
        cal.add(Calendar.HOUR, 1);
        token.setExpiresIn(cal.getTime());
        token.setAccessToken(getToken(250));
        oauthParametrosDAOV1.create(oauthParametros);
        oauthDAOV1.create(oauth);
        oauthTokenDAOV1.create(token);
        return token;
    }

    @Override
    public List<OauthToken> findAllActive() {
        return oauthTokenDAOV1.findAllActive();
    }

}
