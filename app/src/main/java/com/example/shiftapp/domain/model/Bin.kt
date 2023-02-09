package com.example.shiftapp.domain.model

data class Bin(
    val number: Number?,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean?,
    val country: Country?,
    val bank: Bank?
)