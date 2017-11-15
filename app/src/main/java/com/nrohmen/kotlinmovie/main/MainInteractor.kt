package com.nrohmen.kotlinmovie.main

import com.nrohmen.kotlinmovie.api.MovieResponse
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
interface MainInteractor{
    fun getListMovies(): Observable<MovieResponse>
}