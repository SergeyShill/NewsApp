package com.example.newsapp.presentation.screens.news_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {

    private val viewModel: NewsDetailViewModel by viewModels()

    companion object {
        private const val ARTICLE_KEY = "article_key"

        fun getNewInstance(): NewsDetailFragment {
            return NewsDetailFragment()
        }

//        fun getNewInstance(article: Article): NewsDetailFragment {
//            return NewsDetailFragment().apply {
//                arguments = bundleOf(ARTICLE_KEY to article)
//            }
//        }
    }

}