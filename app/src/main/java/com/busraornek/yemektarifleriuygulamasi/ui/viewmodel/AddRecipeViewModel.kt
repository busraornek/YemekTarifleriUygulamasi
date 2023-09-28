package com.busraornek.yemektarifleriuygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipeRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddRecipeViewModel @Inject constructor(var krepo : RecipesDARepository) : ViewModel() {

    fun buttonAdd(foodName:String, recipe:String){
        val recipe = RecipeRequest(foodName,recipe)
        krepo.recipeAdd(recipe)

    }
}