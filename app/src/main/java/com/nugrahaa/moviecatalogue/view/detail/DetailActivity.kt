package com.nugrahaa.moviecatalogue.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.model.offline.MovieEntity
import com.nugrahaa.moviecatalogue.model.offline.TvShowEntity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getType = intent.getStringExtra("TYPE")
        val getId = intent.getIntExtra("ID", -1)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailActivityViewModel::class.java]

        if (getType == "movie") {
            val listMovie = viewModel.getMovie()
            val movie = viewModel.getMovieById(getId, listMovie as ArrayList)
            supportActionBar?.title = "About Movie"
            addMovieToView(movie)
        } else if (getType == "tvshow") {
            val listTvShow = viewModel.getTvShow()
            val tvShow = viewModel.getTvShowById(getId, listTvShow as ArrayList)
            supportActionBar?.title = "About TvShow"
            addTvShowToView(tvShow)
        }

    }

    private fun addMovieToView(movieEntity: MovieEntity) {
        tv_title_detail.text = movieEntity.title
        tv_date_detail.text = movieEntity.date
        tv_duration_detail.text = movieEntity.duration
        tv_genre_detail.text = movieEntity.genre
        tv_userscore_detail.text = movieEntity.userscore
        tv_description_detail.text = movieEntity.description
        tv_director_detail.text = movieEntity.director

        Glide.with(this)
            .load(movieEntity.poster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_detail)

        val userScore = movieEntity.userscore.toFloat()
        circularProgressBar.apply {
            progress = userScore
            setProgressWithAnimation(userScore, 10000)
            progressMax = 100f
        }
    }

    private fun addTvShowToView(tvShowEntity: TvShowEntity) {
        tv_title_detail.text = tvShowEntity.title
        tv_date_detail.text = tvShowEntity.date
        tv_duration_detail.text = tvShowEntity.duration
        tv_genre_detail.text = tvShowEntity.genre
        tv_userscore_detail.text = tvShowEntity.userscore
        tv_description_detail.text = tvShowEntity.description
        tv_director_detail.text = tvShowEntity.director

        Glide.with(this)
            .load(tvShowEntity.poster)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(img_detail)

        val userScore = tvShowEntity.userscore.toFloat()
        circularProgressBar.apply {
            progress = userScore
            setProgressWithAnimation(userScore, 10000)
            progressMax = 100f
        }
    }
}