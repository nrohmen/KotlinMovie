package com.nrohmen.kotlinmovie.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nrohmen.kotlinmovie.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        loadMainFragment(savedInstanceState)
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)
    }

    private fun loadMainFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.main_container, MainFragment(), MainFragment::class.simpleName)
                    .commit()
        }
    }
}
