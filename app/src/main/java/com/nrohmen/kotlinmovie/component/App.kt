package com.nrohmen.kotlinmovie.component

import android.app.Application
import com.nrohmen.kotlinmovie.main.MainComponent
import com.nrohmen.kotlinmovie.main.MainModule
import com.nrohmen.kotlinmovie.network.NetworkModule

/**
 * Created by root on 11/15/17.
 */
class App : Application(){
    lateinit var appComponent : AppComponent
    lateinit var mainComponent : MainComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
    }

    private fun createAppComponent(): AppComponent{
        return DaggerAppComponent.builder()
                .networkModule(NetworkModule())
                .appModule(AppModule(this)).build()
    }

    fun createMainComponent(): MainComponent{
        mainComponent = appComponent.plus(MainModule())
        return mainComponent
    }

    fun releaseMainComponent(){

    }
}