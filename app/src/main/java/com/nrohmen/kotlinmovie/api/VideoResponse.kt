package com.nrohmen.kotlinmovie.api

import com.google.gson.annotations.SerializedName
import com.nrohmen.kotlinmovie.models.Videos

/**
 * Created by root on 11/15/17.
 */
data class VideoResponse (
    @SerializedName("results")
    var videos: List<Videos>
)