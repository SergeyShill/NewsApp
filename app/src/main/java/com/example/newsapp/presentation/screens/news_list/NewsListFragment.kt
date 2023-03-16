package com.example.newsapp.presentation.screens.news_list

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.newsapp.R
import com.example.newsapp.presentation.screens.news_detail.NewsDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment(R.layout.fragment_news_list) {

    private val viewModel: NewsListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireView().findViewById<Button>(R.id.button).setOnClickListener {
            openDetailScreen()
        }
    }

    private fun openDetailScreen() {
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            replace(
                R.id.fragment_container,
                NewsDetailFragment.getNewInstance()
            )
        }
    }

    companion object {
        fun getNewInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}