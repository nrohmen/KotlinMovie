package com.nrohmen.kotlinmovie.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.nrohmen.kotlinmovie.R
import com.nrohmen.kotlinmovie.models.Movie
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.ArrayList

/**
 * Created by root on 11/15/17.
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    private var movies: List<Movie> = ArrayList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val root = (LayoutInflater.from(parent?.context).inflate(R.layout.item_movie, parent, false))
        return ViewHolder(root)
    }

    fun addMovies(movies: List<Movie>?) {
        if (movies != null) {
            this.movies = movies
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        fun bind(movie: Movie) = with(itemView) {
            title.text = movie.title
            Glide.with(context).load(movie.getPosterUrl()).into(poster)
        }
    }
}