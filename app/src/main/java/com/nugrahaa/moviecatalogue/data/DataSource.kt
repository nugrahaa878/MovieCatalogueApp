package com.nugrahaa.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.nugrahaa.moviecatalogue.data.remote.response.Movie
import com.nugrahaa.moviecatalogue.data.remote.response.TVShow

interface DataSource {

    fun getAllMovies(): LiveData<PagedList<Movie?>>

    fun getAllTvShow(): LiveData<ArrayList<TVShow?>>

    fun getMoviesById(id: String): LiveData<Movie>

    fun getTVShowById(id: String): LiveData<TVShow>

}