package com.chethan.demoproject


import com.chethan.demoproject.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetWorkApi {

    @GET("/")
    fun getProducts(): Call<List<ProductFamily>>

//    @GET("/articles?source=associated-press?apiKey={api_key}")
    @GET("/v1/articles")
    fun getNews(@Query("source") source: String, @Query("apikey") api_key: String): Call<NewsModel>

}