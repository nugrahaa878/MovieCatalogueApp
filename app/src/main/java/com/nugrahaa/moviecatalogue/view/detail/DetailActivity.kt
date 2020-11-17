package com.nugrahaa.moviecatalogue.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.model.remote.response.Movie
import com.nugrahaa.moviecatalogue.model.remote.response.TVShow
import com.nugrahaa.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getType = intent.getStringExtra("TYPE")
        val getId = intent.getIntExtra("ID", -1)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailActivityViewModel::class.java]

        if (getType == "movie") {
            viewModel.getMoviesById(getId.toString())
            attachObserver(getId.toString())
            supportActionBar?.title = "About Movie"
        } else if (getType == "tvshow") {
            viewModel.getTVShowById(getId.toString())
            attachObserver(getId.toString())
            supportActionBar?.title = "About TV Show"
        }

    }

    private fun attachObserver(id: String) {
        viewModel.getMoviesById(id).observe(this, Observer {
            detail_progress.visibility = View.GONE
            addMovieToView(it)
        })
        viewModel.getTVShowById(id).observe(this, Observer {
            detail_progress.visibility = View.GONE
            addTvShowToView(it)
        })
    }

    private fun addMovieToView(movie: Movie) {
        tv_title_detail.text = movie.title
        tv_date_detail.text = movie.releaseDate
        tv_userscore_detail.text = (movie.voteAverage?.toInt()?.times(100)).toString()
        tv_description_detail.text = movie.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_detail)

        val userScore = (movie.voteAverage?.toInt()?.times(10))?.toFloat()
        if (userScore != null) {
            circularProgressBar.apply {
                progress = userScore
                setProgressWithAnimation(userScore, 10000)
                progressMax = 100f
            }
        }
    }

    private fun addTvShowToView(tvShow: TVShow) {
        tv_title_detail.text = tvShow.name
        tv_date_detail.text = tvShow.firstAirDate
        tv_userscore_detail.text = tvShow.voteCount.toString()
        tv_description_detail.text = tvShow.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" + tvShow.posterPath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_detail)

        val userScore = (tvShow.voteAverage?.toInt()?.times(10))?.toFloat()
        if (userScore != null) {
            circularProgressBar.apply {
                progress = userScore
                setProgressWithAnimation(userScore, 10000)
                progressMax = 100f
            }
        }
    }
}