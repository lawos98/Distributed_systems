package server

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import utilities.Global

@OptIn(DelicateCoroutinesApi::class)
object IdGenerator{
    val idChannel= Channel<Int>()
    init{
        GlobalScope.launch(Dispatchers.IO){for (i in 0 until Global.SERVER_SLOTS)idChannel.send(i)}
    }
    suspend fun getId():Int{
        return idChannel.receive()
    }
    suspend fun returnId(id:Int){
        idChannel.send(id)
    }
}