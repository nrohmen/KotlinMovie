package com.nrohmen.kotlinmovie.movie.upcoming

import android.util.Log
import com.nrohmen.kotlinmovie.api.MovieResponse
import com.nrohmen.kotlinmovie.movie.MovieInteractor
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by root on 11/15/17.
 */
class UpcomingPresenterImpl(private val interactor: MovieInteractor, private var view: UpcomingView?): UpcomingPresenter {

    override fun setView(nowPlayingView: UpcomingView) {
        view = nowPlayingView
        getNowPlayingMovies()
    }

    private fun getNowPlayingMovies(){
        interactor.getUpcomingMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { popularMoviesResponse -> onGetNowPlayingMoviesSuccess(popularMoviesResponse)},
                        { e -> onGetNowPlayingMoviesFailure(e) }
                )
    }

    private fun onGetNowPlayingMoviesFailure(e: Throwable?) {
        Log.e(e?.message, e?.stackTrace.toString())
    }

    private fun onGetNowPlayingMoviesSuccess(moviesResponse: MovieResponse?) {
        view?.showUpcomingMovies(moviesResponse?.movies)
    }
}