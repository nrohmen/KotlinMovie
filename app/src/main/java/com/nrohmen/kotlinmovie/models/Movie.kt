package com.nrohmen.kotlinmovie.models

import com.google.gson.annotations.SerializedName

/**
 * Created by root on 11/15/17.
 */
class Movie(
        @SerializedName("poster_path") val posterPath: String,
        val id: String,
        val title: String)  {

    fun getPosterUrl(): String
    {
        return "http://image.tmdb.org/t/p/w342$posterPath"
    }
}
