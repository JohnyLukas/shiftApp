package com.example.shiftapp.data.model.response

import com.example.shiftapp.data.model.entity.BankEntity
import com.example.shiftapp.data.model.entity.BinEntity
import com.example.shiftapp.data.model.entity.CountryEntity
import com.example.shiftapp.data.model.entity.NumberEntity
import com.example.shiftapp.domain.model.Bank
import com.example.shiftapp.domain.model.Bin
import com.example.shiftapp.domain.model.Country
import com.example.shiftapp.domain.model.Number
import com.example.shiftapp.presentation.model.BankUI
import com.example.shiftapp.presentation.model.BinUI
import com.example.shiftapp.presentation.model.CountryUI
import com.example.shiftapp.presentation.model.NumberUI


fun BinResponse.toDomain() = Bin(
        number = numberResponse?.toDomain(),
        type = type ?: "Unknown",
        scheme = scheme ?: throw Exception("Sorry, \"scheme\" field not found"),
        brand = brand ?: "Unknown",
        prepaid = prepaid,
        country = countryResponse?.toDomain(),
        bank = bankResponse?.toDomain()
    )

    private fun NumberResponse.toDomain() = Number(
        luhn = luhn,
        length = length
    )

    private fun CountryResponse.toDomain() = Country(
        numeric = numeric ?: "Unknown",
        alpha2 = alpha2 ?: "Unknown",
        name = name ?: "Unknown",
        emoji = emoji ?: "Unknown",
        currency = currency ?: "Unknown",
        latitude = latitude,
        longitude = longitude
    )

    private fun BankResponse.toDomain() = Bank(
        name = name ?: "Unknown",
        url = url ?: "Unknown",
        phone = phone ?: "Unknown",
        city = city ?: "Unknown"
    )


fun BinEntity.toUI() = BinUI(
        numberUI = numberEntity?.toUI(),
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        countryUI = countryEntity?.toUI(),
        bankUI = bankEntity?.toUI()
    )

    private fun NumberEntity.toUI() = NumberUI(
        length = length,
        luhn = luhn
    )

    private fun CountryEntity.toUI() = CountryUI(
        numeric = numeric,
        alpha2 = alpha2,
        name = name,
        emoji = emoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude,
    )

    private fun BankEntity.toUI() = BankUI(
        name = name,
        url = url,
        phone = phone,
        city = city
    )