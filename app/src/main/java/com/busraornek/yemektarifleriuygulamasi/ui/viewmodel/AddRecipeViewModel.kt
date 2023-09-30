package com.busraornek.yemektarifleriuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busraornek.yemektarifleriuygulamasi.data.entity.BaseRecipes
import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipeRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddRecipeViewModel @Inject constructor(var krepo: RecipesDARepository) : ViewModel() {
    val recipeAdd = MutableLiveData<BaseRecipes>()
    suspend fun addRecipes(foodName: String, recipe: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = krepo.addRecipe(RecipeRequest(foodName, recipe))
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    recipeAdd.value = response.body()
                } else {

                }
            }
        }
    }
}