package server

import kotlinx.coroutines.channels.Channel
import utilities.Message

object MessegeQueue {
    var queue = Channel<Message>()

    suspend fun add(message: Message){
        queue.send(message)
    }
    suspend fun get(): Message {
        return queue.receive()
    }
}