package com.nrohmen.kotlinmovie.di

import com.nrohmen.kotlinmovie.api.ApiModule
import com.nrohmen.kotlinmovie.detail.DetailComponent
import com.nrohmen.kotlinmovie.detail.DetailModule
import com.nrohmen.kotlinmovie.movie.MovieComponent
import com.nrohmen.kotlinmovie.movie.MovieModule
import com.nrohmen.kotlinmovie.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by root on 11/15/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class))
interface AppComponent{
    fun plus(movieModule: MovieModule): MovieComponent
    fun plus(detailModule: DetailModule): DetailComponent
}