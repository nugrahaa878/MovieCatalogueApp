package com.nugrahaa.moviecatalogue.network

import com.nugrahaa.moviecatalogue.model.online.ResponseMovie
import com.nugrahaa.moviecatalogue.model.online.ResponseTvShow
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMovieData(@Query("api_key") api: String,
                     @Query("language") language: String): Flowable<ResponseMovie>

    @GET("tv/popular")
    fun getTvShowData(@Query("api_key") api: String,
                      @Query("language") language: String): Flowable<ResponseTvShow>

}