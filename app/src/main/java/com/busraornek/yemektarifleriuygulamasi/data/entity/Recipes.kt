package com.busraornek.yemektarifleriuygulamasi.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Recipes(@SerializedName("id")val id :Int,
                   @SerializedName("name") val name:String) :
    Serializable {

}
