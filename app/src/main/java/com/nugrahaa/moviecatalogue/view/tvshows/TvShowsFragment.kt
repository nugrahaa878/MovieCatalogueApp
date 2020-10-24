package com.nugrahaa.moviecatalogue.view.tvshows

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.model.TvShowEntity
import com.nugrahaa.moviecatalogue.view.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_tv_shows.*

class TvShowsFragment : Fragment(), TvShowsFragmentCallback {

    private lateinit var viewModel: TvShowsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowsViewModel::class.java]
            val tvShows = viewModel.getTvShow()

            if (tvShows.isEmpty()) {
                showTvShowsEmptyStatus()
            }

            val tvShowAdapter = TvShowsAdapter(this)
            tvShowAdapter.setTvShows(tvShows)

            rv_tvshow.layoutManager = LinearLayoutManager(context)
            rv_tvshow.setHasFixedSize(true)
            rv_tvshow.adapter = tvShowAdapter
        }
    }

    private fun showTvShowsEmptyStatus() {
        rv_tvshow.visibility = View.GONE
        img_empty.visibility = View.VISIBLE
    }

    override fun onClickGotoDetail(tvShowEntity: TvShowEntity) {
        val mIntent = Intent(context, DetailActivity::class.java)
        mIntent.putExtra("TYPE", "tvshow")
        mIntent.putExtra("ID", tvShowEntity.id)
        startActivity(mIntent)
    }

}