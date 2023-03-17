package com.example.newsapp.presentation.screens.news_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.presentation.adapter.NewsAdapter
import com.example.newsapp.presentation.screens.news_detail.NewsDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsListFragment : Fragment() {

    private val viewModel: NewsListViewModel by viewModels()

//    private var _binding: FragmentNewsListBinding? = null
//    private val binding
//        get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

//    private val adapter = NewsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        requireView().findViewById<RecyclerView>(R.id.newsRV).adapter = adapter
//        binding.newsRV.adapter = adapter

//        viewModel.news.observe(viewLifecycleOwner) {
//            adapter.submitList(it)
//        }
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