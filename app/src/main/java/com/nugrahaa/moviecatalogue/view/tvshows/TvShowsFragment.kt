package com.nugrahaa.moviecatalogue.view.tvshows

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nugrahaa.moviecatalogue.R
import com.nugrahaa.moviecatalogue.model.remote.response.ResponseTvShow
import com.nugrahaa.moviecatalogue.model.remote.response.TVShow
import com.nugrahaa.moviecatalogue.view.detail.DetailActivity
import com.nugrahaa.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_shows.*

class TvShowsFragment : Fragment(), TvShowsFragmentCallback {

    private lateinit var viewModel: TvShowsViewModel
    private lateinit var rvTvShow: RecyclerView
    private lateinit var listTvShowAdapter: TvShowsAdapter

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

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(
                    this,
                    factory
            )[TvShowsViewModel::class.java]

            viewModel.getTvShow()
            attachObserver()
        }
    }

    private fun attachObserver() {
        viewModel.getTvShow().observe(viewLifecycleOwner, Observer {
            showData(it)
        })
    }

    private fun showData(it: ArrayList<TVShow?>) {
        rvTvShow = rv_tvshow
        rvTvShow.setHasFixedSize(true)
        rvTvShow.layoutManager = LinearLayoutManager(context)

        listTvShowAdapter = TvShowsAdapter(it, this)
        rvTvShow.adapter = listTvShowAdapter
    }

    override fun onClickGotoDetail(tvShowEntity: TVShow?) {
        val mIntent = Intent(context, DetailActivity::class.java)
        mIntent.putExtra("TYPE", "tvshow")
        mIntent.putExtra("ID", tvShowEntity?.id)
        startActivity(mIntent)
    }

}