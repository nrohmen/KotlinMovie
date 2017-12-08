package com.nrohmen.kotlinmovie.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by root on 11/15/17.
 */
@Module
class AppModule (private val application : Application){
    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}