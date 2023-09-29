package com.busraornek.yemektarifleriuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var krepo : RecipesDARepository) :ViewModel() {


    var recipeDetail= MutableLiveData<Recipes>()

    fun modelGetRecipeDetail(id:Int) {

        viewModelScope.launch {
            recipeDetail.postValue(krepo.recipeDetail(id))
        }

    }
    /*
    fun detail()  {
        recipeDetail.value =  krepo.getDetail().value
    }

     */

}