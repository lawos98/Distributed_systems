package client

import utilities.Color
import utilities.Global
import java.net.DatagramPacket
import java.net.DatagramSocket

class MulticastOutput(val socket:DatagramSocket, var port:Int){
    suspend fun run(){
        while(true){
            try{
                val packet=DatagramPacket(ByteArray(Global.BUFFER_SIZE),Global.BUFFER_SIZE)
                socket.receive(packet)
                if(packet.port!=port){
                    val message=packet.data.toString(Charsets.UTF_8).filter { e -> e.code!=0 }
                    println("Multicast| $message")
                }
            }
            catch(e:Exception){
                println(Color.RED.colorText("Error with Client Multicast Output"))
                socket.close()
                break
            }
        }
    }
}
