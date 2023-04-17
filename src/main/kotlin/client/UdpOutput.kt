package client

import utilities.Color
import utilities.Global
import java.net.DatagramPacket
import java.net.DatagramSocket

class UdpOutput(val socket:DatagramSocket){
    suspend fun run(){
        while(true){
            try{
                val packet=DatagramPacket(ByteArray(Global.BUFFER_SIZE),Global.BUFFER_SIZE)
                socket.receive(packet)
                val message=packet.data.toString(Charsets.UTF_8).filter { e -> e.code!=0 }
                println("Udp| $message")
            }
            catch (ex: Exception) {
                socket.close()
                println(Color.RED.colorText("Error with Client Udp Output"))
                break
            }
        }
    }
}
