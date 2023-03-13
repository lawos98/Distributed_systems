package utilities

interface MessageInterface {
    val message: String
    val username: String

    override fun toString():String
}