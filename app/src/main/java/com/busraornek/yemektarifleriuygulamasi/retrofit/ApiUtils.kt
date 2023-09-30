package com.busraornek.yemektarifleriuygulamasi.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "https://api.canerture.com/recipes/"
        fun getRecipesDao(): RecipesDao {
            return RetrofitClient.getClient(BASE_URL).create(RecipesDao::class.java)
        }
    }
}