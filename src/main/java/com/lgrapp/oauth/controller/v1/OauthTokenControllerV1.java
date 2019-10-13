/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.controller.v1;

import com.lgrapp.oauth.base.exception.UnauthorizedException;
import com.lgrapp.oauth.model.OauthToken;
import com.lgrapp.oauth.service.v1.custom.IOauthTokenServiceV1;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adm
 */
@Stateless
@Path("oauth")
public class OauthTokenControllerV1 {

    @Inject
    @Named("oauthTokenServiceV1")
    IOauthTokenServiceV1 oauthTokenServiceV1;

    @POST
    @Path("token/{urlProduto}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public OauthToken doAuthenticate(@PathParam("urlProduto") String urlProduto,
            @HeaderParam(value = "grant_type") String grant_type,
            @HeaderParam(value = "client_id") String client_id,
            @HeaderParam(value = "client_secret") String client_secret,
            @HeaderParam(value = "username") String username,
            @HeaderParam(value = "password") String password,
            @HeaderParam(value = "refresh_token") String refresh_token,
            @HeaderParam(value = "authorization") String authorization) throws UnauthorizedException {

        return oauthTokenServiceV1.doAuthenticate(urlProduto, grant_type, client_id, client_secret, username, password, refresh_token, authorization);

    }

    @GET
    @Path("generateToken/{chars}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String generateToken(@PathParam("chars") int chars) {
        return getToken(chars);
    }

    static public String getToken(int chars) {
        String CharSet = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ234567890!@#=";
        String Token = "";
        for (int a = 1; a <= chars; a++) {
            Token += CharSet.charAt(new Random().nextInt(CharSet.length()));
        }
        return Token;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<OauthToken> findAll() {
        return oauthTokenServiceV1.findAll();
    }

    @GET
    @Path("active")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<OauthToken> findAllActive() {
        return oauthTokenServiceV1.findAllActive();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<OauthToken> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return oauthTokenServiceV1.findRange(from, to);
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(oauthTokenServiceV1.count());
    }

}
