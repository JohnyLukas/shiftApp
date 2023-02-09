package com.example.shiftapp.domain.model

import java.util.*

data class BinRequest(
    val id: UUID,
    val binNumber: String,
    val bin: Bin,
    val date: Date
    )
