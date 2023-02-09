package com.example.shiftapp.data.model.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BankEntity(
    val name: String,
    val url: String,
    val phone: String,
    val city: String
) : Parcelable