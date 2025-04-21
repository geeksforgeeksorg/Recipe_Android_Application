package com.example.recipeapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipeapp.models.Meal
import com.example.recipeapp.models.RecipeResponse
import com.example.recipeapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val _recipes = MutableLiveData<List<Meal>>()
    val recipes: LiveData<List<Meal>> get() = _recipes

    // Fetch the list of recipes
    fun fetchRecipes() {
        ApiClient.apiService.getRecipes().enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.isSuccessful) {
                    _recipes.value = response.body()?.meals ?: emptyList()
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
