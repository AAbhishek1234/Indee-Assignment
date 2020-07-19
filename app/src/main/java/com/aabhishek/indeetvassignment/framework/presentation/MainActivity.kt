package com.aabhishek.indeetvassignment.framework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aabhishek.indeetvassignment.R
import com.aabhishek.indeetvassignment.business.data.MovieDataSourceImpl
import com.aabhishek.indeetvassignment.business.domain.usecases.FetchListUsecase
import com.aabhishek.indeetvassignment.framework.datasource.Cache.MovieJsonDataSource
import com.aabhishek.indeetvassignment.framework.presentation.viewmodel.MainViewModel
import com.aabhishek.indeetvassignment.framework.presentation.viewmodel.MainViewModelFactory
import com.aabhishek.indeetvassignment.utils.ItemDecorator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.apply {
            adapter =
                MovieListAdapter(
                    listOf()
                )
            layoutManager = LinearLayoutManager(this@MainActivity)
            val itemDecorator = ItemDecorator(50)
            removeItemDecoration(itemDecorator)
            addItemDecoration(itemDecorator)
        }

        mainViewModel  = ViewModelProvider(
            this,
            MainViewModelFactory(
                FetchListUsecase(
                    MovieDataSourceImpl(
                        MovieJsonDataSource(applicationContext)
                    )
                )
            )).get(MainViewModel::class.java)

        initObservers()
        mainViewModel.fetchList()
    }

    private fun initObservers() {
        mainViewModel.movieList.observe(this, Observer {
            (recycler_view.adapter as MovieListAdapter).submitList(it)
        })
    }
}
