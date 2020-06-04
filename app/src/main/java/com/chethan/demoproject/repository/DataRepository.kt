package com.chethan.demoproject

import com.chethan.demoproject.model.NewsModel
import retrofit2.Call
import retrofit2.Response

class DataRepository(val netWorkApi: NetWorkApi) {

    private companion object val APIKEY = "533af958594143758318137469b41ba9";

    fun getProducts(onProductData: OnProductData) {
        netWorkApi.getProducts().enqueue(object : retrofit2.Callback<List<ProductFamily>> {
            override fun onResponse(call: Call<List<ProductFamily>>, response: Response<List<ProductFamily>>) {
                onProductData.onSuccess((response.body() as List<ProductFamily>))
            }

            override fun onFailure(call: Call<List<ProductFamily>>, t: Throwable) {
                onProductData.onFailure()
            }
        })
    }

    fun getNews(onNewsData: OnNewsData) {
        netWorkApi.getNews( "the-next-web", APIKEY).enqueue(object : retrofit2.Callback<NewsModel> {

            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                onNewsData.onSuccess((response.body() as NewsModel))
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                onNewsData.onFailure()
            }
        })
    }


    interface OnProductData {
        fun onSuccess(data: List<ProductFamily>)
        fun onFailure()
    }

    interface OnNewsData {
        fun onSuccess(data: NewsModel?)
        fun onFailure()
    }
}

