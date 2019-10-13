/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.service.v1.custom;

import com.lgrapp.oauth.base.crud.interfaces.ICrud;
import com.lgrapp.oauth.base.exception.UnauthorizedException;
import com.lgrapp.oauth.model.OauthToken;
import java.util.List;

/**
 *
 * @author adm
 */
public interface IOauthTokenServiceV1 extends ICrud<OauthToken> {

    OauthToken doAuthenticate(String urlProduto, String grant_type, String client_id, String client_secret, String username, String password, String refresh_token, String authorization) throws UnauthorizedException;

    List<OauthToken> findAllActive();
}
