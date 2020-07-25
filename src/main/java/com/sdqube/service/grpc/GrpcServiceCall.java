package com.sdqube.service.grpc;

import com.google.common.collect.Maps;
import com.sdqube.service.logger.SDQubeLogger;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.MetadataUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 1:58 AM
 */
public abstract class GrpcServiceCall<T extends AbstractStub> implements ServiceCall<T> {
    SDQubeLogger sdQubeLogger = SDQubeLogger.getLogger(GrpcServiceCall.class);

    private final String host;
    private final int port;
    private final String name;
    protected T stub;
    private ManagedChannel channel;

    public GrpcServiceCall(final String host, final int port, final String name) {
        this.host = host;
        this.port = port;
        this.name = name;
        this.start();
    }

    private void start() {
        ManagedChannelBuilder<?> channelBuilder =
                ManagedChannelBuilder
                        .forAddress(host, port)
                        .defaultLoadBalancingPolicy("round_robin")
                        .usePlaintext();
        this.channel = channelBuilder
                .build();
        this.initStub();
        sdQubeLogger.debug("Connected to client : {} on : {}:{}", name, host, port);
    }

    protected abstract void initStub();

    protected ManagedChannel getChannel() {
        return this.channel;
    }

    public void stop() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        sdQubeLogger.debug("PB client service stooped.");
    }


    @Override
    public T getService() {
        return stub;
    }

    @Override
    public T getService(Metadata header) {
        if (null != this.stub) {
            return (T) MetadataUtils.attachHeaders(this.stub, header);
        } else {
            return this.stub;
        }
    }

    public Metadata buildHeader(Map<String, String> headers) {
        Metadata metadata = new Metadata();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            if (StringUtils.isNotBlank(entry.getValue())) {
                metadata.put(Metadata.Key.of(entry.getKey(), Metadata.ASCII_STRING_MARSHALLER), entry.getValue());
            }
        }
        return metadata;
    }

    public Metadata buildHeader(String key, String value) {
        Map<String, String> headerMap = Maps.newHashMapWithExpectedSize(1);
        headerMap.put(key, value);
        return this.buildHeader(headerMap);
    }
}
