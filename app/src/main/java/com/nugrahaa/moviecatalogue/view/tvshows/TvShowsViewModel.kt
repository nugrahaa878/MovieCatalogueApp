package com.nugrahaa.moviecatalogue.view.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nugrahaa.moviecatalogue.model.remote.response.ResponseTvShow
import com.nugrahaa.moviecatalogue.model.Repository
import com.nugrahaa.moviecatalogue.model.remote.response.TVShow

class TvShowsViewModel(private val repository: Repository) : ViewModel() {

    fun getTvShow(): LiveData<ArrayList<TVShow?>> {
        return repository.getAllTvShow()
    }

}