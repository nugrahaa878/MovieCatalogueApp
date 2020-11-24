package com.nugrahaa.moviecatalogue.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nugrahaa.moviecatalogue.data.remote.MovieDataSource
import com.nugrahaa.moviecatalogue.data.remote.RemoteDataSource
import com.nugrahaa.moviecatalogue.data.remote.factory.MovieDataFactory
import com.nugrahaa.moviecatalogue.data.remote.response.Movie
import com.nugrahaa.moviecatalogue.data.remote.response.TVShow
import com.nugrahaa.moviecatalogue.utils.EspressoIdlingResource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class Repository : DataSource {

    private lateinit var executor: Executor
    private lateinit var movieData: LiveData<PagedList<Movie?>>

    private var movieDataSource = MovieDataSource()
    private var remoteDataSource = RemoteDataSource()

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository()
            }
    }

    override fun getAllMovies(): LiveData<PagedList<Movie?>> {
        executor = Executors.newFixedThreadPool(5)
        val movieFactory = MovieDataFactory()
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .build()

        movieData = LivePagedListBuilder(movieFactory, pagedListConfig)
            .setFetchExecutor(executor)
            .build()

        Log.d("DATA REPOSITORY", movieData.value.toString())

        return movieData
    }

    override fun getAllTvShow(): LiveData<ArrayList<TVShow?>> {
        val tvShowResults = MutableLiveData<ArrayList<TVShow?>>()
        remoteDataSource.getTvShow()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val tvShowList = ArrayList<TVShow?>()
                if (it.results != null) {
                    for (item in it.results) {
                        tvShowList.add(item)
                    }
                }
                tvShowResults.postValue(tvShowList)
                EspressoIdlingResource.decrement()
            }, {
                it.printStackTrace()
            })
        return tvShowResults
    }

    override fun getMoviesById(id: String): LiveData<Movie> {
        val movieResult = MutableLiveData<Movie>()
        remoteDataSource.getMoviesById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                movieResult.postValue(it)
                EspressoIdlingResource.decrement()
            }, {
                it.printStackTrace()
            })
        return movieResult
    }

    override fun getTVShowById(id: String): LiveData<TVShow> {
        val tvShowResult = MutableLiveData<TVShow>()
        remoteDataSource.getTVShowById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                tvShowResult.postValue(it)
                EspressoIdlingResource.decrement()
            }, {
                it.printStackTrace()
            })
        return tvShowResult
    }
}