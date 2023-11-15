package com.example.tugaspertemuan11retrofit.retrofit

import com.example.tugaspertemuan11retrofit.model.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("volumes")
    fun getBook (
        @Query("q") keyword: String
    ): Call<Item>
}