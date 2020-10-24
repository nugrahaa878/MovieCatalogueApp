package com.nugrahaa.moviecatalogue.view.movies

import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.MovieEntity
import com.nugrahaa.moviecatalogue.utils.DataDummy

class MoviesViewModel : ViewModel() {

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovies()

}