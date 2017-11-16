package com.nrohmen.kotlinmovie.main

import com.nrohmen.kotlinmovie.api.MovieResponse
import com.nrohmen.kotlinmovie.api.MovieDbApi
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
class MainInteractorImpl(val movieDbApi: MovieDbApi): MainInteractor{
    override fun getDiscoverMovies(): Observable<MovieResponse> {
        return movieDbApi.getDiscoverMovie(createQueryMap())
    }

    private fun createQueryMap(): Map<String, String>{
        return hashMapOf(
                "language" to "en",
                "sort_by" to "popularity.desc"
        )
    }
}