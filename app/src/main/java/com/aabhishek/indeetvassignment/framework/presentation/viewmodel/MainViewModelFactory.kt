package com.aabhishek.indeetvassignment.framework.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aabhishek.indeetvassignment.business.domain.usecases.FetchListUsecase

class MainViewModelFactory(
    val fetchListUsecase: FetchListUsecase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(fetchListUsecase) as T
    }
}