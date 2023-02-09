package com.example.shiftapp.domain

import com.example.shiftapp.data.model.entity.*
import com.example.shiftapp.domain.model.*
import com.example.shiftapp.domain.model.Number
import com.example.shiftapp.presentation.model.*

fun BinRequest.toUI() = BinRequestUI(
        id = id,
        binNumber = binNumber,
        bin = bin.toUI(),
        date = date
    )

fun Bin.toUI() = BinUI(
        numberUI = number?.toUI(),
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        countryUI = country?.toUI(),
        bankUI = bank?.toUI()
    )

    private fun Number.toUI() = NumberUI(
        length = length,
        luhn = luhn
    )

    private fun Country.toUI() = CountryUI(
        numeric = numeric,
        alpha2 = alpha2,
        name = name,
        emoji = emoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude,
    )

    private fun Bank.toUI() = BankUI(
        name = name,
        url = url,
        phone = phone,
        city = city
    )

fun BinRequest.toEntity() = BinRequestEntity(
        id = id,
        binNumber = binNumber,
        bin = bin.toEntity(),
        date = date
    )

fun Bin.toEntity() = BinEntity(
        numberEntity = number?.toEntity(),
        scheme = scheme,
        type = type,
        brand = brand,
        prepaid = prepaid,
        countryEntity = country?.toEntity(),
        bankEntity = bank?.toEntity()
    )

    private fun Number.toEntity() = NumberEntity(
        length = length,
        luhn = luhn
    )

    private fun Country.toEntity() = CountryEntity(
        numeric = numeric,
        alpha2 = alpha2,
        name = name,
        emoji = emoji,
        currency = currency,
        latitude = latitude,
        longitude = longitude,
    )

    private fun Bank.toEntity() = BankEntity(
        name = name,
        url = url,
        phone = phone,
        city = city
    )