import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import com.rabbitmq.client.*

const val ORDER_EXCHANGE_NAME = "agency_messages"
const val CONFIRM_EXCHANGE_NAME = "carrier_messages"
const val ADMIN_EXCHANGE_NAME = "admin_messages"

fun createChannel(): Channel {
    val factory = ConnectionFactory()
    factory.host = "localhost"
    val connection = factory.newConnection()
    return connection.createChannel()
}

fun Channel.declareExchanges() {
    this.exchangeDeclare(ORDER_EXCHANGE_NAME, BuiltinExchangeType.TOPIC)
    this.exchangeDeclare(CONFIRM_EXCHANGE_NAME, BuiltinExchangeType.TOPIC)
    this.exchangeDeclare(ADMIN_EXCHANGE_NAME, BuiltinExchangeType.FANOUT)
}

fun main(): Unit = runBlocking {
    val administrator = Administrator()

    val carrier1Services = listOf("people", "cargo")
    val carrier2Services = listOf("cargo", "satellite")

    val carrier1 = Carrier(carrier1Services,"Falcon")
    val carrier2 = Carrier(carrier2Services,"Voyager")

    val agency1 = Agency("NASA")
    val agency2 = Agency("ESA")

    val orderIds = kotlinx.coroutines.channels.Channel<Int>(1)
    orderIds.send(1)

    launch {
        while (true) {
            val randomAgency = listOf(agency1, agency2).random()
            val randomOrder = listOf("people", "cargo", "satellite").random()
            val orderId = orderIds.receive()
            orderIds.send(orderId + 1)

            runBlocking {
                randomAgency.placeOrder(randomOrder, orderId.toString())
            }

            delay(Random.nextLong(100, 1000))
        }
    }

    launch {
        while (true) {
            val randomMessage = listOf("Maintenance announcement", "System upgrade", "Security patch update").random()
            when (Random.nextInt(3)) {
                0 -> administrator.sendMessageToAgencies(randomMessage)
                1 -> administrator.sendMessageToCarriers(randomMessage)
                2 -> administrator.sendMessageToAll(randomMessage)
            }
            delay(Random.nextLong(5000, 20000))
        }
    }
}