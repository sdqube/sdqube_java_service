package com.sdqube.service;

import com.sdqube.service.exception.Config;
import com.sdqube.service.utils.SDQubeDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:33 AM
 */
public class Bootstrap {
    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public void run(Main main) {
        try {
            SDQubeDate.timestamp();
        } catch (UnsatisfiedLinkError ignore) {
            //Empty on purpose
        }
        try {
            logger.info("Running service in production : {}", Config.getInstance().getString("sdqube.environment", "dev"));
            main.run();
            Thread hook = new Thread(main::stop);
            hook.setName("service_shutdown_hook");
            Runtime.getRuntime().addShutdownHook(hook);
            main.waitForTermination();
        } catch (InterruptedException e) {
            logger.error("Error while waiting for server.", e);
            Thread.currentThread().interrupt();
        }
    }
}