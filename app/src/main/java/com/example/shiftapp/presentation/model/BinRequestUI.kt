package com.example.shiftapp.presentation.model

import java.util.*

data class BinRequestUI(
    val id: UUID,
    val binNumber: String,
    val bin: BinUI,
    val date: Date
)
