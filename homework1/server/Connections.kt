package server

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Semaphore
import utilities.Global
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

    suspend fun sendMessage(message: ServerMessage) {
        mapSemaphore.receive()
        for ((key, value) in socketMap) {
            if (key != message.getIdUser()) {
                var writter = PrintWriter(value.getOutputStream(),true)
                writter.println(message.getText())
            }
        }
        mapSemaphore.send(1)
    }

    suspend fun sendDatagram(socket: DatagramSocket,packet:DatagramPacket) {
        mapSemaphore.receive()
        for ((key, value) in socketMap) {
            if (value.port!=socket.port || value.inetAddress!=socket.inetAddress) {
                var serverAddress = InetAddress.getByName(Global.TCP_ADDRESS)
                var port = value.port
                socket.send(DatagramPacket(packet.data, packet.length, serverAddress, port))
            }
        }
        mapSemaphore.send(1)

    }

}