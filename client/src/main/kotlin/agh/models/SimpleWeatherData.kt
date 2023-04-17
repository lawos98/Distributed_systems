package agh.models

import com.google.gson.annotations.SerializedName

data class SimpleWeatherData (

    @SerializedName("mean"     ) var mean     : Double,
    @SerializedName("max"      ) var max      : Double,
    @SerializedName("min"      ) var min      : Double,
    @SerializedName("list"     ) var list    : List<Temperature>,

    )

data class Temperature (

    @SerializedName("text"       ) var text       : String,
    @SerializedName("value"      ) var value      : Double,

    )
