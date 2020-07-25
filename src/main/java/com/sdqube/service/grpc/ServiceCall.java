package com.sdqube.service.grpc;

import io.grpc.Metadata;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 1:57 AM
 */
public interface ServiceCall<T> {
    T getService();

    T getService(Metadata header);
}
