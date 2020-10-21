package com.nugrahaa.moviecatalogue.view.movies

import com.nugrahaa.moviecatalogue.model.MovieEntity

interface MoviesFragmentCallback {

    fun onClickGotoDetail(movie: MovieEntity)

}