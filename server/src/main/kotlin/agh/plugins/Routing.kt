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
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

fun Application.configureRouting() {
    val client = HttpClient(CIO) {
        expectSuccess = true
    }

    routing {
        authenticate("auth-jwt") {
            get("/weather") {
                if(call.parameters["city"]==""){ call.respond(HttpStatusCode(409, "Missing city name."),"Missing city name.");return@get }
                val geoHttp = client.get("${Global.GEO_URL}?q=${call.parameters["city"]}&limit=1&appid=${Global.API_KEY}")

                if(geoHttp.status.value==401) { call.respond(HttpStatusCode(501, "Invalid API server key."),"Invalid API server key.");return@get }
                if(geoHttp.bodyAsText()=="[]"){ call.respond(HttpStatusCode(406, "Invalid city name or incorrect range of days ( Only five days from today)."),"Invalid city name or incorrect range of days ( Only five days from today).");return@get }

                val region: GeoData = Gson().fromJson(geoHttp.bodyAsText().trimIndent().substring(1, geoHttp.bodyAsText().trimIndent().length - 1), GeoData::class.java)
                val weatherHttp = client.get("${Global.WEATHER_URL}?lat=${region.lat}&lon=${region.lon}&appid=${Global.API_KEY}&units=metric")

                if(weatherHttp.status.value==408) { call.respond(HttpStatusCode(501, "Invalid API server key."),"Invalid API server key.");return@get }
                if(weatherHttp.status.value==409) { call.respond(HttpStatusCode(500, "Wrong longitude or latitude."),"Wrong longitude or latitude.");return@get }

                val weather: WeatherData = Gson().fromJson(weatherHttp.bodyAsText().trimIndent(), WeatherData::class.java)

                if(!"""^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])${'$'}""".toRegex().containsMatchIn(call.parameters["fromDate"]!!))
                    { call.respond(HttpStatusCode(403, "From Date is not correct format."),"From Date is not correct format.");return@get }
                if(!"""^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])${'$'}""".toRegex().containsMatchIn(call.parameters["toDate"]!!))
                    { call.respond(HttpStatusCode(405, "To Date is not correct format."),"To Date is not correct format.");return@get }

                val startDate=LocalDate.parse(call.parameters["fromDate"]!!.substring(0,10))
                val endDate=LocalDate.parse(call.parameters["toDate"]!!.substring(0,10))

                val weatherList: ArrayList<Temperature> = arrayListOf()

                weather.list.forEach { e ->
                    if (LocalDate.parse(e.dtTxt!!.substring(0,10)) in startDate..endDate) {
                        weatherList.add(Temperature(e.dtTxt, e.main?.temp))
                    }
                }

                call.respond(Gson().toJson(SimpleWeatherData(String.format("%.2f",(weatherList.sumOf { e -> e.value!! } / weatherList.size)).toDouble(), weatherList.maxBy { e -> e.value!! }.value, weatherList.minBy { e -> e.value!! }.value, weatherList)))
            }
        }
        post("/login") {
            val user = Gson().fromJson(call.receiveText(), User::class.java)
            if(user.password!=Global.PASSWORD || user.username!=Global.USERNAME) {
                call.respond(HttpStatusCode(407, "Invalid username or password."), "Invalid username or password.")
                return@post
            }
            val token = JWT.create()
                .withAudience("http://0.0.0.0:8080/hello")
                .withIssuer("http://0.0.0.0:8080/")
                .withClaim("admin", user.username)
                .withExpiresAt(Date(System.currentTimeMillis() + 60000000000))
                .sign(Algorithm.HMAC256("secret"))

            call.respond(token)
        }
    }
}
