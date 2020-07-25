package com.sdqube.service.grpc;

import com.sdqube.service.logger.SDQubeLogger;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 1:42 AM
 */
public abstract class GrpcMain implements Main {
    SDQubeLogger sdQubeLogger = SDQubeLogger.getLogger(GrpcMain.class);
    private Server server;

    @Override
    public void configure() {

    }

    @Override
    public void run() {
        try {
            configure();
            server.start();
            sdQubeLogger.debug("Running server on port : {}", server.getPort());
        } catch (IOException e) {
            sdQubeLogger.error("Error while running service.", e);
        }
    }

    @Override
    public void stop() {

        if (server != null) {
            server.shutdown();
        }
        this.cleanUp();
        sdQubeLogger.debug("Service stopped successfully.");
    }

    @Override
    public void waitForTermination() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    protected abstract void cleanUp();


    public void buildServer(final String name,
                            ServerBuilder<?> serverBuilder) {
        GrpcServiceRegister.register(name);
        this.server = serverBuilder.build();
    }

}
