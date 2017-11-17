package com.nrohmen.kotlinmovie.detail

import com.nrohmen.kotlinmovie.api.VideoResponse
import com.nrohmen.kotlinmovie.models.MovieDetail
import com.nrohmen.kotlinmovie.models.Videos

/**
 * Created by root on 11/15/17.
 */
interface DetailView {
    fun showMovieDetails(movies : MovieDetail?)
    fun getVideos(videos: List<Videos>?)
}