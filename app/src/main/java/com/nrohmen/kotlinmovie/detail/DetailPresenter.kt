package com.nrohmen.kotlinmovie.detail

/**
 * Created by root on 11/15/17.
 */
interface DetailPresenter {
    fun setView(detailView: DetailView, id: String)
}