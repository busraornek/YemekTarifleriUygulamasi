package com.busraornek.yemektarifleriuygulamasi.data.entity

import com.google.gson.annotations.SerializedName

data class RecipesDetail(@SerializedName("id") var id: Int,
                         @SerializedName("name") var name: String,
                         @SerializedName("description") var description: String)
//id ,name, description
