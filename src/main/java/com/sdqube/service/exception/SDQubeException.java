package com.sdqube.service.exception;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 3:35 AM
 */
public class SDQubeException extends Throwable {

    private static final long serialVersionUID = 1L;

    public SDQubeException() {
        super("SDQube Exception.");
    }

    public SDQubeException(String msg) {
        super(msg);
    }
}
