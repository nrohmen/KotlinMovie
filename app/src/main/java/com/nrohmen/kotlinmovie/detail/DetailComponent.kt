package com.nrohmen.kotlinmovie.detail

import com.nrohmen.kotlinmovie.di.AppScope
import dagger.Subcomponent

/**
 * Created by root on 11/16/17.
 */
@AppScope
@Subcomponent(modules = [(DetailModule::class)])
interface DetailComponent {
    fun inject(target: DetailActivity)
}