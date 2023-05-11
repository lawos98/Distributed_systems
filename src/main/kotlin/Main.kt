import java.io.File
import java.io.InputStreamReader

fun printColoredText(text: String, color: String) {
    val reset = "\u001B[0m"
    val code = when (color) {
        "black" -> "\u001B[30m"
        "red" -> "\u001B[31m"
        "green" -> "\u001B[32m"
        "yellow" -> "\u001B[33m"
        "blue" -> "\u001B[34m"
        "purple" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "white" -> "\u001B[37m"
        else -> ""
    }
    print("$code$text$reset")
}


fun getOrder(){
    val file = File("src/main/resources/getOrder.json")
    val getOrderRequest = file.readText(Charsets.UTF_8)
    val getOrderCommand = listOf(
        "grpcurl",
        "-plaintext",
        "-d", getOrderRequest,
        "localhost:50051",
        "OrderService/GetOrder"
    )
    val getOrderProcess = ProcessBuilder(getOrderCommand)
        .redirectErrorStream(true)
        .start()
    val getOrderOutput = InputStreamReader(getOrderProcess.inputStream).readText()
    printColoredText("GetOrder response: $getOrderOutput","cyan")
}

fun createOrder(){
    val file = File("src/main/resources/createOrder.json")
    val createOrderRequest =  file.readText(Charsets.UTF_8)
    val createOrderCommand = listOf(
        "grpcurl",
        "-plaintext",
        "-d", createOrderRequest,
        "localhost:50051",
        "OrderService/CreateOrder"
    )

    val createOrderProcess = ProcessBuilder(createOrderCommand)
        .redirectErrorStream(true)
        .start()

    val createOrderOutput = InputStreamReader(createOrderProcess.inputStream).readText()
    printColoredText("CreateOrder response: $createOrderOutput","yellow")
}

fun updateOrder(){
    // Update an order
    val file = File("src/main/resources/updateOrder.json")
    val updateOrderRequest = file.readText(Charsets.UTF_8)
    val updateOrderCommand = listOf(
        "grpcurl",
        "-plaintext",
        "-d", updateOrderRequest,
        "localhost:50051",
        "OrderService/UpdateOrder"
    )
    val updateOrderProcess = ProcessBuilder(updateOrderCommand)
        .redirectErrorStream(true)
        .start()
    val updateOrderOutput = InputStreamReader(updateOrderProcess.inputStream).readText()
    printColoredText("UpdateOrder response: $updateOrderOutput","purple")
}

fun main() {
    getOrder()
    createOrder()
    getOrder()
    updateOrder()
    getOrder()
}