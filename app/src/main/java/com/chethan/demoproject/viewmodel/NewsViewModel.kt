package com.chethan.demoproject

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.chethan.demoproject.model.NewsModel
import org.koin.standalone.KoinComponent


class NewsViewModel(val dataRepository: DataRepository) : ViewModel(), KoinComponent {

    var listOfNews = MutableLiveData<NewsModel>()
    var listOfAPNews = MutableLiveData<NewsModel>()

    fun getNews() {
        dataRepository.getNews(object : DataRepository.OnNewsData {
            override fun onSuccess(data: NewsModel?) {
                listOfNews.value = data
                getAPNews(listOfNews.value)
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        }, "the-next-web")
    }

    fun getAPNews(newModel: NewsModel?) {
        dataRepository.getNews(object : DataRepository.OnNewsData {
            override fun onSuccess(data: NewsModel?) {

                data?.articles?.apply {
                    addAll(newModel!!.articles)
                    reverse()
                }

                listOfAPNews.value = data
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        }, "associated-press")
    }


}