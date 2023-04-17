package agh.data

import com.google.gson.annotations.SerializedName

data class SimpleWeatherData (

    @SerializedName("mean"     ) var mean     : Double?         = null,
    @SerializedName("max"      ) var max      : Double?         = null,
    @SerializedName("min"      ) var min      : Double?         = null,
    @SerializedName("list"     ) var list    : ArrayList<Temperature> = arrayListOf(),

)

data class Temperature (

    @SerializedName("text"       ) var text       : String?         = null,
    @SerializedName("value"      ) var value      : Double?         = null,

    )