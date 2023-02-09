package com.example.shiftapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Number(
    val length: Int?,
    val luhn: Boolean?
) : Parcelable