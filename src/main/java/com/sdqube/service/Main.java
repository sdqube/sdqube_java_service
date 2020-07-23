package com.sdqube.service;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:20 AM
 */
public interface Main {

    void configure();

    void run();

    void stop();

    void waitForTermination() throws InterruptedException;
}
