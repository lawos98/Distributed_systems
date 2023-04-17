package server

import utilities.Color
import utilities.Message
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.NullPointerException
import java.net.Socket

class ClientConnection(var clientId:Int,var socket: Socket) {

    suspend fun start(){
        while(true){
            try{
                val reader = BufferedReader(InputStreamReader(socket.getInputStream()))
                val message: String = reader.readLine()
                if (message != null) {
                    MessegeQueue.add(Message(message,clientId))
                }
            }
            catch (e:IOException){
                break
            }
            catch (e:NullPointerException){
                break
            }
        }
        println(Color.YELLOW.colorText("Client : $clientId disconnected"))
        socket.close()
        IdGenerator.returnId(clientId)
        Connections.removeUser(clientId)

    }
}