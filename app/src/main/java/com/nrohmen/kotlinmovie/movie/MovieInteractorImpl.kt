package com.nrohmen.kotlinmovie.movie

import com.nrohmen.kotlinmovie.api.MovieResponse
import com.nrohmen.kotlinmovie.api.MovieDbApi
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
class MovieInteractorImpl(private val movieDbApi: MovieDbApi): MovieInteractor {
    override fun getUpcomingMovies(): Observable<MovieResponse> {
        return movieDbApi.getUpcomingMovie(createQueryMap())
    }

    override fun getPopularMovies(): Observable<MovieResponse> {
        return movieDbApi.getPopularMovie(createQueryMap())
    }

    override fun getNowPlayingMovies(): Observable<MovieResponse> {
        return movieDbApi.getNowPlayingMovie(createQueryMap())
    }

    private fun createQueryMap(): Map<String, String>{
        return hashMapOf(
                "language" to "en",
                "sort_by" to "popularity.desc"
        )
    }
}