package com.nugrahaa.moviecatalogue.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nugrahaa.moviecatalogue.data.local.entity.MovieEntityDB

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieentities")
    fun getAllMovies(): LiveData<List<MovieEntityDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: MovieEntityDB)

    @Delete
    fun deleteMovies(movies: MovieEntityDB)

}