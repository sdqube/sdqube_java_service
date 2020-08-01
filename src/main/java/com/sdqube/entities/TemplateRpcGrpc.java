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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0-SNAPSHOT)",
    comments = "Source: template.proto")
public final class TemplateRpcGrpc {

  private TemplateRpcGrpc() {}

  public static final String SERVICE_NAME = "sdqube.entities.pb.TemplateRpc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sdqube.entities.TemplatePb.TemplateBaseRequest,
      com.sdqube.entities.TemplatePb.TemplateBaseResponse> getGenerateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "generateTemplate",
      requestType = com.sdqube.entities.TemplatePb.TemplateBaseRequest.class,
      responseType = com.sdqube.entities.TemplatePb.TemplateBaseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sdqube.entities.TemplatePb.TemplateBaseRequest,
      com.sdqube.entities.TemplatePb.TemplateBaseResponse> getGenerateTemplateMethod() {
    io.grpc.MethodDescriptor<com.sdqube.entities.TemplatePb.TemplateBaseRequest, com.sdqube.entities.TemplatePb.TemplateBaseResponse> getGenerateTemplateMethod;
    if ((getGenerateTemplateMethod = TemplateRpcGrpc.getGenerateTemplateMethod) == null) {
      synchronized (TemplateRpcGrpc.class) {
        if ((getGenerateTemplateMethod = TemplateRpcGrpc.getGenerateTemplateMethod) == null) {
          TemplateRpcGrpc.getGenerateTemplateMethod = getGenerateTemplateMethod = 
              io.grpc.MethodDescriptor.<com.sdqube.entities.TemplatePb.TemplateBaseRequest, com.sdqube.entities.TemplatePb.TemplateBaseResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sdqube.entities.pb.TemplateRpc", "generateTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sdqube.entities.TemplatePb.TemplateBaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sdqube.entities.TemplatePb.TemplateBaseResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TemplateRpcMethodDescriptorSupplier("generateTemplate"))
                  .build();
          }
        }
     }
     return getGenerateTemplateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TemplateRpcStub newStub(io.grpc.Channel channel) {
    return new TemplateRpcStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TemplateRpcBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TemplateRpcBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TemplateRpcFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TemplateRpcFutureStub(channel);
  }

  /**
   */
  public static abstract class TemplateRpcImplBase implements io.grpc.BindableService {

    /**
     */
    public void generateTemplate(com.sdqube.entities.TemplatePb.TemplateBaseRequest request,
        io.grpc.stub.StreamObserver<com.sdqube.entities.TemplatePb.TemplateBaseResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGenerateTemplateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGenerateTemplateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sdqube.entities.TemplatePb.TemplateBaseRequest,
                com.sdqube.entities.TemplatePb.TemplateBaseResponse>(
                  this, METHODID_GENERATE_TEMPLATE)))
          .build();
    }
  }

  /**
   */
  public static final class TemplateRpcStub extends io.grpc.stub.AbstractStub<TemplateRpcStub> {
    private TemplateRpcStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemplateRpcStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemplateRpcStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemplateRpcStub(channel, callOptions);
    }

    /**
     */
    public void generateTemplate(com.sdqube.entities.TemplatePb.TemplateBaseRequest request,
        io.grpc.stub.StreamObserver<com.sdqube.entities.TemplatePb.TemplateBaseResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGenerateTemplateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TemplateRpcBlockingStub extends io.grpc.stub.AbstractStub<TemplateRpcBlockingStub> {
    private TemplateRpcBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemplateRpcBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemplateRpcBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemplateRpcBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.sdqube.entities.TemplatePb.TemplateBaseResponse generateTemplate(com.sdqube.entities.TemplatePb.TemplateBaseRequest request) {
      return blockingUnaryCall(
          getChannel(), getGenerateTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TemplateRpcFutureStub extends io.grpc.stub.AbstractStub<TemplateRpcFutureStub> {
    private TemplateRpcFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TemplateRpcFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TemplateRpcFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TemplateRpcFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sdqube.entities.TemplatePb.TemplateBaseResponse> generateTemplate(
        com.sdqube.entities.TemplatePb.TemplateBaseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGenerateTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GENERATE_TEMPLATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TemplateRpcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TemplateRpcImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GENERATE_TEMPLATE:
          serviceImpl.generateTemplate((com.sdqube.entities.TemplatePb.TemplateBaseRequest) request,
              (io.grpc.stub.StreamObserver<com.sdqube.entities.TemplatePb.TemplateBaseResponse>) responseObserver);
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

  private static abstract class TemplateRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TemplateRpcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sdqube.entities.TemplatePb.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TemplateRpc");
    }
  }

  private static final class TemplateRpcFileDescriptorSupplier
      extends TemplateRpcBaseDescriptorSupplier {
    TemplateRpcFileDescriptorSupplier() {}
  }

  private static final class TemplateRpcMethodDescriptorSupplier
      extends TemplateRpcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TemplateRpcMethodDescriptorSupplier(String methodName) {
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
      synchronized (TemplateRpcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TemplateRpcFileDescriptorSupplier())
              .addMethod(getGenerateTemplateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
