package com.nrohmen.kotlinmovie.main

import com.nrohmen.kotlinmovie.component.AppScope
import dagger.Subcomponent

/**
 * Created by root on 11/15/17.
 */
@AppScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(target: MainFragment)
}