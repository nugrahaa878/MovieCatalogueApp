package com.nugrahaa.moviecatalogue.view.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.view.home.SectionPagerAdapter
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.tabs
import kotlinx.android.synthetic.main.activity_home.view_pager

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        // pager adapter
        val sectionsPagerAdapter = FavoriteSectionPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs_favorite.setupWithViewPager(view_pager)

    }
}