package server

import kotlinx.coroutines.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.Socket

class ClientConnection(var clientId:Int,var socket: Socket) {

    suspend fun start(){
        println("Starting connection to $clientId")
        while(true){
            try{
                val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
                val message: String = reader.readLine()
                println(message)
                if (message != null) {
                    MessegeQueue.add(ServerMessage(message,clientId))
                }
            }
            catch (e:IOException){
                socket.close()
                Connections.removeUser(clientId)
                break
            }
        }
    }
}