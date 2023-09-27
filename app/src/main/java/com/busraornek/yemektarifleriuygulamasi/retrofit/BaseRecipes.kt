package com.busraornek.yemektarifleriuygulamasi.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaseRecipes(  @SerializedName("status")
                         var success:Int,
                         @SerializedName("message")
                         var message:String
): Serializable
