package com.example.shiftapp.data.database

import com.example.shiftapp.data.model.entity.BinRequestEntity
import com.example.shiftapp.data.model.entity.toDomain
import com.example.shiftapp.domain.model.BinRequest
import kotlinx.coroutines.flow.Flow
import java.util.UUID
import javax.inject.Inject

class BinRepository @Inject constructor(
    private val binDao: BinDao
) {
    fun getBins(): Flow<List<BinRequestEntity>> = binDao.getBins()

    suspend fun getBin(id: UUID): BinRequest = binDao.getBin(id).toDomain()

    suspend fun addBinResponse(binRequestEntity: BinRequestEntity) {
        binDao.addBinResponse(binRequestEntity)
    }
}