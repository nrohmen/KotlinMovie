package com.nrohmen.kotlinmovie.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by root on 11/15/17.
 */
class MovieDetail(
        @SerializedName("backdrop_path") val posterPath: String,
        val id: String,
        val overview: String,
        val title: String,
        val voteAverage: Double) : Parcelable {


    companion object {
        @Suppress("unused")
        @JvmField
        val CREATOR: Parcelable.Creator<MovieDetail> = object : Parcelable.Creator<MovieDetail> {
            override fun createFromParcel(source: Parcel): MovieDetail = MovieDetail(source)
            override fun newArray(size: Int): Array<MovieDetail?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readDouble())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(id)
        dest?.writeString(overview)
        dest?.writeString(posterPath)
        dest?.writeString(title)
        dest?.writeDouble(voteAverage)
    }

    fun getPosterUrl(): String
    {
        return "http://image.tmdb.org/t/p/w342$posterPath"
    }
}
