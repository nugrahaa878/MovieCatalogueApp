package com.nugrahaa.moviecatalogue.view.movies

import com.nugrahaa.moviecatalogue.model.online.Movie

interface MoviesFragmentCallback {

    fun onClickGotoDetail(movie: Movie)

}