package com.nugrahaa.moviecatalogue.view.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nugrahaa.moviecatalogue.model.Repository
import com.nugrahaa.moviecatalogue.model.remote.response.Movie
import com.nugrahaa.moviecatalogue.model.remote.response.TVShow
import com.nugrahaa.moviecatalogue.utils.DataDummy
import com.nugrahaa.moviecatalogue.view.movies.MoviesViewModel
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowsViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: TvShowsViewModel

    @Mock
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(repository)
    }

    @Test
    fun getMovies() {
        val tvShowDummy = MutableLiveData<ArrayList<TVShow?>>()
        tvShowDummy.postValue(DataDummy.generateDummyTvShowAPI())
        `when`<LiveData<ArrayList<TVShow?>>>(repository.getAllTvShow()).thenReturn(tvShowDummy)
        val tvShow = viewModel.getTvShow()
        verify(repository).getAllTvShow()
        assertNotNull(tvShow)
        assertEquals(2, tvShow.value?.size)
    }

}