package com.nrohmen.kotlinmovie.api

import com.nrohmen.kotlinmovie.BuildConfig
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by root on 11/15/17.
 */
@Module
        class ApiModule{
    @Provides @Singleton @Named("baseUrl")
    fun provideBaeUrl(): String{
        return BuildConfig.BASE_URL
    }

    @Provides @Singleton
    fun provideMovieDbApi(retrofit: Retrofit): MovieDbApi {
        return retrofit.create(MovieDbApi::class.java)
    }
}