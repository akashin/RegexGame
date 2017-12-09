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
  @java.lang.Deprecated // Use {@link #getCreateMatchMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.regexgame.CreateMatchRequest,
      com.regexgame.CreateMatchReply> METHOD_CREATE_MATCH = getCreateMatchMethod();

  private static volatile io.grpc.MethodDescriptor<com.regexgame.CreateMatchRequest,
      com.regexgame.CreateMatchReply> getCreateMatchMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.regexgame.CreateMatchRequest,
      com.regexgame.CreateMatchReply> getCreateMatchMethod() {
    io.grpc.MethodDescriptor<com.regexgame.CreateMatchRequest, com.regexgame.CreateMatchReply> getCreateMatchMethod;
    if ((getCreateMatchMethod = RegexGameGrpc.getCreateMatchMethod) == null) {
      synchronized (RegexGameGrpc.class) {
        if ((getCreateMatchMethod = RegexGameGrpc.getCreateMatchMethod) == null) {
          RegexGameGrpc.getCreateMatchMethod = getCreateMatchMethod = 
              io.grpc.MethodDescriptor.<com.regexgame.CreateMatchRequest, com.regexgame.CreateMatchReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "regexgame.RegexGame", "CreateMatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.CreateMatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.CreateMatchReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RegexGameMethodDescriptorSupplier("CreateMatch"))
                  .build();
          }
        }
     }
     return getCreateMatchMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getJoinMatchMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.regexgame.JoinMatchRequest,
      com.regexgame.JoinMatchReply> METHOD_JOIN_MATCH = getJoinMatchMethod();

  private static volatile io.grpc.MethodDescriptor<com.regexgame.JoinMatchRequest,
      com.regexgame.JoinMatchReply> getJoinMatchMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.regexgame.JoinMatchRequest,
      com.regexgame.JoinMatchReply> getJoinMatchMethod() {
    io.grpc.MethodDescriptor<com.regexgame.JoinMatchRequest, com.regexgame.JoinMatchReply> getJoinMatchMethod;
    if ((getJoinMatchMethod = RegexGameGrpc.getJoinMatchMethod) == null) {
      synchronized (RegexGameGrpc.class) {
        if ((getJoinMatchMethod = RegexGameGrpc.getJoinMatchMethod) == null) {
          RegexGameGrpc.getJoinMatchMethod = getJoinMatchMethod = 
              io.grpc.MethodDescriptor.<com.regexgame.JoinMatchRequest, com.regexgame.JoinMatchReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "regexgame.RegexGame", "JoinMatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.JoinMatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.JoinMatchReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RegexGameMethodDescriptorSupplier("JoinMatch"))
                  .build();
          }
        }
     }
     return getJoinMatchMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetEventsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.regexgame.GetEventsRequest,
      com.regexgame.GameEvent> METHOD_GET_EVENTS = getGetEventsMethod();

  private static volatile io.grpc.MethodDescriptor<com.regexgame.GetEventsRequest,
      com.regexgame.GameEvent> getGetEventsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.regexgame.GetEventsRequest,
      com.regexgame.GameEvent> getGetEventsMethod() {
    io.grpc.MethodDescriptor<com.regexgame.GetEventsRequest, com.regexgame.GameEvent> getGetEventsMethod;
    if ((getGetEventsMethod = RegexGameGrpc.getGetEventsMethod) == null) {
      synchronized (RegexGameGrpc.class) {
        if ((getGetEventsMethod = RegexGameGrpc.getGetEventsMethod) == null) {
          RegexGameGrpc.getGetEventsMethod = getGetEventsMethod = 
              io.grpc.MethodDescriptor.<com.regexgame.GetEventsRequest, com.regexgame.GameEvent>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "regexgame.RegexGame", "GetEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.GetEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.GameEvent.getDefaultInstance()))
                  .setSchemaDescriptor(new RegexGameMethodDescriptorSupplier("GetEvents"))
                  .build();
          }
        }
     }
     return getGetEventsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getMakeActionMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.regexgame.MakeActionRequest,
      com.regexgame.MakeActionReply> METHOD_MAKE_ACTION = getMakeActionMethod();

  private static volatile io.grpc.MethodDescriptor<com.regexgame.MakeActionRequest,
      com.regexgame.MakeActionReply> getMakeActionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.regexgame.MakeActionRequest,
      com.regexgame.MakeActionReply> getMakeActionMethod() {
    io.grpc.MethodDescriptor<com.regexgame.MakeActionRequest, com.regexgame.MakeActionReply> getMakeActionMethod;
    if ((getMakeActionMethod = RegexGameGrpc.getMakeActionMethod) == null) {
      synchronized (RegexGameGrpc.class) {
        if ((getMakeActionMethod = RegexGameGrpc.getMakeActionMethod) == null) {
          RegexGameGrpc.getMakeActionMethod = getMakeActionMethod = 
              io.grpc.MethodDescriptor.<com.regexgame.MakeActionRequest, com.regexgame.MakeActionReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "regexgame.RegexGame", "MakeAction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.MakeActionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.regexgame.MakeActionReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RegexGameMethodDescriptorSupplier("MakeAction"))
                  .build();
          }
        }
     }
     return getMakeActionMethod;
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
     * Creates new match.
     * </pre>
     */
    public void createMatch(com.regexgame.CreateMatchRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.CreateMatchReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMatchMethod(), responseObserver);
    }

    /**
     * <pre>
     * Joins existing match.
     * </pre>
     */
    public void joinMatch(com.regexgame.JoinMatchRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.JoinMatchReply> responseObserver) {
      asyncUnimplementedUnaryCall(getJoinMatchMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets events.
     * </pre>
     */
    public void getEvents(com.regexgame.GetEventsRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.GameEvent> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEventsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Makes an action.
     * </pre>
     */
    public void makeAction(com.regexgame.MakeActionRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.MakeActionReply> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeActionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMatchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.regexgame.CreateMatchRequest,
                com.regexgame.CreateMatchReply>(
                  this, METHODID_CREATE_MATCH)))
          .addMethod(
            getJoinMatchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.regexgame.JoinMatchRequest,
                com.regexgame.JoinMatchReply>(
                  this, METHODID_JOIN_MATCH)))
          .addMethod(
            getGetEventsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.regexgame.GetEventsRequest,
                com.regexgame.GameEvent>(
                  this, METHODID_GET_EVENTS)))
          .addMethod(
            getMakeActionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.regexgame.MakeActionRequest,
                com.regexgame.MakeActionReply>(
                  this, METHODID_MAKE_ACTION)))
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
     * Creates new match.
     * </pre>
     */
    public void createMatch(com.regexgame.CreateMatchRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.CreateMatchReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Joins existing match.
     * </pre>
     */
    public void joinMatch(com.regexgame.JoinMatchRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.JoinMatchReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getJoinMatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets events.
     * </pre>
     */
    public void getEvents(com.regexgame.GetEventsRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.GameEvent> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Makes an action.
     * </pre>
     */
    public void makeAction(com.regexgame.MakeActionRequest request,
        io.grpc.stub.StreamObserver<com.regexgame.MakeActionReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeActionMethod(), getCallOptions()), request, responseObserver);
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
     * Creates new match.
     * </pre>
     */
    public com.regexgame.CreateMatchReply createMatch(com.regexgame.CreateMatchRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMatchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Joins existing match.
     * </pre>
     */
    public com.regexgame.JoinMatchReply joinMatch(com.regexgame.JoinMatchRequest request) {
      return blockingUnaryCall(
          getChannel(), getJoinMatchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets events.
     * </pre>
     */
    public java.util.Iterator<com.regexgame.GameEvent> getEvents(
        com.regexgame.GetEventsRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetEventsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Makes an action.
     * </pre>
     */
    public com.regexgame.MakeActionReply makeAction(com.regexgame.MakeActionRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeActionMethod(), getCallOptions(), request);
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
     * Creates new match.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.regexgame.CreateMatchReply> createMatch(
        com.regexgame.CreateMatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMatchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Joins existing match.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.regexgame.JoinMatchReply> joinMatch(
        com.regexgame.JoinMatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getJoinMatchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Makes an action.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.regexgame.MakeActionReply> makeAction(
        com.regexgame.MakeActionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeActionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MATCH = 0;
  private static final int METHODID_JOIN_MATCH = 1;
  private static final int METHODID_GET_EVENTS = 2;
  private static final int METHODID_MAKE_ACTION = 3;

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
        case METHODID_CREATE_MATCH:
          serviceImpl.createMatch((com.regexgame.CreateMatchRequest) request,
              (io.grpc.stub.StreamObserver<com.regexgame.CreateMatchReply>) responseObserver);
          break;
        case METHODID_JOIN_MATCH:
          serviceImpl.joinMatch((com.regexgame.JoinMatchRequest) request,
              (io.grpc.stub.StreamObserver<com.regexgame.JoinMatchReply>) responseObserver);
          break;
        case METHODID_GET_EVENTS:
          serviceImpl.getEvents((com.regexgame.GetEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.regexgame.GameEvent>) responseObserver);
          break;
        case METHODID_MAKE_ACTION:
          serviceImpl.makeAction((com.regexgame.MakeActionRequest) request,
              (io.grpc.stub.StreamObserver<com.regexgame.MakeActionReply>) responseObserver);
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
      return com.regexgame.GameService.getDescriptor();
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
              .addMethod(getCreateMatchMethod())
              .addMethod(getJoinMatchMethod())
              .addMethod(getGetEventsMethod())
              .addMethod(getMakeActionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
