package com.nugrahaa.moviecatalogue.data.local

import androidx.lifecycle.LiveData
import com.nugrahaa.moviecatalogue.data.local.entity.MovieEntityDB
import com.nugrahaa.moviecatalogue.data.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntityDB>> = mMovieDao.getAllMovies()

    fun insertMovie(movie: MovieEntityDB) = mMovieDao.insertMovies(movie)

    fun deleteMovie(movie: MovieEntityDB) = mMovieDao.deleteMovies(movie)

}