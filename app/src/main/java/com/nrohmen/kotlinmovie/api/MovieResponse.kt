package com.nrohmen.kotlinmovie.api

import com.google.gson.annotations.SerializedName
import com.nrohmen.kotlinmovie.models.Movie

/**
 * Created by root on 11/15/17.
 */
class MovieResponse {
    @SerializedName("results")
    lateinit var movies: List<Movie>
}