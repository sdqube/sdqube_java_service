package com.sdqube.service.servicecall;

import com.sdqube.entities.AuthenticationRpcGrpc;
import com.sdqube.service.Config;
import com.sdqube.service.grpc.GrpcServiceCall;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:39 AM
 */
public final class AuthenticationGrpcServiceCall extends GrpcServiceCall<AuthenticationRpcGrpc.AuthenticationRpcBlockingStub> {
    public AuthenticationGrpcServiceCall(String host, int port) {
        super(host, port, "AuthGrpcServiceCall");
    }

    public AuthenticationGrpcServiceCall() {
        super(Config.getInstance().getString("service.auth.host", "localhost"),
                Config.getInstance().getInt("service.auth.port", 9090), "AuthGrpcServiceCall");
    }

    public void initStub() {
        this.stub = AuthenticationRpcGrpc.newBlockingStub(this.getChannel());
    }
}
