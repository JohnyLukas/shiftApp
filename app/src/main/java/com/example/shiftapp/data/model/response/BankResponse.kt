package com.example.shiftapp.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class BankResponse(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "phone")
    val phone: String? = null,
    @Json(name = "number")
    val city: String? = null
) : Parcelable