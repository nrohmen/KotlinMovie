package com.nrohmen.kotlinmovie.main

import com.nrohmen.kotlinmovie.api.MovieResponse
import com.nrohmen.kotlinmovie.api.MovieDbApi
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
class MainInteractorImpl(val movieDbApi: MovieDbApi): MainInteractor{
    override fun getListMovies(): Observable<MovieResponse>{
        return movieDbApi.getVenues(createQueryMap())
    }

    private fun createQueryMap(): Map<String, String>{
        return hashMapOf(
                "language" to "en",
                "sort_bay" to "popularity.desc"
        )
    }
}