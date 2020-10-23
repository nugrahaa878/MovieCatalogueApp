package com.nugrahaa.moviecatalogue.view.detail

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailActivityViewModelTest {

    private lateinit var detailActivityViewModel: DetailActivityViewModel

    @Before
    fun setUp() {
        detailActivityViewModel = DetailActivityViewModel()
    }

    @Test
    fun getTvShowById() {
        val listTvShow = detailActivityViewModel.getTvShow()
        val tvShow = detailActivityViewModel.getTvShowById(2, listTvShow as ArrayList)
        assertNotNull(listTvShow)
        assertNotNull(tvShow)
        assertEquals("Dragon Ball Z", tvShow.title)
    }

    @Test
    fun getMovieById() {
        val listMovie = detailActivityViewModel.getMovie()
        val movie = detailActivityViewModel.getMovieById(0, listMovie as ArrayList)
        assertNotNull(listMovie)
        assertNotNull(movie)
        assertEquals("A Star Is Born", movie.title)

    }

    @Test
    fun getMovie() {
        val listMovie = detailActivityViewModel.getMovie()
        assertNotNull(listMovie)
        assertEquals(11, listMovie.size)
    }

    @Test
    fun getTvShow() {
        val listTvShow = detailActivityViewModel.getTvShow()
        assertNotNull(listTvShow)
        assertEquals(11, listTvShow.size)
    }
}