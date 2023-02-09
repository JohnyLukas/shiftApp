package com.example.shiftapp.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CountryResponse(
    @Json(name = "numeric")
    val numeric: String? = null,
    @Json(name = "alpha2")
    val alpha2: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "emoji")
    val emoji: String? = null,
    @Json(name = "currency")
    val currency: String? = null,
    @Json(name = "latitude")
    val latitude: Int? = null,
    @Json(name = "longitude")
    val longitude: Int? = null
) : Parcelable