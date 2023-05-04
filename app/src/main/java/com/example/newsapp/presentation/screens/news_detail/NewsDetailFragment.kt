package com.example.newsapp.presentation.screens.news_detail

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.newsapp.R
import com.example.newsapp.data.model.objects.Article
import com.example.newsapp.databinding.FragmentNewsDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*


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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val arg = arguments?.getParcelable<Article>("article_key")

        val originalFormat = SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", Locale.getDefault())
        val targetFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val date = arg?.publishedAt?.let { originalFormat.parse(it) }
        val formattedDate = date?.let { targetFormat.format(it) }



        binding.header.text = arg?.title
        binding.description.text = arg?.content
        binding.date.text = formattedDate
        binding.imageNews.load(arg?.urlToImage) {
            transformations(
                RoundedCornersTransformation(30F)
            )
            build()

            placeholder(R.drawable.ic_error_image)
            error(R.drawable.ic_error_image)

        }


        binding.toolbar.setNavigationOnClickListener(){
            requireActivity().supportFragmentManager.popBackStack()
        }


        binding.detail.setOnClickListener(){
            val url = arg?.url
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }




    }



    companion object {
        private const val ARTICLE_KEY = "article_key"


        fun getNewInstance(): NewsDetailFragment {
            return NewsDetailFragment()
        }

        fun getNewInstance(article: Article): NewsDetailFragment {
            return NewsDetailFragment().apply {
                arguments = bundleOf(ARTICLE_KEY to article)
            }
        }
    }

}