package com.chethan.demoproject

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.chethan.demoproject.model.NewsModel
import org.koin.standalone.KoinComponent


class ProductViewModel(val dataRepository: DataRepository) : ViewModel(), KoinComponent {

    var listOfNews = MutableLiveData<NewsModel>()

//    init {
//        listOfProducts.value = listOf()
//    }

//    init {
//        listOfNews.value = NewsModel()
//    }

//    var listOfProducts = MutableLiveData<List<ProductFamily>>()



//    fun getProducts() {
//        dataRepository.getProducts(object : DataRepository.OnProductData {
//            override fun onSuccess(data: List<ProductFamily>) {
//                listOfProducts.value = data
//            }
//
//            override fun onFailure() {
//                //REQUEST FAILED
//            }
//        })
//    }

    fun getNews() {
        dataRepository.getNews(object : DataRepository.OnNewsData {
            override fun onSuccess(data: NewsModel?) {
                listOfNews.value = data
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        })
    }
}