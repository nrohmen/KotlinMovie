package com.nrohmen.kotlinmovie.detail

import com.nrohmen.kotlinmovie.models.Movie
import com.nrohmen.kotlinmovie.models.MovieDetail

/**
 * Created by root on 11/15/17.
 */
interface DetailView {
    fun showMovieDetails(movies : MovieDetail?)
}