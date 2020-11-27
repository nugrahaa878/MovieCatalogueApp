package com.nugrahaa.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nugrahaa.moviecatalogue.data.remote.RemoteDataSource
import com.nugrahaa.moviecatalogue.data.remote.response.Movie
import com.nugrahaa.moviecatalogue.data.remote.response.ResponseMovie
import com.nugrahaa.moviecatalogue.data.remote.response.ResponseTvShow
import com.nugrahaa.moviecatalogue.data.remote.response.TVShow
import com.nugrahaa.moviecatalogue.utils.DataDummy
import com.nugrahaa.moviecatalogue.utils.LiveDataTestUtil
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private lateinit var fakeRepository: FakeRepository

    @Mock
    private lateinit var remote: RemoteDataSource

    @Before
    fun setUp() {
        fakeRepository = FakeRepository(remote)
    }

    @Test
    fun getAllMovies() {
        var moviesResults = DataDummy.generateResponseMovieDummyAPI()
        `when`<Flowable<ResponseMovie>>(remote.getMovies()).thenReturn(Flowable.just(moviesResults))
        val moviesResponse = LiveDataTestUtil.getValue(fakeRepository.getAllMovies())
        verify(remote).getMovies()
        assertNotNull(moviesResponse)
        assertEquals(3, moviesResponse.size)
    }

    @Test
    fun getAllTVShow() {
        var tvShowResults = DataDummy.generateResponseTVShowDummyAPI()
        `when`<Flowable<ResponseTvShow>>(remote.getTvShow()).thenReturn(Flowable.just(tvShowResults))
        val tvShowResponse = LiveDataTestUtil.getValue(fakeRepository.getAllTvShow())
        verify(remote).getTvShow()
        assertNotNull(tvShowResponse)
        assertEquals(2, tvShowResponse.size)
    }

    @Test
    fun getMoviesById() {
        var movie = DataDummy.generateMovieAPI()
        `when`<Flowable<Movie>>(remote.getMoviesById("2")).thenReturn(Flowable.just(movie))
        val movieResponse = LiveDataTestUtil.getValue(fakeRepository.getMoviesById("2"))
        verify(remote).getMoviesById("2")
        assertNotNull(movieResponse)
        assertEquals("Si Ujang", movieResponse.title)
    }

    @Test
    fun getTVShowById() {
        var tvShow = DataDummy.generateTvShowAPI()
        `when`<Flowable<TVShow>>(remote.getTVShowById("3")).thenReturn(Flowable.just(tvShow))
        val tvShowResponse = LiveDataTestUtil.getValue(fakeRepository.getTVShowById("3"))
        verify(remote).getTVShowById("3")
        assertNotNull(tvShowResponse)
        assertEquals("Ku patah hati", tvShowResponse.originalName)
    }
}