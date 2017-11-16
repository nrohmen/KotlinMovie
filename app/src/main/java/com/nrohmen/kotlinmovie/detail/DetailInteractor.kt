package com.nrohmen.kotlinmovie.detail

import com.nrohmen.kotlinmovie.models.MovieDetail
import rx.Observable

/**
 * Created by root on 11/15/17.
 */
interface DetailInteractor {
    fun getMovieDetails(id: String): Observable<MovieDetail>
}