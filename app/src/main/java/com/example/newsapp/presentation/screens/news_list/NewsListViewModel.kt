package com.example.newsapp.presentation.screens.news_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.model.objects.Article
import com.example.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

//    private val _news = MutableLiveData(emptyList<Article>())
//    val news: LiveData<List<Article>> = _news

    init{
//        viewModelScope.launch(Dispatchers.IO) {
//            runCatching {
//                newsRepository.getNews()
//            }.onSuccess {
//                _news.value = it
//            }.onFailure {
//                it.printStackTrace()
//            }
//        }
    }

}