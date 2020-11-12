package com.nugrahaa.moviecatalogue.view.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.offline.MovieEntity
import com.nugrahaa.moviecatalogue.model.online.ResponseMovie
import com.nugrahaa.moviecatalogue.repository.Repository
import com.nugrahaa.moviecatalogue.utils.DataDummy

class MoviesViewModel : ViewModel() {

    private val repository = Repository()
    var responseMovie = MutableLiveData<ResponseMovie>()
    var isError = MutableLiveData<Throwable>()

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovies()

    fun getMovieRepository() {
        repository.getMovies({
            responseMovie.value = it
        }, {
            isError.value = it
        })
    }
}