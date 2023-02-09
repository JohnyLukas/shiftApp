package com.example.shiftapp.data.model.entity

import com.example.shiftapp.domain.model.Bank
import com.example.shiftapp.domain.model.Bin
import com.example.shiftapp.domain.model.BinRequest
import com.example.shiftapp.domain.model.Country
import com.example.shiftapp.domain.model.Number
import com.example.shiftapp.presentation.model.*

fun BinRequestEntity.toDomain() = BinRequest(
        id = id,
        binNumber = binNumber,
        bin = bin.toDomain(),
        date = date
    )

    fun BinEntity.toDomain() = Bin(
        number = numberEntity?.toDomain(),
        type = type,
        scheme = scheme,
        brand = brand,
        prepaid = prepaid,
        country = countryEntity?.toDomain(),
        bank = bankEntity?.toDomain()
    )

        private fun NumberEntity.toDomain() = Number(
            luhn = luhn,
            length = length
        )

        private fun CountryEntity.toDomain() = Country(
            numeric = numeric,
            alpha2 = alpha2,
            name = name,
            emoji = emoji,
            currency = currency,
            latitude = latitude,
            longitude = longitude
        )

        private fun BankEntity.toDomain() = Bank(
            name = name,
            url = url,
            phone = phone,
            city = city
        )

fun BinRequestEntity.toUI() = BinRequestUI(
        id = id,
        binNumber = binNumber,
        bin = bin.toUI(),
        date = date
    )

    fun BinEntity.toUI() = BinUI(
        numberUI = numberEntity?.toUI(),
        type = type,
        scheme = scheme,
        brand = brand,
        prepaid = prepaid,
        countryUI = countryEntity?.toUI(),
        bankUI = bankEntity?.toUI()
    )

    private fun NumberEntity.toUI() = NumberUI(
        luhn = luhn,
        length = length
    )

    private fun CountryEntity.toUI() = CountryUI(
        numeric = numeric,
        alpha2 = alpha2,
        name = name,
        emoji = emoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude
    )

    private fun BankEntity.toUI() = BankUI(
        name = name,
        url = url,
        phone = phone,
        city = city
    )