package server

import utilities.Global
import java.net.DatagramPacket
import java.net.DatagramSocket

object UdpServer {
    var socket = DatagramSocket(Global.SERVER_PORT)

    suspend fun start(){
        println("Starting UDP server")
        while(true){
            var packet = DatagramPacket(ByteArray(Global.BUFFER_SIZE),Global.BUFFER_SIZE)
            socket.receive(packet)
            Connections.sendDatagram(socket,packet)
        }
    }
}