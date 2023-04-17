package client

import utilities.Color
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class TcpOutput(private val socket: Socket) {
    suspend fun run(){
        while(true){
            try {
                val serverInput = BufferedReader(InputStreamReader(socket.inputStream));
                val message = serverInput.readLine()
                if (message != null) {
                    println("TCP| $message")
                }
            }
            catch (ex: Exception) {
                socket.close()
                println(Color.RED.colorText("Error with Client TCP Output"))
                break
            }
        }
    }
}