package com.example.shiftapp.data.net

import com.example.shiftapp.data.model.response.BinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/{numbers}")
    suspend fun fetchBinDetails(@Path("numbers") numbers: String?): BinResponse
}