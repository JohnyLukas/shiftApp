package com.example.shiftapp.data.model.entity

import android.os.Parcelable
import androidx.room.Embedded
import kotlinx.parcelize.Parcelize

@Parcelize
data class BinEntity(
    @Embedded
    val numberEntity: NumberEntity?,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean?,
    @Embedded
    val countryEntity: CountryEntity?,
    @Embedded(prefix = "bank")
    val bankEntity: BankEntity?
) : Parcelable