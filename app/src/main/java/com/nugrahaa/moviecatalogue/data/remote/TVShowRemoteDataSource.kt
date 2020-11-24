package com.nugrahaa.moviecatalogue.data.remote

import com.nugrahaa.moviecatalogue.data.remote.response.Movie
import com.nugrahaa.moviecatalogue.data.remote.response.ResponseMovie
import com.nugrahaa.moviecatalogue.data.remote.response.ResponseTvShow
import com.nugrahaa.moviecatalogue.data.remote.response.TVShow
import com.nugrahaa.moviecatalogue.network.ApiConfig
import com.nugrahaa.moviecatalogue.utils.EspressoIdlingResource
import io.reactivex.rxjava3.core.Flowable

class TVShowRemoteDataSource {

    companion object {
        @Volatile
        private var instance: TVShowRemoteDataSource? = null

        fun getInstance(): TVShowRemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: TVShowRemoteDataSource()
            }
    }

    fun getTvShow(): Flowable<ResponseTvShow> {
        EspressoIdlingResource.increment()
        return ApiConfig.getApiService().getTvShowData("b64d761def5c00e40e6a36e0032741bf", "en-US")
    }

    fun getMoviesById(id: String): Flowable<Movie> {
        EspressoIdlingResource.increment()
        return ApiConfig.getApiService()
            .getMovieById(id, "b64d761def5c00e40e6a36e0032741bf", "en-US")
    }

    fun getTVShowById(id: String): Flowable<TVShow> {
        EspressoIdlingResource.increment()
        return ApiConfig.getApiService()
            .getTvShowById(id, "b64d761def5c00e40e6a36e0032741bf", "en-US")
    }
}