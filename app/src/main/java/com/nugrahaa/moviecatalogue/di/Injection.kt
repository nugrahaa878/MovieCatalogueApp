package com.nugrahaa.moviecatalogue.di

import android.content.Context
import com.nugrahaa.moviecatalogue.model.Repository
import com.nugrahaa.moviecatalogue.model.remote.RemoteDataSource

object Injection {

    fun provideRepository(context: Context): Repository {
        val remoteRepository = RemoteDataSource.getInstance()

        return Repository.getInstance(remoteRepository)
    }

}