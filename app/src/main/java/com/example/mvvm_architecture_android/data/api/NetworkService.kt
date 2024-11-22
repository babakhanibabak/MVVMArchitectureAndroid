package com.example.mvvm_architecture_android.data.api

import com.example.mvvm_architecture_android.data.model.TopHeadlinesResponse
import com.example.mvvm_architecture_android.utils.AppConstant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {
@Headers("X-Api-Key : $API_KEY")
@GET("top-headlines")
suspend fun getTopHeadLines(@Query("country")country:String): TopHeadlinesResponse
}