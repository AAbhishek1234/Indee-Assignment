package com.aabhishek.indeetvassignment.business.data

import com.aabhishek.indeetvassignment.business.domain.entity.ItemDetails

interface MovieDataSource {
    fun getListOfMovies(): List<ItemDetails>
}