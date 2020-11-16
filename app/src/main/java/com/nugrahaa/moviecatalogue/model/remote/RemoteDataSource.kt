package com.nugrahaa.moviecatalogue.model.remote

import com.nugrahaa.moviecatalogue.model.remote.response.Movie
import com.nugrahaa.moviecatalogue.model.remote.response.ResponseMovie
import com.nugrahaa.moviecatalogue.model.remote.response.ResponseTvShow
import com.nugrahaa.moviecatalogue.network.ApiConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMovies(): Flowable<ResponseMovie> {
        return ApiConfig.getApiService().getMovieData("b64d761def5c00e40e6a36e0032741bf", "en-US")
    }

    fun getTvShow(): Flowable<ResponseTvShow> {
        return ApiConfig.getApiService().getTvShowData("b64d761def5c00e40e6a36e0032741bf", "en-US")
    }

}