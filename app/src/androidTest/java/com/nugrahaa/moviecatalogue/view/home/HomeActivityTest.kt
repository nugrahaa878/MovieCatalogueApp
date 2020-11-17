package com.nugrahaa.moviecatalogue.view.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.utils.DataDummy
import com.nugrahaa.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(10000)
//        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyMovies[2].title)))
//        onView(withId(R.id.tv_genre_detail)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_genre_detail)).check(matches(withText(dummyMovies[2].genre)))
//        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyMovies[2].description)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        onView(withId(R.id.tv_title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title_detail)).check(matches(withText(dummyTvShow[2].title)))
        onView(withId(R.id.tv_description_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_detail)).check(matches(withText(dummyTvShow[2].description)))
    }

}