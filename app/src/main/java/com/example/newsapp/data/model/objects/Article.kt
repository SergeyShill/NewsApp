package com.example.newsapp.data.model.objects

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String

) : Parcelable {
    @RequiresApi(Build.VERSION_CODES.N)
    fun changeDate(): String? {
        val originalFormat = SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", Locale.getDefault())
        val targetFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val date = originalFormat.parse(publishedAt)
        return date?.let { targetFormat.format(it) }
    }
}


