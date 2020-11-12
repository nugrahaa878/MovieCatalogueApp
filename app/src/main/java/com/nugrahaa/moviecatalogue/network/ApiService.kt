package com.nugrahaa.moviecatalogue.network

import com.nugrahaa.moviecatalogue.model.online.Movie
import com.nugrahaa.moviecatalogue.model.online.ResponseMovie
import com.nugrahaa.moviecatalogue.model.online.ResponseTvShow
import com.nugrahaa.moviecatalogue.model.online.TVShow
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMovieData(@Query("api_key") api: String,
                     @Query("language") language: String): Flowable<ResponseMovie>

    @GET("tv/popular")
    fun getTvShowData(@Query("api_key") api: String,
                      @Query("language") language: String): Flowable<ResponseTvShow>

    @GET("movie/{id}")
    fun getMovieById(@Path("id") id: String,
                     @Query("api_key") api: String,
                     @Query("language") language: String): Single<Movie>

    @GET("tv/{id}")
    fun getTvShowById(@Path("id") id: String,
                      @Query("api_key") api: String,
                      @Query("language") language: String): Single<TVShow>

}