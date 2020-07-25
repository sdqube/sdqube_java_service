package com.sdqube.service.sql;

import java.sql.*;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:33 AM
 */
public class SqlDataSource {
    private static final String ERROR_MSG = "Connection is null.";
    private final ConnectionFactory connectionFactory;

    public SqlDataSource(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public PreparedStatement prepareStatement(String query, Connection connection) throws JDBCException {
        if (connection == null) throw new JDBCException(ERROR_MSG);
        if (query == null || query.trim().length() == 0) throw new JDBCException("Query is null or empty.");
        try {
            //No need to update and we may iterate many times so we need scrollable
            return connection.prepareStatement(query,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new JDBCException(e);
        }
    }

    public Statement statement(Connection connection) throws JDBCException {
        if (connection == null) throw new JDBCException(ERROR_MSG);
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new JDBCException(e);
        }
    }

    public CallableStatement call(String query, Connection connection) throws JDBCException {
        if (connection == null) throw new JDBCException(ERROR_MSG);
        if (query == null || query.trim().length() == 0) throw new JDBCException("Query is null or empty.");
        try {
            return connection.prepareCall(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new JDBCException(e);
        }
    }

    public Connection getConnection() throws JDBCException, SQLException {
        Connection connection = this.connectionFactory.getConnection();
        connection.setAutoCommit(true);
        return connection;
    }

    public int rows(ResultSet resultSet) throws JDBCException {
        int i = 0;
        try {
            while (resultSet.next()) {
                i++;
            }
        } catch (SQLException e) {
            throw new JDBCException(e);
        }
        return i;
    }
}
