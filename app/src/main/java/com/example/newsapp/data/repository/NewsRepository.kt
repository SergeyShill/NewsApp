package com.example.newsapp.data.repository

import android.accounts.NetworkErrorException
import com.example.newsapp.data.model.objects.Article
import com.example.newsapp.data.network.NewsApi
import com.example.newsapp.mapper.toModel
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApi: NewsApi
) {

    suspend fun getNews(): List<Article> {
        val response = newsApi.getNews()

        return if (response.isSuccessful && response.body() != null) {
            val articlesBody = response.body()?.articles ?: emptyList()
            val list = articlesBody.map { it.toModel() }
            list
        } else {
            throw NetworkErrorException(response.errorBody()?.string() ?: "Unknown error")
        }
    }

}