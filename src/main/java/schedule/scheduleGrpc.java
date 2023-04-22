package schedule;

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
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: schedule.proto")
public final class scheduleGrpc {

  private scheduleGrpc() {}

  public static final String SERVICE_NAME = "schedule.schedule";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<schedule.Event,
      schedule.ResponseMessage> getBookEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bookEvent",
      requestType = schedule.Event.class,
      responseType = schedule.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<schedule.Event,
      schedule.ResponseMessage> getBookEventMethod() {
    io.grpc.MethodDescriptor<schedule.Event, schedule.ResponseMessage> getBookEventMethod;
    if ((getBookEventMethod = scheduleGrpc.getBookEventMethod) == null) {
      synchronized (scheduleGrpc.class) {
        if ((getBookEventMethod = scheduleGrpc.getBookEventMethod) == null) {
          scheduleGrpc.getBookEventMethod = getBookEventMethod = 
              io.grpc.MethodDescriptor.<schedule.Event, schedule.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "schedule.schedule", "bookEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  schedule.Event.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  schedule.ResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new scheduleMethodDescriptorSupplier("bookEvent"))
                  .build();
          }
        }
     }
     return getBookEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<schedule.SendReminder,
      schedule.ResponseMessage> getSendReminderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendReminder",
      requestType = schedule.SendReminder.class,
      responseType = schedule.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<schedule.SendReminder,
      schedule.ResponseMessage> getSendReminderMethod() {
    io.grpc.MethodDescriptor<schedule.SendReminder, schedule.ResponseMessage> getSendReminderMethod;
    if ((getSendReminderMethod = scheduleGrpc.getSendReminderMethod) == null) {
      synchronized (scheduleGrpc.class) {
        if ((getSendReminderMethod = scheduleGrpc.getSendReminderMethod) == null) {
          scheduleGrpc.getSendReminderMethod = getSendReminderMethod = 
              io.grpc.MethodDescriptor.<schedule.SendReminder, schedule.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "schedule.schedule", "sendReminder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  schedule.SendReminder.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  schedule.ResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new scheduleMethodDescriptorSupplier("sendReminder"))
                  .build();
          }
        }
     }
     return getSendReminderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static scheduleStub newStub(io.grpc.Channel channel) {
    return new scheduleStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static scheduleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new scheduleBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static scheduleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new scheduleFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class scheduleImplBase implements io.grpc.BindableService {

    /**
     */
    public void bookEvent(schedule.Event request,
        io.grpc.stub.StreamObserver<schedule.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getBookEventMethod(), responseObserver);
    }

    /**
     */
    public void sendReminder(schedule.SendReminder request,
        io.grpc.stub.StreamObserver<schedule.ResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSendReminderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBookEventMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                schedule.Event,
                schedule.ResponseMessage>(
                  this, METHODID_BOOK_EVENT)))
          .addMethod(
            getSendReminderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                schedule.SendReminder,
                schedule.ResponseMessage>(
                  this, METHODID_SEND_REMINDER)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class scheduleStub extends io.grpc.stub.AbstractStub<scheduleStub> {
    private scheduleStub(io.grpc.Channel channel) {
      super(channel);
    }

    private scheduleStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected scheduleStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new scheduleStub(channel, callOptions);
    }

    /**
     */
    public void bookEvent(schedule.Event request,
        io.grpc.stub.StreamObserver<schedule.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBookEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendReminder(schedule.SendReminder request,
        io.grpc.stub.StreamObserver<schedule.ResponseMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendReminderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class scheduleBlockingStub extends io.grpc.stub.AbstractStub<scheduleBlockingStub> {
    private scheduleBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private scheduleBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected scheduleBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new scheduleBlockingStub(channel, callOptions);
    }

    /**
     */
    public schedule.ResponseMessage bookEvent(schedule.Event request) {
      return blockingUnaryCall(
          getChannel(), getBookEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public schedule.ResponseMessage sendReminder(schedule.SendReminder request) {
      return blockingUnaryCall(
          getChannel(), getSendReminderMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class scheduleFutureStub extends io.grpc.stub.AbstractStub<scheduleFutureStub> {
    private scheduleFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private scheduleFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected scheduleFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new scheduleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<schedule.ResponseMessage> bookEvent(
        schedule.Event request) {
      return futureUnaryCall(
          getChannel().newCall(getBookEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<schedule.ResponseMessage> sendReminder(
        schedule.SendReminder request) {
      return futureUnaryCall(
          getChannel().newCall(getSendReminderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOK_EVENT = 0;
  private static final int METHODID_SEND_REMINDER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final scheduleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(scheduleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BOOK_EVENT:
          serviceImpl.bookEvent((schedule.Event) request,
              (io.grpc.stub.StreamObserver<schedule.ResponseMessage>) responseObserver);
          break;
        case METHODID_SEND_REMINDER:
          serviceImpl.sendReminder((schedule.SendReminder) request,
              (io.grpc.stub.StreamObserver<schedule.ResponseMessage>) responseObserver);
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

  private static abstract class scheduleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    scheduleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return schedule.scheduleImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("schedule");
    }
  }

  private static final class scheduleFileDescriptorSupplier
      extends scheduleBaseDescriptorSupplier {
    scheduleFileDescriptorSupplier() {}
  }

  private static final class scheduleMethodDescriptorSupplier
      extends scheduleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    scheduleMethodDescriptorSupplier(String methodName) {
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
      synchronized (scheduleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new scheduleFileDescriptorSupplier())
              .addMethod(getBookEventMethod())
              .addMethod(getSendReminderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
