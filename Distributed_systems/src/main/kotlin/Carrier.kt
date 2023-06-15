import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class Carrier(services: List<String>, private val name: String) {
    private val channel = createChannel()

    init {
        channel.declareExchanges()
        val broadcastQueueName = channel.queueDeclare().queue
        channel.queueBind(broadcastQueueName, ADMIN_EXCHANGE_NAME, "carrier.$name")

        val broadcastConsumer = object : DefaultConsumer(channel) {
            override fun handleDelivery(
                consumerTag: String,
                envelope: Envelope,
                properties: AMQP.BasicProperties,
                body: ByteArray
            ) {
                val message = String(body, charset("UTF-8"))
                ColorPrinter.printInColor("[Carrier : $name] Received broadcast: $message",TextColor.B_YELLOW)
            }
        }
        channel.basicConsume(broadcastQueueName, true, broadcastConsumer)


        services.forEach { service ->
            val queueServiceName = "$service-queue"
            channel.queueDeclare(queueServiceName, false, false, false, null)
            channel.queueBind(queueServiceName, ORDER_EXCHANGE_NAME, service)
            channel.basicQos(1)

            val consumer = object : DefaultConsumer(channel) {
                override fun handleDelivery(consumerTag: String, envelope: Envelope, properties: AMQP.BasicProperties, body: ByteArray) {
                    val message = String(body, charset("UTF-8"))
                    ColorPrinter.printInColor("[Carrier : $name] Received order: $message",TextColor.B_YELLOW)
                    confirmOrder(message)
                    channel.basicAck(envelope.deliveryTag, false)
                }
            }
            channel.basicConsume(queueServiceName, false, consumer)
        }
    }

    private fun confirmOrder(order: String) = runBlocking {
        delay(Random.nextLong(100, 5000))
        val confirmationMessage = "Order $order completed by $name"
        val (agencyName, _) = order.split(":")
        channel.basicPublish(CONFIRM_EXCHANGE_NAME, "agency.$agencyName", null, confirmationMessage.toByteArray())
        ColorPrinter.printInColor("[Carrier : $name] Sent confirmation for order $order",TextColor.YELLOW)
    }
}