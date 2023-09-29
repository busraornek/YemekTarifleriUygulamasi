package com.busraornek.yemektarifleriuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var krepo : RecipesDARepository) :ViewModel() {


    var recipeDetail= MutableLiveData<Recipes>()
    init {
        recipeDetail= krepo.getDetail()
    }
    fun modelGetRecipeDetail(id:Int) {

        krepo.recipeDetail(id)
    }

}