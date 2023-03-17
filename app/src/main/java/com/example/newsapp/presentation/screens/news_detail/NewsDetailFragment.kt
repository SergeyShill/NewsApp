package com.example.newsapp.presentation.screens.news_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsDetailBinding
import com.example.newsapp.databinding.FragmentNewsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {

    private val viewModel: NewsDetailViewModel by viewModels()

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

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