package client

import kotlinx.coroutines.*
import utilities.Color
import utilities.Global
import java.io.IOException
import java.net.*

fun main(): Unit = runBlocking {
    try {
        var serverAddress = InetAddress.getByName(Global.TCP_ADDRESS)
        var multicastAddress = InetAddress.getByName(Global.MULTICAST_ADDRESS)
        var serverSocket = Socket(Global.TCP_ADDRESS, Global.SERVER_PORT)
        var datagramSocket = DatagramSocket(serverSocket.localPort)
        var multicastSocket = MulticastSocket(Global.MULTICAST_PORT)
        multicastSocket.joinGroup(multicastAddress)

        var reader = Reader(serverSocket, datagramSocket,multicastSocket)
        var tcpOutput = TcpOutput(serverSocket)
        var udpOutput = UdpOutput(datagramSocket)
        var multicastOutput = MulticastOutput(multicastSocket,datagramSocket.localPort)

        println(Color.ORANGE.colorText("Client Started"))

        var job2 = GlobalScope.launch { tcpOutput.run() }
        var job3 = GlobalScope.launch  { udpOutput.run() }
        var job4 = GlobalScope.launch{ multicastOutput.run() }
//
//        reader.benchmark()
        reader.run()

    }
    catch (e:SecurityException){
        println(Color.RED.colorText("Server error with SecurityException"))
    }
    catch (e: UnknownHostException) {
        println(Color.RED.colorText("Server error with UnknownHostException"))
    }
    catch (e: IOException) {
        println(Color.RED.colorText("Server error with IOException"))
    }
}