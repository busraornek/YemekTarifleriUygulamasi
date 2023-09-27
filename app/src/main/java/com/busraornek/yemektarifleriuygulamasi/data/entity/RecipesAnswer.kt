package com.busraornek.yemektarifleriuygulamasi.data.entity

import com.google.gson.annotations.SerializedName

data class RecipesAnswer(
    @SerializedName("recipes") var recipes: List<Recipes>,
    @SerializedName("status") var status: Int,
    @SerializedName("message") var message: String
) {
}
