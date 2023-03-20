package agh.data

import com.google.gson.annotations.SerializedName

data class GeoData (

    @SerializedName("name"        ) var name       : String?     = null,
    @SerializedName("local_names" ) var localNames : LocalNames? = LocalNames(),
    @SerializedName("lat"         ) var lat        : Double?     = null,
    @SerializedName("lon"         ) var lon        : Double?     = null,
    @SerializedName("country"     ) var country    : String?     = null,
    @SerializedName("state"       ) var state      : String?     = null

)

data class LocalNames (

    @SerializedName("lv" ) var lv : String? = null,
    @SerializedName("cs" ) var cs : String? = null,
    @SerializedName("it" ) var it : String? = null,
    @SerializedName("fr" ) var fr : String? = null,
    @SerializedName("en" ) var en : String? = null,
    @SerializedName("fa" ) var fa : String? = null,
    @SerializedName("fi" ) var fi : String? = null,
    @SerializedName("ro" ) var ro : String? = null,
    @SerializedName("la" ) var la : String? = null,
    @SerializedName("pl" ) var pl : String? = null,
    @SerializedName("ar" ) var ar : String? = null,
    @SerializedName("eo" ) var eo : String? = null,
    @SerializedName("nl" ) var nl : String? = null,
    @SerializedName("lt" ) var lt : String? = null,
    @SerializedName("sk" ) var sk : String? = null,
    @SerializedName("mk" ) var mk : String? = null,
    @SerializedName("hu" ) var hu : String? = null,
    @SerializedName("el" ) var el : String? = null,
    @SerializedName("de" ) var de : String? = null,
    @SerializedName("ru" ) var ru : String? = null,
    @SerializedName("sl" ) var sl : String? = null,
    @SerializedName("uk" ) var uk : String? = null,
    @SerializedName("pt" ) var pt : String? = null,
    @SerializedName("sr" ) var sr : String? = null,
    @SerializedName("eu" ) var eu : String? = null,
    @SerializedName("ca" ) var ca : String? = null,
    @SerializedName("ja" ) var ja : String? = null,
    @SerializedName("zh" ) var zh : String? = null,
    @SerializedName("es" ) var es : String? = null,
    @SerializedName("hr" ) var hr : String? = null,
    @SerializedName("mt" ) var mt : String? = null,
    @SerializedName("be" ) var be : String? = null

)