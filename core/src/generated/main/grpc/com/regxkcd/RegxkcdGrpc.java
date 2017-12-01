package com.regxkcd;

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
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.8.0)",
    comments = "Source: regxkcd_service.proto")
public final class RegxkcdGrpc {

  private RegxkcdGrpc() {}

  public static final String SERVICE_NAME = "regxkcd.Regxkcd";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.regxkcd.GetMessageRequest,
      com.regxkcd.GetMessageReply> METHOD_GET_MESSAGE = getGetMessageMethod();

  private static volatile io.grpc.MethodDescriptor<com.regxkcd.GetMessageRequest,
      com.regxkcd.GetMessageReply> getGetMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.regxkcd.GetMessageRequest,
      com.regxkcd.GetMessageReply> getGetMessageMethod() {
    io.grpc.MethodDescriptor<com.regxkcd.GetMessageRequest, com.regxkcd.GetMessageReply> getGetMessageMethod;
    if ((getGetMessageMethod = RegxkcdGrpc.getGetMessageMethod) == null) {
      synchronized (RegxkcdGrpc.class) {
        if ((getGetMessageMethod = RegxkcdGrpc.getGetMessageMethod) == null) {
          RegxkcdGrpc.getGetMessageMethod = getGetMessageMethod = 
              io.grpc.MethodDescriptor.<com.regxkcd.GetMessageRequest, com.regxkcd.GetMessageReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "regxkcd.Regxkcd", "GetMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regxkcd.GetMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regxkcd.GetMessageReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RegxkcdMethodDescriptorSupplier("GetMessage"))
                  .build();
          }
        }
     }
     return getGetMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegxkcdStub newStub(io.grpc.Channel channel) {
    return new RegxkcdStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegxkcdBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegxkcdBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegxkcdFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegxkcdFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class RegxkcdImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void getMessage(com.regxkcd.GetMessageRequest request,
        io.grpc.stub.StreamObserver<com.regxkcd.GetMessageReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.regxkcd.GetMessageRequest,
                com.regxkcd.GetMessageReply>(
                  this, METHODID_GET_MESSAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RegxkcdStub extends io.grpc.stub.AbstractStub<RegxkcdStub> {
    private RegxkcdStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegxkcdStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegxkcdStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegxkcdStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void getMessage(com.regxkcd.GetMessageRequest request,
        io.grpc.stub.StreamObserver<com.regxkcd.GetMessageReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RegxkcdBlockingStub extends io.grpc.stub.AbstractStub<RegxkcdBlockingStub> {
    private RegxkcdBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegxkcdBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegxkcdBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegxkcdBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public com.regxkcd.GetMessageReply getMessage(com.regxkcd.GetMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RegxkcdFutureStub extends io.grpc.stub.AbstractStub<RegxkcdFutureStub> {
    private RegxkcdFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegxkcdFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegxkcdFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegxkcdFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.regxkcd.GetMessageReply> getMessage(
        com.regxkcd.GetMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegxkcdImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegxkcdImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((com.regxkcd.GetMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.regxkcd.GetMessageReply>) responseObserver);
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

  private static abstract class RegxkcdBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegxkcdBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.regxkcd.RegxkcdProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Regxkcd");
    }
  }

  private static final class RegxkcdFileDescriptorSupplier
      extends RegxkcdBaseDescriptorSupplier {
    RegxkcdFileDescriptorSupplier() {}
  }

  private static final class RegxkcdMethodDescriptorSupplier
      extends RegxkcdBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegxkcdMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegxkcdGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegxkcdFileDescriptorSupplier())
              .addMethod(getGetMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
