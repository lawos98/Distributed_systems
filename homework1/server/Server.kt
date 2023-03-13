package server

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import utilities.Global
import java.net.ServerSocket

fun main()= runBlocking {
    var clientId=0
    var socket = ServerSocket(Global.SERVER_PORT)
    GlobalScope.launch { MessegeSender.start() }
    GlobalScope.launch { UdpServer.start() }
    Connections.unlock()

    while(true){
        clientId+=1
        var client = socket.accept()
        println("Client connected: ${clientId}")
        var clientConnection = ClientConnection(clientId,client)
        var job = GlobalScope.launch { Connections.addUser(clientId,client)}
        job.join()
        GlobalScope.launch { clientConnection.start() }
    }

}