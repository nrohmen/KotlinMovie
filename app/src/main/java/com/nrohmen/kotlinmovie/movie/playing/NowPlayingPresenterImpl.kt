package com.nrohmen.kotlinmovie.movie.playing

import android.util.Log
import com.nrohmen.kotlinmovie.api.MovieResponse
import com.nrohmen.kotlinmovie.movie.MovieInteractor
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by root on 11/15/17.
 */
class NowPlayingPresenterImpl(private val interactor: MovieInteractor, private var view: NowPlayingView?): NowPlayingPresenter {

    override fun setView(nowPlayingView: NowPlayingView) {
        view = nowPlayingView
        getNowPlayingMovies()
    }

    private fun getNowPlayingMovies(){
        interactor.getNowPlayingMovies()
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
        view?.showNowPlayingMovies(moviesResponse?.movies)
    }
}