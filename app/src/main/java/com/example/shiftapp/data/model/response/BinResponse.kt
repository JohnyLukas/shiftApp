package com.example.shiftapp.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class BinResponse(
    @Json(name = "number")
    val numberResponse: NumberResponse? = null,
    @Json(name = "scheme")
    val scheme: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "brand")
    val brand: String? = null,
    @Json(name = "prepaid")
    val prepaid: Boolean? = null,
    @Json(name = "country")
    val countryResponse: CountryResponse? = null,
    @Json(name = "bank")
    val bankResponse: BankResponse? = null
) : Parcelable