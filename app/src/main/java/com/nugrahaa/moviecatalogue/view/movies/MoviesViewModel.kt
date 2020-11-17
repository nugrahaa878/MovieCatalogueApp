package com.nugrahaa.moviecatalogue.view.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.data.Repository
import com.nugrahaa.moviecatalogue.data.remote.response.Movie

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    fun getMovies(): LiveData<ArrayList<Movie?>> {
        return repository.getAllMovies()
    }

}