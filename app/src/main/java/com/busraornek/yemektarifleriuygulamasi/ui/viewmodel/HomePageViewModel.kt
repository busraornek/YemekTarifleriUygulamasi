package com.busraornek.yemektarifleriuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class HomePageViewModel @Inject constructor(var krepo : RecipesDARepository) : ViewModel() {
    var recipesList = MutableLiveData<List<Recipes>>()

    init {
        uploadRecipe()
        recipesList = krepo.bringTheFullRecipe()
    }
    fun uploadRecipe(){
        krepo.repicesGet()
    }
    fun search(searchWord:String){
        krepo.foodSearch(searchWord)
    }
}




