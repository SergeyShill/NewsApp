package com.example.newsapp.presentation.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ListAdapter
import com.example.newsapp.data.model.objects.Article
import com.example.newsapp.databinding.ItemNewsBinding

class NewsAdapter(private val listener: NewsViewHolder.OpenDetail) :
    ListAdapter<Article, NewsViewHolder>(NewsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding,listener)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}