package com.nugrahaa.moviecatalogue.data.remote.factory

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nugrahaa.moviecatalogue.data.remote.MovieDataSource
import com.nugrahaa.moviecatalogue.data.remote.response.Movie

class MovieDataFactory: DataSource.Factory<Long, Movie>() {

    var mutableLiveData: MutableLiveData<MovieDataSource> = MutableLiveData()
    var movieDataSource: MovieDataSource = MovieDataSource()

    override fun create(): DataSource<Long, Movie> {
        mutableLiveData.postValue(movieDataSource)
        return movieDataSource
    }

}