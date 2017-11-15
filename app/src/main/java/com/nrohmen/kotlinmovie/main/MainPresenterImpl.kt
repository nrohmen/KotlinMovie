package com.nrohmen.kotlinmovie.main

import android.util.Log
import com.nrohmen.kotlinmovie.api.MovieResponse
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by root on 11/15/17.
 */
class MainPresenterImpl(val interactor: MainInteractor, private var view: MainView?): MainPresenter{

    override fun setView(mainView: MainView) {
        view = mainView
        getListMovies()
    }

    private fun getListMovies(){
        interactor.getListMovies()
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

    private fun onGetMoviesSuccess(moviesResponse: MovieResponse?) {
        view?.showMovies(moviesResponse?.movies)
    }
}