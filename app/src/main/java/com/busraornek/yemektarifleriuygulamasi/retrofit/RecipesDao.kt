package com.busraornek.yemektarifleriuygulamasi.retrofit

import com.busraornek.yemektarifleriuygulamasi.data.entity.BaseRecipes
import com.busraornek.yemektarifleriuygulamasi.data.entity.DetailResponse
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipeRequest
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesAnswer
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesX
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface RecipesDao {

    @GET("get_recipes.php")
    fun recipes(): Call<RecipesAnswer>


    @GET("search_recipe.php")
    fun foodSearch(@Query("query") query:String):Call<RecipesX>

    @GET("get_recipe_detail.php")
    fun recipeDetail(@Query("id") id:Int):Call<DetailResponse>


    @POST("add_recipe.php")
    fun addRecipe( @Body request : RecipeRequest): Call<BaseRecipes>



    @POST("update_recipe.php")
    fun recipeUpdate(@Body request : Recipes): Call<BaseRecipes>






}