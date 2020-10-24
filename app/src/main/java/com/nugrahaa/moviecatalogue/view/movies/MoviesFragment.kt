package com.nugrahaa.moviecatalogue.view.movies

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.model.MovieEntity
import com.nugrahaa.moviecatalogue.view.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(), MoviesFragmentCallback {

    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MoviesViewModel::class.java]
            val movies = viewModel.getMovie()

            if (movies.isEmpty()) {
                showEmptyMoviesStatus()
            }

            val moviesAdapter = MoviesAdapter(this)
            moviesAdapter.setMovies(movies)

            rv_movies.layoutManager = LinearLayoutManager(context)
            rv_movies.setHasFixedSize(true)
            rv_movies.adapter = moviesAdapter
        }
    }

    private fun showEmptyMoviesStatus() {
        rv_movies.visibility = View.GONE
        img_empty.visibility = View.VISIBLE
    }

    override fun onClickGotoDetail(movie: MovieEntity) {
        val mIntent = Intent(context, DetailActivity::class.java)
        mIntent.putExtra("TYPE", "movie")
        mIntent.putExtra("ID", movie.id)
        startActivity(mIntent)
    }

}