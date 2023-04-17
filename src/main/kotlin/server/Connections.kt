package server

import kotlinx.coroutines.channels.Channel
import utilities.Global
import utilities.Message
import java.io.PrintWriter
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.Socket


object Connections {
    var socketMap= mutableMapOf<Int,Socket>()
    var mapSemaphore = Channel<Int>(1)

    suspend fun unlock(){
        mapSemaphore.send(1)
    }

    suspend fun addUser(clientId:Int,socket:Socket) {
        mapSemaphore.receive()
        socketMap[clientId] = socket
        mapSemaphore.send(1)
    }
    suspend fun removeUser(clientId:Int) {
        mapSemaphore.receive()
        socketMap.remove(clientId)
        mapSemaphore.send(1)
    }

    suspend fun sendMessage(message: Message) {
        mapSemaphore.receive()
        for ((key, value) in socketMap) {
            if (key != message.getIdUser() && !value.isClosed) {
                var writter = PrintWriter(value.getOutputStream(),true)
                writter.println(message.toString())
            }
        }
        mapSemaphore.send(1)
    }

    suspend fun sendDatagram(socket: DatagramSocket,packet:DatagramPacket) {
        mapSemaphore.receive()
        var clientId: Int? = null
        for ((key, value) in socketMap) {
            if (value.port==packet.port) {
                clientId=key
            }
        }
        if (clientId!= null) {
            for ((key, value) in socketMap) {
                if (value.port!=packet.port) {
                    val serverAddress = InetAddress.getByName(Global.TCP_ADDRESS)
                    val port = value.port
                    val message=packet.data.toString(Charsets.UTF_8).filter { e -> e.code!=0 }
                    socket.send(DatagramPacket(Message(message,clientId).toByte(), packet.length, serverAddress, port))
                }
            }
        }
        mapSemaphore.send(1)

    }

}