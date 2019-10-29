package com.nrohmen.kotlinmovie.movie.playing

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nrohmen.kotlinmovie.App
import com.nrohmen.kotlinmovie.R
import com.nrohmen.kotlinmovie.models.Movie
import com.nrohmen.kotlinmovie.movie.MovieAdapter
import kotlinx.android.synthetic.main.fragment_now_playing.*
import javax.inject.Inject

class NowPlayingFragment : Fragment(), NowPlayingView {

    @Inject
    lateinit var presenter: NowPlayingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context?.applicationContext as App).createMainComponent().inject(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_now_playing, container, false)
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

    override fun showNowPlayingMovies(movies: List<Movie>?) {
        progress_bar.visibility = View.GONE
        (list_movie.adapter as MovieAdapter).submitList(movies)
    }
}
