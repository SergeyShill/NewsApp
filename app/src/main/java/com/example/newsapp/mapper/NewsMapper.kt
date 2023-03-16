package com.example.newsapp.mapper

import com.example.newsapp.data.model.body.ArticleBody
import com.example.newsapp.data.model.body.SourceBody
import com.example.newsapp.data.model.objects.Article
import com.example.newsapp.data.model.objects.Source

fun ArticleBody.toModel(): Article {
    return Article(
        source = source?.toModel() ?: Source(),
        author = author ?: "",
        title = title ?: "",
        description = description ?: "",
        url = url ?: "",
        urlToImage = urlToImage ?: "",
        publishedAt = publishedAt ?: "",
        content = content ?: ""
    )
}

fun SourceBody.toModel(): Source {
    return Source(
        id = id ?: "",
        name = name ?: ""
    )
}