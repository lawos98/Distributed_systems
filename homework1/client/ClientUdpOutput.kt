package client

import utilities.ErrorMessage
import utilities.Global
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.Socket

class ClientUdpOutput(val socket:DatagramSocket,val username:String){
    suspend fun run(){
        try{
            while(true){
                println("Waiting for Udp Text")
                val packet=DatagramPacket(ByteArray(Global.BUFFER_SIZE),Global.BUFFER_SIZE)
                socket.receive(packet);
                val message=packet.data.toString(Charsets.UTF_8).trim()
                println(message)
                if(message != null){
                    println(ClientMessage(message,username).toString())
                }
            }
        }catch(e:Exception){
            println(ErrorMessage(username,"Error with Client UDP Output").toString())
        }
    }
}
