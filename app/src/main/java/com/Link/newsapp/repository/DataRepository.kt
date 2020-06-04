package com.Link.newsapp

import com.Link.newsapp.model.NewsModel
import com.Link.newsapp.network.NetWorkApi
import retrofit2.Call
import retrofit2.Response

class DataRepository(val netWorkApi: NetWorkApi) {

    private companion object val APIKEY = "533af958594143758318137469b41ba9";

    fun getNews(onNewsData: OnNewsData, source: String ) {

        netWorkApi.getNews( source, APIKEY).enqueue(object : retrofit2.Callback<NewsModel> {

            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                onNewsData.onSuccess((response.body() as NewsModel))
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                onNewsData.onFailure()
            }
        })
    }

    interface OnNewsData {
        fun onSuccess(data: NewsModel?)
        fun onFailure()
    }
}

