package utilities

import java.text.SimpleDateFormat
import java.util.*

class Message(val message: String, val id: Int){
    fun getText(): String {
        return message
    }
    fun getIdUser(): Int {
        return id
    }
    override fun toString():String{
        val sdf = SimpleDateFormat("hh:mm:ss")
        val currentTime = sdf.format(Date())
        return "$currentTime | userId : $id | $message"
    }
    fun toByte():ByteArray{
        return this.toString().toByteArray(Charsets.UTF_8).copyOf(Global.BUFFER_SIZE)
    }
}