package com.example.newsapp.presentation.adapter

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.R
import com.example.newsapp.data.model.objects.Article
import com.example.newsapp.databinding.ItemNewsBinding

class NewsViewHolder(private val binding: ItemNewsBinding, private val listener: OpenDetail) :
    RecyclerView.ViewHolder(binding.root) {

    @RequiresApi(Build.VERSION_CODES.N)
    fun bind(article: Article) {
        binding.header.text = article.title
        binding.description.text = article.description
        binding.date.text = article.changeDate()

        binding.imageNews.load(article.urlToImage) {
            placeholder(R.drawable.ic_error_image)
            error(R.drawable.ic_error_image)
        }

        binding.card.setOnClickListener() {
            listener.clickArticle(article)


        }

    }

    interface OpenDetail {
        fun clickArticle(article: Article)
    }

}
