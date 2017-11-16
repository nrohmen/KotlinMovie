package com.nrohmen.kotlinmovie.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import com.nrohmen.kotlinmovie.R
import com.nrohmen.kotlinmovie.component.App
import com.nrohmen.kotlinmovie.models.MovieDetail
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_overview.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailView {

    @Inject lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        (applicationContext as App).createDetailComponent().inject(this)

        val id = intent.getStringExtra("id")
        setupToolbar()
        presenter.setView(this, id)
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun showDiscoverMovies(movies: MovieDetail?) {
        progress_bar.visibility = View.GONE
        collapsingToolbar.title = movies?.title
        overview?.text = movies?.overview
        Glide.with(this)
                .load(movies?.getPosterUrl())
                .into(poster)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
