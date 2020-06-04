package com.Link.newsapp.network


import com.Link.newsapp.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetWorkApi {

    @GET("/v1/articles")
    fun getNews(@Query("source") source: String, @Query("apikey") api_key: String): Call<NewsModel>

}