package com.example.shiftapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NumberUI(
    val length: Int?,
    val luhn: Boolean?
) : Parcelable