package server

class ServerMessage(val message: String,val id: Int){
    fun getText(): String {
        return message
    }
    fun getIdUser(): Int {
        return id
    }
}