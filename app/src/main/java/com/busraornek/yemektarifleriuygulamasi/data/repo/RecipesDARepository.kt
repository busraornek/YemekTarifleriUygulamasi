package com.busraornek.yemektarifleriuygulamasi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesAnswer
import com.busraornek.yemektarifleriuygulamasi.retrofit.RecipesDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesDARepository(var kdao:RecipesDao) {

    var recipesArray: MutableLiveData<List<Recipes>> = MutableLiveData()

    fun bringTheFullRecipe() : MutableLiveData<List<Recipes>>{
        return recipesArray
    }

    fun repicesGet(){

        kdao.recipes().enqueue(object : Callback<RecipesAnswer> {
            override fun onResponse(call: Call<RecipesAnswer>?, response: Response<RecipesAnswer>) {
                val list = response.body()!!.recipes

                recipesArray.value = list
            }

            override fun onFailure(call: Call<RecipesAnswer>?, t: Throwable?) {
            }

        })
        Log.e("veriler","${kdao.recipes()}")
    }

}