package com.busraornek.yemektarifleriuygulamasi.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaseRecipes(
    @SerializedName("status")
    var status: Int,
    @SerializedName("message")
    var message: String
) : Serializable
