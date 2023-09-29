package com.busraornek.yemektarifleriuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busraornek.yemektarifleriuygulamasi.data.entity.BaseRecipes
import com.busraornek.yemektarifleriuygulamasi.data.entity.DetailResponse
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesAnswer
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesX
import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(val krepo: RecipesDARepository) : ViewModel() {

    var recipesList = MutableLiveData<RecipesAnswer>()
    var recipeAdd = MutableLiveData<BaseRecipes?>()
    var recipeUpdate = MutableLiveData<BaseRecipes?>()
    var recipeSearch = MutableLiveData<RecipesX>()

    fun getRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = krepo.getRecipes()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    recipesList.value = response.body()
                } else {
                }
            }
        }
    }

     fun foodSearch(searchWord: String) {
        viewModelScope.launch {
            val response = krepo.foodSearch(searchWord)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    recipeSearch.value = response.body()
                } else {
                }
            }
        }
    }
}




