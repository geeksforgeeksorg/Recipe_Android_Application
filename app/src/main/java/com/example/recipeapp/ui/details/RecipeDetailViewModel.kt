package com.example.recipeapp.ui.details

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recipeapp.network.ApiClient
import com.example.recipeapp.models.MealDetail
import com.example.recipeapp.models.RecipeDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _recipeDetails = MutableLiveData<MealDetail>()
    val recipeDetails: LiveData<MealDetail> get() = _recipeDetails

    fun fetchRecipeDetails(mealId: String) {
        ApiClient.apiService.getRecipeDetails(mealId).enqueue(object : Callback<RecipeDetailResponse> {
            override fun onResponse(call: Call<RecipeDetailResponse>, response: Response<RecipeDetailResponse>) {
                if (response.isSuccessful) {
                    _recipeDetails.value = response.body()?.meals?.firstOrNull() // This is MealDetail now
                }
            }

            override fun onFailure(call: Call<RecipeDetailResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
