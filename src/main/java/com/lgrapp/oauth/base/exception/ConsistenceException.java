/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lgrapp.oauth.base.exception;

/**
 *
 * @author adm
 */
public class ConsistenceException extends Exception {

    public ConsistenceException() {
    }

    public ConsistenceException(String message) {
        super(message);
    }

    public ConsistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsistenceException(Throwable cause) {
        super(cause);
    }

    public ConsistenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
