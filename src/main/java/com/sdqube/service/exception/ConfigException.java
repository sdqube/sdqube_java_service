package com.sdqube.service.exception;

class ConfigException extends Exception {

    private static final long serialVersionUID = 1L;

    ConfigException(Throwable throwable) {
        super(throwable);
    }

    ConfigException(String msg) {
        super(msg);
    }
}
