import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import proto.WeatherResponse
import proto.WeatherType
import java.sql.Time
import kotlin.random.Random

val cities = listOf("Krakow", "Warsaw", "London", "New York", "Tokyo", "Moscow", "Berlin")

val types = listOf(WeatherType.FOGGY,WeatherType.CLOUDY,WeatherType.RAINY,WeatherType.SUNNY,WeatherType.SNOWY,WeatherType.THUNDER)

fun printList(){
    println(types)
}

fun randomWeather(): WeatherResponse {
    return WeatherResponse.newBuilder()
        .setCity(cities.random())
        .setTemperature((Random.nextFloat() * 100 - 50))
        .setType(types.random())
        .setHumidity(Random.nextFloat())
        .setWind(Random.nextFloat() * 100)
        .setPressure(Random.nextFloat() * 100 + 950)
        .build()
}

val weatherGenerator = MutableSharedFlow<WeatherResponse>()

suspend fun startWeatherGenerator(){
    while (true) {
        val weather = randomWeather()
        weatherGenerator.emit(weather)
        print(Time.valueOf(java.time.LocalTime.now()))
        println(weather)
        delay(5000)
    }
}
