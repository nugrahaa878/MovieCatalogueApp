package com.nugrahaa.moviecatalogue.view.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.offline.MovieEntity
import com.nugrahaa.moviecatalogue.model.offline.TvShowEntity
import com.nugrahaa.moviecatalogue.model.online.Movie
import com.nugrahaa.moviecatalogue.model.online.ResponseMovie
import com.nugrahaa.moviecatalogue.model.online.TVShow
import com.nugrahaa.moviecatalogue.repository.Repository
import com.nugrahaa.moviecatalogue.utils.DataDummy

class DetailActivityViewModel : ViewModel() {

    private val repository = Repository()
    var responseDetailMovie = MutableLiveData<Movie>()
    var responseDetailTvShow = MutableLiveData<TVShow>()
    var isError = MutableLiveData<Throwable>()

    fun getTvShowById(id: Int, listTvShow: ArrayList<TvShowEntity>): TvShowEntity =
        DataDummy.getTvShowById(id, listTvShow)

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()

    fun getMovieByIdRepository(id: String) {
        repository.getMoviesById(id, {
            responseDetailMovie.value = it
        }, {
            isError.value = it
        })
    }

    fun getTvShowByIdRepository(id: String) {
        repository.getTvShowById(id, {
            responseDetailTvShow.value = it
        }, {
            isError.value = it
        })
    }

}