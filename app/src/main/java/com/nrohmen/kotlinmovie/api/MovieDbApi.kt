package com.nrohmen.kotlinmovie.api

import retrofit2.http.GET
import retrofit2.http.QueryMap
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
interface MovieDbApi {
    @GET("3/discover/movie")
    fun getVenues(@QueryMap map : Map<String, String>): Observable<MovieResponse>
}