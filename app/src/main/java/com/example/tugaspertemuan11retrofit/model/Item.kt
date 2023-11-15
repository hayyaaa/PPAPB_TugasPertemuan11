package com.example.tugaspertemuan11retrofit.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("items")
    var items : List<Info>
)
