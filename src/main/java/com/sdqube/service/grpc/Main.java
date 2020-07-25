package com.sdqube.service.grpc;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 1:42 AM
 */
public interface Main {

    void configure();

    void run();

    void stop();

    void waitForTermination() throws InterruptedException;
}
