package agh.plugins

import agh.utilities.Global
import com.auth0.jwt.*
import com.auth0.jwt.algorithms.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.engine.*
import io.ktor.server.response.*

fun Application.auth() {

    install(Authentication) {
        jwt("auth-jwt") {
            realm = "You received toker"
            verifier(JWT
                .require(Algorithm.HMAC256(Global.SECRET))
                .withAudience("http://0.0.0.0:8080/hello")
                .withIssuer("http://0.0.0.0:8080/")
                .build())
            validate { credential ->
                if (credential.payload.getClaim("username").asString() != "") {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
            challenge { defaultScheme, realm ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
            }
        }
    }
}