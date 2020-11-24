package com.nugrahaa.moviecatalogue.data.remote

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.nugrahaa.moviecatalogue.data.remote.response.Movie
import com.nugrahaa.moviecatalogue.data.remote.response.ResponseMovie
import com.nugrahaa.moviecatalogue.network.ApiConfig
import com.nugrahaa.moviecatalogue.network.ApiService
import com.nugrahaa.moviecatalogue.utils.EspressoIdlingResource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDataSource: PageKeyedDataSource<Long, Movie>() {

    var api: ApiService

    init {
        api = ApiConfig.getApiService()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, Movie>
    ) {
        api.getMovieData("b64d761def5c00e40e6a36e0032741bf", "en-US", 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.results?.let { it1 -> callback.onResult(it1, null, 2L)}
                Log.d("DATA SOURCE", it.results.toString())
            }, {

            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Movie>) {
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Movie>) {
        api.getMovieData("b64d761def5c00e40e6a36e0032741bf", "en-US", params.key.toInt())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.results?.let {it1 -> callback.onResult(it1, params.key + 1L)}
                Log.d("DATA SOURCE AFTER", it.results.toString())
            }, {

            })

    }

}