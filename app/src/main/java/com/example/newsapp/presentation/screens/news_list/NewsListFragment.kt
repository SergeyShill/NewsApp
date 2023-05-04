package com.example.newsapp.presentation.screens.news_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.data.model.objects.Article
import com.example.newsapp.databinding.FragmentNewsListBinding
import com.example.newsapp.presentation.adapter.NewsAdapter
import com.example.newsapp.presentation.adapter.NewsViewHolder
import com.example.newsapp.presentation.screens.news_detail.NewsDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private val viewModel: NewsListViewModel by viewModels()

    private var _binding: FragmentNewsListBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val listener = object : NewsViewHolder.OpenDetail {
        override fun clickArticle(article: Article) {
            openDetailScreen(article)
        }

    }
    private val adapter = NewsAdapter(listener)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireView().findViewById<RecyclerView>(R.id.newsRV).adapter = adapter
        binding.newsRV.adapter = adapter

        viewModel.news.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }
    }


    private fun openDetailScreen(article: Article) {
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            replace(
                R.id.fragment_container,
                NewsDetailFragment.getNewInstance(article)
            )
        }
    }


    companion object {
        fun getNewInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}