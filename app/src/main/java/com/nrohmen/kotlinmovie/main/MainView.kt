package com.nrohmen.kotlinmovie.main

import com.nrohmen.kotlinmovie.models.Movie

/**
 * Created by root on 11/15/17.
 */
interface MainView{
    fun showDiscoverMovies(movies : List<Movie>?)
}