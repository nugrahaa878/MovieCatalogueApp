package com.nugrahaa.moviecatalogue.repository

import com.nugrahaa.moviecatalogue.model.online.*
import com.nugrahaa.moviecatalogue.network.ApiConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun getMovies(responseHandler: (ResponseMovie) -> Unit, errorHandler: (Throwable) -> Unit) {
        ApiConfig.getApiService().getMovieData("b64d761def5c00e40e6a36e0032741bf", "en-US")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responseHandler(it)
                }, {
                    errorHandler(it)
                })
    }

    fun getTvShow(responseHandler: (ResponseTvShow) -> Unit, errorHandler: (Throwable) -> Unit) {
        ApiConfig.getApiService().getTvShowData("b64d761def5c00e40e6a36e0032741bf", "en-US")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responseHandler(it)
                }, {
                    errorHandler(it)
                })
    }

    fun getMoviesById(id: String, responseHandler: (Movie) -> Unit, errorHandler: (Throwable) -> Unit) {
        ApiConfig.getApiService().getMovieById(id, "b64d761def5c00e40e6a36e0032741bf", "en-US")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responseHandler(it)
                }, {
                    errorHandler(it)
                })
    }

    fun getTvShowById(id: String, responseHandler: (TVShow) -> Unit, errorHandler: (Throwable) -> Unit) {
        ApiConfig.getApiService().getTvShowById(id, "b64d761def5c00e40e6a36e0032741bf", "en-US")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responseHandler(it)
                }, {
                    errorHandler(it)
                })
    }

}