package com.nugrahaa.moviecatalogue.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntityDB (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var movieTitle: String,

    @ColumnInfo(name = "detail")
    var movieDetail: String,

    @ColumnInfo(name = "userscore")
    var movieScore: String,

    @ColumnInfo(name = "date")
    var movieDate: String,

    @ColumnInfo(name = "posterpath")
    var moviePoster: String
)