package client

import kotlinx.coroutines.delay
import utilities.Color
import utilities.Global
import java.io.PrintWriter
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.MulticastSocket
import java.net.Socket

class Reader(private val serverSocket: Socket, private val datagramSocket: DatagramSocket,private val multicastSocket: MulticastSocket) {
    val serverOutput = PrintWriter(serverSocket.getOutputStream(), true);

    suspend fun benchmark(){
        try{
            while(true){
                val message = "test".toByteArray(Charsets.UTF_8).copyOf(Global.BUFFER_SIZE)
                datagramSocket.send(DatagramPacket(message, Global.BUFFER_SIZE, InetAddress.getByName(Global.UDP_ADDRESS), Global.SERVER_PORT))
                datagramSocket.send(DatagramPacket(message, Global.BUFFER_SIZE, InetAddress.getByName(Global.MULTICAST_ADDRESS), Global.MULTICAST_PORT))
                serverOutput.println("test")
                println(Color.PURPLE.colorText(Thread.activeCount().toString()))
                delay(500);
            }
        }
        catch(e:Exception){
            println(Color.RED.colorText("Error with client Input"))
        }
    }

    fun run(){
        try{
            while(true){
                val readLine = readln()
                val command= readLine.trim().split(" ")
                if (command[0]=="/msg"){
                    if (command.size>1 && (command[1]=="-U" || command[1]=="-M")){
                        if(command.size>2) {
                            val message = readLine.substring(readLine.indexOf("-") + 3).toByteArray(Charsets.UTF_8)
                                .copyOf(Global.BUFFER_SIZE)
                            if (command[1] == "-U") {
                                datagramSocket.send(DatagramPacket(message, Global.BUFFER_SIZE, InetAddress.getByName(Global.UDP_ADDRESS), Global.SERVER_PORT))
                            } else {
                                datagramSocket.send(DatagramPacket(message, Global.BUFFER_SIZE, InetAddress.getByName(Global.MULTICAST_ADDRESS), Global.MULTICAST_PORT))
                            }
                        }
                        else println(Color.RED.colorText("Missing text message"))
                    }
                    else{
                        if(readLine.length<6)println(Color.RED.colorText("Missing text message"))
                        else serverOutput.println(readLine.substring(5))
                    }
                }
                else if(command[0]=="/exit"){
                    serverSocket.close()
                    datagramSocket.close()
                    multicastSocket.close()
                }
                else println(Color.RED.colorText("Incorrect command"))
            }
        }
        catch(e:Exception){
            println(Color.RED.colorText("Error with client Input"))
        }
    }
}