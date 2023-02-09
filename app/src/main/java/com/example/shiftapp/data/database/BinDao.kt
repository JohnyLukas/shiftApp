package com.example.shiftapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shiftapp.data.model.entity.BinRequestEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface BinDao {
    @Query("SELECT * FROM binRequestEntity")
    fun getBins(): Flow<List<BinRequestEntity>>

    @Query("SELECT * FROM binRequestEntity WHERE id=(:id)")
    suspend fun getBin(id: UUID): BinRequestEntity

    @Insert
    suspend fun addBinResponse(binRequestEntity: BinRequestEntity)
}