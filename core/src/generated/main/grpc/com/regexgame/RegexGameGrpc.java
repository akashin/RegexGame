package com.regexgame;

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
    comments = "Source: game_service.proto")
public final class RegexGameGrpc {

  private RegexGameGrpc() {}

  public static final String SERVICE_NAME = "regexgame.RegexGame";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMessageMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.regexgame.GetMessageRequest,
      com.regexgame.GetMessageReply> METHOD_GET_MESSAGE = getGetMessageMethod();

  private static volatile io.grpc.MethodDescriptor<com.regexgame.GetMessageRequest,
      com.regexgame.GetMessageReply> getGetMessageMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.regexgame.GetMessageRequest,
      com.regexgame.GetMessageReply> getGetMessageMethod() {
    io.grpc.MethodDescriptor<com.regexgame.GetMessageRequest, com.regexgame.GetMessageReply> getGetMessageMethod;
    if ((getGetMessageMethod = RegexGameGrpc.getGetMessageMethod) == null) {
      synchronized (RegexGameGrpc.class) {
        if ((getGetMessageMethod = RegexGameGrpc.getGetMessageMethod) == null) {
          RegexGameGrpc.getGetMessageMethod = getGetMessageMethod = 
              io.grpc.MethodDescriptor.<com.regexgame.GetMessageRequest, com.regexgame.GetMessageReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "regexgame.RegexGame", "GetMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.GetMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.GetMessageReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RegexGameMethodDescriptorSupplier("GetMessage"))
                  .build();
          }
        }
     }
     return getGetMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegexGameStub newStub(io.grpc.Channel channel) {
    return new RegexGameStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegexGameBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegexGameBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegexGameFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegexGameFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class RegexGameImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void getMessage(com.regexgame.GetMessageRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.GetMessageReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.regexgame.GetMessageRequest,
                com.regexgame.GetMessageReply>(
                  this, METHODID_GET_MESSAGE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RegexGameStub extends io.grpc.stub.AbstractStub<RegexGameStub> {
    private RegexGameStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegexGameStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegexGameStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegexGameStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void getMessage(com.regexgame.GetMessageRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.GetMessageReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RegexGameBlockingStub extends io.grpc.stub.AbstractStub<RegexGameBlockingStub> {
    private RegexGameBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegexGameBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegexGameBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegexGameBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public com.regexgame.GetMessageReply getMessage(com.regexgame.GetMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class RegexGameFutureStub extends io.grpc.stub.AbstractStub<RegexGameFutureStub> {
    private RegexGameFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegexGameFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegexGameFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegexGameFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.regexgame.GetMessageReply> getMessage(
        com.regexgame.GetMessageRequest request) {
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
    private final RegexGameImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegexGameImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((com.regexgame.GetMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.regexgame.GetMessageReply>) responseObserver);
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

  private static abstract class RegexGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegexGameBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.regexgame.RegexGameProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegexGame");
    }
  }

  private static final class RegexGameFileDescriptorSupplier
      extends RegexGameBaseDescriptorSupplier {
    RegexGameFileDescriptorSupplier() {}
  }

  private static final class RegexGameMethodDescriptorSupplier
      extends RegexGameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegexGameMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegexGameGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegexGameFileDescriptorSupplier())
              .addMethod(getGetMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}