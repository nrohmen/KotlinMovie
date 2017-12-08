package com.nrohmen.kotlinmovie.movie

import com.nrohmen.kotlinmovie.api.MovieResponse
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
interface MovieInteractor {
    fun getNowPlayingMovies(): Observable<MovieResponse>
    fun getUpcomingMovies(): Observable<MovieResponse>
    fun getPopularMovies(): Observable<MovieResponse>
}