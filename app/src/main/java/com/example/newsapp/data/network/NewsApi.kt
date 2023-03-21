package com.example.newsapp.data.network

import com.example.newsapp.data.model.body.NewsResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("q") query: String = "sport",
//        @Query("language") language: String = LANG_RU,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 100
    ): Response<NewsResponseBody>

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        private const val API_KEY = "513def9f379346fb9b5f0f2df638e174"
        private const val LANG_RU = "ru"
    }

}