package com.aabhishek.indeetvassignment.business.data

import com.aabhishek.indeetvassignment.business.domain.entity.ItemDetails
import com.aabhishek.indeetvassignment.framework.datasource.Cache.MovieJsonDataSource

class MovieDataSourceImpl(
    private val movieJsonDataSource: MovieJsonDataSource
) : MovieDataSource {
    override fun getListOfMovies() = movieJsonDataSource.getMovieList()
}