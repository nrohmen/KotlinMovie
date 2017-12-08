package com.nrohmen.kotlinmovie.movie.playing

import com.nrohmen.kotlinmovie.models.Movie

/**
 * Created by root on 11/15/17.
 */
interface NowPlayingView {
    fun showNowPlayingMovies(movies : List<Movie>?)
}