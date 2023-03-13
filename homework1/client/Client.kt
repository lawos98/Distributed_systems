package client

import kotlinx.coroutines.*
import utilities.ErrorMessage
import utilities.Global
import java.io.IOException
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.MulticastSocket
import java.net.Socket

fun main(): Unit = runBlocking {
    var nickname: String = "default"
    try {
        var serverAddress = InetAddress.getByName(Global.TCP_ADDRESS)
        var multicastAddress = InetAddress.getByName(Global.MULTICAST_ADDRESS)
        var serverSocket = Socket("127.0.0.1", Global.SERVER_PORT)
        var datagramSocket = DatagramSocket(serverSocket.localPort)
        var multicastSocket = MulticastSocket(Global.MULTICAST_PORT)
        multicastSocket.joinGroup(multicastAddress)

        var clientInput = ClientInput(serverSocket, datagramSocket, nickname)
        var clientTcpOutput = ClientTcpOutput(serverSocket, nickname)
        var clientUdpOutput = ClientUdpOutput(datagramSocket, nickname)
        var clientMulticastOutput = ClientUdpOutput(multicastSocket, nickname)

        var job2 = GlobalScope.launch { clientTcpOutput.run() }
        var job3 = GlobalScope.launch  { clientUdpOutput.run() }
        var job4 = GlobalScope.launch{ clientMulticastOutput.run() }

        println("Client Started")
        clientInput.run()
//        job1.start()
//        job2.start()
//        job3.start()
//        job4.start()

//        job2.join()
//        datagramSocket.close()
//        job3.join()
//        multicastSocket.close()
//        job4.join()
//        job1.join()

    }
    catch (e: IOException) {
        println(ErrorMessage(nickname,"Connection refused").toString())
    }
}