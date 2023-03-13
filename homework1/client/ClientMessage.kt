package client

import java.text.SimpleDateFormat
import java.util.*

class ClientMessage(val message: String,val username: String){
    override fun toString():String{
        val sdf = SimpleDateFormat("hh:mm:ss")
        val currentTime = sdf.format(Date())
        return "$currentTime | $username : $message"
    }
}