package com.nugrahaa.moviecatalogue.view.tvshows

import com.nugrahaa.moviecatalogue.model.remote.response.TVShow

interface TvShowsFragmentCallback {

    fun onClickGotoDetail(tvShowEntity: TVShow?)

}