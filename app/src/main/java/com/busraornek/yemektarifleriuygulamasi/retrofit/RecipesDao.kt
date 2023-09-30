package com.busraornek.yemektarifleriuygulamasi.retrofit

import com.busraornek.yemektarifleriuygulamasi.data.entity.BaseRecipes
import com.busraornek.yemektarifleriuygulamasi.data.entity.DetailResponse
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipeRequest
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesAnswer
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesX
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface RecipesDao {

    @GET("get_recipes.php")
    suspend fun recipes(): Response<RecipesAnswer>
    @GET("search_recipe.php")
    suspend fun foodSearch(@Query("query") query: String): Response<RecipesX>
    @GET("get_recipe_detail.php")
    suspend fun recipeDetail(@Query("id") id: Int): Response<DetailResponse>
    @POST("add_recipe.php")
    suspend fun addRecipe(@Body request: RecipeRequest): Response<BaseRecipes>
    @POST("update_recipe.php")
    suspend fun recipeUpdate(@Body request: Recipes): Response<BaseRecipes>

}