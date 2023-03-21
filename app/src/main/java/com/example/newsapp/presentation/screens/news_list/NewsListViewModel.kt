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
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news = MutableLiveData(emptyList<Article>())
    val news: LiveData<List<Article>> = _news

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                newsRepository.getNews()
            }.onSuccess {
                withContext(Dispatchers.Main) {
                    _news.value = it
                    _isLoading.value = false
                }
            }.onFailure {
                withContext(Dispatchers.Main) {
                  _isLoading.value = false
                }
                it.printStackTrace()
            }
        }
    }

}