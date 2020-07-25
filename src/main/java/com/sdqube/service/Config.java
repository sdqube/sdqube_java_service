package com.sdqube.service;

import com.sdqube.service.exception.ConfigException;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.beanutils.*;
import java.io.File;
import java.net.URL;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:22 AM
 */
public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static final Config INSTANCE = new Config();
    private Configuration configuration;

    private Config() {
        try {
            this.build();
        } catch (ConfigException e) {
            logger.error("Error while initializing config", e);
        }
    }

    public static Configuration getInstance() {
        return INSTANCE.configuration;
    }

    private void build() throws ConfigException {
        Configurations configs = new Configurations();
        try {
            String file = System.getProperty("service.config.file");
            if (file == null) {
                URL url = Config.class.getClassLoader().getResource("service.properties");
                if (url != null) {
                    file = url.getFile();
                } else {
                    throw new ConfigException("Could not load configuration file.");
                }
            }
            logger.info("Loading config from {}", file);
            configuration = configs.properties(new File(file));
        } catch (ConfigurationException cex) {
            throw new ConfigException(cex);
        }
    }
}
