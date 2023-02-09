package com.example.shiftapp.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class NumberResponse(
    @Json(name = "length")
    val length: Int? = null,
    @Json(name = "luhn")
    val luhn: Boolean? = null
) : Parcelable