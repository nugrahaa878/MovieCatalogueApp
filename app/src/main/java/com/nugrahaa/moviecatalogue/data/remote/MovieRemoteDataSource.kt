package com.nugrahaa.moviecatalogue.data.remote

import androidx.paging.PageKeyedDataSource
import com.nugrahaa.moviecatalogue.data.remote.response.Movie
import com.nugrahaa.moviecatalogue.data.remote.response.ResponseMovie
import com.nugrahaa.moviecatalogue.data.remote.response.ResponseTvShow
import com.nugrahaa.moviecatalogue.data.remote.response.TVShow
import com.nugrahaa.moviecatalogue.network.ApiConfig
import com.nugrahaa.moviecatalogue.utils.EspressoIdlingResource
import io.reactivex.rxjava3.core.Flowable

class MovieRemoteDataSource: PageKeyedDataSource<Long, Movie>() {

    companion object {
        @Volatile
        private var instance: MovieRemoteDataSource? = null

        fun getInstance(): MovieRemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: MovieRemoteDataSource()
            }
    }

    fun getMovies(): Flowable<ResponseMovie> {
        EspressoIdlingResource.increment()
        return ApiConfig.getApiService().getMovieData("b64d761def5c00e40e6a36e0032741bf", "en-US", 1)
    }

    fun getMoviesById(id: String): Flowable<Movie> {
        EspressoIdlingResource.increment()
        return ApiConfig.getApiService()
            .getMovieById(id, "b64d761def5c00e40e6a36e0032741bf", "en-US")
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, Movie>
    ) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovieData("b64d761def5c00e40e6a36e0032741bf", "en-US", 1)
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Movie>) {
        TODO("Not yet implemented")
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Movie>) {
        TODO("Not yet implemented")
    }

}