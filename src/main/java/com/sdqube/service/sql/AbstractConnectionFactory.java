package com.sdqube.service.sql;

import com.sdqube.service.Config;
import com.sdqube.service.logger.SDQubeLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:33 AM
 */
public abstract class AbstractConnectionFactory implements ConnectionFactory {
    private static final SDQubeLogger logger = SDQubeLogger.getLogger(AbstractConnectionFactory.class);
    private static final String SQL_CONN_TEST_QUERY = Config.getInstance().getString("sql.conn.test.query",
            "SELECT 1");
    private ConnectionPool connectionPool;

    public void start() throws JDBCException {
        DbInfo dbInfo = this.config();
        connectionPool = ConnectionPool.create(dbInfo);
    }

    public Connection getConnection() throws JDBCException {
        return this.connectionPool.getConnection();
    }

    public void shutdown() {
        this.connectionPool.destroy();
    }

    @Override
    public boolean checkConnection() {
        if (null == connectionPool) {
            logger.error("Connection pool was not initialized.");
            return false;
        }
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_CONN_TEST_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            return resultSet.next();
        } catch (JDBCException | SQLException e) {
            logger.error("Error in connection check.", e);
        }
        return false;
    }
}
