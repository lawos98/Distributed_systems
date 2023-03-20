package agh.plugins

import agh.data.*
import agh.utilities.Global
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.google.gson.Gson
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.client.request.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import kotlinx.serialization.json.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

fun Application.configureRouting() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            var converter = KotlinxSerializationConverter(Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                explicitNulls = false
            })
            register(ContentType.Application.Json, converter!!)
        }
    }

    routing {
        authenticate("auth-jwt") {
            get("/weather/{city}") {

                val GeoHtml = client.get("${Global.GEO_URL}?q=${call.parameters["city"]}&limit=1&appid=${Global.API_KEY}")
                if(GeoHtml.status.value==401) {
                    call.respond(HttpStatusCode(401, "Invalid API key."),"Invalid API key.")
                    return@get
                }
                if(GeoHtml.bodyAsText()=="[]"){
                    call.respond(HttpStatusCode(400, "Invalid city name."),"Invalid city name.")
                    return@get
                }
                val findRegion: GeoData = Gson().fromJson(GeoHtml.bodyAsText().trimIndent().substring(1, GeoHtml.bodyAsText().trimIndent().length - 1), GeoData::class.java)

                val myJsonWeather = client.get("${Global.WEATHER_URL}?lat=${findRegion.lat}&lon=${findRegion.lon}&appid=${Global.API_KEY}&units=metric").bodyAsText().trimIndent()
                val findWeather: WeatherData = Gson().fromJson(myJsonWeather, WeatherData::class.java)

                var tab: ArrayList<Temperature> = arrayListOf()
                findWeather.list.forEach { e -> tab.add(Temperature(e.dtTxt, e.main?.temp)) }

                call.respond(Gson().toJson(SimpleWeatherData((tab.sumOf { e -> e.value!! } / tab.size * 100).roundToInt()
                    .toDouble() / 100, tab.maxBy { e -> e.value!! }.value, tab.minBy { e -> e.value!! }.value, tab)))
            }
        }
        post("/login") {
            val user = Gson().fromJson(call.receiveText(), User::class.java)
            println(user.username+" | "+user.password)
            val token = JWT.create()
                .withAudience("http://0.0.0.0:8080/hello")
                .withIssuer("http://0.0.0.0:8080/")
                .withClaim("admin", user.username)
                .withExpiresAt(Date(System.currentTimeMillis() + 60000))
                .sign(Algorithm.HMAC256(Global.SECRET))
            call.respond(hashMapOf("token" to token))
        }

        authenticate("auth-jwt") {
            get("/hello") {
                val principal = call.principal<JWTPrincipal>()
                val username = principal!!.payload.getClaim("username").asString()
                val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())
                call.respondText("Hello, $username! Token is expired at $expiresAt ms.")
            }
        }
    }
}
