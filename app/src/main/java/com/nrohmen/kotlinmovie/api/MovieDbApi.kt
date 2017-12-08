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
    @GET("movie/now_playing")
    fun getNowPlayingMovie(@QueryMap map : Map<String, String>): Observable<MovieResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovie(@QueryMap map : Map<String, String>): Observable<MovieResponse>

    @GET("movie/popular")
    fun getPopularMovie(@QueryMap map : Map<String, String>): Observable<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: String, @QueryMap map: Map<String, String>): Observable<MovieDetail>

    @GET("movie/{movie_id}/videos")
    fun getMovieVideos(@Path("movie_id") id: String): Observable<VideoResponse>
}