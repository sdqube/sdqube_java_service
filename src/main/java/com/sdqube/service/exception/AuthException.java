package com.sdqube.service.exception;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 2:13 AM
 */
public class AuthException extends Exception {

    private static final long serialVersionUID = 1L;

    public AuthException() {
        super("Authorization failed.");
    }

    public AuthException(String msg) {
        super(msg);
    }
}
