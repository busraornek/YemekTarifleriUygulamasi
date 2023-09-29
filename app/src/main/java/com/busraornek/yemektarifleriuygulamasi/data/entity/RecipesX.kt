package com.busraornek.yemektarifleriuygulamasi.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RecipesX(
    @SerializedName("recipes")
    var recipes: List<Recipes>,
    @SerializedName("status")
    var status: Int
) : Serializable
