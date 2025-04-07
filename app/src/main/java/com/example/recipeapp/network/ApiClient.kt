package com.example.recipeapp.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// API base URL
private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

// Retrofit setup
object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}