package com.sdqube.service.sql;

import java.sql.Connection;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:33 AM
 */
public interface ConnectionFactory {

    void start() throws JDBCException;

    DbInfo config();

    Connection getConnection() throws JDBCException;

    void shutdown();

    boolean checkConnection();
}
