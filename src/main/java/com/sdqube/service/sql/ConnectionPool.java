package com.sdqube.service.sql;

import com.sdqube.service.Config;
import com.sdqube.service.Injector;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:33 AM
 */
final class ConnectionPool {
    private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);
    private final DataSource dataSource;

    private ConnectionPool(PoolProperties properties, String dataSourceClass) {
        logger.debug("Using datasource class : {}", dataSourceClass);
        this.dataSource = Injector.instance(dataSourceClass);
        this.dataSource.setPoolProperties(properties);
    }

    static ConnectionPool create(final DbInfo dbInfo) throws JDBCException {
        if (dbInfo == null) throw new JDBCException("DbInfo was not initialized.");
        String db = dbInfo.getDatabaseName();
        final PoolProperties properties = new PoolProperties();
        properties.setUrl(dbInfo.getUrl());
        properties.setDriverClassName(dbInfo.getDriver());
        properties.setPassword(dbInfo.getPassword());
        properties.setUsername(dbInfo.getUsername());
        properties.setJmxEnabled(true);
        properties.setTestWhileIdle(false);
        properties.setTestOnBorrow(true);
        if (null == dbInfo.getValidationQuery()) {
            dbInfo.setValidationQuery("SELECT 1");
        }
        properties.setValidationQuery(dbInfo.getValidationQuery());
        properties.setValidationInterval(30000);
        properties.setTimeBetweenEvictionRunsMillis(35000);
        properties.setMaxActive(Config.getInstance().getInt(getConfigName("pool.max.active", db), 8));
        properties.setInitialSize(Config.getInstance().getInt(getConfigName("pool.initial.size", db), 2));
        properties.setMaxWait(Config.getInstance().getInt(getConfigName("pool.max.wait", db), 80000));
        properties.setRemoveAbandonedTimeout(Config.getInstance()
                .getInt(getConfigName("pool.removeAbandonedTimeout", db), 180));
        properties.setMinEvictableIdleTimeMillis(30000);
        properties.setMinIdle(Config.getInstance()
                .getInt(getConfigName("pool.min.idle", db), 4));
        properties.setMaxIdle(Config.getInstance()
                .getInt(getConfigName("pool.max.idle", db), 6));
        properties.setLogAbandoned(true);
        properties.setRemoveAbandoned(true);
        properties.setAbandonWhenPercentageFull(50);
        properties.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;" +
                "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;" +
                "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer"
        );
        if (dbInfo.getDataSourceClass() == null) {
            dbInfo.setDataSourceClass("org.apache.tomcat.jdbc.pool.DataSource");
        }
        return new ConnectionPool(properties, dbInfo.getDataSourceClass());
    }

    private static String getConfigName(String config, String db) {
        return "db." + db + "." + config;
    }

    Connection getConnection() throws JDBCException {
        if (this.dataSource == null)
            throw new RuntimeException("Pool not initialized.");
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new JDBCException(e);
        }
    }

    void destroy() {
        if (this.dataSource != null)
            this.dataSource.close();
    }
}