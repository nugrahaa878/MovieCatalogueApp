package com.nugrahaa.moviecatalogue.view.tvshows

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TvShowsViewModelTest {

    private lateinit var tvShowsViewModel: TvShowsViewModel

    @Before
    fun setUp() {
        tvShowsViewModel = TvShowsViewModel()
    }

    @Test
    fun getTvShow() {
        val tvShowEntities = tvShowsViewModel.getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(11, tvShowEntities.size)
    }
}