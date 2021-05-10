package com.nugrahaa.moviecatalogue.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nugrahaa.moviecatalogue.data.local.entity.MovieEntityDB

@Database(entities = [MovieEntityDB::class], version = 1, exportSchema = false)
abstract class MovieCatalogueDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        @Volatile
        private var INSTANCE: MovieCatalogueDatabase? = null

        fun getInstance(context: Context): MovieCatalogueDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                        MovieCatalogueDatabase::class.java,
                "MovieCatalogue.db").build()
            }

    }

}