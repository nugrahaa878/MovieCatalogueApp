package com.nugrahaa.moviecatalogue.view.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.remote.response.ResponseMovie
import com.nugrahaa.moviecatalogue.model.Repository
import com.nugrahaa.moviecatalogue.model.remote.response.Movie

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    fun getMovies(): LiveData<ArrayList<Movie?>> {
        return repository.getAllMovies()
    }
}