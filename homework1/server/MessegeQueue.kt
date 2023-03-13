package server

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Semaphore
import java.util.LinkedList

object MessegeQueue {
    var queue = Channel<ServerMessage>()

    suspend fun add(message: ServerMessage){
        queue.send(message)
    }
    suspend fun get():ServerMessage{
        return queue.receive()
    }
}