package com.nrohmen.kotlinmovie.movie

import com.nrohmen.kotlinmovie.api.MovieDbApi
import com.nrohmen.kotlinmovie.di.AppScope
import com.nrohmen.kotlinmovie.movie.playing.NowPlayingPresenter
import com.nrohmen.kotlinmovie.movie.playing.NowPlayingPresenterImpl
import com.nrohmen.kotlinmovie.movie.upcoming.UpcomingPresenter
import com.nrohmen.kotlinmovie.movie.upcoming.UpcomingPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by root on 11/15/17.
 */
@Module
class MovieModule {
    @Provides
    fun provideMainPresenter(movieInteractor: MovieInteractor): NowPlayingPresenter {
        return NowPlayingPresenterImpl(movieInteractor, null)
    }

    @Provides
    @AppScope
    fun provideMainInteractor(api : MovieDbApi): MovieInteractor {
        return MovieInteractorImpl(api)
    }

    @Provides
    fun provideUpcomingPresenter(movieInteractor: MovieInteractor): UpcomingPresenter {
        return UpcomingPresenterImpl(movieInteractor, null)
    }
}