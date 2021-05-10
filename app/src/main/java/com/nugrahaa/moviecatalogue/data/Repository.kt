package com.nugrahaa.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nugrahaa.moviecatalogue.data.local.LocalDataSource
import com.nugrahaa.moviecatalogue.data.remote.RemoteDataSource
import com.nugrahaa.moviecatalogue.data.remote.response.Movie
import com.nugrahaa.moviecatalogue.data.remote.response.TVShow
import com.nugrahaa.moviecatalogue.utils.EspressoIdlingResource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource) : DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource, localData:LocalDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData, localData)
            }
    }

    override fun getAllMovies(): LiveData<ArrayList<Movie?>> {
        val moviesResults = MutableLiveData<ArrayList<Movie?>>()
        remoteDataSource.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val moviesList = ArrayList<Movie?>()
                if (it.results != null) {
                    for (item in it.results) {
                        moviesList.add(item)
                    }
                }
                moviesResults.postValue(moviesList)
                EspressoIdlingResource.decrement()
            }, {
                it.printStackTrace()
            })
        return moviesResults
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