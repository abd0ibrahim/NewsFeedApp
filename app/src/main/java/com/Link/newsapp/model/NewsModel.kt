package com.Link.newsapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsModel(
    @SerializedName("articles")
    var articles: ArrayList<Article>,
    @SerializedName("sortBy")
    val sortBy: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("status")
    val status: String
) : Serializable