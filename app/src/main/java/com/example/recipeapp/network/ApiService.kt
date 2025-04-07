package com.example.recipeapp.network

import com.example.recipeapp.models.RecipeDetailResponse
import com.example.recipeapp.models.RecipeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("filter.php?a=Italian")
    fun getRecipes(): Call<RecipeResponse>

    @GET("lookup.php")
    fun getRecipeDetails(@Query("i") mealId: String): Call<RecipeDetailResponse>
}
