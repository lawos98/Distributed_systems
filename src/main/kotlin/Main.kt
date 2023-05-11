import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.Status
import io.grpc.stub.ServerCallStreamObserver
import io.grpc.stub.StreamObserver
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import proto.*

class SubscriptionService(private val port: Int) {
    private val server: Server = ServerBuilder.forPort(port)
        .addService(WeatherServiceImpl())
        .build()

    @OptIn(DelicateCoroutinesApi::class)
    fun start() {
        server.start()
        println("Server started, listening on $port")
        GlobalScope.launch {
            startWeatherGenerator()
        }
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                this@SubscriptionService.stop()
                println("*** server shut down")
            }
        )
    }

    fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }
}

    internal class WeatherServiceImpl : WeatherServiceGrpc.WeatherServiceImplBase() {
        override fun getWeatherByTemperature(
            request: WeatherTemperatureRequest,
            responseObserver: StreamObserver<WeatherResponse>
        ) {
            println(request)
            handleRequest(request.city, responseObserver) { weather ->
                weather.city == request.city && weather.temperature >= request.temperature - request.range && weather.temperature <= request.temperature + request.range
            }
        }

        override fun getWeatherByHumidity(request: WeatherHumidityRequest, responseObserver: StreamObserver<WeatherResponse>) {
            println(request)
            handleRequest(request.city, responseObserver) { weather ->
                weather.city == request.city && weather.humidity >= request.humidity - request.range && weather.humidity <= request.humidity + request.range
            }
        }

        override fun getWeatherByWind(request: WeatherWindRequest, responseObserver: StreamObserver<WeatherResponse>) {
            println(request)
            handleRequest(request.city, responseObserver) { weather ->
                weather.city == request.city && weather.wind >= request.wind  - request.range && weather.wind  <= request.wind  + request.range
            }
        }

        override fun getWeatherByPressure(request: WeatherPressureRequest, responseObserver: StreamObserver<WeatherResponse>) {
            println(request)
            handleRequest(request.city, responseObserver) { weather ->
                weather.city == request.city && weather.pressure >= request.pressure  - request.range && weather.pressure  <= request.pressure  + request.range
            }
        }

        override fun getWeatherByType(request: WeatherTypeRequest, responseObserver: StreamObserver<WeatherResponse>) {
            println(request.typeList)
            println("==============")
            handleRequest(request.city, responseObserver) { weather ->
                weather.city == request.city && request.typeList.contains(weather.type)
            }
        }

        @OptIn(DelicateCoroutinesApi::class)
        private fun handleRequest(
            cityName: String,
            responseObserver: StreamObserver<WeatherResponse>,
            filter: (WeatherResponse) -> Boolean
        ) {
            if (cityName !in cities) {
                val msg = "Weather in $cityName is not supported, we only know about $cities"
                responseObserver.onError(
                    Status.INVALID_ARGUMENT
                        .withDescription(msg)
                        .asRuntimeException()
                )
                return
            }

            // Handle call cancellation
            (responseObserver as ServerCallStreamObserver).setOnCancelHandler {
                println("Call cancelled $cityName , $filter")
            }

            val job = GlobalScope.launch {
                weatherGenerator.filter(filter).collect { response ->
                    responseObserver.onNext(response)
                }
            }

            job.invokeOnCompletion {
                responseObserver.onCompleted()
            }
        }
    }

fun serve() {
    println("Subscription server starting...")
    val server = SubscriptionService(50051)
    server.start()
    server.blockUntilShutdown()
}

fun main() {
    printList()
    serve()
}