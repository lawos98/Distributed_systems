import com.rabbitmq.client.DefaultConsumer
import com.rabbitmq.client.Envelope

class Agency(private val name: String) {
    private val channel = createChannel()

    init {
        channel.declareExchanges()

        val queueName = channel.queueDeclare().queue
        channel.queueBind(queueName, CONFIRM_EXCHANGE_NAME, "agency.$name")
        channel.queueBind(queueName,ADMIN_EXCHANGE_NAME, "agency.$name")
        val consumer = object : DefaultConsumer(channel) {
            override fun handleDelivery(consumerTag: String, envelope: Envelope, properties: com.rabbitmq.client.AMQP.BasicProperties, body: ByteArray) {
                val message = String(body, charset("UTF-8"))
                ColorPrinter.printInColor("[$name] Received: $message", TextColor.B_GREEN)
            }
        }
        channel.basicConsume(queueName, true, consumer)
    }

    fun placeOrder(orderType: String, orderNumber: String) {
        val message = "$name:$orderNumber"
        ColorPrinter.printInColor("[$name] Sent order $orderNumber of type $orderType",TextColor.GREEN)
        channel.basicPublish(ORDER_EXCHANGE_NAME, orderType, null, message.toByteArray())
    }
}
