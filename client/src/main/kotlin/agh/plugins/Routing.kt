package agh.plugins

import agh.models.Error
import agh.models.SimpleWeatherData
import agh.utilities.Global
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.util.*
import io.ktor.util.pipeline.*

fun Application.configureRouting() {
    var token = ""
    val client = HttpClient(CIO) {}

    suspend fun handleError(http:HttpResponse, call: ApplicationCall):Boolean{
        if(!http.status.isSuccess()) call.respond(FreeMarkerContent("error.ftl", mapOf("error" to Error(http.bodyAsText(),http.status.value))))
        return !http.status.isSuccess()
    }


    routing {
        get("/") {
            val tokenReceive = client.post("${Global.URL}/login"){
                contentType(ContentType.Application.Json)
                setBody("{\"username\":\"${Global.USERNAME}\",\"password\":\"${Global.PASSWORD}\"}")
            }
            if(handleError(tokenReceive,call)) return@get

            token= tokenReceive.bodyAsText()

            call.respond(FreeMarkerContent("empty.ftl", model=null))
        }
        post("/"){
            val formParameters = call.receiveParameters()
            val city = formParameters.getOrFail("city")
            val from = formParameters.getOrFail("from")
            val to = formParameters.getOrFail("to")
            call.respondRedirect("/weather?city=$city&from=$from&to=$to")
        }
        get("/weather") {
            val city = call.parameters["city"]
            val from = call.parameters["from"]
            val to = call.parameters["to"]

            val weatherHttp = client.get("${Global.URL}/weather?city=$city&fromDate=$from&toDate=$to"){
                header("Authorization","Bearer $token")
            }

            if(handleError(weatherHttp,call))return@get

            val weather = Gson().fromJson(weatherHttp.bodyAsText().trimIndent(), SimpleWeatherData::class.java)

            call.respond(FreeMarkerContent("weather.ftl", mapOf("weather" to weather)))
        }
    }
}
