package server

object MessegeSender {

    suspend fun start(){
        while(true){
            Connections.sendMessage(MessegeQueue.get())
        }
    }
}