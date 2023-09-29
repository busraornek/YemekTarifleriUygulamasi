package com.busraornek.yemektarifleriuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busraornek.yemektarifleriuygulamasi.data.entity.DetailResponse
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(var krepo: RecipesDARepository) : ViewModel() {

    var recipeDetail = MutableLiveData<DetailResponse?>()

    suspend fun recipeDetail(id: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            val response = krepo.recipeDetail(id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    recipeDetail.value = response.body()
                } else {
                }
            }
        }
    }
}