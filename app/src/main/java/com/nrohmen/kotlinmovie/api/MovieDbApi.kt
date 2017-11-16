package com.nrohmen.kotlinmovie.api

import com.nrohmen.kotlinmovie.models.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
interface MovieDbApi {
    @GET("discover/movie")
    fun getDiscoverMovie(@QueryMap map : Map<String, String>): Observable<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: String, @QueryMap map: Map<String, String>): Observable<MovieDetail>
}