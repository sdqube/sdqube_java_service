package com.sdqube.service.exception;

public class ConfigException extends Exception {

    private static final long serialVersionUID = 1L;

    public ConfigException(Throwable throwable) {
        super(throwable);
    }

    public ConfigException(String msg) {
        super(msg);
    }
}
