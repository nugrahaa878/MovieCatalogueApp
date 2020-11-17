package com.nugrahaa.moviecatalogue.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.data.remote.response.Movie
import com.nugrahaa.moviecatalogue.data.remote.response.TVShow
import com.nugrahaa.moviecatalogue.data.Repository

class DetailActivityViewModel(private val repository: Repository) : ViewModel() {

    fun getMoviesById(id: String): LiveData<Movie> {
        return repository.getMoviesById(id)
    }

    fun getTVShowById(id: String): LiveData<TVShow> {
        return repository.getTVShowById(id)
    }

}