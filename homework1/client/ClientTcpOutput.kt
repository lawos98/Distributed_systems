package client

import utilities.ErrorMessage
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

class ClientTcpOutput(private val socket: Socket, private val username:String) {
    suspend fun run(){
        try{
            while(true){
                val serverInput = BufferedReader(InputStreamReader(socket.inputStream));
                println("Waiting for Tcp Text")
                val message=serverInput.readLine()
                println(message)
                if(message != null){
                    println(ClientMessage(username,message).toString())
                }
            }
        }
        catch (ex: Exception) {
            println(ErrorMessage(username,"Error with Client TCP Output").toString())
        }
    }
}