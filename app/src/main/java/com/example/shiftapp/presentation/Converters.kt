package com.example.shiftapp.presentation

import com.example.shiftapp.data.model.entity.*
import com.example.shiftapp.domain.model.*
import com.example.shiftapp.domain.model.Number
import com.example.shiftapp.presentation.model.*

fun BinUI.toEntity() = BinEntity(
        numberEntity = numberUI?.toEntity(),
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        countryEntity = countryUI?.toEntity(),
        bankEntity = bankUI?.toEntity()
    )

    private fun NumberUI.toEntity() = NumberEntity(
        length = length,
        luhn = luhn
    )

    private fun CountryUI.toEntity() = CountryEntity(
        numeric = numeric,
        alpha2 = alpha2,
        name = name,
        emoji = emoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude,
    )

    private fun BankUI.toEntity() = BankEntity(
        name = name,
        url = url,
        phone = phone,
        city = city
    )

fun BinRequestUI.toDomain() = BinRequest(
    id = id,
    binNumber = binNumber,
    bin = bin.toDomain(),
    date = date
)

    fun BinUI.toDomain() = Bin(
        number = numberUI?.toDomain(),
        type = type,
        scheme = scheme,
        brand = brand,
        prepaid = prepaid,
        country = countryUI?.toDomain(),
        bank = bankUI?.toDomain()
    )

    private fun NumberUI.toDomain() = Number(
        luhn = luhn,
        length = length
    )

    private fun CountryUI.toDomain() = Country(
        numeric = numeric,
        alpha2 = alpha2,
        name = name,
        emoji = emoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude
    )

    private fun BankUI.toDomain() = Bank(
        name = name,
        url = url,
        phone = phone,
        city = city
    )