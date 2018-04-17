package com.nrohmen.kotlinmovie.movie

import com.nrohmen.kotlinmovie.di.AppScope
import com.nrohmen.kotlinmovie.movie.playing.NowPlayingFragment
import com.nrohmen.kotlinmovie.movie.upcoming.UpcomingFragment
import dagger.Subcomponent

/**
 * Created by root on 11/15/17.
 */
@AppScope
@Subcomponent(modules = [(MovieModule::class)])
interface MovieComponent {
    fun inject(target: NowPlayingFragment)
    fun inject(target: UpcomingFragment)
}