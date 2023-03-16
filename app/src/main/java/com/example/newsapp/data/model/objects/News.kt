package com.example.newsapp.data.model.objects

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
) : Parcelable