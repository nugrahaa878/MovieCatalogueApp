package com.nugrahaa.moviecatalogue.view.tvshows

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.offline.TvShowEntity
import com.nugrahaa.moviecatalogue.model.online.ResponseMovie
import com.nugrahaa.moviecatalogue.model.online.ResponseTvShow
import com.nugrahaa.moviecatalogue.model.online.TVShow
import com.nugrahaa.moviecatalogue.repository.Repository
import com.nugrahaa.moviecatalogue.utils.DataDummy

class TvShowsViewModel : ViewModel() {

    private val repository = Repository()
    var responseTvShow = MutableLiveData<ResponseTvShow>()
    var isError = MutableLiveData<Throwable>()

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()

    fun getTvShowRepository() {
        repository.getTvShow({
            responseTvShow.value = it
        }, {
            isError.value = it
        })
    }

}