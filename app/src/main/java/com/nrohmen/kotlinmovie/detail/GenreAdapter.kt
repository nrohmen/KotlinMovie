package com.nrohmen.kotlinmovie.detail

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.nrohmen.kotlinmovie.R
import com.nrohmen.kotlinmovie.detail.DetailActivity
import com.nrohmen.kotlinmovie.models.Genre
import com.nrohmen.kotlinmovie.models.Movie
import kotlinx.android.synthetic.main.item_genre.view.*
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.*

/**
 * Created by root on 11/15/17.
 */
class GenreAdapter : RecyclerView.Adapter<GenreAdapter.ViewHolder>(){
    private var genres: List<Genre> = ArrayList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(genres[position])
    }

    override fun getItemCount(): Int {
        return genres.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val root = (LayoutInflater.from(parent?.context).inflate(R.layout.item_genre, parent, false))
        return ViewHolder(root)
    }

    fun addGenre(genres: List<Genre>?) {
        if (genres != null) {
            this.genres = genres
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {

        fun bind(genre: Genre) = with(itemView) {
            genre_name?.text = genre.name
        }
    }
}