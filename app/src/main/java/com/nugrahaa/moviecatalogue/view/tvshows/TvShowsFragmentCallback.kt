package com.nugrahaa.moviecatalogue.view.tvshows

import com.nugrahaa.moviecatalogue.data.remote.response.TVShow

interface TvShowsFragmentCallback {

    fun onClickGotoDetail(tvShowEntity: TVShow?)

}