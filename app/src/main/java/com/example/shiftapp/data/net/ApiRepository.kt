package com.example.shiftapp.data.net

import com.example.shiftapp.data.model.response.BinResponse
import com.example.shiftapp.data.model.response.toDomain
import com.example.shiftapp.domain.model.Bin
import javax.inject.Inject


class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getBinDetails(numbers: String?): Bin {
        val result: BinResponse = apiService.fetchBinDetails(numbers)
        return result.toDomain()
    }

}