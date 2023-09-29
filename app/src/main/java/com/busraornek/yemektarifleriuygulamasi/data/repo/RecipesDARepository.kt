package com.busraornek.yemektarifleriuygulamasi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.busraornek.yemektarifleriuygulamasi.data.entity.Recipes
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesAnswer
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipesX
import com.busraornek.yemektarifleriuygulamasi.data.entity.BaseRecipes
import com.busraornek.yemektarifleriuygulamasi.data.entity.DetailResponse
import com.busraornek.yemektarifleriuygulamasi.data.entity.RecipeRequest
import com.busraornek.yemektarifleriuygulamasi.retrofit.RecipesDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesDARepository(var kdao:RecipesDao) {

    var recipesArray: MutableLiveData<List<Recipes>>
    var recipeDetail: MutableLiveData<Recipes?>
    init {
        recipesArray = MutableLiveData()
        recipeDetail = MutableLiveData()

    }

    fun bringTheFullRecipe() : MutableLiveData<List<Recipes>>{
        return recipesArray
    }
    fun getDetail(): MutableLiveData<Recipes?> {
        return recipeDetail
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
     //   return recipeDetail.value
    }

    fun foodSearch(foodSearch:String){
        kdao.foodSearch(foodSearch).enqueue(object : Callback<RecipesX>{
            override fun onResponse(call: Call<RecipesX>, response: Response<RecipesX>) {
                val list = response.body()!!.recipes
               recipesArray.value =list
            }

            override fun onFailure(call: Call<RecipesX>, t: Throwable) {}


        })
    }fun recipeAdd(recipe: RecipeRequest){
        kdao.addRecipe(recipe).enqueue(object : Callback<BaseRecipes> {
            override fun onResponse(call: Call<BaseRecipes>, response: Response<BaseRecipes>) {
                val response = response.body()
                Log.e("Add"," ${response?.message} - ${response?.status}")
                getAllRecipes()
            }
            override fun onFailure(call: Call<BaseRecipes>, t: Throwable) {
            }
        }) }fun getAllRecipes(){
        kdao.recipes().enqueue(object : Callback<RecipesAnswer> {
            override fun onResponse(call: Call<RecipesAnswer>?, response: Response<RecipesAnswer>) {
                val list = response.body()!!.recipes
                recipesArray.value = list
            }
            override fun onFailure(call: Call<RecipesAnswer>?, t: Throwable?) {
            }
        })
    }fun recipeUpdate(recipe:Recipes) {
        kdao.recipeUpdate(recipe).enqueue(object : Callback<BaseRecipes>{
            override fun onResponse(call: Call<BaseRecipes>, response: Response<BaseRecipes>) {
                val response = response.body()

               // recipeDetail(recipe.id)
                Log.e("yemek detay", "$recipe.description - $response.mesage")
                Log.e("yemek detay", "$response.succes - $response.mesage")
               //repicesGet()
            }
            override fun onFailure(call: Call<BaseRecipes>, t: Throwable) {
            }

        })

    }
    fun recipeDetail(id:Int):Recipes?{
        kdao.recipeDetail(id).enqueue(object : Callback<DetailResponse>{
            override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {

                val recipe = response.body()?.recipe
                Log.e("detay","${response.message()} ")
                recipeDetail.value = recipe
                }


            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                
            }

        })
        return recipeDetail.value

    }

}