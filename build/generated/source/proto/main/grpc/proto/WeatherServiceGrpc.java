package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.0)",
    comments = "Source: subscriptions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WeatherServiceGrpc {

  private WeatherServiceGrpc() {}

  public static final String SERVICE_NAME = "subscriptions.WeatherService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.WeatherTemperatureRequest,
      proto.WeatherResponse> getGetWeatherByTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeatherByTemperature",
      requestType = proto.WeatherTemperatureRequest.class,
      responseType = proto.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.WeatherTemperatureRequest,
      proto.WeatherResponse> getGetWeatherByTemperatureMethod() {
    io.grpc.MethodDescriptor<proto.WeatherTemperatureRequest, proto.WeatherResponse> getGetWeatherByTemperatureMethod;
    if ((getGetWeatherByTemperatureMethod = WeatherServiceGrpc.getGetWeatherByTemperatureMethod) == null) {
      synchronized (WeatherServiceGrpc.class) {
        if ((getGetWeatherByTemperatureMethod = WeatherServiceGrpc.getGetWeatherByTemperatureMethod) == null) {
          WeatherServiceGrpc.getGetWeatherByTemperatureMethod = getGetWeatherByTemperatureMethod =
              io.grpc.MethodDescriptor.<proto.WeatherTemperatureRequest, proto.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWeatherByTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherServiceMethodDescriptorSupplier("GetWeatherByTemperature"))
              .build();
        }
      }
    }
    return getGetWeatherByTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.WeatherHumidityRequest,
      proto.WeatherResponse> getGetWeatherByHumidityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeatherByHumidity",
      requestType = proto.WeatherHumidityRequest.class,
      responseType = proto.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.WeatherHumidityRequest,
      proto.WeatherResponse> getGetWeatherByHumidityMethod() {
    io.grpc.MethodDescriptor<proto.WeatherHumidityRequest, proto.WeatherResponse> getGetWeatherByHumidityMethod;
    if ((getGetWeatherByHumidityMethod = WeatherServiceGrpc.getGetWeatherByHumidityMethod) == null) {
      synchronized (WeatherServiceGrpc.class) {
        if ((getGetWeatherByHumidityMethod = WeatherServiceGrpc.getGetWeatherByHumidityMethod) == null) {
          WeatherServiceGrpc.getGetWeatherByHumidityMethod = getGetWeatherByHumidityMethod =
              io.grpc.MethodDescriptor.<proto.WeatherHumidityRequest, proto.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWeatherByHumidity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherHumidityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherServiceMethodDescriptorSupplier("GetWeatherByHumidity"))
              .build();
        }
      }
    }
    return getGetWeatherByHumidityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.WeatherWindRequest,
      proto.WeatherResponse> getGetWeatherByWindMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeatherByWind",
      requestType = proto.WeatherWindRequest.class,
      responseType = proto.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.WeatherWindRequest,
      proto.WeatherResponse> getGetWeatherByWindMethod() {
    io.grpc.MethodDescriptor<proto.WeatherWindRequest, proto.WeatherResponse> getGetWeatherByWindMethod;
    if ((getGetWeatherByWindMethod = WeatherServiceGrpc.getGetWeatherByWindMethod) == null) {
      synchronized (WeatherServiceGrpc.class) {
        if ((getGetWeatherByWindMethod = WeatherServiceGrpc.getGetWeatherByWindMethod) == null) {
          WeatherServiceGrpc.getGetWeatherByWindMethod = getGetWeatherByWindMethod =
              io.grpc.MethodDescriptor.<proto.WeatherWindRequest, proto.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWeatherByWind"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherWindRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherServiceMethodDescriptorSupplier("GetWeatherByWind"))
              .build();
        }
      }
    }
    return getGetWeatherByWindMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.WeatherPressureRequest,
      proto.WeatherResponse> getGetWeatherByPressureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeatherByPressure",
      requestType = proto.WeatherPressureRequest.class,
      responseType = proto.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.WeatherPressureRequest,
      proto.WeatherResponse> getGetWeatherByPressureMethod() {
    io.grpc.MethodDescriptor<proto.WeatherPressureRequest, proto.WeatherResponse> getGetWeatherByPressureMethod;
    if ((getGetWeatherByPressureMethod = WeatherServiceGrpc.getGetWeatherByPressureMethod) == null) {
      synchronized (WeatherServiceGrpc.class) {
        if ((getGetWeatherByPressureMethod = WeatherServiceGrpc.getGetWeatherByPressureMethod) == null) {
          WeatherServiceGrpc.getGetWeatherByPressureMethod = getGetWeatherByPressureMethod =
              io.grpc.MethodDescriptor.<proto.WeatherPressureRequest, proto.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWeatherByPressure"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherPressureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherServiceMethodDescriptorSupplier("GetWeatherByPressure"))
              .build();
        }
      }
    }
    return getGetWeatherByPressureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.WeatherTypeRequest,
      proto.WeatherResponse> getGetWeatherByTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeatherByType",
      requestType = proto.WeatherTypeRequest.class,
      responseType = proto.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<proto.WeatherTypeRequest,
      proto.WeatherResponse> getGetWeatherByTypeMethod() {
    io.grpc.MethodDescriptor<proto.WeatherTypeRequest, proto.WeatherResponse> getGetWeatherByTypeMethod;
    if ((getGetWeatherByTypeMethod = WeatherServiceGrpc.getGetWeatherByTypeMethod) == null) {
      synchronized (WeatherServiceGrpc.class) {
        if ((getGetWeatherByTypeMethod = WeatherServiceGrpc.getGetWeatherByTypeMethod) == null) {
          WeatherServiceGrpc.getGetWeatherByTypeMethod = getGetWeatherByTypeMethod =
              io.grpc.MethodDescriptor.<proto.WeatherTypeRequest, proto.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWeatherByType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.WeatherResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherServiceMethodDescriptorSupplier("GetWeatherByType"))
              .build();
        }
      }
    }
    return getGetWeatherByTypeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WeatherServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherServiceStub>() {
        @java.lang.Override
        public WeatherServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherServiceStub(channel, callOptions);
        }
      };
    return WeatherServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WeatherServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherServiceBlockingStub>() {
        @java.lang.Override
        public WeatherServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherServiceBlockingStub(channel, callOptions);
        }
      };
    return WeatherServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WeatherServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherServiceFutureStub>() {
        @java.lang.Override
        public WeatherServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherServiceFutureStub(channel, callOptions);
        }
      };
    return WeatherServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getWeatherByTemperature(proto.WeatherTemperatureRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWeatherByTemperatureMethod(), responseObserver);
    }

    /**
     */
    default void getWeatherByHumidity(proto.WeatherHumidityRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWeatherByHumidityMethod(), responseObserver);
    }

    /**
     */
    default void getWeatherByWind(proto.WeatherWindRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWeatherByWindMethod(), responseObserver);
    }

    /**
     */
    default void getWeatherByPressure(proto.WeatherPressureRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWeatherByPressureMethod(), responseObserver);
    }

    /**
     */
    default void getWeatherByType(proto.WeatherTypeRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWeatherByTypeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WeatherService.
   */
  public static abstract class WeatherServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WeatherServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WeatherService.
   */
  public static final class WeatherServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WeatherServiceStub> {
    private WeatherServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherServiceStub(channel, callOptions);
    }

    /**
     */
    public void getWeatherByTemperature(proto.WeatherTemperatureRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetWeatherByTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWeatherByHumidity(proto.WeatherHumidityRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetWeatherByHumidityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWeatherByWind(proto.WeatherWindRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetWeatherByWindMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWeatherByPressure(proto.WeatherPressureRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetWeatherByPressureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getWeatherByType(proto.WeatherTypeRequest request,
        io.grpc.stub.StreamObserver<proto.WeatherResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetWeatherByTypeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WeatherService.
   */
  public static final class WeatherServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WeatherServiceBlockingStub> {
    private WeatherServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<proto.WeatherResponse> getWeatherByTemperature(
        proto.WeatherTemperatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetWeatherByTemperatureMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.WeatherResponse> getWeatherByHumidity(
        proto.WeatherHumidityRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetWeatherByHumidityMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.WeatherResponse> getWeatherByWind(
        proto.WeatherWindRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetWeatherByWindMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.WeatherResponse> getWeatherByPressure(
        proto.WeatherPressureRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetWeatherByPressureMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<proto.WeatherResponse> getWeatherByType(
        proto.WeatherTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetWeatherByTypeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WeatherService.
   */
  public static final class WeatherServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WeatherServiceFutureStub> {
    private WeatherServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_WEATHER_BY_TEMPERATURE = 0;
  private static final int METHODID_GET_WEATHER_BY_HUMIDITY = 1;
  private static final int METHODID_GET_WEATHER_BY_WIND = 2;
  private static final int METHODID_GET_WEATHER_BY_PRESSURE = 3;
  private static final int METHODID_GET_WEATHER_BY_TYPE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_WEATHER_BY_TEMPERATURE:
          serviceImpl.getWeatherByTemperature((proto.WeatherTemperatureRequest) request,
              (io.grpc.stub.StreamObserver<proto.WeatherResponse>) responseObserver);
          break;
        case METHODID_GET_WEATHER_BY_HUMIDITY:
          serviceImpl.getWeatherByHumidity((proto.WeatherHumidityRequest) request,
              (io.grpc.stub.StreamObserver<proto.WeatherResponse>) responseObserver);
          break;
        case METHODID_GET_WEATHER_BY_WIND:
          serviceImpl.getWeatherByWind((proto.WeatherWindRequest) request,
              (io.grpc.stub.StreamObserver<proto.WeatherResponse>) responseObserver);
          break;
        case METHODID_GET_WEATHER_BY_PRESSURE:
          serviceImpl.getWeatherByPressure((proto.WeatherPressureRequest) request,
              (io.grpc.stub.StreamObserver<proto.WeatherResponse>) responseObserver);
          break;
        case METHODID_GET_WEATHER_BY_TYPE:
          serviceImpl.getWeatherByType((proto.WeatherTypeRequest) request,
              (io.grpc.stub.StreamObserver<proto.WeatherResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetWeatherByTemperatureMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              proto.WeatherTemperatureRequest,
              proto.WeatherResponse>(
                service, METHODID_GET_WEATHER_BY_TEMPERATURE)))
        .addMethod(
          getGetWeatherByHumidityMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              proto.WeatherHumidityRequest,
              proto.WeatherResponse>(
                service, METHODID_GET_WEATHER_BY_HUMIDITY)))
        .addMethod(
          getGetWeatherByWindMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              proto.WeatherWindRequest,
              proto.WeatherResponse>(
                service, METHODID_GET_WEATHER_BY_WIND)))
        .addMethod(
          getGetWeatherByPressureMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              proto.WeatherPressureRequest,
              proto.WeatherResponse>(
                service, METHODID_GET_WEATHER_BY_PRESSURE)))
        .addMethod(
          getGetWeatherByTypeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              proto.WeatherTypeRequest,
              proto.WeatherResponse>(
                service, METHODID_GET_WEATHER_BY_TYPE)))
        .build();
  }

  private static abstract class WeatherServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WeatherServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.Subscriptions.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WeatherService");
    }
  }

  private static final class WeatherServiceFileDescriptorSupplier
      extends WeatherServiceBaseDescriptorSupplier {
    WeatherServiceFileDescriptorSupplier() {}
  }

  private static final class WeatherServiceMethodDescriptorSupplier
      extends WeatherServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WeatherServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WeatherServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WeatherServiceFileDescriptorSupplier())
              .addMethod(getGetWeatherByTemperatureMethod())
              .addMethod(getGetWeatherByHumidityMethod())
              .addMethod(getGetWeatherByWindMethod())
              .addMethod(getGetWeatherByPressureMethod())
              .addMethod(getGetWeatherByTypeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
