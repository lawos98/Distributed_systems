package agh

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import agh.plugins.*

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureTemplating()
    configureRouting()
}
