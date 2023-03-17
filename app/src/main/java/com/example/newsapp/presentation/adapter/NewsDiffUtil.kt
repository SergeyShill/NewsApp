package com.example.newsapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.data.model.objects.Article

class NewsDiffUtil : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

}