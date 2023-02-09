package com.example.shiftapp.data.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NumberEntity(
    val length: Int?,
    val luhn: Boolean?
) : Parcelable