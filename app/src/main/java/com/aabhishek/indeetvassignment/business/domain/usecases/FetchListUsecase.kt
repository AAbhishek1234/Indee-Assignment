package com.aabhishek.indeetvassignment.business.domain.usecases

import com.aabhishek.indeetvassignment.business.domain.entity.ItemDetails
import com.aabhishek.indeetvassignment.business.data.MovieDataSource

class FetchListUsecase(
   private val dataSource: MovieDataSource
) {

    operator fun invoke(): List<ItemDetails> {
        return dataSource.getListOfMovies()
    }
}