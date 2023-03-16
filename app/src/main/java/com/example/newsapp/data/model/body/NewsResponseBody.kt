package com.example.newsapp.data.model.body

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsResponseBody {

    @Expose
    @SerializedName("status")
    val status: String? = null

    @Expose
    @SerializedName("totalResults")
    val totalResults: Int? = null

    @Expose
    @SerializedName("results")
    val articles: List<ArticleBody>? = null

}