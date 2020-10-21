package com.nugrahaa.moviecatalogue.view.tvshows

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.TvShowEntity
import com.nugrahaa.moviecatalogue.utils.DataDummy

class TvShowsViewModel: ViewModel() {

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()

}