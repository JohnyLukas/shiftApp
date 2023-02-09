package com.example.shiftapp.data.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class BinRequestEntity(
    @PrimaryKey
    val id: UUID,
    val binNumber: String,
    @Embedded
    val bin: BinEntity,
    val date: Date
)