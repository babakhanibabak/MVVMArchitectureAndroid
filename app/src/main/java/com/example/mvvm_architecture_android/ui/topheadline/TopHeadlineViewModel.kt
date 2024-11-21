package com.example.mvvm_architecture_android.ui.topheadline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_architecture_android.data.model.Article
import com.example.mvvm_architecture_android.data.repository.TopHeadlineRepository
import com.example.mvvm_architecture_android.ui.base.UiState
import com.example.mvvm_architecture_android.utils.AppConstant.COUNTRY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class TopHeadlineViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Article>>> = _uiState

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines(COUNTRY)
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect{
                    _uiState.value=UiState.success(it)
                }
        }
    }

}