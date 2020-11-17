package com.nugrahaa.moviecatalogue.view.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nugrahaa.moviecatalogue.model.Repository
import com.nugrahaa.moviecatalogue.model.remote.response.Movie
import com.nugrahaa.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import kotlin.collections.ArrayList

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: MoviesViewModel

    @Mock
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(repository)
    }

    @Test
    fun getMovies() {
        val moviesDummy = MutableLiveData<ArrayList<Movie?>>()
        moviesDummy.postValue(DataDummy.generateDummyMoviesAPI())
        `when`<LiveData<ArrayList<Movie?>>>(repository.getAllMovies()).thenReturn(moviesDummy)
        val movies = viewModel.getMovies()
        verify(repository).getAllMovies()
        assertNotNull(movies)
        assertEquals(3, movies.value?.size)
    }

}