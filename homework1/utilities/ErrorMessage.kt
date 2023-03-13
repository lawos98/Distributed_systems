package utilities

import java.text.SimpleDateFormat
import java.util.*

class ErrorMessage(override val username: String, override val message: String=""):MessageInterface {
    override fun toString():String{
        val sdf = SimpleDateFormat("hh:mm:ss")
        val currentTime = sdf.format(Date())
        return "\u001B[31m $currentTime | $username : $message"
    }
}