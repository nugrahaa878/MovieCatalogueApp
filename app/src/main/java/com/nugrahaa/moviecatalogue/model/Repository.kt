package com.nugrahaa.moviecatalogue.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nugrahaa.moviecatalogue.model.remote.RemoteDataSource
import com.nugrahaa.moviecatalogue.model.remote.response.Movie
import com.nugrahaa.moviecatalogue.model.remote.response.ResponseMovie
import com.nugrahaa.moviecatalogue.model.remote.response.ResponseTvShow
import com.nugrahaa.moviecatalogue.model.remote.response.TVShow
import com.nugrahaa.moviecatalogue.network.ApiConfig
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository private constructor(private val remoteDataSource: RemoteDataSource): DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteData: RemoteDataSource): Repository =
                instance ?: synchronized(this) {
                    instance ?: Repository(remoteData)
                }
    }

    override fun getAllMovies(): LiveData<ArrayList<Movie?>> {
        var moviesResults = MutableLiveData<ArrayList<Movie?>>()
        remoteDataSource.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                val moviesList = ArrayList<Movie?>()
                if (it.results != null) {
                    for (item in it.results) {
                        moviesList.add(item)
                    }
                }
                moviesResults.postValue(moviesList)
            }, {
                it.printStackTrace()
            })
        return moviesResults
    }

    override fun getAllTvShow(): LiveData<ArrayList<TVShow?>> {
        var tvShowResults = MutableLiveData<ArrayList<TVShow?>>()
        remoteDataSource.getTvShow()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                val tvShowList = ArrayList<TVShow?>()
                if (it.results != null) {
                    for (item in it.results) {
                        tvShowList.add(item)
                    }
                }
                tvShowResults.postValue(tvShowList)
            }, {
                it.printStackTrace()
            })
        return tvShowResults
    }

    override fun getMoviesById(id: String): LiveData<Movie> {
        var movieResult = MutableLiveData<Movie>()
        remoteDataSource.getMoviesById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                movieResult.postValue(it)
            }, {
                it.printStackTrace()
            })
        return movieResult
    }

    override fun getTVShowById(id: String): LiveData<TVShow> {
        var tvShowResult = MutableLiveData<TVShow>()
        remoteDataSource.getTVShowById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                tvShowResult.postValue(it)
            }, {
                it.printStackTrace()
            })
        return tvShowResult
    }
}