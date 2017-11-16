package com.nrohmen.kotlinmovie.component

import com.nrohmen.kotlinmovie.api.ApiModule
import com.nrohmen.kotlinmovie.detail.DetailComponent
import com.nrohmen.kotlinmovie.detail.DetailModule
import com.nrohmen.kotlinmovie.main.MainComponent
import com.nrohmen.kotlinmovie.main.MainModule
import com.nrohmen.kotlinmovie.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by root on 11/15/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ApiModule::class))
interface AppComponent{
    fun plus(mainModule: MainModule): MainComponent
    fun plus(detailModule: DetailModule): DetailComponent
}