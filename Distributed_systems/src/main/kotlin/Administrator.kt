import com.rabbitmq.client.AMQP
import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope

class Administrator {
    private val role = "Administrator"
    private val channel = createChannel()
    init {
        channel.declareExchanges()

        val queueName = channel.queueDeclare().queue
        channel.queueBind(queueName, ADMIN_EXCHANGE_NAME, "#")
        channel.queueBind(queueName,CONFIRM_EXCHANGE_NAME, "#" )
        channel.queueBind(queueName, ORDER_EXCHANGE_NAME, "#")


        val consumer = object : DefaultConsumer(channel) {
            override fun handleDelivery(
                consumerTag: String,
                envelope: Envelope,
                properties: AMQP.BasicProperties,
                body: ByteArray
            ) {
                val message = String(body, charset("UTF-8"))
                ColorPrinter.printInColor("[$role] Received message: $message",TextColor.B_PURPLE)
            }
        }
        channel.basicConsume(queueName, true, consumer)
    }

    fun sendMessageToCarriers(message: String) {
        channel.basicPublish(ADMIN_EXCHANGE_NAME, "carrier.*", null, message.toByteArray())
        ColorPrinter.printInColor("[$role] Sent message to carriers: $message",TextColor.PURPLE)
    }

    fun sendMessageToAgencies(message: String) {
        channel.basicPublish(ADMIN_EXCHANGE_NAME, "agency.*", null, message.toByteArray())
        ColorPrinter.printInColor("[$role] Sent message to agencies: $message",TextColor.PURPLE)
    }

    fun sendMessageToAll(message: String) {
        channel.basicPublish(ADMIN_EXCHANGE_NAME, "#", null, message.toByteArray())
        ColorPrinter.printInColor("[$role] Sent message to all: $message",TextColor.PURPLE)
    }
}



