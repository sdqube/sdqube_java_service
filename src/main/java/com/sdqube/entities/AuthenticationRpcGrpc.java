package com.sdqube.entities;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *RPC calls
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0-SNAPSHOT)",
    comments = "Source: authentication.proto")
public final class AuthenticationRpcGrpc {

  private AuthenticationRpcGrpc() {}

  public static final String SERVICE_NAME = "sdqube.entities.pb.AuthenticationRpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
      com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getAuthorizeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "authorize",
      requestType = com.sdqube.entities.AuthenticationPb.AuthBaseRequest.class,
      responseType = com.sdqube.entities.AuthenticationPb.AuthBaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
      com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getAuthorizeMethod() {
    io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest, com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getAuthorizeMethod;
    if ((getAuthorizeMethod = AuthenticationRpcGrpc.getAuthorizeMethod) == null) {
      synchronized (AuthenticationRpcGrpc.class) {
        if ((getAuthorizeMethod = AuthenticationRpcGrpc.getAuthorizeMethod) == null) {
          AuthenticationRpcGrpc.getAuthorizeMethod = getAuthorizeMethod = 
              io.grpc.MethodDescriptor.<com.sdqube.entities.AuthenticationPb.AuthBaseRequest, com.sdqube.entities.AuthenticationPb.AuthBaseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sdqube.entities.pb.AuthenticationRpc", "authorize"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sdqube.entities.AuthenticationPb.AuthBaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sdqube.entities.AuthenticationPb.AuthBaseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthenticationRpcMethodDescriptorSupplier("authorize"))
                  .build();
          }
        }
     }
     return getAuthorizeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
      com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = com.sdqube.entities.AuthenticationPb.AuthBaseRequest.class,
      responseType = com.sdqube.entities.AuthenticationPb.AuthBaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
      com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest, com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getLoginMethod;
    if ((getLoginMethod = AuthenticationRpcGrpc.getLoginMethod) == null) {
      synchronized (AuthenticationRpcGrpc.class) {
        if ((getLoginMethod = AuthenticationRpcGrpc.getLoginMethod) == null) {
          AuthenticationRpcGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<com.sdqube.entities.AuthenticationPb.AuthBaseRequest, com.sdqube.entities.AuthenticationPb.AuthBaseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sdqube.entities.pb.AuthenticationRpc", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sdqube.entities.AuthenticationPb.AuthBaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sdqube.entities.AuthenticationPb.AuthBaseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthenticationRpcMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
      com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = com.sdqube.entities.AuthenticationPb.AuthBaseRequest.class,
      responseType = com.sdqube.entities.AuthenticationPb.AuthBaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
      com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<com.sdqube.entities.AuthenticationPb.AuthBaseRequest, com.sdqube.entities.AuthenticationPb.AuthBaseResponse> getLogoutMethod;
    if ((getLogoutMethod = AuthenticationRpcGrpc.getLogoutMethod) == null) {
      synchronized (AuthenticationRpcGrpc.class) {
        if ((getLogoutMethod = AuthenticationRpcGrpc.getLogoutMethod) == null) {
          AuthenticationRpcGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<com.sdqube.entities.AuthenticationPb.AuthBaseRequest, com.sdqube.entities.AuthenticationPb.AuthBaseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sdqube.entities.pb.AuthenticationRpc", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sdqube.entities.AuthenticationPb.AuthBaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sdqube.entities.AuthenticationPb.AuthBaseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthenticationRpcMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthenticationRpcStub newStub(io.grpc.Channel channel) {
    return new AuthenticationRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthenticationRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthenticationRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthenticationRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthenticationRpcFutureStub(channel);
  }

  /**
   * <pre>
   *RPC calls
   * </pre>
   */
  public static abstract class AuthenticationRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void authorize(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request,
        io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAuthorizeMethod(), responseObserver);
    }

    /**
     */
    public void login(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request,
        io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request,
        io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuthorizeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
                com.sdqube.entities.AuthenticationPb.AuthBaseResponse>(
                  this, METHODID_AUTHORIZE)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
                com.sdqube.entities.AuthenticationPb.AuthBaseResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sdqube.entities.AuthenticationPb.AuthBaseRequest,
                com.sdqube.entities.AuthenticationPb.AuthBaseResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   * <pre>
   *RPC calls
   * </pre>
   */
  public static final class AuthenticationRpcStub extends io.grpc.stub.AbstractStub<AuthenticationRpcStub> {
    private AuthenticationRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticationRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticationRpcStub(channel, callOptions);
    }

    /**
     */
    public void authorize(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request,
        io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAuthorizeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request,
        io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request,
        io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *RPC calls
   * </pre>
   */
  public static final class AuthenticationRpcBlockingStub extends io.grpc.stub.AbstractStub<AuthenticationRpcBlockingStub> {
    private AuthenticationRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticationRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticationRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.sdqube.entities.AuthenticationPb.AuthBaseResponse authorize(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request) {
      return blockingUnaryCall(
          getChannel(), getAuthorizeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.sdqube.entities.AuthenticationPb.AuthBaseResponse login(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.sdqube.entities.AuthenticationPb.AuthBaseResponse logout(com.sdqube.entities.AuthenticationPb.AuthBaseRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *RPC calls
   * </pre>
   */
  public static final class AuthenticationRpcFutureStub extends io.grpc.stub.AbstractStub<AuthenticationRpcFutureStub> {
    private AuthenticationRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthenticationRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthenticationRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthenticationRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> authorize(
        com.sdqube.entities.AuthenticationPb.AuthBaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAuthorizeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> login(
        com.sdqube.entities.AuthenticationPb.AuthBaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sdqube.entities.AuthenticationPb.AuthBaseResponse> logout(
        com.sdqube.entities.AuthenticationPb.AuthBaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTHORIZE = 0;
  private static final int METHODID_LOGIN = 1;
  private static final int METHODID_LOGOUT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthenticationRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthenticationRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTHORIZE:
          serviceImpl.authorize((com.sdqube.entities.AuthenticationPb.AuthBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((com.sdqube.entities.AuthenticationPb.AuthBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((com.sdqube.entities.AuthenticationPb.AuthBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.sdqube.entities.AuthenticationPb.AuthBaseResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AuthenticationRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthenticationRpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sdqube.entities.AuthenticationPb.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthenticationRpc");
    }
  }

  private static final class AuthenticationRpcFileDescriptorSupplier
      extends AuthenticationRpcBaseDescriptorSupplier {
    AuthenticationRpcFileDescriptorSupplier() {}
  }

  private static final class AuthenticationRpcMethodDescriptorSupplier
      extends AuthenticationRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthenticationRpcMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuthenticationRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthenticationRpcFileDescriptorSupplier())
              .addMethod(getAuthorizeMethod())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}
