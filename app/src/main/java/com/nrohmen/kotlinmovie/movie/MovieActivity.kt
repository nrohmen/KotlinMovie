package com.nrohmen.kotlinmovie.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Log
import android.widget.Toast
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import com.nrohmen.kotlinmovie.App
import com.nrohmen.kotlinmovie.R
import com.nrohmen.kotlinmovie.movie.playing.NowPlayingFragment
import com.nrohmen.kotlinmovie.movie.upcoming.UpcomingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        bottom_navigation.setOnNavigationItemSelectedListener({ item ->
            when (item.itemId) {
                R.id.playing -> {
                   loadPlayingFragment(savedInstanceState)
                }
                R.id.upcoming -> {
                   loadUpcomingFragment(savedInstanceState)
                }
                R.id.popular -> {

                }
            }
            true
        })
        bottom_navigation.selectedItemId = R.id.playing

        (this.applicationContext as App).welcoming(this, bottom_navigation, "Welcome!", "Here you can select what's movie you want")

    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }

    private fun loadPlayingFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, NowPlayingFragment(), NowPlayingFragment::class.simpleName)
                    .commit()
        }
    }

    private fun loadUpcomingFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, UpcomingFragment(), UpcomingFragment::class.simpleName)
                    .commit()
        }
    }
}
