package com.nrohmen.kotlinmovie.main

import dagger.Subcomponent

/**
 * Created by root on 11/15/17.
 */
@MainScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(target: MainFragment)
}