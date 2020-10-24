package com.nugrahaa.moviecatalogue.view.detail

import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.MovieEntity
import com.nugrahaa.moviecatalogue.model.TvShowEntity
import com.nugrahaa.moviecatalogue.utils.DataDummy

class DetailActivityViewModel : ViewModel() {

    fun getTvShowById(id: Int, listTvShow: ArrayList<TvShowEntity>): TvShowEntity =
        DataDummy.getTvShowById(id, listTvShow)

    fun getMovieById(id: Int, listMovie: ArrayList<MovieEntity>): MovieEntity =
        DataDummy.getMoviesById(id, listMovie)

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovies()

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()

}