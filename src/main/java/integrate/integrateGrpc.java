package integrate;

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
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: integrate.proto")
public final class integrateGrpc {

  private integrateGrpc() {}

  public static final String SERVICE_NAME = "integrate.integrate";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<integrate.Integration,
      integrate.ResponseMessage> getDoIntegrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "doIntegration",
      requestType = integrate.Integration.class,
      responseType = integrate.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<integrate.Integration,
      integrate.ResponseMessage> getDoIntegrationMethod() {
    io.grpc.MethodDescriptor<integrate.Integration, integrate.ResponseMessage> getDoIntegrationMethod;
    if ((getDoIntegrationMethod = integrateGrpc.getDoIntegrationMethod) == null) {
      synchronized (integrateGrpc.class) {
        if ((getDoIntegrationMethod = integrateGrpc.getDoIntegrationMethod) == null) {
          integrateGrpc.getDoIntegrationMethod = getDoIntegrationMethod = 
              io.grpc.MethodDescriptor.<integrate.Integration, integrate.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "integrate.integrate", "doIntegration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  integrate.Integration.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  integrate.ResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new integrateMethodDescriptorSupplier("doIntegration"))
                  .build();
          }
        }
     }
     return getDoIntegrationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static integrateStub newStub(io.grpc.Channel channel) {
    return new integrateStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static integrateBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new integrateBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static integrateFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new integrateFutureStub(channel);
  }

  /**
   */
  public static abstract class integrateImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<integrate.Integration> doIntegration(
        io.grpc.stub.StreamObserver<integrate.ResponseMessage> responseObserver) {
      return asyncUnimplementedStreamingCall(getDoIntegrationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDoIntegrationMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                integrate.Integration,
                integrate.ResponseMessage>(
                  this, METHODID_DO_INTEGRATION)))
          .build();
    }
  }

  /**
   */
  public static final class integrateStub extends io.grpc.stub.AbstractStub<integrateStub> {
    private integrateStub(io.grpc.Channel channel) {
      super(channel);
    }

    private integrateStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected integrateStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new integrateStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<integrate.Integration> doIntegration(
        io.grpc.stub.StreamObserver<integrate.ResponseMessage> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDoIntegrationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class integrateBlockingStub extends io.grpc.stub.AbstractStub<integrateBlockingStub> {
    private integrateBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private integrateBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected integrateBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new integrateBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class integrateFutureStub extends io.grpc.stub.AbstractStub<integrateFutureStub> {
    private integrateFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private integrateFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected integrateFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new integrateFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DO_INTEGRATION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final integrateImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(integrateImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DO_INTEGRATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.doIntegration(
              (io.grpc.stub.StreamObserver<integrate.ResponseMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class integrateBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    integrateBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return integrate.integrateImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("integrate");
    }
  }

  private static final class integrateFileDescriptorSupplier
      extends integrateBaseDescriptorSupplier {
    integrateFileDescriptorSupplier() {}
  }

  private static final class integrateMethodDescriptorSupplier
      extends integrateBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    integrateMethodDescriptorSupplier(String methodName) {
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
      synchronized (integrateGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new integrateFileDescriptorSupplier())
              .addMethod(getDoIntegrationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
