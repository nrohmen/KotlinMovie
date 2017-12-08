package com.nrohmen.kotlinmovie

import android.app.Activity
import android.app.Application
import android.text.SpannableString
import android.util.Log
import android.view.View
import android.widget.Toast
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import com.nrohmen.kotlinmovie.detail.DetailComponent
import com.nrohmen.kotlinmovie.detail.DetailModule
import com.nrohmen.kotlinmovie.di.AppComponent
import com.nrohmen.kotlinmovie.di.AppModule
import com.nrohmen.kotlinmovie.di.DaggerAppComponent
import com.nrohmen.kotlinmovie.movie.MovieComponent
import com.nrohmen.kotlinmovie.movie.MovieModule
import com.nrohmen.kotlinmovie.network.NetworkModule
import com.nrohmen.kotlinmovie.util.Constants
import com.nrohmen.kotlinmovie.util.Utils
import com.nrohmen.kotlinmovie.util.Utils.readSharedSetting

/**
 * Created by root on 11/15/17.
 */
class App : Application(){
    lateinit var appComponent : AppComponent
    lateinit var movieComponent: MovieComponent
    lateinit var detailComponent : DetailComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .networkModule(NetworkModule())
                .appModule(AppModule(this)).build()
    }

    fun createMainComponent(): MovieComponent {
        movieComponent = appComponent.plus(MovieModule())
        return movieComponent
    }

    fun createDetailComponent(): DetailComponent{
        detailComponent = appComponent.plus(DetailModule())
        return detailComponent
    }

    fun releaseMainComponent(){

    }

    fun welcoming(context : Activity, view: View, title: String, msg: String){
        val isUserFirstTime = java.lang.Boolean.valueOf(readSharedSetting(context, Constants.PREF_USER_FIRST_TIME, "true"))
        if (isUserFirstTime){
            val spannedDesc = SpannableString(msg)
            TapTargetView.showFor(context, TapTarget.forView(view, title, spannedDesc)
                    .cancelable(false)
                    .drawShadow(true)
                    .titleTextDimen(R.dimen.title_text_size)
                    .tintTarget(false), object : TapTargetView.Listener() {

                override fun onTargetClick(view: TapTargetView?) {
                    super.onTargetClick(view)
                    Utils.saveSharedSetting(context, Constants.PREF_USER_FIRST_TIME, "false")
                }

                override fun onOuterCircleClick(view: TapTargetView?) {
                    super.onOuterCircleClick(view)
                    Toast.makeText(view!!.context, "You clicked the outer circle!", Toast.LENGTH_SHORT).show()
                }

                override fun onTargetDismissed(view: TapTargetView?, userInitiated: Boolean) {
                    Log.d("TapTargetViewSample", "You dismissed me :(")
                }
            })
        }
    }
}