package com.nugrahaa.moviecatalogue.view.tvshows

import com.nugrahaa.moviecatalogue.model.TvShowEntity

interface TvShowsFragmentCallback {

    fun onClickGotoDetail(tvShowEntity: TvShowEntity)

}