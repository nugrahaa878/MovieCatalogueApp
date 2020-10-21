package com.nugrahaa.moviecatalogue.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.model.MovieEntity
import com.nugrahaa.moviecatalogue.model.TvShowEntity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val getDataMovie = intent.getParcelableExtra<MovieEntity>("EXTRA_ITEM")
        val getDataTvShow = intent.getParcelableExtra<TvShowEntity>("EXTRA_TVSHOW")

        if (getDataMovie != null) {
            addMovieToView(getDataMovie)
        }

        if (getDataTvShow != null) {
            addTvShowToView(getDataTvShow)
        }

    }

    fun addMovieToView(movieEntity: MovieEntity) {
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

    fun addTvShowToView(tvShowEntity: TvShowEntity) {
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