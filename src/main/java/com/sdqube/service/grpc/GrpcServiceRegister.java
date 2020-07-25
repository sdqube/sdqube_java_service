package com.sdqube.service.grpc;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 1:56 AM
 */
final class GrpcServiceRegister {
    private static final Set<String> SERVICES = Sets.newHashSetWithExpectedSize(30);

    private GrpcServiceRegister() {
        //Empty on purpose
    }

    static void register(String service) {
        SERVICES.add(service);
    }

    static boolean check(String service) {
        return SERVICES.contains(service);
    }
}
