package com.nrohmen.kotlinmovie.api

import com.google.gson.annotations.SerializedName
import com.nrohmen.kotlinmovie.models.Videos

/**
 * Created by root on 11/15/17.
 */
class VideoResponse {
    @SerializedName("results")
    lateinit var videos: List<Videos>
}