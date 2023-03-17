package com.example.newsapp.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.data.model.objects.Article
import com.example.newsapp.databinding.ItemNewsBinding

class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.header.text = article.title
        binding.description.text = article.description
        binding.date.text = article.publishedAt

        binding.imageNews.load(article.urlToImage)

    }

}
