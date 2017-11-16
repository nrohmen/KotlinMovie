package com.nrohmen.kotlinmovie.detail

import android.util.Log
import com.nrohmen.kotlinmovie.models.MovieDetail
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by root on 11/15/17.
 */
class DetailPresenterImpl(val interactor: DetailInteractor, private var view: DetailView?): DetailPresenter{

    override fun setView(mainView: DetailView, id: String) {
        view = mainView
        getListMovies(id)
    }

    private fun getListMovies(id: String){
        interactor.getMovieDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { popularMoviesResponse -> onGetMoviesSuccess(popularMoviesResponse)},
                        { e -> onGetMoviesFailure(e) }
                )
    }

    private fun onGetMoviesFailure(e: Throwable?) {
        Log.e(e?.message, e?.stackTrace.toString())
    }

    private fun onGetMoviesSuccess(moviesResponse: MovieDetail?) {
        view?.showDiscoverMovies(moviesResponse)
    }
}