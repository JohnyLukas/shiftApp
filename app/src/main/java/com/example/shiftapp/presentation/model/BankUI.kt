package com.example.shiftapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BankUI(
    val name: String,
    val url: String,
    val phone: String,
    val city: String
) : Parcelable