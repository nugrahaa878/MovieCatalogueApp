package com.nugrahaa.moviecatalogue.view.movies

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovie() {
        val moviesEntities = viewModel.getMovie()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.size)
    }

}