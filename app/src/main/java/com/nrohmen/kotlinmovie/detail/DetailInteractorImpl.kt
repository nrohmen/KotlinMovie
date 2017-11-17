package com.nrohmen.kotlinmovie.detail

import com.nrohmen.kotlinmovie.api.MovieDbApi
import com.nrohmen.kotlinmovie.api.VideoResponse
import com.nrohmen.kotlinmovie.models.MovieDetail
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
class DetailInteractorImpl(val movieDbApi: MovieDbApi): DetailInteractor{
    override fun getMovieVideos(id: String): Observable<VideoResponse> {
        return movieDbApi.getMovieVideos(id)
    }

    override fun getMovieDetails(id: String): Observable<MovieDetail> {
        return movieDbApi.getMovieDetails(id, createQueryMap())
    }


    private fun createQueryMap(): Map<String, String>{
        return hashMapOf(
                "language" to "en"
        )
    }
}