package com.example.tugaspertemuan11retrofit.model

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("volumeInfo")
    val volumeInfo : Bukuinfo
)
