package com.nugrahaa.moviecatalogue.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.local.TvShowEntity
import com.nugrahaa.moviecatalogue.model.remote.response.Movie
import com.nugrahaa.moviecatalogue.model.remote.response.TVShow
import com.nugrahaa.moviecatalogue.model.Repository
import com.nugrahaa.moviecatalogue.utils.DataDummy

class DetailActivityViewModel(private val repository: Repository) : ViewModel() {

//    private val repository = Repository()
//    var responseDetailTvShow = MutableLiveData<TVShow>()
//    var isError = MutableLiveData<Throwable>()

    fun getMoviesById(id: String): LiveData<Movie> {
        return repository.getMoviesById(id)
    }

    fun getTVShowById(id: String): LiveData<TVShow> {
        return repository.getTVShowById(id)
    }

//
//    fun getTvShowById(id: Int, listTvShow: ArrayList<TvShowEntity>): TvShowEntity =
//        DataDummy.getTvShowById(id, listTvShow)
//
//    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()
//
//    fun getMovieByIdRepository(id: String) {
//        repository.getMoviesById(id, {
//            responseDetailMovie.value = it
//        }, {
//            isError.value = it
//        })
//    }
//
//    fun getTvShowByIdRepository(id: String) {
//        repository.getTvShowById(id, {
//            responseDetailTvShow.value = it
//        }, {
//            isError.value = it
//        })
//    }

}