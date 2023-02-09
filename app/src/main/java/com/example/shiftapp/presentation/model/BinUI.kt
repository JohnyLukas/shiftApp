package com.example.shiftapp.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BinUI(
    val numberUI: NumberUI?,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean?,
    val countryUI: CountryUI?,
    val bankUI: BankUI?
) : Parcelable