package com.nrohmen.kotlinmovie.main

import com.nrohmen.kotlinmovie.api.MovieDbApi
import com.nrohmen.kotlinmovie.component.AppScope
import dagger.Module
import dagger.Provides

/**
 * Created by root on 11/15/17.
 */
@Module
class MainModule{
    @Provides
    fun provideMainPresenter(mainInteractor : MainInteractor): MainPresenter{
        return MainPresenterImpl(mainInteractor, null)
    }

    @Provides
    @AppScope
    fun provideMainInteractor(api : MovieDbApi): MainInteractor{
        return MainInteractorImpl(api)
    }
}