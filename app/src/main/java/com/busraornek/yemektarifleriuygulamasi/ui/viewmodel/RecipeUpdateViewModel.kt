package com.busraornek.yemektarifleriuygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipeRequest
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeUpdateViewModel @Inject constructor(var krepo : RecipesDARepository): ViewModel() {
    fun recipeUpdate(recipeId: Int, recipeName: String, recipe: String){
        val recipe = Recipes(recipeId,recipeName,recipe)
        krepo.recipeUpdate(recipe)
    }
}