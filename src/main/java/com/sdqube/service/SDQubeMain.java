package com.sdqube.service;

import com.sdqube.service.grpc.Main;
import com.sdqube.service.logger.SDQubeLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:20 AM
 */
public abstract class SDQubeMain implements Main {
    private static final SDQubeLogger logger = SDQubeLogger.getLogger(SDQubeMain.class);
    private static final int port = Config.getInstance().getInt("sdqube.main.port", 9001);
    private Thread server;

    @Override
    public void run() {
        try {
            configure();
            server = new Thread(new Server());
            server.setName("bg_server");
            server.start();
        } catch (Exception e) {
            logger.error("Error while running main.", e);
        }
    }

    protected abstract void cleanUp();

    @Override
    public void stop() {
        if (server != null) {
            try {
                server.interrupt();
            } catch (Exception ignore) {
            }
        }
        this.cleanUp();
        logger.debug("Service stopped successfully.");
    }

    @Override
    public void waitForTermination() throws InterruptedException {
    }

    private static final class Server implements Runnable {
        @Override
        public void run() {
            try (ServerSocket socket = new ServerSocket(port)) {
                logger.debug("Running server on port : {}", port);
                while (!Thread.currentThread().isInterrupted()) {
                    Socket connection = socket.accept();
                    this.handle(connection);
                }
                logger.debug("Stopped sdqube main.");
            } catch (IOException e) {
                logger.error("Could not start sdqube server.", e);
            }
        }

        private void handle(Socket connection) {
            try {
                DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());
                outToClient.writeBytes("OK\n");
                outToClient.close();
            } catch (Exception ex) {
                logger.error("Error while handling connection.", ex);
            }
        }
    }
}