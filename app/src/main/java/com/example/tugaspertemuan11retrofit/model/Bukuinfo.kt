package com.example.tugaspertemuan11retrofit.model

import com.google.gson.annotations.SerializedName

data class Bukuinfo(
    @SerializedName("title")
    val title : String,
    @SerializedName("publishedDate")
    val publishedDate : String,
    @SerializedName("description")
    val description : String,
    @SerializedName("imageLinks")
    val imageLinks : Bukuimage
)
