package com.nugrahaa.moviecatalogue.view.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.nugrahaa.moviecatalogue.data.Repository
import com.nugrahaa.moviecatalogue.data.remote.response.Movie

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    fun getMovies(): LiveData<PagedList<Movie?>> {
        return repository.getAllMovies()
    }

}