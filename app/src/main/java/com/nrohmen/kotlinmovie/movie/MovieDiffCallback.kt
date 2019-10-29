package com.nrohmen.kotlinmovie.movie

import androidx.recyclerview.widget.DiffUtil
import com.nrohmen.kotlinmovie.models.Movie

class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {

    override fun areItemsTheSame(oldItem: Movie?, newItem: Movie?): Boolean {
        return oldItem?.id == newItem?.id
    }

    override fun areContentsTheSame(oldItem: Movie?, newItem: Movie?): Boolean {
        return oldItem == newItem
    }

}