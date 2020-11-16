package com.nugrahaa.moviecatalogue.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nugrahaa.moviecatalogue.model.remote.response.Movie
import com.nugrahaa.moviecatalogue.model.remote.response.TVShow

interface DataSource {

    fun getAllMovies(): LiveData<ArrayList<Movie?>>

    fun getAllTvShow(): LiveData<ArrayList<TVShow?>>

}