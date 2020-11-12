package com.nugrahaa.moviecatalogue.view.movies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.model.offline.MovieEntity
import com.nugrahaa.moviecatalogue.model.online.Movie
import com.nugrahaa.moviecatalogue.model.online.ResponseMovie
import com.nugrahaa.moviecatalogue.view.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(), MoviesFragmentCallback {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var rvMovie: RecyclerView
    private lateinit var listMovieAdapter: MoviesAdapter

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
            viewModel = ViewModelProvider(
                    this,
                    ViewModelProvider.NewInstanceFactory()
            )[MoviesViewModel::class.java]

            viewModel.getMovieRepository()
            attachObserver()
        }
    }

    private fun attachObserver() {
        viewModel.responseMovie.observe(viewLifecycleOwner, Observer {
            showData(it)
        })
    }

    private fun showData(it: ResponseMovie?) {
        rvMovie = rv_movies
        rvMovie.setHasFixedSize(true)
        rvMovie.layoutManager = LinearLayoutManager(context)

        listMovieAdapter = MoviesAdapter(it?.results as ArrayList<Movie>, this)
        rvMovie.adapter = listMovieAdapter
    }

    override fun onClickGotoDetail(movie: Movie) {
        val mIntent = Intent(context, DetailActivity::class.java)
        mIntent.putExtra("TYPE", "movie")
        mIntent.putExtra("ID", movie.id)
        startActivity(mIntent)
    }

}