package com.nugrahaa.moviecatalogue.view.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.view.favorite.movie.FavoriteMovieFragment
import com.nugrahaa.moviecatalogue.view.favorite.tvshow.FavoriteTVShowFragment
import com.nugrahaa.moviecatalogue.view.movies.MoviesFragment
import com.nugrahaa.moviecatalogue.view.tvshows.TvShowsFragment

class FavoriteSectionPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_shows)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTVShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        mContext.resources.getString(TAB_TITLES[position])

}