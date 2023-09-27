package com.busraornek.yemektarifleriuygulamasi.retrofit

import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesAnswer
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RecipesDao {

    @GET("get_recipes.php")
    fun recipes(): Call<RecipesAnswer>




}