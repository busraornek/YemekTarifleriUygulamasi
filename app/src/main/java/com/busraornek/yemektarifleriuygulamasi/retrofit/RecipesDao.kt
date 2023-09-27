package com.busraornek.yemektarifleriuygulamasi.retrofit

import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesAnswer
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesX
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface RecipesDao {

    @GET("get_recipes.php")
    fun recipes(): Call<RecipesAnswer>


    @POST("search_recipe.php")
    @FormUrlEncoded
    fun foodSearch(@Query("foodSearch")foodSearch:String):Call<RecipesX>


    @POST("add_recipe.php")
    fun addRecipe( @Body request : RecipeRequest): Call<BaseRecipes>




}