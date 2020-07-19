package com.aabhishek.indeetvassignment.framework.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aabhishek.indeetvassignment.business.domain.entity.ItemDetails
import com.aabhishek.indeetvassignment.business.domain.usecases.FetchListUsecase

class MainViewModel (
    private val fetchListUsecase: FetchListUsecase
) : ViewModel() {

    private val _movieList : MutableLiveData<List<ItemDetails>> = MutableLiveData()

    val movieList: LiveData<List<ItemDetails>>
        get() = _movieList


    fun fetchList() {
        _movieList.value = fetchListUsecase.invoke()
    }
}