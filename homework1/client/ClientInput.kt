package client

import utilities.ErrorMessage
import utilities.Global
import java.io.PrintWriter
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.Socket

class ClientInput(private val serverSocket: Socket, private val datagramSocket: DatagramSocket, private val username:String) {
    val serverOutput = PrintWriter(serverSocket.getOutputStream(), true);

    fun run(){
        try{
            while(true){
                println("Waiting for input")
                val readLine = readln()
                val command= readLine.trim().split(" ")
                if (command.size>1 && command[0]=="/msg"){
                    if ((command[1]=="-U" || command[1]=="-M") && command.size>2){
                        val message = readLine.substring(readLine.indexOf("-")+3).toByteArray(Charsets.UTF_8).copyOf(Global.BUFFER_SIZE)
                        if(command[1]=="-U"){
                            datagramSocket.send(DatagramPacket(message,Global.BUFFER_SIZE,InetAddress.getByName(Global.UDP_ADDRESS),Global.SERVER_PORT))
                        }
                        else{
                            datagramSocket.send(DatagramPacket(message,Global.BUFFER_SIZE,InetAddress.getByName(Global.MULTICAST_ADDRESS),Global.MULTICAST_PORT))
                        }
                    }
                    else{
                        serverOutput.println(readLine.substring(5))
                    }
                }
                else println("Incorrect command")
            }
        }
        catch(e:Exception){
            println(ErrorMessage(username,"Error with client Input").toString())
        }
    }
}