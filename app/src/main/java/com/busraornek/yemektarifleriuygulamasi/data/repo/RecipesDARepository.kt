package com.busraornek.yemektarifleriuygulamasi.data.repo

import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipeRequest
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.retrofit.RecipesDao

class RecipesDARepository(var kdao: RecipesDao) {
    suspend fun getRecipes() = kdao.recipes()
    suspend fun foodSearch(searchWord:String) = kdao.foodSearch(searchWord)
    suspend fun recipeDetail(id:Int) = kdao.recipeDetail(id)
    suspend fun addRecipe(request: RecipeRequest) = kdao.addRecipe(request)
    suspend fun recipeUpdate(recipe: Recipes) = kdao.recipeUpdate(recipe)
}