package com.nugrahaa.moviecatalogue.view.movies

import com.nugrahaa.moviecatalogue.data.remote.response.Movie

interface MoviesFragmentCallback {

    fun onClickGotoDetail(movie: Movie?)

}