/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.dao.v1.custom;

import com.lgrapp.oauth.base.crud.interfaces.ICrud;
import com.lgrapp.oauth.model.OauthToken;
import java.util.List;

/**
 *
 * @author adm
 */
public interface IOauthTokenDAOV1 extends ICrud<OauthToken> {

    List<OauthToken> findAllActive();

    OauthToken findByAccessToken(String access_token);
}
