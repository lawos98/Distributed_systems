package proto

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow
import proto.WeatherServiceGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for subscriptions.WeatherService.
 */
public object WeatherServiceGrpcKt {
  public const val SERVICE_NAME: String = WeatherServiceGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = WeatherServiceGrpc.getServiceDescriptor()

  public val getWeatherByTemperatureMethod:
      MethodDescriptor<WeatherTemperatureRequest, WeatherResponse>
    @JvmStatic
    get() = WeatherServiceGrpc.getGetWeatherByTemperatureMethod()

  public val getWeatherByHumidityMethod: MethodDescriptor<WeatherHumidityRequest, WeatherResponse>
    @JvmStatic
    get() = WeatherServiceGrpc.getGetWeatherByHumidityMethod()

  public val getWeatherByWindMethod: MethodDescriptor<WeatherWindRequest, WeatherResponse>
    @JvmStatic
    get() = WeatherServiceGrpc.getGetWeatherByWindMethod()

  public val getWeatherByPressureMethod: MethodDescriptor<WeatherPressureRequest, WeatherResponse>
    @JvmStatic
    get() = WeatherServiceGrpc.getGetWeatherByPressureMethod()

  public val getWeatherByTypeMethod: MethodDescriptor<WeatherTypeRequest, WeatherResponse>
    @JvmStatic
    get() = WeatherServiceGrpc.getGetWeatherByTypeMethod()

  /**
   * A stub for issuing RPCs to a(n) subscriptions.WeatherService service as suspending coroutines.
   */
  @StubFor(WeatherServiceGrpc::class)
  public class WeatherServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<WeatherServiceCoroutineStub>(channel, callOptions) {
    public override fun build(channel: Channel, callOptions: CallOptions):
        WeatherServiceCoroutineStub = WeatherServiceCoroutineStub(channel, callOptions)

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getWeatherByTemperature(request: WeatherTemperatureRequest, headers: Metadata =
        Metadata()): Flow<WeatherResponse> = serverStreamingRpc(
      channel,
      WeatherServiceGrpc.getGetWeatherByTemperatureMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getWeatherByHumidity(request: WeatherHumidityRequest, headers: Metadata =
        Metadata()): Flow<WeatherResponse> = serverStreamingRpc(
      channel,
      WeatherServiceGrpc.getGetWeatherByHumidityMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getWeatherByWind(request: WeatherWindRequest, headers: Metadata = Metadata()):
        Flow<WeatherResponse> = serverStreamingRpc(
      channel,
      WeatherServiceGrpc.getGetWeatherByWindMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getWeatherByPressure(request: WeatherPressureRequest, headers: Metadata =
        Metadata()): Flow<WeatherResponse> = serverStreamingRpc(
      channel,
      WeatherServiceGrpc.getGetWeatherByPressureMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getWeatherByType(request: WeatherTypeRequest, headers: Metadata = Metadata()):
        Flow<WeatherResponse> = serverStreamingRpc(
      channel,
      WeatherServiceGrpc.getGetWeatherByTypeMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the subscriptions.WeatherService service based on Kotlin coroutines.
   */
  public abstract class WeatherServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns a [Flow] of responses to an RPC for
     * subscriptions.WeatherService.GetWeatherByTemperature.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getWeatherByTemperature(request: WeatherTemperatureRequest):
        Flow<WeatherResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method subscriptions.WeatherService.GetWeatherByTemperature is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * subscriptions.WeatherService.GetWeatherByHumidity.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getWeatherByHumidity(request: WeatherHumidityRequest): Flow<WeatherResponse> =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method subscriptions.WeatherService.GetWeatherByHumidity is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for subscriptions.WeatherService.GetWeatherByWind.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getWeatherByWind(request: WeatherWindRequest): Flow<WeatherResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method subscriptions.WeatherService.GetWeatherByWind is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * subscriptions.WeatherService.GetWeatherByPressure.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getWeatherByPressure(request: WeatherPressureRequest): Flow<WeatherResponse> =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method subscriptions.WeatherService.GetWeatherByPressure is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for subscriptions.WeatherService.GetWeatherByType.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getWeatherByType(request: WeatherTypeRequest): Flow<WeatherResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method subscriptions.WeatherService.GetWeatherByType is unimplemented"))

    public final override fun bindService(): ServerServiceDefinition =
        builder(getServiceDescriptor())
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = WeatherServiceGrpc.getGetWeatherByTemperatureMethod(),
      implementation = ::getWeatherByTemperature
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = WeatherServiceGrpc.getGetWeatherByHumidityMethod(),
      implementation = ::getWeatherByHumidity
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = WeatherServiceGrpc.getGetWeatherByWindMethod(),
      implementation = ::getWeatherByWind
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = WeatherServiceGrpc.getGetWeatherByPressureMethod(),
      implementation = ::getWeatherByPressure
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = WeatherServiceGrpc.getGetWeatherByTypeMethod(),
      implementation = ::getWeatherByType
    )).build()
  }
}
