package server

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import utilities.Color
import utilities.Global
import java.io.PrintWriter
import java.net.ServerSocket

fun main()= runBlocking {

    val socket = ServerSocket(Global.SERVER_PORT)

    println(Color.ORANGE.colorText("Server started"))

//    GlobalScope.launch {
//        while(true){
//            println(Color.PURPLE.colorText(Thread.activeCount().toString()))
//            delay(5000)
//        }
//    }
    GlobalScope.launch { MessegeSender.start() }
    GlobalScope.launch { DatagramSender.start();}
    Connections.unlock()

    while(true){
        val client = socket.accept()
        val clientId=IdGenerator.getId()
        PrintWriter(client.getOutputStream(),true).println(Color.PURPLE.colorText("Client id : $clientId is ready"))
        println(Color.GREEN.colorText("Client : ${clientId} connected"))
        var clientConnection = ClientConnection(clientId,client)
        var job = GlobalScope.launch { Connections.addUser(clientId,client)}
        job.join()
        GlobalScope.launch { clientConnection.start() }
    }

}