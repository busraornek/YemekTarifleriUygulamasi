package com.busraornek.yemektarifleriuygulamasi.di

import com.busraornek.yemektarifleriuygulamasi.data.repo.RecipesDARepository
import com.busraornek.yemektarifleriuygulamasi.retrofit.ApiUtils
import com.busraornek.yemektarifleriuygulamasi.retrofit.RecipesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRecipesDARepository(kdao: RecipesDao): RecipesDARepository {
        return RecipesDARepository(kdao)
    }
    @Provides
    @Singleton
    fun provideRecipesDao(): RecipesDao {
        return ApiUtils.getRecipesDao()
    }
}