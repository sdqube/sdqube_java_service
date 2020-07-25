package com.sdqube.service.sql;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:33 AM
 */
public class JDBCException extends Exception {
    public JDBCException(String message) {
        super(message);
    }

    public JDBCException(Throwable throwable) {
        super(throwable);
    }
}