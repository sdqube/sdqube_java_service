package com.sdqube.service.sql;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:33 AM
 */
public final class TestDbConnection extends AbstractConnectionFactory {
    private static final Logger logger = LoggerFactory.getLogger(TestDbConnection.class);
    private final String host;
    private final String user;
    private final String password;
    private final String db;
    private final String driver;
    private final int port;
    public TestDbConnection(String host,
                            String user,
                            String password,
                            String db,
                            String driver,
                            int port){
        this.host = host;
        this.user = user;
        this.password = password;
        this.db = db;
        this.driver = StringUtils.isBlank(driver)?"com.mysql.cj.jdbc.Driver":driver;
        this.port = (port == 0)?3306:port;
        try {
            this.start();
        } catch (JDBCException e) {
            logger.error("DB_ERROR Error while initializing db connection.", e);
        }
        logger.error("TestDbConnection is only for testing purpose.");

    }
    public TestDbConnection(String host,
                            String user,
                            String password,
                            String db){
        this(host, user, password, db, null, 0);
    }
    public TestDbConnection(String db){
        this(System.getProperty("db.host", getEnv("db.host","192.168.0.176")),
                System.getProperty("db.user", getEnv("db.user","root")),
                System.getProperty("db.password", getEnv("db.password","root")),
                db,
                "com.mysql.cj.jdbc.Driver",
                Integer.parseInt(System.getProperty("db.port", getEnv("db.port","3306"))));
    }
    public TestDbConnection(String host,
                            String user,
                            String password,
                            String db,
                            String driver){
        this(host, user, password, db, driver, 0);
    }
    public TestDbConnection(String host,
                            String user,
                            String password,
                            String db,
                            int port){
        this(host, user, password, db, null, port);
    }
    private static String getEnv(String key, String def){
        String val = System.getenv(key);
        return StringUtils.isBlank(val)?def:val;
    }
    @Override
    public DbInfo config() {
        DbInfo dbInfo = new DbInfo();
        dbInfo.setValidationQuery("SELECT 1");
        dbInfo.setPassword(this.password);
        dbInfo.setUsername(this.user);
        dbInfo.setDriver(this.driver);
        dbInfo.setDatabaseName(this.db);
        String url = System.getProperty("db.url");
        if(StringUtils.isBlank(url)){
            url = System.getenv("db.url");
            if(StringUtils.isBlank(url)) {
                url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false",
                        this.host,
                        this.port,
                        dbInfo.getDatabaseName());
            }
        }
        dbInfo.setUrl(url);
        logger.debug("DB URL : {}", dbInfo.getUrl());
        return dbInfo;
    }
}
