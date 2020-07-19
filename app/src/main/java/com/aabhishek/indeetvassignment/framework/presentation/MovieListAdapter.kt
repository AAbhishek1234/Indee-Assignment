package com.aabhishek.indeetvassignment.framework.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aabhishek.indeetvassignment.R
import com.aabhishek.indeetvassignment.business.domain.entity.ItemDetails
import com.aabhishek.indeetvassignment.databinding.ListItemBinding
import com.aabhishek.indeetvassignment.utils.decodeSampledBitmapFromPath
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MovieListAdapter(
    private var movieList: List<ItemDetails>
): RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private val executors: ExecutorService = Executors.newFixedThreadPool(2)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun submitList(list: List<ItemDetails>) {
        movieList = list
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemDetails) {
            binding.movieItem = item
            binding.executePendingBindings()
            executors.submit {
                var bitmap = decodeSampledBitmapFromPath(
                    binding.banner.resources,
                    R.drawable.testimage,
                    200,200
                )
                binding.banner.post {
                    binding.banner.setImageBitmap(
                        bitmap
                    )
                }
            }
        }
    }
}