package com.nrohmen.kotlinmovie.movie.upcoming

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nrohmen.kotlinmovie.App
import com.nrohmen.kotlinmovie.R
import com.nrohmen.kotlinmovie.models.Movie
import com.nrohmen.kotlinmovie.movie.MovieAdapter
import kotlinx.android.synthetic.main.fragment_now_playing.*
import javax.inject.Inject

class UpcomingFragment : Fragment(), UpcomingView {

    @Inject
    lateinit var presenter: UpcomingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as App).createMainComponent().inject(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
        presenter.setView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (context?.applicationContext as App).releaseMainComponent()
    }

    private fun initLayout() {
        list_movie.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(context, 2)
        list_movie.layoutManager = layoutManager
        list_movie.setHasFixedSize(true)
        list_movie.adapter = MovieAdapter(context)
    }

    override fun showUpcomingMovies(movies: List<Movie>?) {
        progress_bar.visibility = View.GONE
        (list_movie.adapter as MovieAdapter).submitList(movies)
    }
}
