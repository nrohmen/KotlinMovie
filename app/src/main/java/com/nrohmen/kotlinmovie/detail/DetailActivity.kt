package com.nrohmen.kotlinmovie.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
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
        collapsingToolbar.setExpandedTitleMargin(50, 50, 250, 50)
    }

    override fun showDiscoverMovies(movies: MovieDetail?) {
        val rateAvg = movies?.voteAverage?.div(2)
        progress_bar.visibility = View.GONE
        collapsingToolbar.title = movies?.title
        overview?.text = movies?.overview
        rate?.text = movies?.voteAverage.toString()
        vote_count?.text = movies?.voteCount.toString()
        release_date?.text = movies?.releaseDate
        runtime?.text = movies?.runtime.toString()
        if (rateAvg != null) {
            rating_bar.rating = rateAvg.toFloat()
        }
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
