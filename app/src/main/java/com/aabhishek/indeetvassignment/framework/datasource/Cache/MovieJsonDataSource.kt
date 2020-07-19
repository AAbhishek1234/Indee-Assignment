package com.aabhishek.indeetvassignment.framework.datasource.Cache

import android.content.Context
import com.aabhishek.indeetvassignment.business.domain.entity.ItemDetails
import com.aabhishek.indeetvassignment.utils.getJsonFromAssets
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieJsonDataSource (
    private val appContext: Context
) {

    fun getMovieList(): List<ItemDetails> {
        val jsonString = getJsonFromAssets(appContext, "TestJSON.json")

        val gson = Gson()

        val listItemType = object :  TypeToken<List<ItemDetails>>(){}.type
        return gson.fromJson(jsonString, listItemType)
    }
}